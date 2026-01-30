import Logo from "./components/common/Logo";
import Navbar from "./components/common/navbar";
import "./App.css"

function App() {
  return (
    <div className="App">
      <Navbar />
      <div className="HomeLogo">
        <Logo />
      </div>
    </div>
  );
}

export default App;
