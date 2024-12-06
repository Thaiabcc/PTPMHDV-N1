// src/App.js
import React from "react";
import MyAutocomplete from './components/MyAutocomplete'; // Đảm bảo đường dẫn chính xác
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Home from "./pages/Home";
import BookDetail from "./pages/BookDetail";
import Footer from "./components/Footer";
import ImageSlider from "./components/ImageSlider";

function App() {
  return (
    <Router>
      <Header />
      <ImageSlider />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profit/:maSach" element={<BookDetail />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
