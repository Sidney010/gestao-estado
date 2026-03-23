package com.aulasandroid.gestoestado.juros

import android.R.string.no
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aulasandroid.gestoestado.calculos.calcularJuros
import com.aulasandroid.gestoestado.calculos.calcularMontante
import kotlin.text.toDouble

class JurosScreenViewModel: ViewModel() {
    private val _capitalState = MutableLiveData<String>()
    var capital: LiveData<String> = _capitalState

    private val _taxaState = MutableLiveData<String>()

    var taxa: LiveData<String> = _taxaState

    private val _tempoState = MutableLiveData<String>()

    var tempo: LiveData<String> = _tempoState

    private val _jurosState = MutableLiveData<Double>()

    var juros: LiveData<Double> = _jurosState

    private val _montanteState = MutableLiveData<Double>()

    var montante: LiveData<Double> = _montanteState

    fun onCapitalChange(novoCapital: String){
        _capitalState.value = novoCapital
    }

    fun onTaxaChange(novaTaxa: String) {
        _taxaState.value = novaTaxa
    }

    fun onTempoChange(novoTempo: String) {
        _tempoState.value= novoTempo
    }

    fun calcularJurosInvestimento(){
        _jurosState.value =
            calcularJuros(
            capital = _capitalState.value!!.toDouble(),
                //      !! -> Sei que ele não vai vir nulo
                //      ?  -> Pode ser nulo
            taxa = _taxaState.value!!.toDouble(),
            tempo = _tempoState.value!!.toDouble()
        )

    }
    fun calcularMontanteInvestimento (){
        _montanteState.value =
            calcularMontante(
                capital = _capitalState.value!!.toDouble(),
                // juros já uma variavel to Double portanto não precisa ser transformada
                juros = _jurosState.value!!
            )
    }

}
