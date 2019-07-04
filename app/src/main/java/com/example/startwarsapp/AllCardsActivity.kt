package com.example.startwarsapp


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.startwarsapp.model.api.NetworkService
import com.example.startwarsapp.model.entity.FullInfoCard
import com.example.startwarsapp.model.entity.InfoPageAndResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllCardsActivity : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var adapter:RecyclerAdapter
    lateinit var infoPageAndResult: InfoPageAndResult
    var cardsList:List<FullInfoCard>?=null
    val clickListener:OnItemClickListener

    init {
        clickListener =object :OnItemClickListener{
            override fun onClick(view: View, position: Int, id:Int,bundle: Bundle){
                val intent = Intent(applicationContext,FullInfoActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_cards)

        cardsList= ArrayList()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setNestedScrollingEnabled(false)
        recyclerView.setHasFixedSize(true)
        getCardsList()


    }


    fun getCardsList(){
        NetworkService.getInstance()
            .getJSONApi()
            .getCards("1")
            .enqueue(object: Callback<InfoPageAndResult>{
                override fun onFailure(call: Call<InfoPageAndResult>, t: Throwable) {

                }

                override fun onResponse(call: Call<InfoPageAndResult>, response: Response<InfoPageAndResult>) {
                   if(response.isSuccessful){
                       Log.e("Laza4",response.body()!!.results.toString())
                       infoPageAndResult = response.body()!!
                       cardsList = infoPageAndResult.results
                       Log.e("Laza5",cardsList!!.get(0).name)
                       adapter = RecyclerAdapter(cardsList!!,applicationContext,clickListener)
                       recyclerView.setAdapter(adapter)

                   }
                }
            })
    }
}
