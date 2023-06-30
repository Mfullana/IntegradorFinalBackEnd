function altaTurno() {
    window.open("altaTurno.html", "popup", "width=400,height=930,left=200,top=100");
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
            fecha: document.getElementById("fecha").value,
            paciente: {
                nombre: document.getElementById("nombre").value,
                apellido: document.getElementById("apellido").value,
                dni: document.getElementById("dni").value,
                domicilio: {
                    calle: document.getElementById("calle").value,
                    numero: document.getElementById("numero").value,
                    localidad: document.getElementById("localidad").value,
                    provincia: document.getElementById("provincia").value
                }
            },
            odontologo: {
                nombre: document.getElementById("nombreOdon").value,
                apellido: document.getElementById("apellidoOdon").value,
                matricula: document.getElementById("matricula").value
            }
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

/*Automatically set getdate() on fecha when page loads or refreshes*/
window.onload = function () {
    var fecha = new Date();
    var dd = fecha.getDate();
    var mm = fecha.getMonth() + 1;
    var yyyy = fecha.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm

    }
    fecha = yyyy + '-' + mm + '-' + dd;
    document.getElementById("fechaAlta").setAttribute("value", fecha);
    document.getElementById("fechaAlta").setAttribute("disabled", "true");

}
