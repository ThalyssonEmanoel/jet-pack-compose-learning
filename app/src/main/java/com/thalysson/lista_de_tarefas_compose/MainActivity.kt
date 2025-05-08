package com.thalysson.lista_de_tarefas_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
/**
 * androidx.navigation:navigation-compose Importantissímo para a navegação entre as telas, ele é um dependência que foi criada em build.gradle.kts (:app)
 */
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thalysson.lista_de_tarefas_compose.ui.theme.ListadeTarefasComposeTheme
import com.thalysson.lista_de_tarefas_compose.view.ListaTarefas
import com.thalysson.lista_de_tarefas_compose.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /**
             * @ListadeTarefasComposeTheme Logo de início já é obrigatório definir o navController, depois utiliza o NavHost, nele irá ser passado a instância do navController e qual tela que será iniciada ao abrir o app
             * composable serve para definir as rotase logo depois terá que chamar a classe que será essa rota, "listaTarefas" é um id para a classe "ListaTarefas"
             * */
            ListadeTarefasComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas") {
                    composable(
                        route = "listaTarefas"
                    ){
                        ListaTarefas(navController)
                    };
                    composable(
                        route = "salvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }
                }
            }
        }
    }
}