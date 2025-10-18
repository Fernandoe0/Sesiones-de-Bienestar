import { createContext, useContext, useEffect, useState } from "react";
import api from "../api/axios";

const AuthContext = createContext();

export function AuthProvider({ children }) {
  const [token, setToken] = useState(() => localStorage.getItem("token"));

  
  const login = async (username, password) => {
	const {data} = await api.post("/auth/login", { username, password });
	localStorage.setItem("token", data.token);
	setToken(data.token);
};

const logout = () => {
   localStorage.removeItem("token");
   setToken(null);
};

useEffect(() => {

}, []);

return(
  <AuthContext.Provider value={{ token, isAuth: !!token, login, logout }}>
	{children}
      </AuthContext.Provider>
    );
}

export const useAuth = () => useContext(AuthContext);