package edu.itsco.jsonclient.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itsco.jsonclient.data.api.model.Character
import edu.itsco.jsonclient.data.repository.RickMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val rickMortyRepository: RickMortyRepository
): ViewModel(){
    private val _state = MutableStateFlow(emptyList<Character>())
    val state: StateFlow<List<Character>>
    get() = _state

    init{
        viewModelScope.launch {
            _state.value = rickMortyRepository.getCharacters().results
        }
    }
}