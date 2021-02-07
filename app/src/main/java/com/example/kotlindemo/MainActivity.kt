package com.example.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var count = 42

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


        //toUpperCase() 是一个只能对 String 类型的变量调用的函数
        val langName = "Kotlin"
        val upperCaseName = langName.toUpperCase();
        Log.e(TAG, "onCreate:====> " + upperCaseName)

        //要使变量持有 null 值，它必须是可为 null 类型。可以在变量类型后面加上 ? 后缀，将变量指定为可为 null，如以下示例所示：
        val  langNull : String? = null
        Log.e(TAG, "onCreate: 2......>>>" + langNull )

        //随着条件语句的复杂性不断增加，您可以考虑将 if-else 表达式替换为 when 表达式，如以下示例所示：
        val answerString = when {
            count == 42 -> "I have the answer."
            count > 35 -> "The answer is close."
            else -> "The answer eludes me."
        }
        Log.e(TAG, "onCreate: ===3===>" + answerString )

    }
}
