package com.example.oraculoichingpro

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Icon


import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape


@Composable
fun ScrollIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = ColoresOraculo.fondoTarjeta.copy(alpha = 0.9f),
                    shape = CircleShape
                )
                .border(1.dp, ColoresOraculo.dorado, CircleShape)
                .padding(horizontal = 14.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "Desliza para leer más",
                    color = ColoresOraculo.doradoClaro,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Desplazar hacia abajo",
                    tint = ColoresOraculo.dorado,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

// ─────────────────────────────────────────────
// PANTALLA 1: ¿Qué es el I Ching?
// ─────────────────────────────────────────────
@Composable
fun PantallaQueEsIChing(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "¿Qué es el I Ching?", color = ColoresOraculo.doradoClaro,
                fontSize = 26.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 8.dp))
            HorizontalDivider(color = ColoresOraculo.dorado, thickness = 1.dp,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp))


            Text(text = "El I Ching, o Libro de las Mutaciones, es uno de los libros de sabiduría más antiguos de la humanidad. Desde hace muchos años acompaña a las personas a comprender los cambios de la vida, ofreciendo una mirada profunda sobre los acontecimientos, las emociones y las decisiones.",
                color = ColoresOraculo.textoPrincipal, fontSize = 16.sp, textAlign = TextAlign.Justify, lineHeight = 24.sp)
            Text(text = "Su lenguaje no son las palabras, sino los símbolos. El I Ching está formado por 64 hexagramas. Cada uno representa una situación o un momento de la experiencia humana: avanzar, esperar, confiar, superar un obstáculo, resolver un conflicto, iniciar un cambio, cerrar una etapa o encontrar el equilibrio.",
                color = ColoresOraculo.textoPrincipal, fontSize = 16.sp, textAlign = TextAlign.Justify, lineHeight = 24.sp)
            Text(text = "Los trigramas", color = ColoresOraculo.doradoClaro, fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
            Text(text = "Cada hexagrama está compuesto por dos trigramas. Un trigrama es una figura formada por tres líneas, que pueden ser continuas (yang) o partidas (yin). Cada uno simboliza una fuerza de la naturaleza, como el Cielo, la Tierra, el Agua, el Fuego, el Trueno, el Viento, la Montaña o el Lago.",
                color = ColoresOraculo.textoPrincipal, fontSize = 16.sp, textAlign = TextAlign.Justify, lineHeight = 24.sp)
            Text(text = "Al unirse un trigrama inferior y un trigrama superior, nace un hexagrama único. La combinación de ambas energías da lugar a una enseñanza diferente, como si la naturaleza nos hablara a través de imágenes y símbolos para ayudarnos a comprender mejor lo que estamos viviendo.",
                color = ColoresOraculo.textoPrincipal, fontSize = 16.sp, textAlign = TextAlign.Justify, lineHeight = 24.sp)
            Text(text = "El I Ching como espejo", color = ColoresOraculo.doradoClaro, fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
            Text(text = "En este programa utilizaremos esos 64 hexagramas como un espejo psicológico. No para predecir el futuro, sino para reflexionar sobre el presente, comprender nuestras emociones, ampliar la perspectiva y descubrir nuevas formas de afrontar la vida con mayor serenidad, flexibilidad y sabiduría.",
                color = ColoresOraculo.textoPrincipal, fontSize = 16.sp, fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Justify, lineHeight = 24.sp, modifier = Modifier.padding(bottom = 48.dp))
        }

        // Indicador flotante de scroll si hay contenido abajo
        if (scrollState.canScrollForward) {
            ScrollIndicator()
        }
    }
}
// ─────────────────────────────────────────────
// PANTALLA 2: Lista de los 64 hexagramas
// ─────────────────────────────────────────────
@Composable
fun PantallaLos64Hexagramas(
    modifier: Modifier = Modifier,
    alPulsarHexagrama: (Hexagrama) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(ColoresOraculo.fondoPrincipal)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(bottom = 48.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(text = "Los 64 Hexagramas", color = ColoresOraculo.doradoClaro,
                fontSize = 22.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp))
        }
        items(listaHexagramas) { hexagrama ->
            FilaHexagrama(hexagrama = hexagrama, alPulsar = { alPulsarHexagrama(hexagrama) })
        }
        item {
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Composable
fun FilaHexagrama(hexagrama: Hexagrama, alPulsar: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { alPulsar() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = ColoresOraculo.fondoTarjeta),
        border = androidx.compose.foundation.BorderStroke(1.dp, ColoresOraculo.dorado)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "${hexagrama.numero}.", color = ColoresOraculo.dorado,
                fontSize = 16.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 10.dp))
            Text(text = hexagrama.nombre, color = ColoresOraculo.textoPrincipal,
                fontSize = 16.sp, modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Ver detalle",
                tint = ColoresOraculo.dorado,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

// ─────────────────────────────────────────────
// PANTALLA 3: Detalle de un hexagrama
// ─────────────────────────────────────────────
@Composable
fun PantallaDetalleHexagrama(hexagrama: Hexagrama, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        // Imagen del hexagrama
        if (hexagrama.imagenRes != 0) {
            // "imagenAmpliada" recuerda si el usuario ha pulsado la imagen o no.
            // Cuando es true, la imagen ocupa toda la pantalla. Al pulsar de nuevo vuelve al tamaño normal.
            var imagenAmpliada by remember { mutableStateOf(false) }

            if (imagenAmpliada) {
                // Imagen a pantalla completa con fondo oscuro
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(ColoresOraculo.fondoTarjeta)
                        .clickable { imagenAmpliada = false }
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = hexagrama.imagenRes),
                        contentDescription = "Imagen ampliada del hexagrama ${hexagrama.numero}",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                    // Indicador de "toca para cerrar" arriba a la derecha
                    Text(
                        text = "✕",
                        color = ColoresOraculo.dorado,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(12.dp)
                    )
                }
            } else {
                // Imagen en tamaño normal, pulsable para ampliar
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier
                        .size(220.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(ColoresOraculo.fondoTarjeta)
                        .clickable { imagenAmpliada = true }
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = hexagrama.imagenRes),
                        contentDescription = "Imagen del hexagrama ${hexagrama.numero}",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                    // Indicador de "toca para ampliar" abajo a la derecha
                    Text(
                        text = "⤢",
                        color = ColoresOraculo.dorado,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                    )
                }
            }
        }

        // Simbolo de las 6 lineas
        SimboloHexagrama(lineas = hexagrama.lineas, color = ColoresOraculo.dorado)

        // Numero y nombre
        Text(
            text = "${hexagrama.numero}. ${hexagrama.nombre}",
            color = ColoresOraculo.doradoClaro,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        // Trigramas en una cajita especial
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = ColoresOraculo.fondoTarjeta),
            border = androidx.compose.foundation.BorderStroke(1.dp, ColoresOraculo.dorado.copy(alpha = 0.5f))
        ) {
            Text(
                text = hexagrama.trigramas,
                color = ColoresOraculo.dorado,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(12.dp)
            )
        }

        HorizontalDivider(color = ColoresOraculo.dorado, thickness = 1.dp, modifier = Modifier.fillMaxWidth())

        // Seccion 1: Imagen del hexagrama
        SeccionHexagrama(titulo = "1. Imagen del hexagrama", texto = hexagrama.imagen)

        // Seccion 2: Significado fundamental
        SeccionHexagrama(titulo = "2. Significado fundamental", texto = hexagrama.significado)

        // Seccion 3: Mirada psicologica
        SeccionHexagrama(titulo = "3. Una mirada psicológica", texto = hexagrama.psicologia)

        // Seccion 4: Reflexion practica
        SeccionHexagrama(titulo = "4. Reflexión práctica para la vida cotidiana", texto = hexagrama.reflexion)

        // Seccion 5: Para integrar
        SeccionHexagrama(titulo = "5. Para integrar este hexagrama", texto = hexagrama.integracion)

            Spacer(modifier = Modifier.height(48.dp))
        }

        if (scrollState.canScrollForward) {
            ScrollIndicator()
        }
    }
}

