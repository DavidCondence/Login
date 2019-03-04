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



        boton_crearUsuario.setOnClickListener {
            val intento1 = Intent(this, RegistroActivity::class.java)
            startActivity(intento1)
        }
        boton_Ingresar.setOnClickListener {
            val intent = Intent(this, BienvenidoActivity::class.java)
            if(campo_nombre.getText().toString().isEmpty()){
                Toast.makeText(this, "Ingresa nombre de usuario", Toast.LENGTH_SHORT).show()
            } else {
                if(campo_contrasena.getText().toString().isEmpty()){
                    Toast.makeText(this, "Ingresa contraseña", Toast.LENGTH_SHORT).show()
                } else {
                    intent.putExtra("usuario", campo_nombre.getText().toString())
                    startActivityForResult(intent,123)
                    finish()
                }
            }
        }
    }
}
