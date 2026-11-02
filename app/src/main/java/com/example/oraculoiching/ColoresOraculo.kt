package com.example.oraculoichingpro

import androidx.compose.ui.graphics.Color

// Paleta de colores de la app, estilo tradicional chino (rojo, negro, dorado).
// Tenerlos todos juntos aqui facilita cambiar el aspecto de toda la app
// desde un solo sitio, sin tener que buscar colores sueltos por cada archivo.
object ColoresOraculo {
    val fondoPrincipal = Color(0xFF1A0606)      // Negro con un toque rojizo, para el fondo de toda la pantalla
    val fondoTarjeta = Color(0xFF3B0A0A)        // Rojo oscuro/granate, para el fondo de la carta de resultado
    val dorado = Color(0xFFD4AF37)              // Dorado, para bordes y detalles destacados
    val doradoClaro = Color(0xFFE8D27A)         // Dorado mas claro, para texto sobre fondo oscuro
    val textoPrincipal = Color(0xFFF5E9D3)      // Blanco roto/crema, mas suave que el blanco puro para leer mejor
    val rojoBoton = Color(0xFF8B1A1A)           // Rojo intenso para el boton principal
}