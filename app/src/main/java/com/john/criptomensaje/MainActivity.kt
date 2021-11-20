package com.john.criptomensaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var mergeAlphabet: HashMap<Char, Char>? = null
    private var tvMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMessage = findViewById(R.id.tv_message_encrypted)
        getMessage()
    }

    fun getMessage() {
        val messageEncrypted = "53‡‡†305))6*;4826)4‡.)4‡);806*;48†8¶60))85;;]8*;:‡*8†83(88)5*†;46(;88*96*?;8)*‡(;485);5*†2:*‡(;4956*2(5*—4)8¶8*;4069285);)6†8)4‡‡;1(‡9;48081;8:8‡1;48†85;4)485†528806*81(‡9;48;(88;4(‡?34;48)4‡;161;:188;‡?;"
        tvMessage?.setText(decipher(messageEncrypted))
    }

    fun getMergeAlphabet(): HashMap<Char, Char>? {
        if (mergeAlphabet == null) {
            mergeAlphabet = HashMap()
            val alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray()
            val alphabetEncrypted = "52—†81346,709*‡.$();?¶]¢:[".toCharArray()
            alphabetEncrypted.forEachIndexed { index, word ->
                mergeAlphabet?.put(word, alphabet[index])
            }
        }
        return mergeAlphabet
    }

    fun decipher(messageEncrypted: String): String {
        var decryptedMessage = ""
        messageEncrypted.toCharArray().forEach {
            try {
                decryptedMessage += getMergeAlphabet()?.getValue(it)
            } catch (e: Exception) {
                decryptedMessage += "[$it]"
            }
        }
        return decryptedMessage
    }
}