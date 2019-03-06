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
            finish()
        }
        boton_aceptar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            if (validarCampos(new_campo_usuario.getText().toString(), new_campo_contrasena.getText().toString(), new_campo_contrasenarepeat.getText().toString())) {
                intent.putExtra("new_nombre", new_campo_usuario.getText().toString())
                intent.putExtra("new_contrasena", new_campo_contrasena.getText().toString())
                intent.putExtra("new_contrasena_repeat", new_campo_contrasenarepeat.getText().toString())
                Toast.makeText(this, "Nuevo usuario registrado", Toast.LENGTH_SHORT).show()
                startActivityForResult(intent, 123)
                finish()
            }
        }
    }
    fun validarCampos(nombre: String, ps1: String, ps2: String): Boolean{
        if(nombre.isEmpty()){
            Toast.makeText(this, "Ingresa nombre de usuario", Toast.LENGTH_SHORT).show()
        } else {
            if(ps1.isEmpty() || ps2.isEmpty()){
                Toast.makeText(this, "Ingresa contraseña", Toast.LENGTH_SHORT).show()
            } else {
                if(!validarContrasena(ps1)){
                    Toast.makeText(this, "Contraseña corta", Toast.LENGTH_SHORT).show()
                } else {
                    if(ps1 != ps2){
                        Toast.makeText(this, "Contraseña diferente, vuelve a repetir", Toast.LENGTH_SHORT).show()
                    } else {
                        return true
                    }
                }
            }
        }
        return false
    }
    fun validarContrasena(ps1: String): Boolean {
        if (ps1.length >= 6){
            return true
        }
        return false
    }
}
