package br.com.etec.agendatbtarde.services

import android.util.Log
import br.com.etec.agendatbtarde.models.Contact
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class ContactService {

    val db = Firebase.firestore

    fun store(contact: Contact){

        db.collection("contacts")
            .add(contact)
            .addOnSucessListener { documentReference ->
                Log.d("firebase", "Adicionado ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.e("firebase", "Erro", e)
            }
    }

}