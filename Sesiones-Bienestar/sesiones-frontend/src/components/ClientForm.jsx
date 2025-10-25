import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { clientSchema } from "../validation/clientSchema";

export default function ClientForm({ onSubmit, defaultValues }) {
  const { register, handleSubmit, formState: { errors }, reset } = useForm({
    resolver: zodResolver(clientSchema),
    defaultValues: { nombre: "", correo: "", telefono: "" },
  });

  // Cuando cambias a "editar", precarga el formulario
  useEffect(() => {
    if (defaultValues) {
      reset({
        nombre: defaultValues.nombre ?? "",
        correo: defaultValues.correo ?? "",
        telefono: defaultValues.telefono ?? "",
      });
    } else {
      reset({ nombre: "", correo: "", telefono: "" });
    }
  }, [defaultValues, reset]);

  const submit = async (data) => {
    await onSubmit(data);
    reset({ nombre: "", correo: "", telefono: "" });
  };

  return (
    <form onSubmit={handleSubmit(submit)} style={{ display: "grid", gap: 10, width: 320 }}>
      <label>
        Nombre<br />
        <input {...register("nombre")} placeholder="Juan Pérez" />
        {errors.nombre && <small style={{color:"crimson"}}>{errors.nombre.message}</small>}
      </label>

      <label>
        Correo<br />
        <input type="email" {...register("correo")} placeholder="correo@dominio.com" />
        {errors.correo && <small style={{color:"crimson"}}>{errors.correo.message}</small>}
      </label>

      <label>
        Teléfono<br />
        <input {...register("telefono")} placeholder="55555555" />
        {errors.telefono && <small style={{color:"crimson"}}>{errors.telefono.message}</small>}
      </label>

      <button type="submit">{defaultValues ? "Guardar cambios" : "Crear"}</button>
    </form>
  );
}