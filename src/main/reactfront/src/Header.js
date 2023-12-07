import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
    return (
        <div>
            <div>
                <h1 style={{display: 'inline-block'}}>헤더</h1> <span><Link to="/">메인페이지로 가기</Link></span>
            </div>
            <hr/>
        </div>
    )
}

export default Header;