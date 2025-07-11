
# Java-Spring-web-2 (H2 Version): Student Management API

In this exercise, you'll build a **RESTful API** that stores data in an **H2 in-memory database** using **Spring Boot**, **Spring Web**, and **Spring Data JPA**.

You will learn to use:
- `@RestController`, `@RequestMapping`, `@RequestParam`, `@PathVariable`, and `@RequestBody`
- Spring Data JPA repositories
- H2 in-memory database

---

## ✅ Task 1: Project Setup

### 1.1: Create a Spring Boot Application

In your `pom.xml`, add these dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### 1.2: Configure H2 in `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:studentdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  h2:
    console:
      enabled: true
```

You will be able to access the H2 console at:

➡️ `http://localhost:8080/h2-console`

---

## ✅ Task 2: Create the `Student` Entity

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String major;

    // Getters and Setters
    // Default constructor for JPA
    // Optional: toString()
}
```

---

## ✅ Task 3: Create the Repository

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
```

---

## ✅ Task 4: Build the Controller

Create a `StudentController` class with the following endpoints.

### 🔹 4.1 Add a New Student

- **Endpoint:** `/students/add`
- **Method:** `POST`
- **Body:** JSON with student details

```java
@PostMapping("/students/add")
public Student addStudent(@RequestBody Student student) {
    return studentRepository.save(student);
}
```

### 🔹 4.2 List All Students (with limit)

- **Endpoint:** `/students`
- **Method:** `GET`
- **Param (optional):** `limit`

```java
@GetMapping("/students")
public List<Student> getAllStudents(@RequestParam(required = false) Integer limit) {
    List<Student> students = studentRepository.findAll();
    return limit != null ? students.stream().limit(limit).toList() : students;
}
```

### 🔹 4.3 Get Student by ID

- **Endpoint:** `/students/{id}`
- **Method:** `GET`

```java
@GetMapping("/students/{id}")
public Student getStudentById(@PathVariable String id) {
    return studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found"));
}
```

### 🔹 4.4 Delete Student by ID

- **Endpoint:** `/students/{id}`
- **Method:** `DELETE`

```java
@DeleteMapping("/students/{id}")
public void deleteStudent(@PathVariable String id) {
    studentRepository.deleteById(id);
}
```

---

## ✅ Task 5: Run and Test

Start the app and test it using:
- **Postman**
- **IntelliJ HTTP Client**
- **H2 Console:** `http://localhost:8080/h2-console`, JDBC URL: `jdbc:h2:mem:studentdb`

---

## 🔍 Optional Task 6: Enhance

- Add an endpoint to search by major: `/students/major/{major}`
- Add global exception handling with `@ControllerAdvice`
- Use `ResponseEntity` for proper HTTP responses.

---
