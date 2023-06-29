function altaPaciente() {
    window.open("altaPaciente.html", "popup","width=400,height=940,left=200,top=100");
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
            fechaAlta: document.getElementById("fechaAlta").value.format("YYYY-MM-DD"), //Probar si el format arregla el post
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