package com.thalysson.lista_de_tarefas_compose.componentes

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thalysson.lista_de_tarefas_compose.ui.theme.GREEN
import com.thalysson.lista_de_tarefas_compose.ui.theme.WHITE

@Composable
fun BotaoSalvar(
    onClick: () -> Unit,
    modifier: Modifier,
    texto: String
){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = GREEN,
            contentColor = WHITE
        )
    ){
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}