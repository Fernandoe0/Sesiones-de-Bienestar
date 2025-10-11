import { Routes, Route, Navigate } from "react-router-dom";
import Navbar from "./components/Navbar";
import LoginPage from "./pages/LoginPage";
import ClientesPage from "./pages/ClientesPage";
import ServiciosPage from "./pages/ServiciosPage";
import ProtectedRoute from "./auth/ProtectedRoute";

export default function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Navigate to="/clientes" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/clientes" element={<ProtectedRoute><ClientesPage /></ProtectedRoute>} />
        <Route path="/servicios" element={<ProtectedRoute><ServiciosPage /></ProtectedRoute>} />
        <Route path="*" element={<div style={{padding:20}}>404</div>} />
      </Routes>
    </>
  );
}
