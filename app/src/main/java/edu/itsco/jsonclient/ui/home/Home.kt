package edu.itsco.jsonclient.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.itsco.jsonclient.data.api.model.Character

@Composable
fun HomeScreen(){
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()

    LazyColumn {
        if(state.isEmpty()){
            item{
                CircularProgressIndicator(
                    modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center)
                )
            }
        }
        items(items = state){ character: Character ->  
            Text(character.name, Modifier.padding(all = 8.dp));
        }
    }
}