import { useForm } from "react-hook-form";
import { useAuth} from "../auth/AuthContext";

export default function LoginPage() {
	const { register, handleSubmit, formState:{errors} } = useForm();
	const { login } = useAuth();

	const onSubmit = async (d) => {
		try {
			await login(d.username, d.password);
			window.location.href ="/clientes";
		} catch (e) {
			alert("Credenciales inválidas");
		}
	};

	return (
		<div style={{ padding: 20}}>
			<h2>Login</h2>
			<form onSubmit={handleSubmit(onSubmit)} style={{ display:"grid", gap:8, maxWidth: 400}}>
				<label>Usuario <input {...register("username", {required:"usuario requerido"})} /></label>
				{errors.username && <small style={{color:"crimson"}}>{errors.username.message}</small>}

				<label>Contraseña <input type="password" {...register("password", {required:"Contraseña requerida"})} /></label>
				{errors.password && (
  					<small style={{ color: "crimson" }}>
    				{errors.password?.message}
  					</small>
					)}	

				<button type="submit">Entrar</button>
			</form>
		</div>
		);
}