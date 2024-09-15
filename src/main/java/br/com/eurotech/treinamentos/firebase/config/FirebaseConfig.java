package br.com.eurotech.treinamentos.firebase.config;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void configFirebaseConnection(){
        try {
   
            FileInputStream serviceAccount =
            new FileInputStream("src/main/resources/config/eurofinal-firebase-adminsdk-nh5g4-45eb9e22c2.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://teste-firebase-7a314-default-rtdb.firebaseio.com")
            .build();
            
            if(FirebaseApp.getApps().isEmpty()){
                FirebaseApp.initializeApp(options);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch(IOException e){
            System.out.println(e);
        }

        
    }



}
