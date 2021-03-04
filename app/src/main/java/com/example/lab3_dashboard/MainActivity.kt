package com.example.lab3_dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<Noticia> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias.add(Noticia("Prueba", "https://i.pinimg.com/originals/15/f2/79/15f279fdfaafec59ee5f4bb78f208d1c.jpg"))

        val adaptador:NoticiasAdaptador = NoticiasAdaptador(noticias)

        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticias.layoutManager = LinearLayoutManager(this)
        listaNoticias.adapter = adaptador



    }
}