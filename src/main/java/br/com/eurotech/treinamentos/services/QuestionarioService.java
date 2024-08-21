package br.com.eurotech.treinamentos.services;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import br.com.eurotech.treinamentos.model.Questionario;

@Service
public class QuestionarioService {
    public void criarQuestionario(Questionario questionario){
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("questionario").document();
        questionario.setId(documentReference.getId());
        ApiFuture<WriteResult> apiFuture= documentReference.set(questionario);        
    }
}
