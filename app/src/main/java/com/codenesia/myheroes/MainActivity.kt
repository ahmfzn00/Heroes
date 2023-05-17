package com.codenesia.myheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.recyclerview.widget.LinearLayoutManager
import com.codenesia.myheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<DataPahlawan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getData())

        binding.rvHeroes.setHasFixedSize(true)

        /* Mengatur jenis layour manager pada recycleview*/
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)

        /* Menambahkan array pahlawan ke dalam adapter */
        val adapterPahlawan = AdapterPahlawan(list)

        /* Menghubungkan recycleview dengan adapterPahlawan */
        binding.rvHeroes.adapter = adapterPahlawan

        supportActionBar?.hide()

    }

    private fun getData(): ArrayList<DataPahlawan> {
        val dataNamaPahlawan = resources.getStringArray(R.array.nama_pahlawan)
        val dataDescPahlawan = resources.getStringArray(R.array.desc_pahlawan)
        val listPahlawan = ArrayList<DataPahlawan>()
        for (i in dataNamaPahlawan.indices) {
            val data = DataPahlawan(dataNamaPahlawan[i], dataDescPahlawan[i])
            listPahlawan.add(data)
        }
        return listPahlawan
    }
}