package com.thalysson.lista_de_tarefas_compose

/**
 * Código feito com base na playlist de aulas sobre jetpack compose: https://youtu.be/DD88xfumD-8?si=0w_y4_W1NkWu-16w
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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