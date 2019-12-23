package com.example.firebasreg

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var firebase: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebase = FirebaseAuth.getInstance()


        register.setOnClickListener {

            val Email: String = email.text.toString()
            val Password: String = password.text.toString()


            if (Email == "" || Password == "") {
                Toast.makeText(this, "შეავსეთ ველები", Toast.LENGTH_LONG).show()
            } else {
                firebase.createUserWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "რეგისტრაცია წარმატებით დაწრულდა", Toast.LENGTH_LONG).show()

                            email.setText("")
                            password.setText("")
                        } else {

                            Toast.makeText(this, "რეგისტრაცია წარუმატებელია", Toast.LENGTH_LONG).show()
                        }
                    })
            }
        }
    }

}

