# CRUD Repository Demo

This project demonstrates how to use **Spring Data JPA's `CrudRepository`** interface to perform standard **CRUD operations** (Create, Read, Update, Delete) on a `Doctor` entity.

---

## 📌 Features Covered

- **Create**
  - Save a single doctor
  - Save multiple doctors in batch
- **Read**
  - Count doctors
  - Check if a doctor exists by ID
  - Retrieve all doctors
  - Retrieve doctors by ID(s)
  - Retrieve doctor by ID using `Optional`
- **Update**
  - Update doctor name by ID
- **Delete**
  - Delete doctor by ID
  - Delete doctor by entity
  - Delete all doctors
  - Delete multiple doctors by IDs

---

## 📂 Project Structure

```

src/main/java/com/nit/
│
├── entity/
│   └── Doctor.java            # Doctor entity
│
├── repository/
│   └── IDoctorRepo.java       # Extends CrudRepository
│
├── service/
│   ├── IDoctorService.java    # Service interface
│   └── IDoctorMgmtServiceImpl.java  # Service implementation
│
└── runner/
└── Runner.java            # Test runner (CommandLineRunner)

```

---

## 🚀 How to Run

1. Navigate into the project folder:
   ```bash
   cd BootDataJPAproj-2-CrudRepository
````

2. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

3. Check the **console output** for CRUD operations.

---

## 📖 References

* [Spring Data JPA - CrudRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)

```
