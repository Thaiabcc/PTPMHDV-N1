// src/components/ImageSlider.js
import React from "react";
import Slider from "react-slick";
import { Box, IconButton } from "@mui/material";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

const ImageSlider = () => {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true, // Tự động chuyển
        autoplaySpeed: 2500, // Thay đổi mỗi 4 giây
    };

    const images = [
        "https://theme.hstatic.net/200000343865/1001052087/14/ms_banner_img2.jpg?v=1556",
        "https://theme.hstatic.net/200000343865/1001052087/14/ms_banner_img5.jpg?v=1556",
        "https://theme.hstatic.net/200000343865/1001052087/14/ms_banner_img1.jpg?v=1556",
    ];

    let sliderRef = React.useRef(null);

    return (
        <Box sx={{ marginY: 4 }}>
            <Slider ref={sliderRef} {...settings}>
                {images.map((image, index) => (
                    <div key={index}>
                        <img src={image} alt={`Slide ${index + 1}`} style={{ width: '100%', height: 'auto' }} />
                    </div>
                ))}
            </Slider>
        </Box>
    );
};

export default ImageSlider;