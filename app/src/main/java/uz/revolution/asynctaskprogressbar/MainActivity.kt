package uz.revolution.asynctaskprogressbar

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.revolution.asynctaskprogressbar.adapter.ImageAdapter
import uz.revolution.asynctaskprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var data: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        MyAsyncTask().execute()
    }

    private fun loadAdapter() {
        val adapter = ImageAdapter(data!!)
        binding.rv.adapter = adapter
    }

    private fun loadData() {
        data = ArrayList<String>()
        for (i in 200..299) {
            data?.add("https://picsum.photos/id/$i/400/700")
        }
    }

    inner class MyAsyncTask : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg p0: Void?): Void? {
            loadAdapter()
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

    }

}