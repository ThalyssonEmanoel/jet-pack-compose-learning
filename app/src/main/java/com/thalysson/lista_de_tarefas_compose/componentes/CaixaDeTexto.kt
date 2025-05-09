package com.thalysson.lista_de_tarefas_compose.componentes

import android.annotation.SuppressLint
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import com.thalysson.lista_de_tarefas_compose.ui.theme.GREEN
import com.thalysson.lista_de_tarefas_compose.ui.theme.WHITE
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CaixaDeTexto( value: String,
                  onValueChange: (String) -> Unit,
                  modifier: Modifier,
                  label: String,
                  maxLines: Int,
                  keyboardType: KeyboardType
                  ){
    val customTextSelectionColors = TextSelectionColors(
        handleColor = Color.Black,
        backgroundColor = Color.Gray
    )
    CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            label = { Text(text = label) },
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = GREEN,
                cursorColor = GREEN,
                unfocusedContainerColor = WHITE,
                focusedContainerColor = WHITE,
                disabledContainerColor = WHITE,
                errorContainerColor = WHITE,
                focusedLabelColor = GREEN,
//                unfocusedLabelColor =
//                disabledLabelColor =
//                errorLabelColor =
            )
        )
    }
}