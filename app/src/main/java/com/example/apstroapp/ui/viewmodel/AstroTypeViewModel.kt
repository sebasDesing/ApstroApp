package com.example.apstroapp.ui.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apstroapp.R
import com.example.apstroapp.adapter.AstroTypeAdapter
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.domain.AstroTypeUseCases.GetAstroTypesUseCase
import com.example.apstroapp.domain.AstroTypeUseCases.SRLAstroTypeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstroTypeViewModel @Inject constructor(
    private val getAstroTypeUseCase: GetAstroTypesUseCase,
    private val srlAstroTypeUseCase: SRLAstroTypeUseCase

) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    fun onCreate(adapter: AstroTypeAdapter, view: View, context: Context) {
        val layoutManager = LinearLayoutManager(context)
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        setRecyclerView(layoutManager, itemDecorator, recyclerView, adapter, context)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setRecyclerView(
        layoutManager: LinearLayoutManager,
        itemDecorator: DividerItemDecoration,
        recyclerView: RecyclerView,
        adapter: AstroTypeAdapter,
        context: Context
    ) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecorator)

        viewModelScope.launch {
            isLoading.postValue(true)
            try {
                val result = getAstroTypeUseCase()

                if (result.isNotEmpty()) {
                    adapter.setList(result.map {
                        AstroTypeModel(
                            typeAstro = it.typeAstro,
                            imageUrl = it.imgUrl
                        )
                    })
                    adapter.notifyDataSetChanged()

                    isLoading.postValue(false)
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(context, "No se encontraron datos", Toast.LENGTH_SHORT).show()
                    isLoading.postValue(false)
                }
            } catch (e: Exception) {
                // Mostrar mensaje de error
                Toast.makeText(
                    context,
                    "Error al cargar los datos: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                isLoading.postValue(false)
            }
        }
    }


    fun onReload(
        layoutManager: LinearLayoutManager,
        itemDecorator: DividerItemDecoration,
        recyclerView: RecyclerView,
        adapter: AstroTypeAdapter,
    ) {
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecorator)
        viewModelScope.launch {
            val result = srlAstroTypeUseCase()
            if (result.isNotEmpty()) {
                adapter.setList(result.map {
                    AstroTypeModel(
                        typeAstro = it.typeAstro,
                        imageUrl = it.imgUrl
                    )
                })
                adapter.notifyDataSetChanged()
            }
        }
    }
}