import { useEffect, useState } from "react";
import api from "../api/axios";
import ServiceFrom from "../components/ServiceForm";

export default function ServiciosPage() {
   const [data, setData] = useState([]);
   const [edit, setEdit] = useState(null);

   const load = async () => {
   	const res = await api.get("/servicios");
   	setData(res.data);
   };
   useEffect(()=>{ load(); }, []);

   const create = async (dto) => {
   	dto.precio = Number(dto.precio);
   	await api.post("/servicios", dto);
   	await load();
   	alert("Servicio creado");
   };

   const startEdit = (s) => setEdit(s);
   const update = async (dto) => {
   	const id = edit.idServicio ?? edit.id;
   	dto.precio = Number(dto.precio);
   	await api.put('/servicios/${id}', dto);
   	await load();
   	setEdit(null);
   	alert("Servicio actualizado");
   };

   const remove = async (s) => {
   	const id = s.idServicio ?? s.id;
   	if (confirm("¿Eliminar servicio?")) {
   		await api.delete('/servicios/${id}');
   		await load();
   	}
   };

   return (
   	<div style={{ padding:20}}>
   		<h2>Servicios</h2>Servicios

   		<div style={{ display:"flex", gap:40}}>
   		  <div>
   		  	<h3>{edit ? "Editar" : "Nuevo"}</h3>
   		  	<ServiceFrom onSubmit={edit ? update : create} defaultValues={edit ? {...edit, precio: String(edit.precio)} : undefined} />
   		  	{edit && <button onClick={()=>setEdit(null)} style={{ marginTop:8 }}>Cancelar edición</button>}
   		  		<p style={{marginTop:10, color:"#555"}}>
   		  			<b>Validaciones visibles:</b> nombre (≥3), precio numérico mayor a 0.
   		  		</p>
   		  	</div>

   		  	<div style={{ flex:1}}>
   		  		<table border="1" cellPadding="6">
   		  			<thead>
   		  				<tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Acciones</th></tr>
   		  			</thead>
   		  			<tbody>
   		  				{data.map(s => (
   		  					<tr key={(s.idServicio ?? s.id)}>
   		  						<td>{s.idServicio ?? s.id}</td>
   		  						<td>{s.nombre}</td>
   		  						<td>{s.precio}</td>
   		  					<td>
   		  						<button onClick={()=>startEdit(s)}>Editar</button>
   		  						<button onClick={()=>remove(s)} style={{ marginLeft:6 }}>Eliminar</button>
   		  					</td>
   		  				</tr>
   		  					))}
   		  				{data.length===0 && <tr><td colSpan="4">Sin servicios</td></tr>}
   		  			</tbody>
   		  		</table>
   		  		</div>
   		  	</div>
   		  </div>
   	);
}