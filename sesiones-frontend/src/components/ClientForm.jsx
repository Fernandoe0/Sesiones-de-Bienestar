import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { clientSchema } from "../validation/clientSchema";

export default function ClientForm({ onSubmit, defaultValues }) {
	const { register, handleSubmit, formState: {errors }, reset } = useForm({
		resolver: zodResolver(clientSchema),
		defaultValues: defaultValues || { nombre:"", correo:"", telefono:"" },
	});

	return (
		<form onSubmit={handleSubmit((d)=>{ onSubmit(d); reset();})} style={{display:"grid", gap:8, maxWidth: 500}}>
			<label>Nombre <input {...register("nombre")} /></label>
			{errors.nombre && <small style={{color:"crimson"}}>{errors.nombre.message}</small>}

			<label>Correo <input {...register("correo")} /></label>
			{errors.correo && <small style={{color:"crimson"}}>{errors.correo.message}</small>}

			<label>Teléfono <input {...register("telefono")} /></label>
			{errors.telefono && <small style={{color:"crimson"}}>{errors.telefono.message}</small>}

			<button type="submit">Guardar</button>
		</form>

	);
			
			
			
}