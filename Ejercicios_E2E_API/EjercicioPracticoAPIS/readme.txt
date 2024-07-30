Instrucciones : paso a paso del ejercicio.

OBJETIVO DEL DESARROLLO
Realizar prueba test API.

CASOS DE PRUEBA
- Crear un usuario.
- Buscar el usuario creado.
- Actualizar nombre y el correo del usuario.
- Buscar el usuario actualizado.
- Eliminar el usuario.

HERRAMIENTAS SELECCIONADAS
- Cypress.
- Visual Code.

DESARROLLO

1. Crear un usuario: se tomala el endpoint de creación de usuario "POST" donde se envie el body con los parámetros que están documentandos en swagger y se valida la salida esperada status 200.
2. Buscar usuario creado: se toma el endpoint de buscar usuario "GET" donde se envia en la url el parámetro de nombre y se valida la salida esperada status 200.
3. Actualizar nombre y correo: se toma el endpoint de actualizar usuario "PUT" donde se envia el nombre del usuario a actualizar, asi mismo se arma en body enviando los valores a actualizar y se valida la respuesta esperada un 200.
4. Buscar usuario actualizado: se toma el endpoint de buscar usuario "GET", solo que esta vez se envia en la url el nuevo nombre que se actualizo en el punto 3, y se valida la salida status 200.
5. Eliminar usuario: se toma el endpoint de eliminar usuario "DELETE", enviando en la url en parámetro a eliminar y se valida la salida un status 200.







