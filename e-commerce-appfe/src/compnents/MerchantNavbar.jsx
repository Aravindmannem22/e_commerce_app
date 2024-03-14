import { Link } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
import "../styles/MerchantNavbar.css";


import AccountCircleIcon from '@mui/icons-material/AccountCircle';
const MerchantNavbar = () => {
    return ( 
        <nav>
            <div className="logo">
                <h1><span>Shopper</span> Cart</h1>
            </div>
            <div className="option">
                <Link to ="/merchanthomepage/productview">View product</Link>
                 </div>
                 <div className="account">
                 <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
       <AccountCircleIcon/> Accounts
      </Dropdown.Toggle>

      <Dropdown.Menu>
        <Dropdown.Item href="/merchanthomepage/updatemerchant">Edit Account</Dropdown.Item>
        <Dropdown.Item href="/">Logout</Dropdown.Item>
       
      </Dropdown.Menu>
    </Dropdown>
  
                 </div>
        </nav>
     );
}
 
export default MerchantNavbar;