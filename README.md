# PROYECTO_ACID
Prueba conocimientos AcidLabs

Para la ejecucion de este proyecto se utilizo el IDE Netbeans 8.2 con el servidor Glassfish 4.1.1

Pasos:

	1.- Ir a pestaña "File" opcion "Open Project..."
	2.- Buscamos el directorio del proyecto y presionamos el boton "Open Project"
	3.- Sobre el proyecto, hacemos click derecho y pulsamos la opcion "Build with Dependencies"
	4.- Ir a pestaña "Run" y presionar sobre la opcion "Run Project"
	
	Al cargar el proyecto, se deberia abrir automaticamente el navegador de internet con la URL: http://localhost:8080/AcidLabsUsers, en caso de no ser asi y el proyecto se encuentra en ejecucion,
	ingresar la URL manual en su navegador.
	
	En esta aplicacion, se puede crear usuarios y luego ser consultados lo 
	5.- Para crear usuario, se debe ingresar un numero en el campo de "ID user", un nombre de usuario en el campo "User name" y seleccionar una imagen presionando el boton "Examinar..."
	6.- Una vez asignado los campos a insertar, se debera presionar el boton "Create user" el cual arrojara un mensaje indicando el JSON que se esta enviando y luego la respuesta "success"
	
	En esta aplicacion tambien se puede consultar por los usuarios insertados
	7.- Para consultar por los usuarios insertados, se debera presionar el boton "Return users list" el cual se mostrara la respuesta "success"
	
Utilizando peticiones desde aplicativos de terceros.

Para este caso, se utilizo el plugin "POSTMAN" del navegador "Chrome"

A continuacion se mostrara los URL que se pueden utilizar con POSTMAN en esta aplicacion:

Agregar usuario principal
GET : http://localhost:8080/AcidLabsUsers/rest/user/acid 

Para este caso, hay un metodo que agregar un usuario por defecto el cual esta definido de la siguiente manera:

  {
    "id": 1,
    "username": "Ivan Riveros",
    "image": "C:\\Users\\ivriv\\Pictures\\test.png"
  }

    -------
   
Obtener todos los usuarios
GET : http://localhost:8080/AcidLabsUsers/rest/users

	-------
Obtener usuario por ID especifico
GET : http://localhost:8080/AcidLabsUsers/rest/user/{id}

	-------
Creación de usuario
POST: http://localhost:8080/AcidLabsUsers/rest/user/create

	-------
Eliminar usuario por ID especifico
PUT: http://localhost:8080/AcidLabsUsers/rest/user/delete/{id}


	GET:
	
	1.- Para ejecutar las URL GET, se debe abrir el plugin "POSTMAN"
	2.- Abrir "New Tab" con el boton "+"
	3.- Seleccionar la opcion "GET"
	4.- insertar la URL "GET" deseada
	5.- Presionar boton "Send"
	
	Caso 1:
	
	http://localhost:8080/AcidLabsUsers/rest/user/acid
	
	retorno: 
	
	{
	  "id": 1,
	  "username": "Ivan Riveros",
	  "image": "C:\\Users\\ivriv\\Pictures\\test.png"
	}
	
	Caso 2:
	
	http://localhost:8080/AcidLabsUsers/rest/user/1
	
	retorno:
	
	{
	  "id": 1,
	  "username": "Ivan Riveros",
	  "image": "C:\\Users\\ivriv\\Pictures\\test.png"
	}
	
	Caso 3:
	
	http://localhost:8080/AcidLabsUsers/rest/users
	
	retorno:
	
	[
	  {
		"id": 1,
		"username": "Ivan Riveros",
		"image": "C:\\Users\\ivriv\\Pictures\\test.png"
	  },
	  {
		"id": 2,
		"username": "test2",
		"image": "C:\\Users\\ivriv\\Pictures\\test.png"
	  }
	]
	
	NOTA: id 2 fue ingresado la pagina http://localhost:8080/AcidLabsUsers
	
	POST:
	
	1.- Para ejecutar las URL POST, se debe abrir el plugin "POSTMAN"
	2.- Abrir "New Tab" con el boton "+"
	3.- Seleccionar la opcion "POST"
	4.- Insertar la URL "POST" deseada
	5.- Seleccionar pestaña BODY
	6.- Seleccionar el radiobutton raw
	7.- Al lado de los radiobutton, seleccionar la pestaña JSON
	8.- Agregar el JSON del siguiente formato.
	{
	"id": {ID deseado},
	"username": "{Nombre usuario deseado}",
	"image": "{Ruta archivo deseado}"
	}
	9.- Presionar boton "Send"
	
	Caso 1: 
	
	http://localhost:8080/AcidLabsUsers/rest/user/create
	
	JSON
	
	{
	"id": 444,
	"username": "KIKI",
	"image": "C:\\Users\\ivriv\\Pictures\\Fewtiyz.png"
	}
	
	retorno:
	
	{
	  "id": 444,
	  "username": "KIKI",
	  "image": "C:\\Users\\ivriv\\Pictures\\Fewtiyz.png"
	}
	
	PUT:
	
	1.- Para ejecutar las URL PUT, se debe abrir el plugin "POSTMAN"
	2.- Abrir "New Tab" con el boton "+"
	3.- Seleccionar la opcion "PUT"
	4.- insertar la URL "PUT" deseada
	5.- Presionar boton "Send"

	Caso 1:
	
	http://localhost:8080/AcidLabsUsers/rest/user/delete/444
	
	retorno:
	
	{
	  "id": 444,
	  "username": "KIKI",
	  "image": "C:\\Users\\ivriv\\Pictures\\Fewtiyz.png"
	}
	