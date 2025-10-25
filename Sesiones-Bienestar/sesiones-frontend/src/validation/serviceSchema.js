import {z} from "zod";
export const serviceSchema = z.object({
   nombre: z.string().min(3, "El nombre debe tener mínimo 3 caracteres"),
   precio: z
	.string()
	.refine((v) => !isNaN(Number(v)) && Number(v) > 0, "El precio debe ser > 0"),
});
