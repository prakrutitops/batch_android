package tops.tech.data123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tops.tech.data123.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            binding.pb.incrementProgressBy(1)
            setProgress(100*binding.pb.progress)
        }
        binding.btn2.setOnClickListener {

            binding.pb.incrementProgressBy(-1)
            setProgress(100*binding.pb.progress)
        }


    }
}