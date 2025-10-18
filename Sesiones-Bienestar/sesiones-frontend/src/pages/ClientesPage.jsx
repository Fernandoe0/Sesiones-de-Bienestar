import { useEffect, useState } from "react";
import api from "../api/axios";
import ClientForm from "../components/ClientForm";

export default function ClientesPage() {
  const [data, setData] = useState([]);
  const [edit, setEdit] = useState(null);

  const load = async () => {
    const res = await api.get("/clientes");
    setData(res.data);
  };
  useEffect(()=>{ load(); },[]);

  const create = async (dto) => {
    await api.post("/clientes", dto);
    await load();
    alert("Cliente creado");
  };

  const startEdit = (c) => setEdit(c);
  const update = async (dto) => {
    const id = edit.idCliente ?? edit.id;  
    await api.put(`/clientes/${id}`, dto);
    await load();
    setEdit(null);
    alert("Cliente actualizado");
  };

  const remove = async (c) => {
    const id = c.idCliente ?? c.id;
    if (confirm("¿Eliminar cliente?")) {
      await api.delete(`/clientes/${id}`);
      await load();
    }
  };

  return (
    <div style={{ padding:20 }}>
      <h2>Clientes</h2>

      <div style={{ display:"flex", gap:40 }}>
        <div>
          <h3>{edit ? "Editar" : "Nuevo"}</h3>
          <ClientForm onSubmit={edit ? update : create} defaultValues={edit || undefined} />
          {edit && <button onClick={()=>setEdit(null)} style={{ marginTop:8 }}>Cancelar edición</button>}
          <p style={{marginTop:10, color:"#555"}}>
            <b>Validaciones visibles:</b> nombre (≥3), email válido, teléfono numérico (≥8).
          </p>
        </div>

        <div style={{ flex:1 }}>
          <table border="1" cellPadding="6">
            <thead>
              <tr><th>ID</th><th>Nombre</th><th>Correo</th><th>Teléfono</th><th>Acciones</th></tr>
            </thead>
            <tbody>
              {data.map(c => (
                <tr key={(c.idCliente ?? c.id)}>
                  <td>{c.idCliente ?? c.id}</td>
                  <td>{c.nombre}</td>
                  <td>{c.correo}</td>
                  <td>{c.telefono}</td>
                  <td>
                    <button onClick={()=>startEdit(c)}>Editar</button>
                    <button onClick={()=>remove(c)} style={{ marginLeft:6 }}>Eliminar</button>
                  </td>
                </tr>
              ))}
              {data.length===0 && <tr><td colSpan="5">Sin clientes</td></tr>}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}
