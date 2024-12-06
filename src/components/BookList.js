// src/components/BookList.js
import React, { useEffect, useState } from "react";
import { Grid, Container, Typography, TextField, Button, Pagination, AppBar, Toolbar, Box } from "@mui/material";
import axios from "axios";
import BookCard from "./BookCard";

const BookList = () => {
    const [books, setBooks] = useState([]); // Danh sách sách bestseller
    const [filteredBooks, setFilteredBooks] = useState([]); // Danh sách sách tìm kiếm
    const [searchTerm, setSearchTerm] = useState("");
    const [page, setPage] = useState(1);
    const [rowsPerPage] = useState(6);
    const [error, setError] = useState(null);

    // Lấy danh sách bestseller khi component được gắn
    useEffect(() => {
        const fetchBestsellers = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/bestsellers");
                if (Array.isArray(response.data.items)) {
                    setBooks(response.data.items);
                    setFilteredBooks(response.data.items); // Khởi tạo danh sách tìm kiếm
                } else {
                    setError("Dữ liệu không phải là mảng.");
                }
            } catch (error) {
                console.error(error);
                setError("Có lỗi xảy ra khi tải dữ liệu.");
            }
        };

        fetchBestsellers();
    }, []);

    // Hàm tìm kiếm
    const handleSearch = async () => {
        if (searchTerm) {
            try {
                const response = await axios.get(`http://localhost:8080/api/search?tenSach=${encodeURIComponent(searchTerm)}`);
                console.log(response.data); // Kiểm tra phản hồi từ API

                // Kiểm tra dữ liệu trả về
                if (response.data && Array.isArray(response.data)) {
                    setFilteredBooks(response.data); // Cập nhật với dữ liệu tìm kiếm
                } else if (response.data && response.data.message) {
                    setFilteredBooks([]); // Không có kết quả
                    setError(response.data.message); // Hiển thị thông điệp lỗi
                } else {
                    setFilteredBooks([]); // Không có kết quả
                }
            } catch (error) {
                console.error(error);
                setError("Có lỗi xảy ra khi tìm kiếm.");
            }
        } else {
            setFilteredBooks(books); // Nếu không có từ khóa, hiển thị lại sách bestseller
        }
        setPage(1); // Reset về trang 1 khi tìm kiếm
    };

    const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
    };

    const handleChange = (event, value) => {
        setPage(value);
    };

    const startIndex = (page - 1) * rowsPerPage;
    const endIndex = startIndex + rowsPerPage;
    const currentBooks = filteredBooks.slice(startIndex, endIndex);

    return (
        <Container sx={{ marginTop: 4 }}>
            <Box sx={{ display: 'flex', justifyContent: 'center', margin: '20px 0' }}>
                <TextField
                    label="Tìm kiếm sách"
                    variant="outlined"
                    value={searchTerm}
                    onChange={handleSearchChange}
                    sx={{ width: '300px', marginRight: 2 }} // Chiều rộng và khoảng cách
                />
                <Button variant="contained" onClick={handleSearch}>
                    Tìm kiếm
                </Button>
            </Box>
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6" sx={{ flexGrow: 1 }} textAlign={"center"}>
                        Sách Siêu Sales
                    </Typography>
                </Toolbar>
            </AppBar>
            <Typography variant="body1" align="center" sx={{ marginY: 2 }}>
                Khám phá những cuốn sách siêu hot mà bạn không thể bỏ lỡ. Tìm kiếm và khám phá thêm!
            </Typography>
            <Grid container spacing={4}>
                {error ? (
                    <Typography variant="body1" color="error" align="center">
                        {error}
                    </Typography>
                ) : currentBooks.length > 0 ? (
                    currentBooks.map(book => (
                        <Grid item xs={12} sm={6} md={4} key={book.maSach}>
                            <BookCard book={book} />
                        </Grid>
                    ))
                ) : (
                    <Typography variant="body1" align="center">
                        Không có sách nào phù hợp
                    </Typography>
                )}
            </Grid>
            <Pagination
                count={Math.ceil(filteredBooks.length / rowsPerPage)}
                page={page}
                onChange={handleChange}
                sx={{ display: 'flex', justifyContent: 'center', marginTop: 4 }}
            />
        </Container>
    );
};

export default BookList;