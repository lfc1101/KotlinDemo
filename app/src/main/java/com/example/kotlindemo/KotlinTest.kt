package com.example.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * Created by lifc
 * User: lifanchao
 * Date: 2020/4/29
 * Time: 09:39
 */
class KotlinTest: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin);


        //接收到MainActivity传过来的值，并将数据附值给Textview
        var bundle = this.intent.extras;
        mTv_msg.text = bundle!!.get("name").toString();



    }

}