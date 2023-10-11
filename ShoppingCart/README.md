# Ejercicios JUnit

## Ejercicio 1: shopping cart

- Crea un proyecto maven con las clases proporcionadas.

### Especificaciones
- Cuando se crea, el carrito tiene 0 artículos.
- Cuando está vacío, el carrito tiene 0 artículos.
- Cuando se agrega un nuevo producto, la cantidad de artículos debe ser incrementado.
- Cuando se agrega un nuevo producto, el nuevo saldo debe ser la suma de los saldos anteriores más el costo del nuevo producto
- Cuando se elimina un elemento, se debe disminuir el número de elementos.
- Cuando se retira un producto que no está en el carrito, se debe lanzar ProductNotFoundException.

## Ejercicio 2: converter

- Crea un proyecto maven y escribe una clase con un método estático que convierta una cadena en un valor entero

### Especificaciones
- El método debe aceptar una cadena y convertirla en un número entero.
- Las cadenas bien formadas no contienen caracteres diferentes de números, espacios finales y menos
- El número representado debe estar en el rango [-32768, 32767]
- No se permiten números reales
- OK: “-3”, “500”, “-10”, “32767”
- NO: “2 3”, “32768”, “A3”, “2.3”Especificaciones

### Usa JUnit para probar el método definido
- Consejo 1: lanza una excepción en el método de conversión y prueba si la excepción se ha lanzado cuando el método
se llama con argumentos incorrectos
- Consejo 2: aprovecha el método Integer.parseInt() tanto para la conversión como para la verificación
