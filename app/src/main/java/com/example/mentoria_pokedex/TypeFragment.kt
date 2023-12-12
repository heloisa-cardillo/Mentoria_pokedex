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