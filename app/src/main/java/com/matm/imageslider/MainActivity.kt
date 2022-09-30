package com.matm.imageslider

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.abs


class MainActivity : AppCompatActivity() {


    lateinit var adapterX:ProgressBarAdapter
    lateinit var goToNextActivity:Button
    lateinit var bannerAdapter: ImageSliderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goToNextActivity=findViewById(R.id.button)
        supportActionBar?.hide()


        goToNextActivity.setOnClickListener {
            startActivity(Intent(this,DetailView::class.java))
        }
















        val arrayList = ArrayList<BannerModel>()
        repeat(3) {
            arrayList.add(
                BannerModel(
                    "https://www.thoughtco.com/thmb/gtl-IotmuSFI9Li_8OJtaPXGrms=/2592x2592/smart/filters:no_upscale()/89538987-56a1316f3df78cf772684961.jpg",
                    "rose3",false
                )
            )
            arrayList.add(
                BannerModel(
                    "https://www.floraqueen.com/blog/wp-content/uploads/2020/02/shutterstock_552296878.jpg",
                    "rose2",false
                )
            )

            arrayList.add(
                BannerModel(
                    "https://www.thoughtco.com/thmb/gtl-IotmuSFI9Li_8OJtaPXGrms=/2592x2592/smart/filters:no_upscale()/89538987-56a1316f3df78cf772684961.jpg",
                    "rose3",false
                )
            )

        }

        bannerAdapter = ImageSliderAdapter(arrayList)
        viewPager2.adapter = bannerAdapter
        worm_dots_indicator.attachTo(viewPager2)
        viewPager2.offscreenPageLimit=2


        val viewPager6 =findViewById<RecyclerView>(R.id.frameLayout)
        adapterX = ProgressBarAdapter(arrayList)
        viewPager6.adapter = adapterX











       // viewPager2.setCurrentItem(1,true)
        adapterX.startProgressBar(0)
        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        val nextItemVisiblePx = 80
        val currentItemHorizontalMarginPx = 50
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        viewPager2.setPageTransformer { page, position ->
            page.translationX = -pageTranslationX * position
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.scaleY = 1 - (0.25f * abs(position))
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        }

//        viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
//
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//                if (ViewPager.SCROLL_STATE_IDLE==state){
//                    adapterX.startProgressBar(viewPager2.currentItem)
//                }
//            }
//        })


        // The ItemDecoration gives the current (centered) item horizontal margin so that
        // it doesn't occupy the whole screen width. Without it the items overlap

        val itemDecoration = HorizontalMarginItemDecoration()
        viewPager2.addItemDecoration(itemDecoration)
        autoScrollPosition()

















    }

    private fun autoScrollPosition(){
        val currentPosition:Int = viewPager2.currentItem
        if (currentPosition+1 == bannerAdapter.itemCount){
            viewPager2.currentItem = 0
            //adapterX.startProgressBar(0)
        }else{
            viewPager2.currentItem = currentPosition+1
           // adapterX.startProgressBar(currentPosition+1)
        }
        countDownTimer.cancel()
        countDownTimer.start()
    }
    private val countDownTimer =object :CountDownTimer(2000,1000){
        override fun onTick(p0: Long) {
        }
        override fun onFinish() {
            autoScrollPosition()
            adapterX.startProgressBar(viewPager2.currentItem)
        }
    }
}

class HorizontalMarginItemDecoration() :
    RecyclerView.ItemDecoration() {
    private val horizontalMarginInPx: Int = 80

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.right = horizontalMarginInPx
        outRect.left = horizontalMarginInPx
    }
}




