package com.example.simulasiupk_malifmafaza

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var Panjang : EditText
    private lateinit var Lebar : EditText
    private lateinit var Luas : RadioButton
    private lateinit var Keliling : RadioButton
    private lateinit var Hasil : TextView
    private lateinit var proses : Button
    private lateinit var save : CheckBox
    private lateinit var RecyclerView : RecyclerView
    private lateinit var RecyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var rumus : Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Panjang = findViewById(R.id.etPanjang)
        Lebar = findViewById(R.id.etLebar)
        Luas = findViewById(R.id.rbLuas)
        Keliling = findViewById(R.id.rbKeliling)
        Hasil = findViewById(R.id.Hasil)
        proses = findViewById(R.id.btnHasil)
        save = findViewById(R.id.ckSave)

        RecyclerView = findViewById(R.id.listData)


        /*proses.setOnClickListener {
            var panjang = Panjang.text.toString().toInt()
            var lebar = Lebar.text.toString().toInt()

            if (Keliling.isChecked) {
                rumus = (panjang * lebar)
                Hasil.setText("Jawab ="+rumus.toString() + "cm")
            } else if(Luas.isChecked){
                rumus = ((2 * panjang)+(2 * lebar))
                Hasil.setText("Jawab ="+rumus.toString() + "cm")
            } else {
                Hasil.setText("Pilih Hasil Yang diinginkan" + Toast.LENGTH_SHORT)
            }
        }*/
        val data = ArrayList<DataUPK>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        RecyclerAdapter = AdapaterActivity(data)
        RecyclerView.adapter = RecyclerAdapter
        RecyclerView.layoutManager = viewManager

        fun jadi(){
            var panjang = Panjang.text.toString().toInt()
            var lebar = Lebar.text.toString().toInt()

            if (Keliling.isChecked) {
                rumus = (panjang * lebar)
                Hasil.setText("Jawab ="+rumus.toString() + "cm")
            } else if(Luas.isChecked){
                rumus = ((2 * panjang)+(2 * lebar))
                Hasil.setText("Jawab ="+rumus.toString() + "cm")
            } else {
                Hasil.setText("Pilih Hasil Yang diinginkan" + Toast.LENGTH_SHORT)
            }
        }

        fun simpan(){
            val panjang = Panjang.text.toString()
            val lebar = Lebar.text.toString()
            val hasil = Hasil.text.toString()
            var rb = ""
            if(Keliling.isChecked){
                rb = "Keliling"
            } else {
                rb = "Luas"
            }

            val dataa = DataUPK(panjang,lebar, rb, hasil)
            data.add(dataa)
            RecyclerAdapter.notifyDataSetChanged()
        }

        proses.setOnClickListener {
            if (save.isChecked) {
                jadi()
                simpan()
            } else {
                jadi()
            }
        }
    }
}