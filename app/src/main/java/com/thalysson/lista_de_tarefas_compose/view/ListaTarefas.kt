package com.thalysson.lista_de_tarefas_compose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.thalysson.lista_de_tarefas_compose.itemDeLista.PessoaItem
import com.thalysson.lista_de_tarefas_compose.model.Pessoa
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
                        text = "Lista de pessoas",
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
                .padding(innerPadding) // <- isso é essencial
        ) {
            val listaPessoas: MutableList<Pessoa> = mutableListOf(
                Pessoa(
                    nome = "Neymar",
                    descricao = "Jogador que mais se joga no chão",
                    sexo = 0
                ),
                Pessoa(
                    nome = "Eddard Stark",
                    descricao = "Estressou-se demais e acabou perdendo a cabeça",
                    sexo = 1
                ),
                Pessoa(
                    nome = "Thalysson",
                    descricao = "O cara que está programando isso agora",
                    sexo = 2
                ),
                Pessoa(
                    nome = "Anônimos",
                    descricao = "asssssssssssssssssssssssssssssssaaaaaaaaaaa",
                    sexo = 3
                )

            )
            LazyColumn {
                itemsIndexed(listaPessoas) { position, _ ->
                    PessoaItem(position, listaPessoas)
                }
            }
        }
    }
}
