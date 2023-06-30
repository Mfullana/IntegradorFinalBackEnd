var boton = document.getElementById("btn-alta-generica");

document.addEventListener('DOMContentLoaded', function () {
    var datepickers = document.querySelectorAll('.datepicker');
    M.Datepicker.init(datepickers, {
        autoClose: true,
        format: 'yyyy-mm-dd' // Actualiza el formato al deseado (ISO 8601)
    });

});

$('#fechaAlta').mask('00/00/0000');
$('#fecha').mask('00/00/0000');

boton.addEventListener("click", function (event) {
 console.log ("hola")
    {
        event.preventDefault();
    }
});

function altaTurno() {
    window.open("altaTurno.html", "popup", "width=400,height=930,left=200,top=100");
}
function altaGenerico() {

    /*Esta funcion es para hacer el alta, funciona y fue probada*/
    console.log('Intentando hacer el alta de ' + document.getElementById("nombre").value + ' ' + document.getElementById("apellido").value)
    //Aqui tomo el mismo Endpoint que aparece en el Swagger//
    const url = 'http://localhost:8080/turnos/crear';
var fechaInput = document.getElementById('fecha');

        var fechaSeleccionada = new Date(fechaInput.value);
        var fechaTurno = fechaSeleccionada.toISOString();
//    let fechaTurno = document.getElementById("fecha").value
        /*format yyyy-mm-dd*/
//        fechaTurno = fechaTurno.substring(6, 10) + '-' + fechaTurno.substring(3, 5) + '-' + fechaTurno.substring(0, 2)
  //  let fechaTurnoFormateada = fechaTurno.toISOString();
    const settings = {
        method: 'POST',
        body: JSON.stringify({
               fecha: fechaTurno,
            paciente: {
                id: document.getElementById("idPaciente").value,
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
                id: document.getElementById("idOdontologo").value,
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
    console.log(settings)
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
    fecha = dd + '/' + mm + '/' + yyyy;
    document.getElementById("fechaAlta").setAttribute("value", fecha);
    document.getElementById("fechaAlta").setAttribute("disabled", "true");

}
