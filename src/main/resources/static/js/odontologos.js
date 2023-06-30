function altaOdontologo() {
    //window.open("altaOdontologo.html", "popup", "width=500,height=500,left=200,top=200");
    //Make this popup open with 100% of its content height + 30px
    window.open("altaOdontologo.html", "popup", "width=500,height=450,left=200,top=200");
    
}

//function altaPaciente() {
//    window.open("altaPaciente.html", "width=400,height=400,left=100,top=100");
//
//}

/*Se le puso el prevent default para poder dejar los datos cargados sin que vuelva a cargar la pagina, y poder debugear con la consola, 
se puede probar sin el preventDefault ahora que esta arreglado el Post*/
var boton = document.getElementById("eliminarOdon");

boton.addEventListener("click", function (event) {
    {
        event.preventDefault();
    }
});


function altaGenerico() {

    /*Esta funcion es para hacer el alta, funciona y fue probada*/
    console.log('Intentando hacer el alta de ' + document.getElementById("nombre").value + ' ' + document.getElementById("apellido").value)
    //Aqui tomo el mismo Endpoint que aparece en el Swagger//
    const url = 'http://localhost:8080/odontologos/crear';

    let matricula = parseInt(document.getElementById("matricula").value)
    const settings = {
        method: 'POST',
        body: JSON.stringify({
            nombre: document.getElementById("nombre").value,
            apellido: document.getElementById("apellido").value,
            matricula: matricula
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
function obtenerOdontologos() {
    //Este funciona y fue probado, trae en consola los odontologos que se encuentran dados de alta
    const url = 'http://localhost:8080/odontologos/todos';
    const settings = {
        method: 'GET'

    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
//
function eliminarOdontologo() {

    const url = 'http://localhost:8080/odontologos/eliminar';
    let id = parseInt(document.getElementById("idEliminarOdon").value)
    let parameter = url+"/"+id
    const settings = {
        method: 'DELETE',

        headers: {'Content-Type': 'application/json'}
    }
    fetch(parameter, settings)
        .then(response => response.json())
        .then(data => {console.log(data);})
        .catch(error => {console.error('Error:', error);});
}