import { BrowserRouter,Route,Routes } from "react-router-dom";
import LandingPage from "./compnents/LandingPage";
import MerchantLogin from "./compnents/MerchantLogin";
import MerchantSignUp from "./compnents/MerchantSignUp";


import UesrLogin from "./compnents/UserLogin";
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantHomepage from "./compnents/MetchantHomepage";
import Error from "./compnents/error";
import Protect from "./compnents/Protect";


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<LandingPage/>}/>
        <Route path="/*" element={<Error/>}/>
        <Route path="/merchant" element={<MerchantLogin/>}/>
        <Route path="/user" element={<UesrLogin/>}/>
        <Route path="/merchantsignup" element={<MerchantSignUp/>}/>
        <Route path="/merchanthomepage/*" element={<Protect Child= {MerchantHomepage}/>}/>
       
      </Routes>
      </BrowserRouter>

      
    </div>
  );
}

export default App;
