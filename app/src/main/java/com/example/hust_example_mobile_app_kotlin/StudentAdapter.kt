package com.example.hust_example_mobile_app_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import org.w3c.dom.Text

class StudentAdapter(val students: List<StudentModel>): BaseAdapter() {
    override fun getCount(): Int {
        return students.size
    }

    override fun getItem(position: Int): Any {
        return students[position]
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        if(convertView == null)
        {
            Log.v("TAG DIFF", "new view created: $position")
            itemView = LayoutInflater.from(parent?.context).inflate(
                R.layout.student_list_item_layout,
                parent,
                false
            )
        }else
        {
            itemView = convertView
        }



        val imageAva = itemView.findViewById<ImageView>(R.id.student_list_item_image)
        val txt_name = itemView.findViewById<TextView>(R.id.item_student_name)
        val txt_code = itemView.findViewById<TextView>(R.id.item_student_code)

        val student = students[position]
        //imageAva.setImageResource(student.ava_id) // we dont have the images list
        imageAva.setImageDrawable(R.drawable.default_ava.toDrawable())
        txt_name.text = student.name
        txt_code.text = student.code

        return  itemView
    }
}