package org.dci.studentmanagementapi.config;

import org.dci.studentmanagementapi.models.Student;
import org.dci.studentmanagementapi.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadSampleStudents(StudentRepository repository) {
        return args -> {
            repository.save(new Student(null, "Ali", "Rezaei", 22, "Computer Science"));
            repository.save(new Student(null, "Sara", "Ahmadi", 24, "Electrical Engineering"));
            repository.save(new Student(null, "Reza", "Karimi", 21, "Mathematics"));
            repository.save(new Student(null, "Niloofar", "Hosseini", 23, "Physics"));
            repository.save(new Student(null, "Amir", "Javadi", 25, "Computer Engineering"));
            repository.save(new Student(null, "Mina", "Khosravi", 20, "Mechanical Engineering"));
            repository.save(new Student(null, "Hassan", "Farhadi", 22, "Civil Engineering"));
            repository.save(new Student(null, "Parisa", "Nazari", 23, "Architecture"));
            repository.save(new Student(null, "Mohammad", "Bagheri", 24, "Business Administration"));
            repository.save(new Student(null, "Elham", "Mohammadi", 21, "Graphic Design"));
            repository.save(new Student(null, "Sina", "Ghasemi", 22, "Software Engineering"));
            repository.save(new Student(null, "Yasaman", "Sharifi", 23, "Art History"));
            repository.save(new Student(null, "Arman", "Fathi", 24, "Industrial Design"));
            repository.save(new Student(null, "Fatemeh", "Tavakoli", 20, "Linguistics"));
            repository.save(new Student(null, "Shayan", "Ebrahimi", 22, "Robotics"));
            repository.save(new Student(null, "Zahra", "Kiani", 23, "Data Science"));
            repository.save(new Student(null, "Hossein", "Norouzi", 25, "Statistics"));
            repository.save(new Student(null, "Negar", "Soltani", 21, "English Literature"));
            repository.save(new Student(null, "Milad", "Tahami", 22, "Economics"));
            repository.save(new Student(null, "Maryam", "Ghayoomi", 24, "Artificial Intelligence"));
        };
    }
}
