package com.example.exploreentertainment.ui.activities

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.example.exploreentertainment.R
import com.example.exploreentertainment.databinding.ActivityMainBinding
import com.example.exploreentertainment.ui.fragments.movies.MoviesFragment
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingFragment
import com.example.exploreentertainment.ui.fragments.shows.ShowsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        fm = supportFragmentManager
        bottomMenu()
        binding.navBar.setItemSelected(R.id.now_playing)
    }
    private fun bottomMenu() {
        fm.beginTransaction().replace(R.id.nav_host, NowPlayingFragment()).commit()
        binding.navBar.setOnItemSelectedListener {
            when(it){
                R.id.movies -> {
                    fm.beginTransaction().replace(R.id.nav_host, MoviesFragment())
                        .commit()
                }
                R.id.now_playing -> {
                    fm.beginTransaction().replace(R.id.nav_host, NowPlayingFragment())
                        .commit()
                }
                R.id.tv_shows -> {
                    fm.beginTransaction().replace(R.id.nav_host, ShowsFragment())
                        .commit()
                }

            }

        }
    }
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action === MotionEvent.ACTION_DOWN) {
            Log.i("MainActivity Frames","Action Hiding ")
            val v: View? = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }
}