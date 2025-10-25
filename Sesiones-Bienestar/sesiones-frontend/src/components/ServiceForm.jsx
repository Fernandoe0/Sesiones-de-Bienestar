import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { serviceSchema} from "../validation/serviceSchema";

export default function ServiceForm({ onSubmit, defaultValues }) {
 const { register, handleSubmit, formState: { errors }, reset } = useForm({
   resolver: zodResolver(serviceSchema),
   defaultValues: defaultValues || { nombre:"", precio:""},
});

 return (
 	<form onSubmit={handleSubmit((d)=>{ onSubmit({ ...d, precio: Number(d.precio) }); reset(); })}
 		style={{ display:"grid", gap:8, maxWidth: 500 }}>
 	<label>nombre <input {...register("nombre")} /></label>
 	{errors.nombre && <small style={{color:"crimson"}}>{errors.nombre.message}</small>}

 	<label>Precio <input {...register("precio")} /></label>
 	{errors.precio && <small style={{color:"crimson"}}>{errors.precio.message}</small>}

 	<button type="submit">Guardar</button>
  </form>
	);
}