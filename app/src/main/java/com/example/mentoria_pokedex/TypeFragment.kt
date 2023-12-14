//package com.example.mentoria_pokedex
//
//import android.os.Bundle
//import android.os.Parcelable
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.google.android.material.bottomsheet.BottomSheetDialogFragment
//
//@Suppress("ControlFlowWithEmptyBody")
//class TypeFragment : BottomSheetDialogFragment() {
//
//    var type1: TextView? = null
//    var type2: TextView? = null
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_type,container,false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val type: Parcelable? = arguments?.getParcelable("medicine")
//        type1 = view.findViewById<TextView>(R.id.tvType1)
//        type2 = view.findViewById<TextView>(R.id.tvType2)
//
//        type?.let {
//            PokemonType("")
//        }
//    }
//}
//
//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//android:orientation="vertical"
//android:background="@color/white">
//
//
//<TextView
//android:id="@+id/tvType"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Types"
//android:textColor="@color/black"
//android:textSize="24dp"
//android:layout_gravity="center"
//android:layout_marginTop="20dp"/>
//
//<TextView
//android:id="@+id/tvType1"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_gravity="center"
//android:layout_marginEnd="8dp"
//android:layout_marginTop="16dp"
//android:text="Type 1"
//android:textColor="@color/black"
//android:textSize="16dp" />
//
//
//<TextView
//android:id="@+id/tvType2"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_gravity="center"
//android:layout_marginEnd="8dp"
//android:layout_marginTop="16dp"
//android:text="Type 2"
//android:textColor="@color/black"
//android:textSize="16dp" />
//
//
//</LinearLayout>