import { z } from "zod";

export const clientSchema = z.object({
  nombre: z.string().min(3, "Nombre mínimo 3 caracteres"),
  correo: z.string().email("Correo no válido"),
  telefono: z.string().regex(/^\d{8,}$/, "Teléfono: solo dígitos (≥8)"),
});