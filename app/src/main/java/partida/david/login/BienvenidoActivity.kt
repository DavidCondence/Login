package partida.david.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenido.*

class BienvenidoActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val nombre: String = intent.getStringExtra("usuario")
        txt_usuario.text = nombre

        boton_cerrarSesion.setOnClickListener{
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
    }
}
