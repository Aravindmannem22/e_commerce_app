import { Route, Routes } from "react-router-dom";
import MerchantNavbar from "./MerchantNavbar";
import Productview from "./productview";
import UpdateMerchant from "./UpdateMerchant";

const MerchantHomepage = () => {
    return ( 
        <div className="mph">
            <MerchantNavbar/>
            <Routes>
                <Route path ="/productview" element={<Productview/>}/>
                <Route path ="/updatemerchant" element={<UpdateMerchant/>}/>
                
            </Routes>
        </div>
     );
}
 
export default MerchantHomepage;