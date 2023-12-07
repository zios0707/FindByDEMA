import React from "react";
import {Link} from "react-router-dom";

const Main = () => {

    return (
        <div>
            <p>메인페이지입니다.</p>
            <br/>
            <Link to="/sign">회원가입하기</Link> <br/>
            <Link to="/login">로그인하기</Link> <br/>
        </div>
    )
}

export default Main;