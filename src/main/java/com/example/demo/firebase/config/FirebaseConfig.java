package com.example.demo.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseConfig {


    public void configFirebaseConnection() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("classpath:config/eurofinal-firebase-adminsdk-nh5g4-5bfc96343f.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
    }



}
