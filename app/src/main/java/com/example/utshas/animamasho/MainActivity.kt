package com.example.utshas.animamasho

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var tv: TextView
    internal lateinit var tv_top: TextView
    internal var animations = arrayOf("Fade In", "Fade Out", "Zoom In", "Zoom Out", "Blink", "Rotate", "Move", "Slide Up", "Slide Down", "Slide Left", "Slide Right", "Bounce")
    internal var animationIDs = intArrayOf(R.anim.fade_in, R.anim.fade_out, R.anim.zoom_in, R.anim.zoom_out, R.anim.blink, R.anim.rotate, R.anim.move, R.anim.slide_up, R.anim.slide_down, R.anim.slide_left, R.anim.slide_right, R.anim.bounce)
    internal lateinit var lv: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv) as TextView
        tv_top = findViewById(R.id.tv_top) as TextView
        lv = findViewById(R.id.lv) as ListView

        lv.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animations)


        lv.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val animation = AnimationUtils.loadAnimation(this@MainActivity, animationIDs[position])
            tv.startAnimation(animation)
            tv_top.startAnimation(animation)
        }
    }
}
