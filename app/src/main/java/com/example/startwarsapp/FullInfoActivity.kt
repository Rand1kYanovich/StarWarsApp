package com.example.startwarsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class FullInfoActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        setContentView(R.layout.activity_all_cards)
        super.onCreate(savedInstanceState, persistentState)
    }
}