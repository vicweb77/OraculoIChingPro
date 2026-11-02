package com.example.oraculoichingpro

// Estructura de datos de cada hexagrama con las 5 secciones separadas.
// Esto permite que la pantalla de detalle formatee cada parte de forma diferente
// (titulos en dorado, listas sangradas, emojis destacados, etc.)
data class Hexagrama(
    val numero: Int,
    val nombre: String,
    val lineas: List<Boolean>,
    val trigramas: String,        // Ej: "Superior: ☰ Cielo / Inferior: ☰ Cielo"
    val imagen: String,           // Texto de la seccion "1. Imagen del hexagrama"
    val significado: String,      // Texto de la seccion "2. Significado fundamental"
    val psicologia: String,       // Texto de la seccion "3. Una mirada psicologica"
    val reflexion: String,        // Texto de la seccion "4. Reflexion practica"
    val integracion: String,      // Texto de la seccion "5. Para integrar este hexagrama"
    val imagenRes: Int = 0        // Recurso de imagen (R.drawable.hexagrama_XX)
)