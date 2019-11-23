package com.androidacademy.fixit.core.repositories

import android.accounts.NetworkErrorException
import com.androidacademy.fixit.core.data.Address
import com.androidacademy.fixit.core.data.Order
import com.androidacademy.fixit.core.data.ServiceTarget
import com.androidacademy.fixit.core.data.ServicesName
import com.androidacademy.fixit.utils.ConstApi
import com.google.firebase.auth.FirebaseAuth
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

    fun getOrder(loadCompleted: (List<Order>) -> Unit) {
        dataBase.collection(ConstApi.DataBase.ORDERS_BASE)
            .whereEqualTo("userId", FirebaseAuth.getInstance().currentUser?.uid)
            .get()
            .addOnSuccessListener {
                val listItems = mutableListOf<Order>()
                it.forEach { entry -> listItems.add(mapOrderFromFirebase(entry)) }
                loadCompleted.invoke(listItems)
            }
            .addOnFailureListener { throw NetworkErrorException() }
    }

    private fun mapOrderFromFirebase(entry: QueryDocumentSnapshot) : Order {
        val map = entry.data
        val address = map["address"] as? HashMap<*, *> ?: throw NetworkErrorException()
        return Order(
            address = Address(
                apartments = address["apartments"] as? Long ?: 0,
                building = address["building"] as? Long ?: 0,
                floor = address["floor"] as? Long ?: 0,
                house = address["house"] as? Long ?: 0,
                porch = address["porch"] as? Long ?: 0,
                street = address["street"] as? String ?: ""
            ),
            dataTime = map["dataTime"] as? String ?: "",
            finalPrice = map["finalPrice"] as? Long ?: 0,
            serviceRef = map["serviceRef"] as? String ?: "",
            isCompleted = map["completed"] as? Boolean ?: false,
            serviceTargets = map["serviceTargets"] as? List<String> ?: listOf(),
            isProcessing = map["processing"] as? Boolean ?: false,
            userId = map["userId"] as? String ?: ""
        )
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