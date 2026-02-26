import React from "react";
import {Routes, Route} from "react-router-dom"
import Navbar from "./components/common/navbar";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Footer from "./components/common/footer";
import Dashboard from "./pages/Dashboard";
import Register from "./pages/Register";


function App() {
  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="*" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="//dashboard" element={<Dashboard/>}/>
        <Route path="/register" element={<Register/>}/>
      </Routes>
      <Footer/>
    </>
  );
}

export default App;
