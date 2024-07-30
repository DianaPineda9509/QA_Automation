Instrucciones : paso a paso del ejercicio.

OBJETIVO DEL DESARROLLO
Realizar un flujo de compra.

CASOS DE PRUEBA
- Realizar login.
- Agregar productos al carrito de compra.
- Visualizar carrito.
- Completar formulario.
- Finalizar compra.

HERRAMIENTAS SELECCIONADAS
- Selenium WebDriver (java, mvn).
- Junit.
- Visual Code.
- surefire report plugin.

DESARROLLO

1. Clase TESTPAGE : contiene el objetivo del desarrollo.
	1.1 Método setupBrowser : se inicia con el direccionamiento a la pagina https://www.saucedemo.com, garantizando que el navegador se maximice.
	1.2 Método loginSuccesfull : direcciona a la clase login enviando el userName y Password.
	1.3 Meetodo closeBrowser : cierra el navegador.
2. Clase LOGINPAGE: realiza el login.
	2.1 se declara variables con el valor correspondiente de su selector de tipo estáticos para posibles reutilizaciones.
	2.2 en el método login envía los parámetros de username y password provenientes de testpage y hace click en el botón de login.
3. Clase HOMEPAGE: realiza la verificación del home in después de login.
	3.1  Método userIsInPrivateHome se imprime las cookie de sesión para validación adicional y se verifica que el formulario mostrado sea el correcto haciendo dos aserciones del titulo y productos del home in.
4. Clase BUYPAGE : se realiza la compra de los productos.
	4.1 se declara las variables a utilizar en la clase.
	4.2 se extrae en una lista los elementos que hay actualmente, para poder verificar que podemos comprar los dos productos que nos pide el caso de prueba.
	4.3 luego se da click en el icono de carrito.
	4.4 se verifica que los dos productos seleccionados anteriormente coincida con los que vamos a comprar, es decir realizar doble check.
	4.5 se da click en el botón checking.
	4.6 se llena los campos de nombre, apellido y código postal.
	4.7 se da click en el botón continuar con la compra.
	4.8 se realiza una aserción para certificar que la orden ha sigo exitosa.
5. Clase VALIDATIONPAGE: se realiza la validación de los productos.
	5.1 se recibe el parámetro de la lista de los productos.
	5.2 se extrae la lista de los productos que se encuentra en el formulario de checking.
	5.3 se compara los productos del formulario actual con el listado de los productos que agregamos en el carrito de compras.





