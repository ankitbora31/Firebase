package com.demo.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = ProjectApplication.class.getClassLoader();
		
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountkey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
		

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://demoproject-bc05b-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);

		SpringApplication.run(ProjectApplication.class, args);
		
	}

}
