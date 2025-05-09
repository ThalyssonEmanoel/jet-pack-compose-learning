package com.thalysson.lista_de_tarefas_compose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thalysson.lista_de_tarefas_compose.R
import com.thalysson.lista_de_tarefas_compose.ui.theme.plataformaFontBlack
import com.thalysson.lista_de_tarefas_compose.ui.theme.GREEN
import com.thalysson.lista_de_tarefas_compose.ui.theme.WHITE

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController) {

    Scaffold(
        containerColor = WHITE,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("salvarTarefa") },
                containerColor = GREEN,
                contentColor = plataformaFontBlack
            ) {
                Icon(
                    //Para criar usar um ícone específico, vá até o res na raiz do app, drawable e clicka com o botão direito
                    //Após isso -> new -> vector asset e então adicione o novo ícone.
                    imageVector = ImageVector.vectorResource(id = R.drawable.buttom_arrow_next), "Download"
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
    ) {  }
}
