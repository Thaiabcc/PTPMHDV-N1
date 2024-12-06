// src/components/Header.js
import React from "react";
import { AppBar, Toolbar, Typography, Button } from "@mui/material";
import { Link } from "react-router-dom";
const Header = () => {
    return (
        <AppBar position="sticky" sx={{ backgroundColor: 'primary.main' }}>
            <Toolbar>
                <Button color="inherit" component={Link} to="/" sx={{ marginLeft: 2 }}>
                    Home
                </Button>
                <Button color="inherit" component={Link} to="/" sx={{ marginLeft: 2 }}>
                    Thanh Toán
                </Button>
                <Button color="inherit" component={Link} to="/" sx={{ marginRight: 2 }}>
                    Books
                </Button>
                <Typography variant="h6" sx={{ border: "HighlightText", flexGrow: 2, textAlign: 'center' }}>
                    Book Store
                </Typography>
                <Button color="inherit" component={Link} to="/" sx={{ marginLeft: 2 }}>
                    Giỏ Hàng
                </Button>
                <Button color="inherit" component={Link} to="/" sx={{ marginLeft: 2 }}>
                    Sách Yêu Thích
                </Button>
            </Toolbar>
        </AppBar>
    );
};

export default Header;