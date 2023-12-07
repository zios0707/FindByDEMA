import React, {useState} from "react";

const Login = () => {
    const [values, setValues] = useState({
        sid: "",
        pass: ""
    });

    const handleChange = e => {
        setValues({
            ...values,
            [e.target.name]: e.target.value,
        })
    }

    const handleSubmit = e => {
        e.preventDefault()
        alert(JSON.stringify(values, null, 2))
    }

    return (
        <div>
            <p>로그인 페이지입니다.</p>
            <br/>

            <form onSubmit={handleSubmit}>
                <input type="text"
                       name="sid"
                       value={values.sid}
                       onChange={handleChange}/> <br/>
                <input type="password"
                       name="pass"
                       value={values.pass}
                       onChange={handleChange}/> <br/>

                <button type="submit">로그인</button>
            </form>

        </div>
    )
}

export default Login;