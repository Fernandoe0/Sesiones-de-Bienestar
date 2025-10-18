import {Link} from "react-router-dom"
import {useAuth} from "../auth/AuthContext";

export default function Navbar() {
  const {isAuth, logout} = useAuth();

return (
   <nav style={{ padding: 12, borderBottom: "1px solid #ddd", display:"flex", gap:12}}>
     <Link to="/">Home</Link>
     {isAuth && (
	<>
	  <Link to="/clientes">Clientes</Link>
	  <Link to="/servicios">Servicios</Link>
	  <button onClick={logout} style={{marginLeft: "auto"}}>Salir</button>
	</>
	)}
	{!isAuth && <Link to="/login" style={{ marginLeft: "auto"}}>Login</Link>}
	</nav>
    );
}