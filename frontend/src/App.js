import Logo from "./components/common/Logo";
import Navbar from "./components/common/navbar";
import "./App.css"
import Home from "./pages/home";

function App() {
  return (
    <div className="App">
      <Navbar />
      <div className="HomeLogo">
        <Logo />
      </div>
      <Home/>
    </div>
  );
}

export default App;
