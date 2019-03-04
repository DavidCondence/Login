package partida.david.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        boton_cancelar.setOnClickListener {
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
        }
        boton_aceptar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            if(new_campo_usuario.getText().toString().isEmpty()){
                Toast.makeText(this, "Ingresa nombre de usuario", Toast.LENGTH_SHORT).show()
            } else {
                if (new_campo_contrasena.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa contraseña", Toast.LENGTH_SHORT).show()
                } else {
                    if (new_campo_contrasena.getText().toString() == new_campo_contrasenarepeat.getText().toString()) {
                        intent.putExtra("new_nombre", new_campo_usuario.getText().toString())
                        intent.putExtra("new_contrasena", new_campo_contrasena.getText().toString())
                        intent.putExtra("new_contrasena_repeat", new_campo_contrasenarepeat.getText().toString())
                        Toast.makeText(this, "Nuevo usuario registrado", Toast.LENGTH_SHORT).show()
                        startActivityForResult(intent, 123)
                        finish()
                    } else {
                        Toast.makeText(this, "Contraseña diferente, vuelve a repetir", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
