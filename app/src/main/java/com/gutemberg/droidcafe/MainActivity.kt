package com.gutemberg.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.angoti.retrofit.RetrofitService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscaDados()
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.getProdutos()?.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>?>?, response: Response<List<Produto>?>?) {
                val listaDeProdutos : List<Produto>? = response?.body()

                val produto1 = listaDeProdutos?.get(0)?.produto
                val produto2 = listaDeProdutos?.get(1)?.produto
                val produto3 = listaDeProdutos?.get(2)?.produto

                descricao1.text = listaDeProdutos?.get(0)?.descricao
                descricao2.text = listaDeProdutos?.get(1)?.descricao
                descricao3.text = listaDeProdutos?.get(2)?.descricao

                valor1.text = listaDeProdutos?.get(0)?.valor
                valor2.text = listaDeProdutos?.get(1)?.valor
                valor3.text = listaDeProdutos?.get(2)?.valor

                if (produto1 == "Donuts") {
                    imageView1.setImageResource(R.drawable.donut_circle)
                } else if (produto1 == "Sanduiche de sorvete") {
                    imageView1.setImageResource(R.drawable.icecream_circle)
                } else {
                    imageView1.setImageResource(R.drawable.froyo_circle)
                }

                if (produto2 == "Donuts") {
                    imageView2.setImageResource(R.drawable.donut_circle)
                } else if (produto2 == "Sanduiche de sorvete") {
                    imageView2.setImageResource(R.drawable.icecream_circle)
                } else {
                    imageView2.setImageResource(R.drawable.froyo_circle)
                }

                if (produto3 == "Donuts") {
                    imageView3.setImageResource(R.drawable.donut_circle)
                } else if (produto3 == "Sanduiche de sorvete") {
                    imageView3.setImageResource(R.drawable.icecream_circle)
                } else {
                    imageView3.setImageResource(R.drawable.froyo_circle)
                }

            }

            override fun onFailure(call: Call<List<Produto>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n"+t?.message.toString())
            }
        })
    }

}