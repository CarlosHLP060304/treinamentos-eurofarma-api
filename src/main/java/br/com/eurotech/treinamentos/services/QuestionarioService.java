package br.com.eurotech.treinamentos.services;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import br.com.eurotech.treinamentos.dto.questionario.DadosDetalhamentoQuestionario;
import br.com.eurotech.treinamentos.model.Questionario;


@Service
public class QuestionarioService {
    public void criarQuestionario(Questionario questionario){
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("questionario").document();
        questionario.setId(documentReference.getId());
        ApiFuture<WriteResult> apiFuture= documentReference.set(questionario);        
    }

    // public List<DadosDetalhamentoQuestionario> listarQuestionarios(){
    //     Firestore firestore = FirestoreClient.getFirestore();
    //     ApiFuture<QuerySnapshot> apiFuture = firestore.collection("questionario").get();
    //     List<DadosDetalhamentoQuestionario> listaQuestionarios = null;
    //     try {
    //         List<QueryDocumentSnapshot> list =  apiFuture.get().getDocuments();
    //         listaQuestionarios = list.stream().map(DadosDetalhamentoQuestionario::new).toList();
    //     } catch (InterruptedException | ExecutionException e) {
    //         e.printStackTrace();
    //     }
    //     return listaQuestionarios;
    // }



}
