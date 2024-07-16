package com.example.demo;

import com.example.demo.model.Consultation;
import com.example.demo.model.Medcin;
import com.example.demo.model.Patient;
import com.example.demo.model.RendezVous;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

//    @Bean
//    CommandLineRunner start(UserService userService){
//        return args -> {
//            for(int i= 0; i<10 ; i++){
//                Patient patient = new Patient();
//                patient.setNom(Math.random()<0.5?"Hafsa":"Imane");
//                patient.setEmail(patient.getNom()+i+"@gmail.com");
//                userService.addNewPatient(patient);
//            }
//            for(int j=  0; j<5 ; j++) {
//
//                Medcin medcin = userService.addNewMedcin(Medcin.builder()
//                        .nom("noureddin").email("noureddin" + j + "@gmail.com").specialite(Math.random()<0.5?"cardio":"dentiste").build());
//            }
//            RendezVous rendezVous = new RendezVous();
//            rendezVous.setMedcin(userService.findMedcinById(4L));
//            rendezVous.setPatient(userService.findPatientById(2L));
//            rendezVous.setDateRDV(new Date());
//            rendezVous.setHeureRDV(new Date());
//            userService.addNewRendezVous(rendezVous);
//
//            Consultation consultation = userService.addNewConsultation(Consultation.builder().dateConsultation(new Date()).rapportConsultation("rapport de consultation: ...... ").rendezVous(userService.findRendewVousById(1L)).build());
//        };
//    }

}
