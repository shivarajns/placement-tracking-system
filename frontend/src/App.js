import React from "react";
import {Routes, Route} from "react-router-dom"
import Navbar from "./components/common/navbar";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Footer from "./components/common/footer";
import Dashboard from "./pages/Dashboard";


function App() {
  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="*" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="//dashboard" element={<Dashboard/>}/>
      </Routes>
      <Footer/>
    </>
  );
}

export default App;
