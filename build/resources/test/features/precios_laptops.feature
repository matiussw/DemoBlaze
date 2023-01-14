#language: es
#encoding: UTF-8
Característica: Yo como cliente del almacén demoblaze
  Necesito visualizar los precios de los productos de la categoría Laptops
  Para tomar decisiones de compra

  Antecedentes:
    Dado el usuario se encuetra en la pagina principal de "https://www.demoblaze.com/index.html"

  @listadoDeLaptops
  Escenario:Validar el correcto funcionamiento de la funcionaliad de listados
  de productos con respectiva descripcion y precio en el navegador
    Cuando el usuario da clic en el boton Laptops
    Entonces el sistema muestra los productos filtrados por Laptos

  @LogueoYSelecionDeUnProducto
  Escenario:Validar el correcto funcionamiento de la funcionaliad de logueo y  Seleccion de un producto
    Cuando  el usuario se loguea  y da clic en el boton  Laptops y selecciona un producto
      | username | password   |
      | teo3030  | Entra@2020 |
    Entonces el sistema debera carga el producto seleccionado y debera aparecer el boton "Add to cart"