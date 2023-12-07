import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Sign from "./js/SignIn";
import Login from "./js/Login";
import Main from "./js/Main";
import {Layout} from "./Layout";

function Routing() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Layout/>}>
                        <Route path='' element={<Main/>} />
                        <Route path='sign' element={<Sign/>} />
                        <Route path='login' element={<Login/>} />
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    )
}

export default Routing;
