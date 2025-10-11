import {z} from "zod";


export const clientSchema = z.object({
   nombre: z.string().min(3, "El nombre debe tener mínimo 3 caracteres"),
   correo: z.string().email("Correo inválido"),
   telefono: z
	.string()
	.min(8, "El teléfono debe tener 8 dígitos")
	.regex(/^\d+$, "solo números")
});