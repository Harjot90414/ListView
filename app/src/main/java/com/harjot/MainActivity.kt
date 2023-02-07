package com.harjot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.harjot.databinding.ActivityMainBinding
fun random(random:Int):String{

    var str="qwertyuiopasdfghjklzxcvbnm"
    var result=""
    for(i in 1..random)
    {
        result+=str.random().toString()

    }
    return result
}

class MainActivity : AppCompatActivity() {
     lateinit var binding : ActivityMainBinding

    lateinit var arrayAdapter : ArrayAdapter<String>
    var arrayList = arrayListOf<String>()

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate( savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        binding?.lvListView?.adapter = arrayAdapter

        binding?.fabBtn?.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(resources.getString(R.string.add_data))
            alertDialog.setMessage(resources.getString(R.string.add_data_msg))
            alertDialog.setCancelable(false)

            alertDialog.setNeutralButton(resources.getString(R.string.three)){_,_->
                 var result=random(3)
                arrayList.add((result))
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }



            alertDialog.setNegativeButton(resources.getString(R.string.four)){_,_->
//                arrayList[position] = (arrayList[position].toInt()+2).toString()
//                arrayAdapter.notifyDataSetChanged()
                var result=random(4)
                arrayList.add((result))
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }


            alertDialog.setPositiveButton(resources.getString(R.string.five)){_,_->
//                i=0
//                arrayList.removeAt(position)
//                arrayAdapter.notifyDataSetChanged()
                var  result=random(5)
                arrayList.add((result))
                //to update the list
                arrayAdapter.notifyDataSetChanged()
            }

            alertDialog.show()
//            i++
//            arrayList.add((i).toString())
//            //to update the list
//            arrayAdapter.notifyDataSetChanged()
        }

        binding.lvListView.setOnItemClickListener { _, _, position, _ ->
            System.out.println(" in click $position")
            //  arrayList.removeAt(position)
            //  arrayAdapter.notifyDataSetChanged()
            var alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(resources.getString(R.string.modify_data))
            alertDialog.setMessage(resources.getString(R.string.modify_data_msg))
            alertDialog.setCancelable(false)

            alertDialog.setNegativeButton(resources.getString(R.string.cancel)){_,_->
                alertDialog.setCancelable(true)
            }
            alertDialog.setPositiveButton(resources.getString(R.string.delete)){_,_->
                var result=""
                arrayList.removeAt(position)
                arrayAdapter.notifyDataSetChanged()

            }
            alertDialog.show()

        }


    }

}