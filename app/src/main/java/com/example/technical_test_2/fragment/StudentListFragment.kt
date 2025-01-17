package com.example.technical_test_2.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.technical_test_2.R
import com.example.technical_test_2.adapter.StudentAdapter
import com.example.technical_test_2.model.StudentData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class StudentListFragment : Fragment() {

    private lateinit var rvStudentList: RecyclerView
    private val studentList = mutableListOf<StudentData>()
    private lateinit var adapter: StudentAdapter
    private val firestore: FirebaseFirestore by lazy { Firebase.firestore }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvStudentList = view.findViewById(R.id.rvStudentList)

        adapter = StudentAdapter(studentList)
        rvStudentList.layoutManager = LinearLayoutManager(requireContext())
        rvStudentList.adapter = adapter

        fetchStudentData()
    }
    private fun fetchStudentData() {
        firestore.collection("user2")
            .get()
            .addOnSuccessListener { result ->
                studentList.clear()
                for (document in result.documents) {
                    val name = document.getString("name") ?: "Unknown"
                    val address = document.getString("address") ?: "No Address"
                    val imageUrl = document.getString("image") ?: ""

                    studentList.add(StudentData(name, imageUrl, address))
                }
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreError", "Error fetching students", exception)
            }
    }
}