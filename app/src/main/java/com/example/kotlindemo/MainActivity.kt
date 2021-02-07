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

        initOnclick();//kotlin点击传值
        initTest();//kotlin赋值
        initSz();//kotlin数组使用
        initQJ();//kotlin 区间


    }

    private fun initQJ() {

        //区间的创建
        val intRange = 1 .. 10 // 闭区间  正序区间  包含起止值 [1,2,3,..10]
        val charRange = 'a' .. 'z'
        val longRange = 1L .. 100L
        Log.e(TAG, "initQJ: ===>$intRange ,$charRange ,$longRange")
        Log.e(TAG, "initQJ: ===>${intRange.joinToString()}" )

        val intRangeExclusive = 1 until 10 //开区间 半开半闭式 前开后闭
        val charRangeExclusive = 'a' until 'z'
        val longRangeExclusive = 1L until  100L
        Log.e(TAG, "initQJ: ===>$intRangeExclusive,$charRangeExclusive,$longRangeExclusive")
        Log.e(TAG, "initQJ: ===>${charRangeExclusive.joinToString()}" )

        val intRangeReverse = 10 downTo 1 //  闭区间 倒序区间  [10,9,8..1]
        val charRangeReverse = 'z' downTo 'a'//
        val longRangeReverse = 100L downTo 1L
        Log.e(TAG, "initQJ: ===>${longRangeReverse.joinToString()}", )

        val intRangeWithStep = 1 .. 10 step 2 // 区间的步长 [1,3,5,7,9]  step后面指定步长
        val charRangeWithStep = 'z' downTo 'a' step 4
        val longRangeWithStep = 1L .. 10L step 1
        Log.e(TAG, "initQJ: ===>${charRangeWithStep.joinToString()}" )

    }

    private fun initSz() {

        //数组的创建
        val c1 = intArrayOf(1, 2, 3, 4, 5)
        Log.e(TAG, "initSz1: ===>,${c1.contentToString()}")

        val c2 = IntArray(5) { it + 1 }
        Log.e(TAG, "initSz2: ===>${c2.contentToString()}")

        //数组的包含关系
        if (5 in c1) { // in ： 表示包含的运算符 ，不包含则是 !in  结果输出的是boolean类型
            Log.e(TAG, "initSz: ===> 5包含不包含在c1的数组中 包含 == true")
        } else {
            Log.e(TAG, "initSz: ===> 5包含不包含在c1的数组中 不包含 ==  false")
        }

        if (6 in c1) {
            Log.e(TAG, "initSz: ===> 6包含不包含在c1的数组中 包含 == true")
        } else {
            Log.e(TAG, "initSz: ===> 6包含不包含在c1的数组中 不包含 == false")
        }

        //数组的读写
        val d1 = arrayOf("Hello", "World")
        d1[1] = "Kotlin"
        Log.e(TAG, "initSz3: ===>${d1.contentToString()}")
        Log.e(TAG, "initSz4: ===>${d1[0]},${d1[1]}")//替换

        //数组的遍历
        val float1 = floatArrayOf(1f, 3f, 5f) // float 类型 第一种遍历方法
        for (element_f1 in float1) {
            Log.e(TAG, "initSz5: ===>$element_f1")
        }

        val float2 = floatArrayOf(8f, 9f, 10f)// float 类型 第二种遍历方法
        float2.forEach { element_f2 ->
            Log.e(TAG, "initSz5: ===>$element_f2")
        }

        val string = arrayOf("李", "铁", "柱")// string 类型 第一种遍历方式
        for (element_str in string) {
            Log.e(TAG, "initSz6: ===>$element_str")
        }

        val string2 = arrayOf("李", "凤", "年")// string 类型 第二种遍历方式
        string2.forEach { string_str2 ->
            Log.e(TAG, "initSz6: ===>$string_str2")
        }

    }

    private fun initTest() {

        //toUpperCase() 是一个只能对 String 类型的变量调用的函数
        val langName = "Kotlin"
        val upperCaseName = langName.toUpperCase();
        Log.e(TAG, "initTest1:===>$upperCaseName")

        //要使变量持有 null 值，它必须是可为 null 类型。可以在变量类型后面加上 ? 后缀，将变量指定为可为 null，如以下示例所示：
        val langNull: String? = null
        Log.e(TAG, "initTest2:===>$langNull")

        //随着条件语句的复杂性不断增加，您可以考虑将 if-else 表达式替换为 when 表达式，如以下示例所示：
        val answerString = when {
            count == 42 -> "I have the answer."
            count > 35 -> "The answer is close."
            else -> "The answer eludes me."
        }
        Log.e(TAG, "initTest2:===>$answerString ")
    }

    private fun initOnclick() {

        //  Textview监听事件
        mTv.setOnClickListener {
            Toast.makeText(this@MainActivity, "跳转传值！！！", Toast.LENGTH_SHORT).show();

            //  var是可变变量，可以通过重新分配来更改为另一个值的变量。比如： var name="我是变量";
            //  val是只读变量，声明变量的方法相当于java里的final变量。一个val创建时必须初始化，因为后期不可在改变。
            val intent = Intent(this@MainActivity, KotlinTest::class.java);
            var bundle = Bundle();
            bundle.putString("name", "徐凤年");//bundle传值，根据key，取value。
            intent.putExtras(bundle);
            startActivity(intent);

        }
    }


}
