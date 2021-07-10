package com.ananda.app11_cadastrotarefafoto

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*


class CadastroActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var btnSalvar: Button
    lateinit var imvFoto: ImageView
    lateinit var swtObrigatorio: Switch
    lateinit var txtTitulo: TextView
    lateinit var edtTitulo: EditText
    lateinit var txtDescricao: TextView
    lateinit var edtDescricao: EditText
    lateinit var spnDiaSemana: Spinner
    lateinit var dificuldade: Dificuldade
    lateinit var diaSemana: DiaSemana
    var fotoTirada: Bitmap?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        txtTitulo = findViewById(R.id.txtTitulo)
        txtDescricao = findViewById(R.id.txtDescricao)
        edtTitulo = findViewById(R.id.edtTitulo)
        edtDescricao = findViewById(R.id.edtDescricao)
        spnDiaSemana = findViewById(R.id.spnDiaSemana)
        btnSalvar = findViewById(R.id.btnSalvar)
        imvFoto = findViewById(R.id.imvFoto)
        swtObrigatorio = findViewById(R.id.swtObrigatorio)


        // Intent para chamar a Câmera
        imvFoto.setOnClickListener(){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null)
                startActivityForResult(intent, RC_CAMERA)
        }

        // Aqui estamos implementando o "Adapter" do Spinner (Combo), consumindo o array no arquivo strings.xml
        ArrayAdapter.createFromResource(this, R.array.opcoes_spinner, android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnDiaSemana.adapter = arrayAdapter
        }

        spnDiaSemana.onItemSelectedListener = this

        btnSalvar.setOnClickListener(){
            val tarefa = Tarefas(fotoTirada, edtTitulo.text.toString(), edtDescricao.text.toString(), diaSemana, dificuldade, swtObrigatorio.isChecked)
            MainActivity.lista.add(tarefa)
            finish()
        }
    }

    fun OnDificuldadeClick(view: View){
        if (view is RadioButton){
            var checked = view.isChecked

            when (view.id){
                R.id.rdbFacil -> { if (checked) {dificuldade = Dificuldade.FACIL}}
                R.id.rdbMedio -> { if (checked) {dificuldade = Dificuldade.MEDIO}}
                R.id.rdbDificil -> { if (checked) {dificuldade = Dificuldade.DIFICIL}}
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2){
            0 -> {diaSemana = DiaSemana.SEGUNDA}
            1 -> {diaSemana = DiaSemana.TERCA}
            2 -> {diaSemana = DiaSemana.QUARTA}
            3 -> {diaSemana = DiaSemana.QUINTA}
            4 -> {diaSemana = DiaSemana.SEXTA}
            5 -> {diaSemana = DiaSemana.SABADO}
            6 -> {diaSemana = DiaSemana.DOMINGO}
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((resultCode == RESULT_OK) && (requestCode == RC_CAMERA)){
            fotoTirada = data?.extras?.get("data") as Bitmap
            imvFoto.setImageBitmap(fotoTirada)
        }
    }

    companion object{
        const val RC_CAMERA  = 12345
        const val RC_GALERIA = 67890
    }
}