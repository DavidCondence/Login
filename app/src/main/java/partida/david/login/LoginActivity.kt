package partida.david.login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bienvenido.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var RNombre: String = ""
        var RPassword: String = ""
        val intent = intent
        if(intent.hasExtra("new_nombre")) {
            RNombre = intent.getStringExtra("new_nombre")
            RPassword = intent.getStringExtra("new_contrasena")
        }


        boton_crearUsuario.setOnClickListener {
            val intento1 = Intent(this, RegistroActivity::class.java)
            startActivity(intento1)
        }
        boton_Ingresar.setOnClickListener {
            val intent = Intent(this, BienvenidoActivity::class.java)
            if(validarCampos(RNombre,campo_nombre.getText().toString(),RPassword, campo_contrasena.getText().toString())){
                intent.putExtra("usuario", campo_nombre.getText().toString())
                startActivityForResult(intent,123)
                finish()
            }
        }
    }
    fun validarCampos(RNombre:String, nombre: String,RPassword: String, ps1: String): Boolean{
        if(nombre.isEmpty()){
            Toast.makeText(this, "Ingresa nombre de usuario", Toast.LENGTH_SHORT).show()
        } else {
            if(ps1.length <= 5){
                Toast.makeText(this, "Algún campo erroneo", Toast.LENGTH_SHORT).show()
            } else {
                if(RNombre != nombre){
                    Toast.makeText(this, "Nombre o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                } else {
                    if(RPassword != ps1){
                        Toast.makeText(this, "Nombre o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    } else {
                        return true
                    }
                }
            }
        }
        return false
    }
}
