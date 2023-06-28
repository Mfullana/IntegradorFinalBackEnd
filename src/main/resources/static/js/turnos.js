//borrar el turno buscado

let botonBorrar = document.querySelector("#idEliminar");
botonBorrar.addEventListener('click', (e)=>{
let config = {
method : "DELETE",
headers: {
'Content-Type': 'application/json'

},
body :""
}
fetch('http://localhost:8080/turnos/eliminar/${info.id}', config)
.them((respuesta)=>{
    if(respuesta.status === 204){
        resultado.innerHTML = '<div class="exito">
                                    <h4>Eliminado con exito!</h4>
                                 <div>';
        listadoTurnos.innerHTML = "";
        }
})
.them((info)=> console.log(info))
.catch((error)) => console.log(error))
})
})
.catch((error) => console.log(error))
})
{)
.catch((error)=> console.log(error))
})
})