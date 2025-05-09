package com.thalysson.lista_de_tarefas_compose.view
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.thalysson.lista_de_tarefas_compose.R
import com.thalysson.lista_de_tarefas_compose.componentes.CaixaDeTexto
import com.thalysson.lista_de_tarefas_compose.ui.theme.GREEN
import com.thalysson.lista_de_tarefas_compose.ui.theme.plataformaFontBlack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.thalysson.lista_de_tarefas_compose.componentes.BotaoSalvar
import com.thalysson.lista_de_tarefas_compose.ui.theme.WHITE


@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
fun SalvarTarefa( navController: NavController ){
    Scaffold(
        containerColor = WHITE,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("listaTarefas") },
                containerColor = GREEN,
                contentColor = plataformaFontBlack
            ) {
                Icon(
                    //Para criar usar um ícone específico, vá até o res na raiz do app, drawable e clicka com o botão direito
                    //Após isso -> new -> vector asset e então adicione o novo ícone.
                    imageVector = ImageVector.vectorResource(id = R.drawable.return_buttom), "Download"
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Salvar tarefas",
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            var tituloTarefa by remember {
                mutableStateOf("")
            }
            var descricaoTarefa by remember {
                mutableStateOf("")
            }
            var escolhaMasculino by remember {
                mutableStateOf(false)
            }
            var escolhaFeminino by remember {
                mutableStateOf(false)
            }
            var escolhaOutro by remember {
                mutableStateOf(false)
            }

            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp, 64.dp, 24.dp, 0.dp),
                label = "Email",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth().height(150.dp)
                    .padding(24.dp, 16.dp, 24.dp, 0.dp),
                label = "Descrição do seu email",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )
            Row(
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Start,
               modifier = Modifier.padding(24.dp, 16.dp, 24.dp, 0.dp)
            ){
                Text(
                    text = "Qual o seu sexo?",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(24.dp, 16.dp, 24.dp, 0.dp)
            ) {
                RadioButton(
                    selected = escolhaMasculino,
                    onClick = {
                        escolhaMasculino = true
                        escolhaFeminino = false
                        escolhaOutro = false
                    }
                )
                Text("Masculino", modifier = Modifier.padding(end = 8.dp))

                RadioButton(
                    selected = escolhaFeminino,
                    onClick = {
                        escolhaMasculino = false
                        escolhaFeminino = true
                        escolhaOutro = false
                    }
                )
                Text("Feminino", modifier = Modifier.padding(end = 8.dp))

                RadioButton(
                    selected = escolhaOutro,
                    onClick = {
                        escolhaMasculino = false
                        escolhaFeminino = false
                        escolhaOutro = true
                    }
                )
                Text("Outro")
            }
            BotaoSalvar(
                onClick = {

                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 24.dp, end = 24.dp).height(56.dp),
                texto = "Enviar"
            )
        }

    }
}