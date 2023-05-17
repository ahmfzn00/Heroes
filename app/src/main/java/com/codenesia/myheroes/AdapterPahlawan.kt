package com.codenesia.myheroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPahlawan(private val dataPahlawan: ArrayList<DataPahlawan>) : RecyclerView.Adapter<AdapterPahlawan.ListPahlawan>() {

    class ListPahlawan(itemView: View): RecyclerView.ViewHolder(itemView) {
        /* Class yang digunakan untuk menggabungkan data dan view adapter*/
        val nama: TextView = itemView.findViewById(R.id.tv_namaPahlawan)
        val deskripsi: TextView = itemView.findViewById(R.id.tv_descPahlawan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPahlawan {
        /* Fungsi yang digunakan untuk mengatur tampilan adapter */
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ListPahlawan(view)
    }

    override fun getItemCount(): Int {
        /* Fungsi yang digunakan untuk mendapatkan jumlah item*/
        return dataPahlawan.size
    }

    override fun onBindViewHolder(holder: ListPahlawan, position: Int) {
        /* Fungsi ini digunakan untuk mengisi konten adapter dengan jenis komponen view (nama, deskripsi)*/
        val (nama, deskripsi) = dataPahlawan[position]
        holder.nama.text = nama
        holder.deskripsi.text = deskripsi
    }
}