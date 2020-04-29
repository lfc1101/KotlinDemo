package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Textview监听事件
        mTv.setOnClickListener{
            Toast.makeText(this@MainActivity,"跳转传值！！！",Toast.LENGTH_SHORT).show();

            //  var是可变变量，可以通过重新分配来更改为另一个值的变量。比如： var name="我是变量";
            //  val是只读变量，声明变量的方法相当于java里的final变量。一个val创建时必须初始化，因为后期不可在改变。
            val intent = Intent(this@MainActivity,KotlinTest::class.java);
            var bundle = Bundle();
            bundle.putString("name","徐凤年");//bundle传值，根据key，取value。
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }
}