// Componente que renderiza una seccion del hexagrama con su titulo en dorado
// y su texto interpretando guiones como lista y emojis como texto destacado.
@Composable
fun SeccionHexagrama(titulo: String, texto: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Titulo de la seccion en dorado y negrita
        Text(
            text = titulo,
            color = ColoresOraculo.doradoClaro,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
        HorizontalDivider(
            color = ColoresOraculo.dorado.copy(alpha = 0.3f),
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        // Dividimos el texto en parrafos por salto de linea y renderizamos cada uno
        texto.split("\n").forEach { linea ->
            when {
                // Linea vacia: espacio pequeño entre parrafos
                linea.isBlank() -> {
                    androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(4.dp))
                }
                // Linea con guion: elemento de lista con sangria
                linea.trimStart().startsWith("-") -> {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 12.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(text = "•  ", color = ColoresOraculo.dorado, fontSize = 15.sp)
                        Text(
                            text = linea.trimStart().removePrefix("-").trim(),
                            color = ColoresOraculo.textoPrincipal,
                            fontSize = 15.sp,
                            lineHeight = 22.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                // Linea con emoji: centrada y destacada
                linea.contains("🤔") || linea.contains("🌱") || linea.contains("💡") -> {
                    Text(
                        text = linea,
                        color = ColoresOraculo.doradoClaro,
                        fontSize = 15.sp,
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center,
                        lineHeight = 22.sp,
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                    )
                }
                // Subtitulo dentro de seccion (ej: "- En el ámbito personal:")
                linea.endsWith(":") && !linea.startsWith("-") -> {
                    Text(
                        text = linea,
                        color = ColoresOraculo.doradoClaro,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                // Parrafo normal
                else -> {
                    Text(
                        text = linea,
                        color = ColoresOraculo.textoPrincipal,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Justify,
                        lineHeight = 23.sp
                    )
                }
            }
        }
    }
}

// ─────────────────────────────────────────────
// PANTALLA 4: Lista de Claves para Aprender a Fluir con el Iching
// ─────────────────────────────────────────────
data class Clave(val numero: Int, val titulo: String, val texto: String)

val listadoClaves = listOf(
    Clave(1, "INICIAR",
        "Nacimiento · Comienzo · Impulso\n" +
                "\n" +
                "**Hexagrama 1 – El Poder Creador**\n" +
                "La clave para aprender a fluir: Reconocer nuestra capacidad creadora nos permite dejar de esperar pasivamente a que las circunstancias cambien y empezar a participar conscientemente en la construcción de nuestra vida.\n" +
                "\n" +
                "**Hexagrama 2 – La Receptividad**\n" +
                "La clave para aprender a fluir: No todo comienzo requiere acción. A veces avanzar significa escuchar, recibir, adaptarnos a lo que llega y permitir que las circunstancias nos muestren hacia dónde dirigir nuestra energía.\n" +
                "\n" +
                "**Hexagrama 3 – La Dificultad Inicial**\n" +
                "La clave para aprender a fluir: Todo comienzo puede traer incertidumbre, obstáculos y confusión. Aceptar esa dificultad como parte natural del proceso nos ayuda a avanzar con paciencia sin exigir resultados inmediatos.\n" +
                "\n" +
                "**Hexagrama 24 – El Retorno**\n" +
                "La clave para aprender a fluir: Siempre existe la posibilidad de regresar al camino. Un error, una pérdida de dirección o un periodo de alejamiento no tienen por qué convertirse en nuestro destino; podemos detenernos, reconocerlo y comenzar de nuevo.\n" +
                "\n" +
                "**Hexagrama 25 – La Inocencia**\n" +
                "La clave para aprender a fluir: La autenticidad nos permite relacionarnos con la vida sin cargarla constantemente de expectativas, prejuicios o intenciones ocultas. Confiar más en lo que realmente sucede abre espacio para respuestas más espontáneas y genuinas.\n" +
                "\n" +
                "**Hexagrama 51 – La Conmoción**\n" +
                "La clave para aprender a fluir: Las sacudidas forman parte de la vida. La cuestión no es evitar todo aquello que nos desestabiliza, sino aprender a recuperar nuestro centro, escuchar lo que la experiencia nos muestra y responder con mayor conciencia.\n" +
                "\n" +
                "**Hexagrama 53 – La Evolución**\n" +
                "La clave para aprender a fluir: El crecimiento profundo necesita tiempo. Respetar los ritmos naturales y avanzar mediante pequeños pasos constantes permite construir cambios más sólidos, realistas y duraderos.\n" +
                "\n" +
                "**Enseñanza global de INICIAR**\n" +
                "La clave para aprender a fluir al iniciar: Cada comienzo tiene su propio ritmo. A veces necesitamos crear y actuar; otras, recibir y escuchar. Podemos encontrarnos con dificultades, necesitar regresar a nuestro centro, empezar desde la autenticidad, despertar después de una sacudida o avanzar lentamente. Lo importante es comprender que iniciar no significa tenerlo todo claro, sino estar dispuesto a dar el siguiente paso y confiar en el proceso de evolución."
    ),
    Clave(2, "CRECER",
        "Aprendizaje · Desarrollo · Crecimiento\n" +
                "\n" +
                "**Hexagrama 4 – El No Saber**\n" +
                "La clave para aprender a fluir: Reconocer nuestra inexperiencia no es una debilidad, sino el punto de partida indispensable para aprender. La humildad para reconocer lo que ignoramos y la apertura para dejarnos guiar nos protegen de la precipitación y la arrogancia.\n" +
                "\n" +
                "**Hexagrama 9 – La Fuerza Domesticadora de lo Pequeño**\n" +
                "La clave para aprender a fluir: Las grandes metas se construyen mediante pequeñas acciones cotidianas. Atender los detalles mínimos, cultivar la paciencia y realizar ajustes sutiles nos permite acumular fuerza sin agotarnos intentando forzar resultados antes de tiempo.\n" +
                "\n" +
                "**Hexagrama 10 – La Conducta**\n" +
                "La clave para aprender a fluir: Aprender a movernos en entornos delicados o exigentes requiere prudencia, respeto y un comportamiento impecable. Movernos con cautela y serenidad nos permite avanzar con seguridad incluso en situaciones de riesgo o ante un poder mayor.\n" +
                "\n" +
                "**Hexagrama 26 – La Fuerza Domesticadora de lo Grande**\n" +
                "La clave para aprender a fluir: El verdadero potencial se consolida mediante la autodisciplina. Almacenar conocimiento, cultivar el carácter y saber contener nuestros grandes impulsos nos da la madurez necesaria para actuar con eficacia en el momento oportuno.\n" +
                "\n" +
                "**Hexagrama 27 – La Nutrición**\n" +
                "La clave para aprender a fluir: Somos responsables de aquello con lo que nos alimentamos y de lo que ofrecemos a los demás. Seleccionar conscientemente nuestros pensamientos, palabras, alimentos y relaciones determina directamente la calidad de nuestro desarrollo.\n" +
                "\n" +
                "**Hexagrama 32 – La Duración**\n" +
                "La clave para aprender a fluir: La verdadera estabilidad requiere constancia adaptable. Sostener nuestro propósito a lo largo del tiempo no significa volvernos rígidos, sino saber renovar la actitud interna mientras permanecemos fieles a nuestros valores esenciales.\n" +
                "\n" +
                "**Hexagrama 46 – La Subida**\n" +
                "La clave para aprender a fluir: El crecimiento sólido se logra mediante un esfuerzo gradual, humilde y sostenido. Aprovechar las oportunidades para avanzar paso a paso nos asegura consolidar cada logro antes de intentar alcanzar el siguiente nivel.\n" +
                "\n" +
                "**Hexagrama 48 – El Pozo**\n" +
                "La clave para aprender a fluir: Nuestra fuente interior de sabiduría necesita cuidado y profundización constante. Mantener limpia y renovada nuestra agua interior nos permite ofrecer apoyo y recursos valiosos a nuestro entorno sin desgastarnos.\n" +
                "\n" +
                "**Enseñanza global de CRECER**\n" +
                "La clave para aprender a fluir al crecer: Crecer exige consolidar la estructura interna mientras nos expandimos hacia afuera. Implica asumir el no saber, valorar los pequeños avances, cuidar la conducta, disciplinar el gran potencial, seleccionar una buena nutrición, sostener la constancia en el tiempo, subir paso a paso y cuidar la fuente profunda de nuestro ser. La madurez se construye cuando unimos la paciencia con la disciplina diaria."
    ),
    Clave(3, "ESPERAR Y FLUIR",   "Paciencia · Adaptación · Receptividad\n" +
        "\n" +
                "**Hexagrama 5 – La Espera**\n" +
                "La clave para aprender a fluir: Aprender a esperar no es detener la vida, sino habitar el presente con confianza. Nutrir nuestro cuerpo y mente con serenidad mientras las condiciones externas maduran nos asegura actuar con la máxima fuerza cuando llegue el momento oportuno.\n" +
                "\n" +
                "**Hexagrama 11 – La Paz**\n" +
                "La clave para aprender a fluir: Los periodos de fluidez y armonía se disfrutan y se protegen desde la conciencia. Mantener la humildad y la atención en los momentos de bonanza evita que caigamos en la complacencia y permite que la prosperidad se prolongue en el tiempo.\n" +
                "\n" +
                "**Hexagrama 17 – La Adaptación**\n" +
                "La clave para aprender a fluir: Aprender a fluir exige soltar la necesidad de imponer nuestro propio ritmo. Permitirnos seguir el curso natural de los acontecimientos y responder con flexibilidad a las necesidades del entorno nos integra sin esfuerzo en la corriente de la vida.\n" +
                "\n" +
                "**Hexagrama 20 – La Contemplación**\n" +
                "La clave para aprender a fluir: La claridad nace de la observación imparcial. Tomar distancia para contemplar la realidad con atención plena y sin juicios nos permite comprender la naturaleza profunda de las situaciones antes de decidir cualquier paso.\n" +
                "\n" +
                "**Hexagrama 33 – La Retirada**\n" +
                "La clave para aprender a fluir: Saber dar un paso atrás a tiempo es una muestra de inteligencia emocional. Alejarnos con dignidad de las dinámicas que desgastan nuestra energía resguarda nuestra integridad y prepara el terreno para un futuro regreso desde una posición más fuerte.\n" +
                "\n" +
                "**Hexagrama 52 – El Aquietamiento**\n" +
                "La clave para aprender a fluir: Poner pausa al movimiento externo serena la agitación mental. Encontrar el silencio interior y detener las reacciones impulsivas nos devuelve la paz y nos permite responder a la existencia desde un centro firme e inamovible.\n" +
                "\n" +
                "**Hexagrama 57 – Lo Invisible**\n" +
                "La clave para aprender a fluir: La persistencia suave y constante genera cambios verdaderamente profundos. Adaptarnos de forma sutil a las circunstancias nos permite disolver barreras e influir en nuestro entorno sin recurrir a la fuerza ni a la confrontación directa.\n" +
                "\n" +
                "**Enseñanza global de ESPERAR Y FLUIR**\n" +
                "La clave para aprender a fluir al esperar: Fluir requiere dominar el arte de la no-fuerza. Implica cultivar la confianza durante la espera, honrar los momentos de paz, adaptarnos con flexibilidad, contemplar la vida con atención neutra, saber retirarnos con dignidad, aquietar la mente y avanzar mediante una influencia sutil e invisible. La verdadera maestría de la receptividad consiste en permanecer en total sintonía con los ritmos y tiempos del universo."
    ),
    Clave(4, "ACTUAR Y AVANZAR",  "Acción · Fuerza · Decisión\n" +
            "\n" +
            "**Hexagrama 7 – El Liderazgo**\n" +
            "La clave para aprender a fluir: Toda acción colectiva u organizada requiere orden, responsabilidad y disciplina interior. Asumir el propio liderazgo con serenidad y dirigir los esfuerzos hacia un propósito justo permite coordinar la energía con firmeza sin caer en el autoritarismo.\n" +
            "\n" +
            "**Hexagrama 14 – La Prosperidad**\n" +
            "La clave para aprender a fluir: El éxito y la plenitud de recursos exigen una profunda humildad y generosidad. Gestionar la riqueza material o espiritual con altruismo y rectitud asegura que la prosperidad trascienda a favor de todo el entorno sin alimentar la arrogancia.\n" +
            "\n" +
            "**Hexagrama 19 – El Acercamiento**\n" +
            "La clave para aprender a fluir: Las fases de crecimiento y apertura deben aprovecharse con entusiasmo y proactividad. Acercarnos con calidez y actitud receptiva a las oportunidades nos permite construir, sembrar y consolidar bases sólidas mientras el ciclo sea favorable.\n" +
            "\n" +
            "**Hexagrama 21 – La Acción Justa**\n" +
            "La clave para aprender a fluir: Superar los bloqueos y la arbitrariedad exige tomar decisiones directas, imparciales y firmes. Afrontar los conflictos despejando los obstáculos con claridad y sentido de justicia permite restablecer el orden y la verdad en el camino.\n" +
            "\n" +
            "**Hexagrama 34 – El Poder de lo Grande**\n" +
            "La clave para aprender a fluir: La fuerza sin freno acaba atrapada en sus propias redes. Dominar el gran ímpetu mediante el respeto a los límites, la ética y la templanza nos asegura avanzar con firmeza sin arrollar ni caer en la obstinación.\n" +
            "\n" +
            "**Hexagrama 35 – El Progreso**\n" +
            "La clave para aprender a fluir: Avanzar de manera constante requiere claridad de intenciones, transparencia y apertura. Aceptar la luz y el reconocimiento con nobleza nos permite impulsar proyectos con fluidez y servir de inspiración a los demás.\n" +
            "\n" +
            "**Hexagrama 42 – El Aumento**\n" +
            "La clave para aprender a fluir: La verdadera expansión se multiplica cuando se orienta al bien común. Aprovechar las épocas de bonanza para corregir nuestros fallos internos y contribuir al bienestar ajeno garantiza un crecimiento sostenible y duradero.\n" +
            "\n" +
            "**Hexagrama 43 – La Resolución**\n" +
            "La clave para aprender a fluir: Romper con lo insostenible o con la negatividad exige una decisión firme, transparente y definitiva. Expresar los límites con determinación y valentía, evitando el enojo y las mañas, despeja el terreno para dar el paso hacia lo nuevo.\n" +
            "\n" +
            "**Enseñanza global de ACTUAR Y AVANZAR**\n" +
            "La clave para aprender a fluir al actuar: Avanzar con verdadera eficacia exige unir el ímpetu con la conciencia. Implica liderar con disciplina, administrar la prosperidad con humildad, aprovechar el acercamiento de las oportunidades, ejecutar una acción justa, moderar la gran fuerza con templanza, progresar de forma transparente, multiplicar el aumento mediante el compartir y tomar decisiones con determinación moral. La acción correcta fluye sin esfuerzo cuando nace de un propósito noble y se ejecuta con serenidad."
    ),
    Clave(5, "VINCULARSE",        "Encuentro · Cooperación · Comunidad\n" +
            "\n" +
            "**Hexagrama 8 – La Solidaridad**\n" +
            "La clave para aprender a fluir: Construir lazos sólidos exige buscar la cohesión desde la lealtad y la claridad de intenciones. Unirnos de corazón a causas o personas afines refuerza nuestro camino, siempre que antes hayamos examinado nuestro propio compromiso interior.\n" +
            "\n" +
            "**Hexagrama 13 – La Comunidad**\n" +
            "La clave para aprender a fluir: Fomentar la cooperación abierta requiere trascender los intereses individuales y el prejuicio. Colaborar con amplitud de criterio y transparencia permite crear alianzas profundas basadas en el bien común y la fraternidad humana.\n" +
            "\n" +
            "**Hexagrama 15 – La Moderación**\n" +
            "La clave para aprender a fluir: El verdadero equilibrio en el trato con los demás nace de equilibrar los excesos y valorar la sencillez. Actuar con sobriedad y objetividad nos permite integrarnos con soltura sin imponernos ni despertar resentimientos.\n" +
            "\n" +
            "**Hexagrama 16 – El Entusiasmo**\n" +
            "La clave para aprender a fluir: Inspirar a un grupo moviliza una valiosa energía de acción. Canalizar la alegría compartida y la motivación a través de un plan realista asegura que la euforia se transforme en realizaciones duraderas y armónicas.\n" +
            "\n" +
            "**Hexagrama 31 – La Influencia**\n" +
            "La clave para aprender a fluir: Toda atracción e intercambio genuino florece desde la sensibilidad y la apertura receptiva. Permitir que la influencia mutua fluya con naturalidad, respeto y sin manipulación consolida vínculos afectivos y creativos auténticos.\n" +
            "\n" +
            "**Hexagrama 37 – La Familia**\n" +
            "La clave para aprender a fluir: La estabilidad en los entornos cotidianos se sostiene con la claridad de roles, la responsabilidad y el afecto coherente. Fomentar el orden pacífico mediante el propio ejemplo crea un núcleo seguro donde todos pueden prosperar.\n" +
            "\n" +
            "**Hexagrama 44 – El Encuentro**\n" +
            "La clave para aprender a fluir: No todas las interacciones o tentaciones resultan saludables a largo plazo. Mantener la lucidez y la cautela frente a influencias seductoras pero desequilibradas nos protege de comprometer nuestra autonomía e integridad.\n" +
            "\n" +
            "**Hexagrama 45 – La Reunión**\n" +
            "La clave para aprender a fluir: Agrupar personas y recursos en torno a un propósito requiere un centro de gravedad firme y precavido. Liderar o integrarnos en colectivos exige previsión y prevención para mantener la seguridad y el sentido del grupo.\n" +
            "\n" +
            "**Hexagrama 58 – La Alegría**\n" +
            "La clave para aprender a fluir: El diálogo amable y el intercambio gozoso nutren la mente y el espíritu. Compartir satisfacciones, verdades y momentos amables con otros fortalece la confianza mutua sin caer en superficialidades.\n" +
            "\n" +
            "**Enseñanza global de VINCULARSE**\n" +
            "La clave para aprender a fluir al vincularse: Aprender a convivir es aprender a conocer nuestro propio reflejo en el otro. Fluir en comunidad requiere ofrecer una solidaridad sincera, construir comunidad desde la apertura, cultivar la moderación, encauzar el entusiasmo con realismo, acoger la influencia mutua, cuidar la estructura familiar, guardar prudencia ante encuentros sutiles, organizar la reunión con propósito y compartir la alegría de vivir. La verdadera unión se consolida donde existen el respeto, la libertad y el beneficio mutuo."
    ),
    Clave(6, "AFRONTAR",          "Obstáculos · Conflicto · Dificultades\n" +
            "\n" +
            "**Hexagrama 6 – El Conflicto**\n" +
            "La clave para aprender a fluir: Persistir en la confrontación por tener la razón suele acentuar el desgaste. Detener la escalada a tiempo, buscar el diálogo moderado y aceptar la mediación nos permite resolver desacuerdos sin consumir nuestra vitalidad en batallas estériles.\n" +
            "\n" +
            "**Hexagrama 12 – El Estancamiento**\n" +
            "La clave para aprender a fluir: Cuando los canales de comunicación se cierran y las circunstancias se bloquean, la mejor opción es el repliegue consciente. Proteger nuestra energía y sostener nuestros principios en silencio nos permite atravesar la inmovilidad sin desgastar nuestra esencia.\n" +
            "\n" +
            "**Hexagrama 28 – La Excesiva Carga**\n" +
            "La clave para aprender a fluir: Las situaciones de extrema tensión o responsabilidad desmedida exigen decisiones valientes y aligerar peso. Reconocer que la estructura está a punto de ceder nos permite tomar medidas extraordinarias para liberar la presión antes del colapso.\n" +
            "\n" +
            "**Hexagrama 29 – El Abismo**\n" +
            "La clave para aprender a fluir: Atravesar tramos oscuros o temores profundos exige mantener la calma y adaptarse a la forma de las circunstancias. Fluir como el agua, llenando las cavidades sin perder el rumbo, nos permite salir airosos del peligro.\n" +
            "\n" +
            "**Hexagrama 36 – El Oscurecimiento de la Luz**\n" +
            "La clave para aprender a fluir: En entornos hostiles o adversos es sabio mantener un perfil bajo y proteger la luz interior sin ostentación. Guardar prudencia en la conducta resguarda nuestra verdad hasta que el contexto vuelva a ser propicio.\n" +
            "\n" +
            "**Hexagrama 38 – La Oposición**\n" +
            "La clave para aprender a fluir: Las diferencias de visión o de carácter no deben paralizar la convivencia. Aceptar los desacuerdos y enfocarse en encontrar puntos de encuentro en los asuntos menores nos permite avanzar pese a las discrepancias.\n" +
            "\n" +
            "**Hexagrama 39 – El Impedimento**\n" +
            "La clave para aprender a fluir: Insistir torpemente frente a un muro impracticable agota nuestras fuerzas. Hacer una pausa reflexiva, examinar nuestra actitud y corregir la estrategia nos permite rodear o superar los obstáculos con madurez.\n" +
            "\n" +
            "**Hexagrama 47 – El Agotamiento**\n" +
            "La clave para aprender a fluir: Las épocas de limitación o escasez ponen a prueba nuestra firmeza interna. Conservar la entereza, la serenidad y la dignidad sin caer en la amargura fortalece el carácter y nos prepara para la recuperación.\n" +
            "\n" +
            "**Hexagrama 54 – La Prisa**\n" +
            "La clave para aprender a fluir: Impulsar iniciativas cuando nos encontramos en una posición subordinada o poco favorable conduce a la frustración. Aceptar las reglas del contexto con humildad y contención nos evita dar pasos en falso.\n" +
            "\n" +
            "**Hexagrama 62 – El Exceso de lo Pequeño**\n" +
            "La clave para aprender a fluir: En momentos delicados o inciertos, las grandes pretensiones resultan riesgosas. Priorizar la sobriedad, el cuidado meticuloso de los detalles más sencillos y el bajo perfil garantiza nuestro avance seguro.\n" +
            "\n" +
            "**Enseñanza global de AFRONTAR**\n" +
            "La clave para aprender a fluir al afrontar: Las pruebas de la vida no aparecen para bloquearnos, sino para templar nuestro carácter. Afrontar la dificultad exige frenar los conflictos a tiempo, aceptar los estancamientos con paciencia, aliviar las excesivas cargas, cruzar los abismos con adaptabilidad, resguardar la luz interna, convivir con la oposición, rectificar ante los impedimentos, resistir el agotamiento con dignidad, pausar la prisa y cuidar con rigor lo pequeño. La verdadera templanza consiste en mantener la calma y el eje en medio de la tormenta."
    ),
    Clave(7, "TRANSFORMARSE",     "Cambio · Ruptura · Renovación\n" +
            "\n" +
            "**Hexagrama 18 – La Reparación**\n" +
            "La clave para aprender a fluir: Asumir la responsabilidad de corregir los errores pasados y sanar lo dañado nos devuelve la iniciativa. Actuar con método, firmeza y determinación para reparar viejos patrones nos permite restaurar el equilibrio y renovar nuestro camino.\n" +
            "\n" +
            "**Hexagrama 22 – La Belleza**\n" +
            "La clave para aprender a fluir: Apreciar la armonía, las formas y la estética le otorga elegancia a nuestro tránsito por la vida. Cuidar la apariencia y los modales embellece el presente, siempre que la forma sea un reflejo sincero de una sustancia real y sólida.\n" +
            "\n" +
            "**Hexagrama 23 – La Desintegración**\n" +
            "La clave para aprender a fluir: Aceptar con serenidad la caída de lo que ya no se sostiene nos libera del sufrimiento inútil. Soltar el apego a lo que concluye y mantener la quietud mientras la estructura se desmorona prepara el terreno para la futura renovación.\n" +
            "\n" +
            "**Hexagrama 40 – La Liberación**\n" +
            "La clave para aprender a fluir: Aprovechar el alivio tras la tormenta para perdonar, deshacer nudos y desatarse de viejas cargas nos devuelve la ligereza. Volver a la normalidad con rapidez y sin guardar rencores consolida nuestra paz interna.\n" +
            "\n" +
            "**Hexagrama 41 – La Disminución**\n" +
            "La clave para aprender a fluir: Reducir lo superfluo y simplificar nuestras necesidades nos reconecta con lo esencial. Entender que desprenderse de excesos o expectativas despeja espacio interno garantiza que podamos acoger de nuevo la abundancia.\n" +
            "\n" +
            "**Hexagrama 49 – La Revolución**\n" +
            "La clave para aprender a fluir: Transformar radicalmente nuestra realidad exige que el momento haya madurado plenamente. Guiar la metamorfosis con convicción, justicia y claridad de propósito permite abolir lo caduco sin generar violencia innecesaria.\n" +
            "\n" +
            "**Hexagrama 50 – La Transformación**\n" +
            "La clave para aprender a fluir: La verdadera metamorfosis es un proceso de refinamiento y alquimia interior. Nutrirnos de las vivencias del pasado para renovar nuestra visión nos permite ofrecer una versión de nosotros más consciente, sabia y madura.\n" +
            "\n" +
            "**Hexagrama 59 – La Dispersión**\n" +
            "La clave para aprender a fluir: Disolver los bloqueos del ego, los prejuicios y el aislamiento nos acerca con la totalidad. Permitir que la empatía flexibilice las rigideces emocionales disipa las barreras y reconcilia lo que estaba distanciado.\n" +
            "\n" +
            "**Enseñanza global de TRANSFORMARSE**\n" +
            "La clave para aprender a fluir al transformarse: Toda transformación requiere soltar lo viejo para dar cabida a lo nuevo. Fluir en los momentos de metamorfosis implica asumir la reparación de lo dañado, valorar la belleza de las formas, aceptar la desintegración inevitable, celebrar la liberación de cargas, simplificar mediante la disminución, encarar la revolución con oportunidad, cultivar la transformación interna y disolver la dispersión del aislamiento. La renovación es la capacidad de mudar de piel con confianza en la vida."
    ),
    Clave(8, "CULMINAR Y RENACER","Plenitud · Cosecha · Cierre\n" +
            "\n" +
            "**Hexagrama 30 – La Afinidad**\n" +
            "La clave para aprender a fluir: Mantener encendida la claridad mental y la consciencia nos permite adherirnos a principios elevados. Conectarnos con lo que nos nutre espiritualmente ilumina nuestro camino e inspira calidez a nuestro alrededor.\n" +
            "\n" +
            "**Hexagrama 55 – La Abundancia**\n" +
            "La clave para aprender a fluir: Disfrutar los picos de plenitud y éxito exige ecuanimidad y desapego. Reconocer que los momentos de máximo brillo son efímeros por naturaleza nos permite vivirlos con gratitud sin temer a su posterior e inevitable declive.\n" +
            "\n" +
            "**Hexagrama 56 – El Viaje**\n" +
            "La clave para aprender a fluir: Vivir en tránsito por nuevas etapas o lugares exige humildad, flexibilidad y reserva. Reconocer nuestra condición de viajeros transitorios nos ayuda a adaptarnos con elegancia sin crear apegos rígidos ni conflictos.\n" +
            "\n" +
            "**Hexagrama 60 – El Autocontrol**\n" +
            "La clave para aprender a fluir: Establecer límites claros y alcanzables otorga una estructura saludable a nuestra vida. Definir marcos sostenibles evita la dispersión de nuestra energía sin caer en una rigidez que asfixie nuestra vitalidad.\n" +
            "\n" +
            "**Hexagrama 61 – La Verdad Interior**\n" +
            "La clave para aprender a fluir: Cuando vivimos de acuerdo con nuestra verdad interior, nuestras decisiones, relaciones y acciones adquieren mayor coherencia y autenticidad, abriendo el corazón a una confianza mutua profunda.\n" +
            "\n" +
            "**Hexagrama 63 – El Después**\n" +
            "La clave para aprender a fluir: Alcanzar la culminación de una meta no significa descuidar el proceso. Mantener la atención vigilante en los pequeños detalles tras haber triunfado preserva el orden alcanzado y evita el desorden de la complacencia.\n" +
            "\n" +
            "**Hexagrama 64 – El Porvenir**\n" +
            "La clave para aprender a fluir: Hallarnos en el umbral de un nuevo comienzo exige extrema prudencia y paciencia. Mantener la atención y la flexibilidad en los momentos previos al cruce nos asegura iniciar el siguiente ciclo con pleno éxito.\n" +
            "\n" +
            "**Enseñanza global de CULMINAR Y RENACER**\n" +
            "La clave para aprender a fluir al culminar y renacer: Cerrar una etapa es la semilla del renacimiento. Aprender a fluir en el cierre exige cultivar la afinidad con lo consciente, disfrutar la abundancia con madurez, adaptarnos en el viaje de la vida, aplicar el autocontrol mediante límites sanos, expresar la verdad interior, sostener el orden en el después y preparar con prudencia el porvenir. Completar un ciclo con consciencia nos deja listos para reiniciar con sabiduría el eterno fluir de la existencia."
    )
)

// Listado de las 8 claves — igual que los 64 hexagramas: solo nombre + flecha
@Composable
fun PantallaClaves(
    modifier: Modifier = Modifier,
    alPulsarClave: (Clave) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(ColoresOraculo.fondoPrincipal)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(bottom = 48.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Claves para Aprender a Fluir",
                color = ColoresOraculo.doradoClaro,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
        items(listadoClaves) { clave ->
            FilaClave(clave = clave, alPulsar = { alPulsarClave(clave) })
        }
        item {
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

// Fila de cada clave en el listado
@Composable
fun FilaClave(clave: Clave, alPulsar: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { alPulsar() },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = ColoresOraculo.fondoTarjeta),
        border = androidx.compose.foundation.BorderStroke(1.dp, ColoresOraculo.dorado)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${clave.numero}.",
                color = ColoresOraculo.dorado,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 10.dp)
            )
            Text(
                text = clave.titulo,
                color = ColoresOraculo.textoPrincipal,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Ver detalle",
                tint = ColoresOraculo.dorado,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

// ─────────────────────────────────────────────
// PANTALLA 5: Detalle de una clave
// ─────────────────────────────────────────────
@Composable
fun PantallaDetalleClave(clave: Clave, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        // Número de clave pequeño arriba
        Text(
            text = "Clave ${clave.numero}",
            color = ColoresOraculo.dorado,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        // Título grande
        Text(
            text = clave.titulo,
            color = ColoresOraculo.doradoClaro,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        HorizontalDivider(color = ColoresOraculo.dorado, thickness = 1.dp,
            modifier = Modifier.fillMaxWidth())
        // Texto de la clave (lo rellenarás tú)
        // Renderizamos el texto linea a linea para aplicar formato
        clave.texto.split("\n").forEach { linea ->
            when {
                // Linea vacia: espacio entre parrafos
                linea.isBlank() -> {
                    androidx.compose.foundation.layout.Spacer(
                        modifier = Modifier.size(6.dp)
                    )
                }
                // Linea con ** al principio y al final: negrita en dorado
                linea.startsWith("**") && linea.endsWith("**") -> {
                    Text(
                        text = linea.removeSurrounding("**"),
                        color = ColoresOraculo.doradoClaro,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                // Parrafo normal
                else -> {
                    Text(
                        text = linea,
                        color = ColoresOraculo.textoPrincipal,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Justify,
                        lineHeight = 24.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
            Spacer(modifier = Modifier.height(48.dp))
        }

        if (scrollState.canScrollForward) {
            ScrollIndicator()
        }
    }
}

// ─────────────────────────────────────────────
// PANTALLA 6: Información
// ─────────────────────────────────────────────
@Composable
fun PantallaInformacion(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
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
            horizontalAlignment = Alignment.Start
        ) {

        // TÍTULO PRINCIPAL
        Text(
            text = "Información",
            color = ColoresOraculo.doradoClaro,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // ACERCA DE ESTA APLICACIÓN
        Text(
            text = "Acerca de esta aplicación",
            color = ColoresOraculo.doradoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Esta aplicación nace con el propósito de acercar el I Ching, o Libro de las Mutaciones, a aquellas personas interesadas en conocer su tradición y utilizarlo como una herramienta de reflexión y autoconocimiento.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "El I Ching es un antiguo texto de origen chino basado en 64 hexagramas, cada uno de los cuales representa una determinada situación, actitud o proceso de transformación. A través de sus símbolos y enseñanzas, invita a observar las circunstancias desde una perspectiva diferente y a reflexionar sobre los cambios que forman parte de nuestra vida.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // UNA HERRAMIENTA PARA LA REFLEXIÓN
        Text(
            text = "Una herramienta para la reflexión",
            color = ColoresOraculo.doradoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Esta aplicación no pretende predecir el futuro ni ofrecer respuestas absolutas. Su finalidad es proporcionar un espacio de consulta y reflexión en el que cada persona pueda plantear una cuestión, obtener un hexagrama y explorar su significado.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "La interpretación de una consulta depende también de las circunstancias personales de quien la realiza. Por ello, los resultados deben entenderse como una orientación para la reflexión, y no como una afirmación sobre aquello que necesariamente va a suceder.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // EL SISTEMA DE CONSULTA
        Text(
            text = "El sistema de consulta",
            color = ColoresOraculo.doradoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "La aplicación reproduce el proceso de obtención de un hexagrama mediante la generación de sus seis líneas, incluyendo las posibles líneas mutantes y el correspondiente hexagrama resultante.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Cada consulta puede mostrar:",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = "• El hexagrama obtenido.\n" +
                    "• Su nombre y significado.\n" +
                    "• Las líneas que lo forman.\n" +
                    "• Las líneas mutantes, cuando las haya.\n" +
                    "• El hexagrama resultante.\n" +
                    "• La interpretación correspondiente.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 6.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // UN ESPACIO PERSONAL DE CONSULTA
        Text(
            text = "Un espacio personal de consulta",
            color = ColoresOraculo.doradoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "El objetivo es ofrecer una experiencia sencilla y accesible, manteniendo al mismo tiempo el carácter simbólico y reflexivo del I Ching.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "La aplicación está pensada para que cada consulta sea una oportunidad para detenerse, observar una situación y considerar nuevas perspectivas.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 10.dp)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // IMPORTANTE
        Text(
            text = "Importante",
            color = ColoresOraculo.doradoClaro,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "El contenido de esta aplicación tiene carácter informativo y reflexivo. Las interpretaciones del I Ching no constituyen predicciones, diagnósticos ni recomendaciones profesionales. Las decisiones personales corresponden exclusivamente al usuario.",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // INFORMACIÓN DE LA APLICACIÓN
        Text(
            text = "Versión: 1.0",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 14.sp
        )

        Text(
            text = "Desarrollado por: Luz Navas Torres",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )

        Text(
            text = "© 2026 VICWEB",
            color = ColoresOraculo.textoPrincipal,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )

            Spacer(modifier = Modifier.height(48.dp))
        }

        if (scrollState.canScrollForward) {
            ScrollIndicator()
        }
    }
}
