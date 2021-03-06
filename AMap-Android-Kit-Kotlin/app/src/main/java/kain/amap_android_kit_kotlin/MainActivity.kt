package kain.amap_android_kit_kotlin

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import com.amap.api.maps.MapView

class MainActivity : AppCompatActivity() {
    private var mapView: MapView? = null
    private var mapOptions: MapOptions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView = findViewById(R.id.map) as MapView
        mapView?.onCreate(savedInstanceState)
        mapOptions = MapOptions(mapView?.map!!)
        //设置定位蓝点
        mapOptions?.showPositionDot()
        mapOptions?.asyncMapLocation?.subscribe {
            Log.wtf("Main Msg", it.latitude.toString() + ":" + it.longitude.toString())
        }
        //mapOptions?.setGestureScaleByMapCenter(100,100,true)
        //改变地图的缩放级别
        //mapOptions?.mapZoomTo(17F)
        //设置地图显示区域
        //mapOptions?.setMapStatusLimits(33.789925, 104.838326,38.740688, 114.647472)
        //设置默认显示地点
        mapOptions?.setDefaultMap(18.312963, 109.616185, 12f)
        mapOptions?.asyncScreenShot?.subscribe(){
            Log.wtf("Msg", "地图截图位置为："+it)
        }
        //添加默认标记
        //mapOptions?.addMarker(18.312963, 109.616185,"三亚")
        //mapOptions?.addMarker(18.312963, 109.616185,"三亚","三亚市吉阳区云港园区")
        //mapOptions?.addMarker(18.312963, 109.616185,"三亚","三亚市吉阳区云港园区",BitmapFactory.decodeResource(getResources(),R.drawable.location_marker))
        //mapOptions?.addMarker(18.312963, 109.616185,"三亚","三亚市吉阳区云港园区",BitmapFactory.decodeResource(getResources(),R.drawable.location_marker),true,true)


    }
    /**
     * 对地图进行截屏
     */
    fun getMapScreenShot(v: View) {
        mapOptions?.getMapScreenShot()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView?.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        mapView?.onSaveInstanceState(outState)
    }
}
