// src/components/BookCard.js
import React from "react";
import { Card, CardContent, CardMedia, Typography } from "@mui/material";
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

const BookCard = ({ book }) => {
    return (
        <Card>
            <CardMedia
                component="img"
                height="350"
                image={book.linkAnh}
                alt={book.tenSach}
            />
            <CardContent>
                <Typography variant="h5">{book.tenSach}</Typography>
                <Typography variant="subtitle1">Tác Giả: {book.tenTG}</Typography>
                <Typography variant="body2" color="text.secondary" sx={{ textDecoration: 'line-through' }}>
                    Giá Gốc: {book.giaGoc}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Giá Khuyến Mại: {book.giaKM}
                    <Typography>
                        <Link to={`/profit/${book.maSach}`}>
                            <Button variant="contained" color="primary">
                                Xem chi tiết
                            </Button>
                        </Link>
                    </Typography>
                </Typography>
            </CardContent>
        </Card>
    );
};

export default BookCard;
