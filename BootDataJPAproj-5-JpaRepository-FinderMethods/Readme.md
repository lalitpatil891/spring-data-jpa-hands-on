# 📌 Spring Data JPA – Derived Query Methods Demo

This project demonstrates the usage of **Spring Data JPA derived query methods** with the `Doctor` entity.
It shows how we can query the database by simply following Spring Data JPA’s **method naming conventions** without writing explicit JPQL or SQL.

---

## 🚀 Features

* Uses **`JpaRepository`** for CRUD operations.
* Demonstrates **derived query methods** on `docName` field.
* Covers different use cases like **exact match, pattern search, case-insensitive search, null checks, and IN queries**.

---

## 📂 Project Structure

```
src/main/java
 ├── com.nit.entity.Doctor.java        # Entity class (Doctor table)
 ├── com.nit.repository.IDoctorRepo.java  # Repository interface with custom finder methods
 └── com.nit.runner.Runner.java        # Runner to test methods on startup
```

---

## 🔍 Derived Query Methods Covered

### 1. **Exact Match**

```java
List<Doctor> findByDocName(String docName);
```

➡ Finds doctors with the exact name.

---

### 2. **Starts With / Ends With**

```java
Iterable<Doctor> findByDocNameStartingWith(String prefix);
Iterable<Doctor> findByDocNameEndingWith(String suffix);
```

➡ Finds doctors whose names start or end with a given string.

---

### 3. **Contains / Like**

```java
Iterable<Doctor> findByDocNameContaining(String keyword);
Iterable<Doctor> findByDocNameLike(String pattern);
```

➡ Finds doctors whose names contain a keyword (case-sensitive).

---

### 4. **Case-Insensitive Search**

```java
Iterable<Doctor> findByDocNameEqualsIgnoreCase(String name);
Iterable<Doctor> findByDocNameContainingIgnoreCase(String keyword);
```

➡ Ignores case while searching.

---

### 5. **Null / Not Null**

```java
Iterable<Doctor> findByDocNameIsNull();
Iterable<Doctor> findByDocNameIsNotNull();
```

➡ Finds doctors with `null` / non-null names.

---

### 6. **IN / NOT IN**

```java
Iterable<Doctor> findByDocNameIn(List<String> names);
Iterable<Doctor> findByDocNameNotIn(List<String> names);
```

➡ Finds doctors whose names are in / not in a given list.

---

## ⚙️ Tech Stack

* **Java 17+**
* **Spring Boot 3+**
* **Spring Data JPA**
* **Hibernate**
* **MySQL Database**

