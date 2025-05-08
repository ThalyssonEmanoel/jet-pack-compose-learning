package com.thalysson.lista_de_tarefas_compose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thalysson.lista_de_tarefas_compose.ui.theme.plataformaFontBlack
import com.thalysson.lista_de_tarefas_compose.ui.theme.GREEN
import com.thalysson.lista_de_tarefas_compose.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController) {
    var downloads by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = plataformaFontBlack,
        floatingActionButton = {
            FloatingActionButton(onClick = { downloads++ }) {
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Download"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lista de tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = plataformaFontBlack
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GREEN
                )
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Você clicou em download $downloads vezes.",
                color = WHITE,
                fontSize = 16.sp
            )
        }
    }
}
