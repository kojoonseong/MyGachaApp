# MyGachaApp
( Android / kotlin ) 자신의 운을 시험해보는 뽑기 앱

## 시작화면
![image](https://user-images.githubusercontent.com/93521155/195471285-2ea88bfe-d38b-425d-bc30-87615efec9ed.png)
여기에서 '뽑기 5회'라는 버튼을 누르면 확률에 따라 SS ~ C등급이 나온다.

![image](https://user-images.githubusercontent.com/93521155/195471572-f255e17e-7bc5-4f47-9e3d-bedad67e3eb7.png)

![image](https://user-images.githubusercontent.com/93521155/195471900-b967eb58-d203-48ab-9320-5a8d4a10afa4.png)

이런 식으로 돌릴 때마다 다른 결과가 나온다. (SS확률이 1%라 나오는데 오래 걸렸다..)

## 코드
```kotlin
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
```

뽑기할 때 나오는 기울어진 팔각형 모양 중 SS의 모양 (나머지도 비슷하게 만들어졌다.)
```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item>
        <rotate
            android:fromDegrees="30"
            android:toDegrees="30"
            >
            <shape android:shape="rectangle">
                <gradient
                    android:centerColor="#FF00FF"
                    android:endColor="#0000FF"
                    android:startColor="#FFFF00"
                    />
                <size
                    android:width="60dp"
                    android:height="60dp"
                    />
            </shape>
        </rotate>
    </item>
</layer-list>
```
