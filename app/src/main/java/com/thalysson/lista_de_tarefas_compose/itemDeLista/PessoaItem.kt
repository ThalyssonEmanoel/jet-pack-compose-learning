package com.thalysson.lista_de_tarefas_compose.itemDeLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.thalysson.lista_de_tarefas_compose.R
import com.thalysson.lista_de_tarefas_compose.model.Pessoa

@Composable
fun PessoaItem(
    position: Int,
    listaPessoa: MutableList<Pessoa>
) {

    val nomePessoa = listaPessoa[position].nome
    val descricaoPessoa = listaPessoa[position].descricao
    val sexo = listaPessoa[position].sexo
    val sexoNivel: String = when(sexo) {
        0 -> "Sem gênero"
        1 -> "Sexo masculino"
        2 -> "Sexo feminino"
        3 -> "Outro"
        else -> "Problema ao verificar o sexo"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtNome, txtDescricao, txtSexo, btDeletar) = createRefs()

            Text(
                text = nomePessoa.toString(),
                color = Color.White,
                modifier = Modifier.constrainAs(txtNome) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = descricaoPessoa.toString(),
                color = Color.White,
                modifier = Modifier.constrainAs(txtDescricao) {
                    top.linkTo(txtNome.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = sexoNivel,
                color = Color.White,
                modifier = Modifier.constrainAs(txtSexo) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            IconButton(
                onClick = { },
                modifier = Modifier.constrainAs(btDeletar) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(txtSexo.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.id_delete),
                    contentDescription = "Botão de deletar"
                )
            }
        }
    }
}