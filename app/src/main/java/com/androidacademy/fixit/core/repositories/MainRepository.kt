package com.androidacademy.fixit.core.repositories

import android.accounts.NetworkErrorException
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.utils.ConstApi
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import javax.inject.Inject

class MainRepository @Inject constructor() {
    private val dataBase by lazy { FirebaseFirestore.getInstance() }

    fun getServices(loadCompleted: (List<ServicesName>) -> Unit) {
        dataBase.collection(ConstApi.DataBase.SERVICES_NAME_BASE)
            .get()
            .addOnSuccessListener {
                val itemsList = mutableListOf<ServicesName>()
                it.forEach { entry -> itemsList.add(mapServices(entry)) }
                loadCompleted.invoke(itemsList)
            }
            .addOnFailureListener { throw NetworkErrorException() }
    }

    fun getServiceTargets(serviceId: String, loadCompleted: (List<ServiceTarget>) -> Unit) {
        dataBase.collection(ConstApi.DataBase.SERVICE_TARGETS_BASE)
            .whereEqualTo("serviceId", serviceId)
            .get()
            .addOnSuccessListener {
                val listItems = mutableListOf<ServiceTarget>()
                it.forEach {entry -> listItems.add(mapServiceTargets(entry))}
                loadCompleted.invoke(listItems)
            }
            .addOnFailureListener { throw NetworkErrorException() }
    }

    fun setOrder(order: Order, success: () -> Unit) {
        dataBase.collection(ConstApi.DataBase.ORDERS_BASE)
            .add(order)
            .addOnSuccessListener {
                success.invoke()
            }
            .addOnFailureListener { throw NetworkErrorException() }
    }

    private fun mapServiceTargets(entry: QueryDocumentSnapshot): ServiceTarget {
        val map = entry.data
        return ServiceTarget(
            price = map["price"] as? Long ?: 0,
            name = (map["text"] as HashMap<*, *>)["ru"] as? String ?: ""
        )
    }


    private fun mapServices(entry: QueryDocumentSnapshot): ServicesName {
        val map = entry.data
        return ServicesName(
            map["orderPrice"] as? Long ?: 0,
            (map["text"] as HashMap<*, *>)["ru"] as? String ?: "",
            entry.id
        )
    }
}