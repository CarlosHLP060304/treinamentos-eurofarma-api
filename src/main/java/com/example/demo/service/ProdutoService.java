package com.example.demo.service;

import com.example.demo.entidades.Produto;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreFactory;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    public void criarProduto(Produto produto){
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =firestore.collection("Questionarios").document();
        produto.setId(documentReference.getId());
        ApiFuture<WriteResult> apiFuture = documentReference.set(produto);
    }
}
