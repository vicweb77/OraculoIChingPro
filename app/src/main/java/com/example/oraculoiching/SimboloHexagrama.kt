package com.example.oraculoichingpro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Este Composable dibuja el simbolo completo de un hexagrama: sus 6 lineas,
// una encima de otra. Recibe la lista de 6 valores true/false que ya tenemos
// guardada en cada Hexagrama (true = linea continua, false = linea partida).
@Composable
fun SimboloHexagrama(
    lineas: List<Boolean>,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    // "Column" coloca las lineas en vertical, una debajo de otra.
    // Usamos reversed() porque en el I Ching la primera linea de la lista
    // representa la de ABAJO, pero al dibujar en pantalla hay que pintar
    // de arriba hacia abajo. Con reversed() invertimos el orden solo para dibujar.
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        lineas.reversed().forEach { esContinua ->
            LineaHexagrama(esContinua = esContinua, color = color)
        }
    }
}

// Dibuja UNA sola linea: completa si esContinua es true,
// o partida en dos mitades con un hueco en medio si es false.
@Composable
private fun LineaHexagrama(esContinua: Boolean, color: Color) {
    val anchoTotal = 120.dp
    val alto = 10.dp

    if (esContinua) {
        // Linea continua: un solo rectangulo del ancho completo
        Spacer(
            modifier = Modifier
                .width(anchoTotal)
                .height(alto)
                .background(color)
        )
    } else {
        // Linea partida: dos rectangulos mas cortos con un hueco en medio,
        // colocados en fila (Row) uno al lado del otro
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.width(anchoTotal)
        ) {
            Spacer(
                modifier = Modifier
                    .width(anchoTotal * 0.4f)
                    .height(alto)
                    .background(color)
            )
            Spacer(
                modifier = Modifier
                    .width(anchoTotal * 0.4f)
                    .height(alto)
                    .background(color)
            )
        }
    }
}
