package org.d3if2143.luassegitiga.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if2143.luassegitiga.db.SegitigaDao
import org.d3if2143.luassegitiga.db.SegitigaEntity
import org.d3if2143.luassegitiga.model.Hasil

class HitungViewModel(private val db: SegitigaDao) : ViewModel() {
    private val hasilSegitiga = MutableLiveData<Hasil?>()

    val data = db.getLastSegitiga()

    fun hitungSegitiga(alas : Float, tinggi : Float ){
        val hasil = alas * tinggi / 2
        hasilSegitiga.value = Hasil(hasil)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = SegitigaEntity(
                    alas = alas,
                    tinggi = tinggi,
                    hasil = hasil,
                )
                db.insert(data)
            }
        }
    }
    fun getHasilSg(): LiveData<Hasil?> = hasilSegitiga
}