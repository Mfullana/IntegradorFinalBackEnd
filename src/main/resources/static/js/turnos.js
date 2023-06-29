function altaTurno() {
    window.open("altaTurno.html", "width=400,height=400,left=100,top=100");
}
function altaGenerico() {

    /*Esta funcion es para hacer el alta, funciona y fue probada*/
    console.log('Intentando hacer el alta de ' + document.getElementById("nombre").value + ' ' + document.getElementById("apellido").value)
    //Aqui tomo el mismo Endpoint que aparece en el Swagger//
    const url = 'http://localhost:8080/pacientes/crear';

    let id = parseInt(document.getElementById("id").value)
    const settings = {
        method: 'POST',
        body: JSON.stringify({
            nombre: document.getElementById("nombre").value,
            apellido: document.getElementById("apellido").value,
            dni: document.getElementById("dni").value,
            fechaAlta: document.getElementById("fechaAlta").value,
            calle:document.getElementById("calle").value,
            numero:document.getElementById("numero").value,
            localidad:document.getElementById("localidad").value,
            provincia:document.getElementById("provincia").value,

        }),
        //Importante agregarle el header para que tome el post
        headers: {
            'Content-Type': 'application/json'
        }
    }

    console.log('Alta de ' + document.getElementById("nombre").value + ' ' + document.getElementById("apellido").value + ' exitosa')
    //Aca usa el url y la configuracion armada arriba para enviar el post al servidor
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });

}


////borrar el turno buscado
//
//let botonBorrar = document.querySelector("#idEliminar");
//botonBorrar.addEventListener('click', (e)=>{
//let config = {
//method : "DELETE",
//headers: {
//'Content-Type': 'application/json'
//
//},
//body :""
//}
//fetch('http://localhost:8080/turnos/eliminar/${info.id}', config)
//.them((respuesta)=>{
//    if(respuesta.status === 204){
//        resultado.innerHTML = '<div class="exito">
//                                    <h4>Eliminado con exito!</h4>
//                                 <div>';
//        listadoTurnos.innerHTML = "";
//        }
//})
//.them((info)=> console.log(info))
//.catch((error)) => console.log(error))
//})
//})
//.catch((error) => console.log(error))
//})
//{)
//.catch((error)=> console.log(error))
//})
//})