package com.example.listed_application

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import java.text.SimpleDateFormat
import java.util.*

class links : Fragment(R.layout.fragment_links) {
    private lateinit var lineChart: LineChart
    private lateinit var text:TextView
    private lateinit var   list: ArrayList<Entry>
    private lateinit var lineDataSet: LineDataSet
    private lateinit var lineData: LineData
    private lateinit var wbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_links, container, false)

        lineChart=view.findViewById(R.id.linechart)
        setLineGraph(lineChart)
        // set the greet
        text=view.findViewById(R.id.greetmsq)
        text.setText(greet())

        //whatsapp toast
        wbutton=view.findViewById(R.id.whatsappbtn)
        wbutton.setOnClickListener {
//            Toast.makeText(context, "Contact-8297368106", Toast.LENGTH_SHORT).show()
            openWhatsAppChat("8297368106")
        }
        return view
    }

    fun setLineGraph(linechart:LineChart)
    {
            list= ArrayList()
            list.add(Entry(getTimeInMillis("2023-06-06"), 0f))
          list.add(Entry(getTimeInMillis("2023-06-07"), 3f))
        list.add(Entry(getTimeInMillis("2023-06-08"), 5f))
        list.add(Entry(getTimeInMillis("2023-06-09"), 11f))
        list.add(Entry(getTimeInMillis("2023-06-10"), 4f))
        list.add(Entry(getTimeInMillis("2023-06-11"), 9f))
        list.add(Entry(getTimeInMillis("2023-06-12"), 4f))
        list.add(Entry(getTimeInMillis("2023-06-13"), 20f))
        list.add(Entry(getTimeInMillis("2023-06-13"), 20f))
        list.add(Entry(getTimeInMillis("2023-06-14"), 2f))
        list.add(Entry(getTimeInMillis("2023-06-15"), 7f))
        list.add(Entry(getTimeInMillis("2023-06-16"), 24f))
        list.add(Entry(getTimeInMillis("2023-06-17"), 2f))
        list.add(Entry(getTimeInMillis("2023-06-18"), 4f))
        list.add(Entry(getTimeInMillis("2023-06-19"), 16f))
        list.add(Entry(getTimeInMillis("2023-06-20"), 11f))
        list.add(Entry(getTimeInMillis("2023-06-21"), 29f))
        list.add(Entry(getTimeInMillis("2023-06-22"), 6f))
        list.add(Entry(getTimeInMillis("2023-06-23"), 3f))
        list.add(Entry(getTimeInMillis("2023-06-24"), 8f))
        list.add(Entry(getTimeInMillis("2023-06-25"), 7f))
        list.add(Entry(getTimeInMillis("2023-06-26"), 5f))
        list.add(Entry(getTimeInMillis("2023-06-27"), 2f))
        list.add(Entry(getTimeInMillis("2023-06-28"), 1f))
        list.add(Entry(getTimeInMillis("2023-06-29"), 13f))
        list.add(Entry(getTimeInMillis("2023-06-30"), 26f))
        list.add(Entry(getTimeInMillis("2023-07-01"), 1f))
        list.add(Entry(getTimeInMillis("2023-07-02"), 4f))
        list.add(Entry(getTimeInMillis("2023-07-03"), 2f))
        list.add(Entry(getTimeInMillis("2023-07-04"), 3f))
        list.add(Entry(getTimeInMillis("2023-07-05"), 61f))
        list.add(Entry(getTimeInMillis("2023-07-06"), 2f))

        lineDataSet=LineDataSet(list,"count")
        lineData=LineData(lineDataSet)
        lineChart.data=lineData
        lineDataSet.setColor( Color.parseColor("#0E6FFF"))
       lineDataSet.setCircleColor(Color.parseColor("#0E6FFF"))
        lineDataSet.setLineWidth(2f)
        lineDataSet.setDrawFilled(true)

        lineChart.xAxis.setDrawLabels(false) // Remove x-axis labels
        lineChart.axisLeft.setDrawLabels(false) // Remove left y-axis labels
        lineChart.axisRight.setDrawLabels(false)

        linechart.description.isEnabled = false
        lineChart.invalidate()



    }

    private fun getTimeInMillis(dateString: String): Float {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdf.parse(dateString)
            return date.time.toFloat()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0f
    }

    fun greet(): String {
        val currentTime = Calendar.getInstance()
        val currentHour=currentTime.get(Calendar.HOUR_OF_DAY)
        return when (currentHour) {
            in 0..11 -> "Good morning"
            in 12..15 -> "Good afternoon"
            in 16..20 -> "Good evening"
            else -> "Good night"
        }
    }
    fun openWhatsAppChat(contactNumber: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$contactNumber")
        startActivity(intent)
    }
}