package com.example.oraculoichingpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oraculoichingpro.ui.theme.OraculoIChingTheme
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontStyle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.ui.platform.LocalContext
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        var mantenerSplash = true
        splash.setKeepOnScreenCondition { mantenerSplash }
        Handler(Looper.getMainLooper()).postDelayed({ mantenerSplash = false }, 2000)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OraculoIChingTheme {
                // Ahora arrancamos desde NavegacionPrincipal en vez de PantallaPrincipal.
                // Esto hace que la app empiece en el menu y desde ahi se navegue
                // al resto de pantallas.
                NavegacionPrincipal()
            }
        }
    }
}

// Esta es la pantalla del oraculo (lo que hemos hecho hasta ahora).
// Ya no se llama directamente desde onCreate, sino que la invoca
// el sistema de navegacion cuando el usuario elige "Hexagrama del Dia".
@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier) {
    var hexagramaElegido by remember { mutableStateOf<Hexagrama?>(null) }
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(ColoresOraculo.fondoPrincipal)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
        // Solo mostramos el boton y el texto si aun no hay hexagrama elegido
        if (hexagramaElegido == null) {
            // Botón circular decorativo
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .background(ColoresOraculo.fondoTarjeta)
                    .border(3.dp, ColoresOraculo.dorado, CircleShape)

                    .clickable {
                        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                            vibratorManager.defaultVibrator
                        } else {
                            @Suppress("DEPRECATION")
                            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        }

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
                        } else {
                            @Suppress("DEPRECATION")
                            vibrator.vibrate(50)
                        }

                        hexagramaElegido = listaHexagramas.random()
                    }

                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "☰",
                        color = ColoresOraculo.dorado,
                        fontSize = 64.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "I CHING",
                        color = ColoresOraculo.doradoClaro,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 4.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Texto indicativo centrado debajo del círculo
            Text(
                text = "Descubrir mi hexagrama",
                color = ColoresOraculo.doradoClaro,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp, bottom = 32.dp)
            )
        }

        // Tarjeta del hexagrama elegido
        hexagramaElegido?.let { hexagrama ->
            TarjetaHexagrama(hexagrama = hexagrama)
        }

            Spacer(modifier = Modifier.height(48.dp))
        }

        if (scrollState.canScrollForward) {
            ScrollIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    OraculoIChingTheme {
        PantallaPrincipal()
    }
}