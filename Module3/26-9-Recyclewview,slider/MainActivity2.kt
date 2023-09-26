package tops.tech.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView

class MainActivity2 : AppCompatActivity()
{
    lateinit var sliderlayout: SliderLayout
    var map = HashMap<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sliderlayout = findViewById(R.id.slider)

        map.put("A",R.drawable.a)
        map.put("B",R.drawable.b)
        map.put("C",R.drawable.c)
        map.put("D",R.drawable.d)

        for(i in map.keys)
        {
            var textslider = TextSliderView(this)
            textslider.description(i)
            textslider.image(map.get(i)!!)
            sliderlayout.addSlider(textslider)
        }
        sliderlayout.setPresetTransformer(SliderLayout.Transformer.ZoomIn)
    }
}