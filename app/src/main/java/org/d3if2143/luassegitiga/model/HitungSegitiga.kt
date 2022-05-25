package org.d3if2143.luassegitiga.model

import org.d3if2143.luassegitiga.db.SegitigaEntity

fun SegitigaEntity.hitungSegitiga(): Hasil {
    val hasil = alas * tinggi / 2

    return Hasil(hasil)
}