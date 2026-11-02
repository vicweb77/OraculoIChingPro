package com.example.oraculoichingpro

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Esta es la "carta" que se muestra tras consultar el oraculo.
// Usa el componente Card de Compose, que ya trae de fabrica bordes
// redondeados y sombra, ideal para el efecto "carta de tarot".
@Composable
fun TarjetaHexagrama(
    hexagrama: Hexagrama,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = ColoresOraculo.fondoTarjeta),
        border = BorderStroke(2.dp, ColoresOraculo.dorado),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SimboloHexagrama(
                lineas = hexagrama.lineas,
                color = ColoresOraculo.dorado
            )

            Text(
                text = "${hexagrama.numero}. ${hexagrama.nombre}",
                color = ColoresOraculo.doradoClaro,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = hexagrama.imagen,
                color = ColoresOraculo.textoPrincipal,
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )
        }
    }
}