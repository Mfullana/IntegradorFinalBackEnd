function altaPaciente()
{
          //con fetch invocamos a la API de peliculas con el método DELETE
          //pasandole el id en la URL
          const url = '/crear';
          const settings = {
              method: 'DELETE'
          }
          fetch(url,settings)
          .then(response => response.json())

}