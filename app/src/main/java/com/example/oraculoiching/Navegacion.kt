package com.example.oraculoichingpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object Rutas {
    const val MENU              = "menu"
    const val QUE_ES            = "que_es"
    const val LOS_64            = "los_64"
    const val DETALLE_HEXAGRAMA = "detalle_hexagrama"
    const val HEXAGRAMA_DIA     = "hexagrama_dia"
    const val CLAVES            = "claves"
    const val DETALLE_CLAVE     = "detalle_clave"
    const val INFORMACION       = "informacion"
}

@Composable
fun NavegacionPrincipal() {
    val navController = rememberNavController()
    var hexagramaSeleccionado by remember { mutableStateOf<Hexagrama?>(null) }
    var claveSeleccionada by remember { mutableStateOf<Clave?>(null) }

    NavHost(navController = navController, startDestination = Rutas.MENU) {
        composable(Rutas.MENU) {
            PantallaMenu(navController = navController)
        }
        composable(Rutas.QUE_ES) {
            PantallaConBarra(titulo = "¿Qué es el I Ching?", navController = navController) {
                PantallaQueEsIChing(modifier = it)
            }
        }
        composable(Rutas.LOS_64) {
            PantallaConBarra(titulo = "Los 64 Hexagramas", navController = navController) {
                PantallaLos64Hexagramas(
                    modifier = it,
                    alPulsarHexagrama = { hexagrama ->
                        hexagramaSeleccionado = hexagrama
                        navController.navigate(Rutas.DETALLE_HEXAGRAMA)
                    }
                )
            }
        }
        composable(Rutas.DETALLE_HEXAGRAMA) {
            hexagramaSeleccionado?.let { hexagrama ->
                PantallaConBarra(titulo = hexagrama.nombre, navController = navController) {
                    PantallaDetalleHexagrama(hexagrama = hexagrama, modifier = it)
                }
            }
        }
        composable(Rutas.HEXAGRAMA_DIA) {
            PantallaConBarra(titulo = "Hexagrama del Día", navController = navController) {
                PantallaPrincipal(modifier = it)
            }
        }
        composable(Rutas.CLAVES) {
            PantallaConBarra(titulo = "Claves para Aprender a Fluir", navController = navController) {
                PantallaClaves(
                    modifier = it,
                    alPulsarClave = { clave ->
                        claveSeleccionada = clave
                        navController.navigate(Rutas.DETALLE_CLAVE)
                    }
                )
            }
        }
        composable(Rutas.DETALLE_CLAVE) {
            claveSeleccionada?.let { clave ->
                PantallaConBarra(titulo = clave.titulo, navController = navController) {
                    PantallaDetalleClave(clave = clave, modifier = it)
                }
            }
        }
        composable(Rutas.INFORMACION) {
            PantallaConBarra(titulo = "Acerca de esta aplicación", navController = navController) {
                PantallaInformacion(modifier = it)
            }
        }
    }
}

@Composable
fun PantallaMenu(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColoresOraculo.fondoPrincipal)
            .systemBarsPadding()
            .verticalScroll(scrollState)
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Primera línea normal
        Text(
            text = "Aprende a Fluir con el",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 20.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

// Segunda línea destacada
        Text(
            text = "I Ching Pro",
            color = ColoresOraculo.doradoClaro,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp
        )

// Trigrama del Cielo con estrellas decorativas a cada lado
        Text(
            text = "✦  ☰  ✦",
            color = ColoresOraculo.dorado,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 20.dp)
        )
        OpcionMenu(texto = "¿Qué es el I Ching?")          { navController.navigate(Rutas.QUE_ES) }
        OpcionMenu(texto = "Los 64 Hexagramas")             { navController.navigate(Rutas.LOS_64) }
        OpcionMenu(texto = "Claves para Fluir") { navController.navigate(Rutas.CLAVES) }
        OpcionMenu(texto = "Hexagrama del Día")             { navController.navigate(Rutas.HEXAGRAMA_DIA) }
        OpcionMenu(texto = "Sobre esta aplicación")                   { navController.navigate(Rutas.INFORMACION) }
    }
}

@Composable
fun OpcionMenu(texto: String, alPulsar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { alPulsar() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = ColoresOraculo.fondoTarjeta),
        border = androidx.compose.foundation.BorderStroke(1.dp, ColoresOraculo.dorado)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = texto, color = ColoresOraculo.textoPrincipal,
                fontSize = 18.sp, fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Ver detalle",
                tint = ColoresOraculo.dorado,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaConBarra(
    titulo: String,
    navController: NavController,
    contenido: @Composable (Modifier) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = titulo, color = ColoresOraculo.doradoClaro,
                    fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver", tint = ColoresOraculo.dorado)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = ColoresOraculo.fondoPrincipal)
            )
        }
    ) { innerPadding ->
        contenido(Modifier.padding(innerPadding))
    }
}