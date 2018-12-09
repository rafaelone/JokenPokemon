package com.sergio.rafael.jokenpokemon

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.sergio.rafael.jokenpokemon.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        btnCriar.setOnClickListener{
            mAuth.createUserWithEmailAndPassword(
                    edEmail.text.toString(),
                    edSenha.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    saveInRealTimeDataBase()
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

        }

    }

    private fun saveInRealTimeDataBase(){
        val user = User(edEmail.text.toString(), etNomeJogador.text.toString(), edNick.text.toString(), edSenha.text.toString())
        FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                .setValue(user)
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        val returnIntent = Intent()
                        returnIntent.putExtra("email", edEmail.text.toString())
                        setResult(Activity.RESULT_OK, returnIntent)
                        finish()
                    }else{
                        Toast.makeText(this, "Erro ao criar o usuário", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}
