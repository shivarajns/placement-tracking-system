import React from "react";
import {Routes, Route} from "react-router-dom"
import Navbar from "./components/common/navbar";
import Home from "./pages/Home";
import Login from "./pages/Login";


function App() {
  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/login" element={<Login/>}/>
      </Routes>
    </>
  );
}

export default App;
