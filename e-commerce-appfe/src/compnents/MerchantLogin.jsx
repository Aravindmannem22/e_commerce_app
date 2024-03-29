import { Link, json, useNavigate } from 'react-router-dom';
import "../styles/MerchantLogin.css";
import axios from 'axios';
import { useState } from 'react';
import Form from 'react-bootstrap/Form';
const MerchantLogin = () => {
    let [email,setemail]= useState(" ")
    let [password,setpassword] = useState(" ")

    let navigate = useNavigate()
    function verifymerchant (e) {
        e.preventDefault();
         axios.post(`http://localhost:8080/merchants/verify?email=${email}&password=${password}`)
          .then((res)=>{
            console.log(res.data);
            localStorage.setItem("Merchant",JSON.stringify(res.data.body))
            navigate('/merchanthomepage')
            alert("login successfull")
        })
        .catch((err)=>{
            console.log(err.data);
            alert("Invalid credentials")
        })
    }
    
    return (

        <div className="MerchantLogin">
            <Form>
                <h1>Merchant Login</h1>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control value={email} onChange={(e) => {setemail(e.target.value)}} type="email" placeholder="Enter email" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control  value={password} onChange={(e) => {setpassword(e.target.value)}} type="password" placeholder="Password" />
                </Form.Group>
                <Form.Group>
                    <button  className="btn btn-danger mx-5" onClick={verifymerchant}>Login</button>
                    <button className="btn btn-success mx-5"> <Link to ="/merchantsignup"> Sigh Up</Link> </button>
                </Form.Group>
            </Form>
        </div>
    );
}

export default MerchantLogin;