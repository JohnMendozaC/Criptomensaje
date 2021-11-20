package com.john.criptomensaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val orderedAlphabet: HashMap<Char, Char> = HashMap()

    //val messageEncrypted: String = "53‡‡†305))6*;4826)4‡.)4‡);806*;48†8¶60))85;;]8*;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;"
    private val messageEncrypted =
        "53‡‡†305))6*;4826)4‡.)4‡);806*;48†8¶60))85;1‡(;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;"
    private var tvMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMessage = findViewById(R.id.tv_message_encrypted)
        orderAlphabet()
        tvMessage?.setText(decipher())
    }

    fun countLetters(): Map<Char, Int> {
        val messageCriptoChar = messageEncrypted.toCharArray()
        val numberOfCharacters: HashMap<Char, Int> = HashMap<Char, Int>()
        messageCriptoChar.forEach { c ->
            val number = countCharacters(messageEncrypted, c)
            if (!numberOfCharacters.containsKey(c))
                numberOfCharacters.put(c, number)
        }
        return numberOfCharacters.toList().sortedByDescending { (_, value) -> value }.toMap()
    }

    fun getAlphabet(): CharArray {
        //val alphabet = "etaonihsrlducmwyfgpbvkjxqz".toCharArray()
        //val alphabet = "etaonihsrdflbmgyupvbwkj".toCharArray()
        val alphabet = "ethosnairdflbmgyuvpcwkj".toCharArray()

        return alphabet
    }

    fun orderAlphabet() {
        var i = 0
        countLetters().forEach {
            orderedAlphabet.put(it.key, getAlphabet()[i])
            i++
        }
    }

    fun decipher() :String{
        var decryptedMessage = ""
        messageEncrypted.toCharArray().forEach {
            decryptedMessage += orderedAlphabet.getValue(it)
        }
        return decryptedMessage
    }

    fun countCharacters(messageEncrypted: String, character: Char): Int {
        var posicion: Int
        var contador = 0
        posicion = messageEncrypted.indexOf(character)
        while (posicion != -1) {
            contador++
            posicion = messageEncrypted.indexOf(character, posicion + 1)
        }
        return contador
    }

}