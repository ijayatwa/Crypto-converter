package com.example.assignment1_20170599

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val edtxt1: EditText = findViewById(R.id.edtxt1)
        val resultTVUSDT: TextView = findViewById(R.id.USDT_ID)
        val resultTVCrypto: TextView = findViewById(R.id.Crypto_ID)

        var flag : String = "BTC"

        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("BTC","ETH","BNB","DOGE")
        spinnerVal.adapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            } //p2 is the index of selected item


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        button.setOnClickListener{ view ->
        //code here
        var x: Double = edtxt1.text.toString().toDouble();
            resultTVUSDT.text = x.toString()

            if(flag =="BTC") {
                resultTVCrypto.text = calculateBTC(x).toString();

            }
            else if(flag == "ETH") {
                resultTVCrypto.text = calculateETH(x).toString();

            }
            else if(flag == "BNB") {
                resultTVCrypto.text = calculateBNB(x).toString();

            }
            else if(flag == "DOGE") {
                resultTVCrypto.text = calculateDOGE(x).toString();

            }
        }



    }
}
public fun calculateBTC(a: Double): Double {
    return a/44500;
}
public fun calculateETH(a: Double): Double {
    return a/3120;
}
public fun calculateBNB(a: Double): Double {
    return a/415;
}
public fun calculateDOGE(a: Double): Double {
    return a/(0.133);
}