package cubex.mahesh.spinnertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gender_list = mutableListOf<String>()
        gender_list.add("Select_")
        gender_list.add("Male_")
        gender_list.add("Female_")

        var myadapter = ArrayAdapter<String>(this@MainActivity,
           android.R.layout.simple_spinner_item ,gender_list)
        sp1.adapter = myadapter
        sp1.onItemSelectedListener =
            object:AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if(position > 0) {
                        var gender_array = resources.getStringArray(R.array.gender)
                        var selected_value = gender_array[position]
                        Toast.makeText(
                            this@MainActivity,
                            selected_value, Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
    }
}
