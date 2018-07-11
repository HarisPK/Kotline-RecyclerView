package com.example.muhammedharis.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val alMyAndroidOS = ArrayList<MyAndroidOS>()
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Cupcake", "v1.5"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Donut", "v1.6"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Eclair", "v2.1"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Froyo", "v2.2.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Gingerbread", "v2.3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Honeycomb", "v3.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Ice Cream Sandwich", "v4.0.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Jelly Bean", "v4.1.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "KitKat", "v4.4.x"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Lollipop", "v5.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Marshmallow", "v6.0"))
        alMyAndroidOS.add(MyAndroidOS(R.drawable.new_text_straight_edge, "Nougat", "v7.0"))
        recycler_view.adapter = MyAndroidAdapter(alMyAndroidOS) {
            val name: String = it
            toast(name)
        }

        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                var result = alMyAndroidOS.filter { it.name.contains(et_search.text) ||it.version.contains(et_search.text)}
                recycler_view.adapter = MyAndroidAdapter(result) {
                    val name: String = it
                    toast(name)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

}
