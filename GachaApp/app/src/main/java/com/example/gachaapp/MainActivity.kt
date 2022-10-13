package com.example.gachaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.gachaapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        reset()

        binding.btnGacha.setOnClickListener {
            var per = gacha()
        }
    }

    private fun gacha() {
        val rnd = Random()
        val units = IntArray(5)
        for (i in 0 until 5) {
            units[i] = rnd.nextInt(100)+1
        }
        setTvNumber(units[0], binding.tv1)
        setTvNumber(units[1], binding.tv2)
        setTvNumber(units[2], binding.tv3)
        setTvNumber(units[3], binding.tv4)
        setTvNumber(units[4], binding.tv5)
    }

    private fun setTvNumber(i: Int, tv: TextView) {
        when(i) {
            1 -> tv.background = ContextCompat.getDrawable(this, R.drawable.ss)
            in 2..4 -> tv.background = ContextCompat.getDrawable(this, R.drawable.s)
            in 5..20 -> tv.background = ContextCompat.getDrawable(this, R.drawable.a)
            in 21..55 -> tv.background = ContextCompat.getDrawable(this, R.drawable.b)
            else -> tv.background = ContextCompat.getDrawable(this, R.drawable.c)
        }

        when(i) {
            1 -> tv.text = "SS"
            in 2..4 -> tv.text = "S"
            in 5..20 -> tv.text = "A"
            in 21..55 -> tv.text = "B"
            else -> tv.text = "C"
        }
    }

    private fun reset() {
        binding.tv1.setBackgroundResource(R.drawable.ss)
        binding.tv2.setBackgroundResource(R.drawable.s)
        binding.tv3.setBackgroundResource(R.drawable.a)
        binding.tv4.setBackgroundResource(R.drawable.b)
        binding.tv5.setBackgroundResource(R.drawable.c)
    }
}