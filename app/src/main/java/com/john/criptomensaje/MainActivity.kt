package com.john.criptomensaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countLetters()
    }

    fun countLetters() {
        //val messageCripto: String = "53‡‡†305))6*;4826)4‡.)4‡);806*;48†8¶60))85;;]8*;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;"
        val messageCripto: String = "53‡‡†305))6*;4826)4‡.)4‡);806*;48†8¶60))85;1‡(;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;"
        val messageCriptoChar = messageCripto.toCharArray()

        val hashMap : HashMap<Char, Int>
                = HashMap<Char, Int> ()

        messageCriptoChar.forEach { c ->
            val number = contarCaracteres(messageCripto, c)
            if(!hashMap.containsKey(c))
                hashMap.put(c,number)
        }

        val result = hashMap.toList().sortedByDescending { (_, value) -> value}.toMap()
        Log.d("",result.toString())

        val abecedario = "etaonihsrlducmwyfgpbvkjxqz".toCharArray()

        val abecedarioOrdenado : HashMap<Char, Char>
                = HashMap<Char, Char> ()

        var i = 0
        result.forEach{
            abecedarioOrdenado.put(it.key,abecedario[i])
            i++
        }
        Log.d("",abecedarioOrdenado.toString())

        var mensajeDesencriptado = ""
        messageCripto.toCharArray().forEach {
            mensajeDesencriptado += abecedarioOrdenado.getValue(it)
        }
        Log.d("",mensajeDesencriptado)
    }

    //calcular el número de veces que se repite un carácter en un String
    fun contarCaracteres(cadena: String, caracter: Char): Int {
        var posicion: Int
        var contador = 0
        //se busca la primera vez que aparece
        posicion = cadena.indexOf(caracter)
        while (posicion != -1) { //mientras se encuentre el caracter
            contador++ //se cuenta
            //se sigue buscando a partir de la posición siguiente a la encontrada
            posicion = cadena.indexOf(caracter, posicion + 1)
        }
        return contador
    }

}