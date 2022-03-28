package com.demo.project;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class crudService {
	
	public String createCrud(crud cr) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("project_users").document(cr.getName()).set(cr);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	public crud getCrud(String documentId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("project_users").document(documentId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		crud cr;
		if(document.exists()) {
			cr = document.toObject(crud.class);
			return cr;
		}
		return null;
	}
	
	public String updateCrud(crud cr) throws InterruptedException, ExecutionException { 
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("project_users").document(cr.getName()).set(cr);
		return collectionsApiFuture.get().getUpdateTime().toString();
		} 
	
	public String deleteCrud(String documentId) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("project_users").document(documentId).delete();
		return "Successfully deleted" + documentId;
	}
	
}
