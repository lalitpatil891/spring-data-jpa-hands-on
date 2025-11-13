# Spring Data JPA - Advanced Queries

## 📖 Project Description

This Spring Boot project demonstrates advanced Spring Data JPA features including:

* **CRUD operations** with `JpaRepository`
* **Custom finder methods** using naming conventions
* **Example-based queries** with `Example` API
* **Batch deletion** of records
* **Lazy loading** using `getReferenceById`

The project focuses on the **Doctor** entity and showcases practical examples of how to query and manipulate data efficiently using Spring Data JPA.

---

## ⚡ Features

1. **Delete Operations**

   * Delete multiple doctors in a single batch by IDs
   * Delete individual doctor by entity

2. **Finder Methods**

   * Find doctor by exact name
   * Case-insensitive search
   * Search by starting, ending, or containing a string

3. **Example Queries**

   * Retrieve doctors matching specific fields using `Example` API
   * Sort results by specified properties in ascending or descending order

4. **Lazy Loading**

   * Fetch entity references without immediately loading from database
   * Forces initialization using `getReferenceById`

---

## 🛠️ Project Structure

```
com.nit
│
├── entity
│   └── Doctor.java          # JPA entity for doctor
│
├── repository
│   └── IDoctorRepo.java     # JpaRepository for Doctor
│
├── service
│   ├── IDoctorService.java           # Service interface
│   └── IDoctorMgmtServiceImpl.java  # Service implementation
│
└── runner
    └── Runner.java          # CommandLineRunner to test queries
```

---

## 📝 Methods Overview

### **Service Methods (IDoctorService)**

| Method                                                                              | Description                                                |
| ----------------------------------------------------------------------------------- | ---------------------------------------------------------- |
| `deleteAllByIdInBatch(List<Integer> ids)`                                           | Deletes multiple doctors in a batch                        |
| `showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties)` | Finds doctors matching an example entity and sorts results |
| `findDoctorById(Integer id)`                                                        | Finds a doctor by ID (lazy-loaded reference)               |
| `findByName(String docName)`                                                        | Finds doctors by exact name                                |

---