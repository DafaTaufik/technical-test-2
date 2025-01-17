package com.example.technical_test_2.adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.technical_test_2.R
import com.example.technical_test_2.model.StudentData

class StudentAdapter (
    private val studentList: List<StudentData>
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
        val nameTextView: TextView = itemView.findViewById(R.id.profileName)
        val addressTextView: TextView = itemView.findViewById(R.id.profileAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student_list, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        holder.nameTextView.text = student.name
        holder.addressTextView.text = student.address


        Glide.with(holder.profileImage.context)
            .load(student.profileImage)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(holder.profileImage)
    }

    override fun getItemCount(): Int = studentList.size
}