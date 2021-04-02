package src.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.services_app.R
import com.example.services_app.databinding.*
import mvi.BaseView
import org.koin.androidx.viewmodel.ext.android.viewModel
import src.state.UserState
import src.viewmodel.UserViewModel

class Register : AppCompatActivity(), BaseView<UserState> {

    private val mViewModel by viewModel<UserViewModel>()

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var binding2: WorkersSignUpBinding
    private lateinit var binding3: ClientsSignUpBinding
    private lateinit var completado: CompletedBinding
    private lateinit var fin: ActivityMainBinding
    private val pasos = arrayOf("Basic Info", "Specifics", "Complete")
    var actual =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        binding2 = WorkersSignUpBinding.inflate(layoutInflater)
        binding3 = ClientsSignUpBinding.inflate(layoutInflater)
        completado = CompletedBinding.inflate(layoutInflater)
        fin = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.Pasos.setLabels(pasos).setBarColorIndicator(Color.BLACK).setLabelColorIndicator(Color.parseColor("#0ca450")).setCompletedPosition(actual).drawView()
        binding.Pasos.completedPosition = actual

        binding.buttonPrestar.setOnClickListener {
            if (!todoLleno1())
            {

            }
            else {
            actual += 1
            val view2 = binding2.root
            setContentView(view2)
            binding2.Pasos.setLabels(pasos).setBarColorIndicator(Color.BLACK).setLabelColorIndicator(Color.parseColor("#0ca450")).setCompletedPosition(actual).drawView()
            binding2.Pasos.completedPosition = actual
             }
        }
        binding.buttonSolicitar.setOnClickListener {
            if (!todoLleno1())
            {

            }
            else {
            actual += 1
            val view2 = binding3.root
            setContentView(view2)
            binding3.Pasos.setLabels(pasos).setBarColorIndicator(Color.BLACK).setLabelColorIndicator(Color.parseColor("#0ca450")).setCompletedPosition(actual).drawView()
            binding3.Pasos.completedPosition = actual
        }
        }
        binding2.volver.setOnClickListener {
            actual -= 1
            val view2 = binding.root
            setContentView(view2)
        }
        binding3.volver.setOnClickListener {
            actual -= 1
            val view2 = binding.root
            setContentView(view2)
        }
        binding2.finalizar.setOnClickListener {
            if (!todoLleno2())
            {

            }
            else {
            actual += 1
            val view2 = completado.root
            setContentView(view2)
                completado.Pasos.setLabels(pasos).setBarColorIndicator(Color.BLACK).setLabelColorIndicator(Color.parseColor("#0ca450")).setCompletedPosition(actual).drawView()
                completado.Pasos.completedPosition = actual
        }
        }
        binding3.finalizar.setOnClickListener {
            if (!todoLleno3())
            {

            }
            else {
            actual += 1
            val view2 = completado.root
            setContentView(view2)
                completado.Pasos.setLabels(pasos).setBarColorIndicator(Color.BLACK).setLabelColorIndicator(Color.parseColor("#0ca450")).setCompletedPosition(actual).drawView()
                completado.Pasos.completedPosition = actual
        }}
        completado.Continue.setOnClickListener {
            val view2 = fin.root
            setContentView(view2)
        }



    }
    fun todoLleno1(): Boolean {
        if (binding.editTextTextEmailAddress.text.trim().isEmpty())
        {
            binding.editTextTextEmailAddress.setError("debe completar este campo")
            return false
        }
        if (binding.editTextTextPassword.text.trim().isEmpty())
        {
            binding.editTextTextPassword.setError("debe completar este campo")
            return false
        }
        if (binding.editTextTextPassword2.text.trim().isEmpty())
        {
            binding.editTextTextPassword2.setError("debe completar este campo")
            return false
        }
        if (binding.editTextTextPersonName2.text.trim().isEmpty())
        {
            binding.editTextTextPersonName2.setError("debe completar este campo")
            return false
        }
        if (binding.editTextTextPassword2.text.trim() != binding.editTextTextPassword.text.trim())
        {
            binding.editTextTextPassword2.setError("las contraseñas no son iguales")
            return false
        }
        return true
    }
    fun todoLleno2(): Boolean {
        if (binding2.Direccion.text.trim().isEmpty())
        {
            binding2.Direccion.setError("debe completar este campo")
            return false
        }
        if (binding2.cedula.text.trim().isEmpty())
        {
            binding2.cedula.setError("debe completar este campo")
            return false
        }
        if (binding2.precio.text.trim().isEmpty())
        {
            binding2.precio.setError("debe completar este campo")
            return false
        }
        if (binding2.radio.text.trim().isEmpty())
        {
            binding2.radio.setError("debe completar este campo")
            return false
        }
        return true
    }
    fun todoLleno3(): Boolean {
        if (binding3.Direccion.text.trim().isEmpty())
        {
            binding3.Direccion.setError("debe completar este campo")
            return false
        }
        if (binding3.cedula.text.trim().isEmpty())
        {
            binding3.cedula.setError("debe completar este campo")
            return false
        }
        return true
    }

    override fun render(state: UserState) {
        TODO("Not yet implemented")
    }
}