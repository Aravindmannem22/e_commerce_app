import { Link } from "react-router-dom";
import "../styles/LandingPage.css"
const LandingPage = () => {
  return (
    <div className="landingpage">


      <Link to="/merchant">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWfTdgKoyWAuNd40PkKJen5VH7MANNOE0TTT8ZJIcjzyRrB7tTfvIx1Ar59b87fvQIPns&usqp=CAU" />Merchant</Link>
      <Link to="/user">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjoaEJig6G9xO7jdBwOVrSVahDhrcI7MAPRGCRPmg8RA&s" /> User</Link>


    </div>
  );
}

export default LandingPage;