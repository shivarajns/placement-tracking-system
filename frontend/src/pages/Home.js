import React from "react";
import Logo from "../components/common/Logo";
import Line from "../components/common/line";
import ExploreSection from "../components/Home/Explore";
// import Features from "../components/Home/Features";
import AboutSection from "../components/Home/About";

function Home() {

    return(
        <>
            <Logo/>
            <Line/>
            <ExploreSection/>
            <Line/>
            {/* <Features/> */}
            <AboutSection/>
        </>
    )
}

export default Home