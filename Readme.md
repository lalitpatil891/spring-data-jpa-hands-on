## Spring Boot Paging and Sorting Example

This project demonstrates the use of **Spring Data JPA's `PagingAndSortingRepository`** with a `Doctor` entity.  
It shows how to perform:

- Sorting by one or more fields.
- Paging with page size and number.
- Iterating through all pages (pagination).

---

## 🛠️ Tech Stack

- Java 17+  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL  

---

## 📂 Project Structure

```

src/main/java/com/nit
│
├── entity/Doctor.java
├── repository/IDoctorRepo.java
├── service/IDoctorService.java
├── service/IDoctorMgmtServiceImpl.java
└── runner/Runner.java

````

---

## 🔑 Core Concepts

### 1. Sorting

```java
@Override
public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
    Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
    return doctorRepo.findAll(sort);
}
````

* Single property sorting (e.g., `docName`)
* Multiple property sorting (e.g., `docName`, `income`)

---

### 2. Paging

```java
@Override
public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String props) {
    Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, props);
    Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
    return doctorRepo.findAll(pageable);
}
```

* Returns a `Page<Doctor>` object.
* Provides metadata like `page number`, `total pages`, `number of elements`, etc.

---

### 3. Pagination (Iterating Pages)

```java
@Override
public void showDataThroughPagiation(int pageSize) {
    long count = doctorRepo.count();
    long pagesCount = count / pageSize;

    if (count % pagesCount != 0)
        pagesCount++;

    for (int i = 0; i < pagesCount; ++i) {
        Pageable pageable = PageRequest.of(i, pageSize);
        Page<Doctor> page = doctorRepo.findAll(pageable);

        System.out.println("page::" + (page.getNumber() + 1) +
            " Records of " + page.getTotalPages());
        page.getContent().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
    }
}
```

---

## ▶️ Sample Output

```
Doctor(docId=1, docName=Raju, specialization=Cardio, income=40000.0)
Doctor(docId=2, docName=Ramesh, specialization=Ortho, income=60000.0)
Doctor(docId=3, docName=Sunil, specialization=Neuro, income=55000.0)
Doctor(docId=4, docName=Amit, specialization=Dental, income=50000.0)
Doctor(docId=5, docName=Anil, specialization=Ortho, income=45000.0)

============================================
Doctor(docId=4, docName=Amit, specialization=Dental, income=50000.0)
Doctor(docId=5, docName=Anil, specialization=Ortho, income=45000.0)
Doctor(docId=2, docName=Ramesh, specialization=Ortho, income=60000.0)
Doctor(docId=1, docName=Raju, specialization=Cardio, income=40000.0)
Doctor(docId=3, docName=Sunil, specialization=Neuro, income=55000.0)

PageNumber: 0
Pages Count: 2
Page Elements count: 5
Is it first Page: true
Is it last Page: false
Get page size: 5
Doctor(docId=1, docName=Raju, specialization=Cardio, income=40000.0)
Doctor(docId=2, docName=Ramesh, specialization=Ortho, income=60000.0)
Doctor(docId=3, docName=Sunil, specialization=Neuro, income=55000.0)
Doctor(docId=4, docName=Amit, specialization=Dental, income=50000.0)
Doctor(docId=5, docName=Anil, specialization=Ortho, income=45000.0)

==============================================
page::1 Records of 2
Doctor(docId=1, docName=Raju, specialization=Cardio, income=40000.0)
Doctor(docId=2, docName=Ramesh, specialization=Ortho, income=60000.0)
Doctor(docId=3, docName=Sunil, specialization=Neuro, income=55000.0)
Doctor(docId=4, docName=Amit, specialization=Dental, income=50000.0)
Doctor(docId=5, docName=Anil, specialization=Ortho, income=45000.0)
----------------------------------------------------
page::2 Records of 2
Doctor(docId=6, docName=Vikas, specialization=Eye, income=48000.0)
Doctor(docId=7, docName=Rahul, specialization=ENT, income=52000.0)
----------------------------------------------------
```

---

## 🚀 How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/spring-boot-paging-sorting.git
   ```

2. Import into your IDE (IntelliJ / Eclipse / VS Code).

3. Run the project as a **Spring Boot App**.

4. Check the console output for sorting & paging results.

---

## 📖 Reference

* [Spring Data JPA - Paging and Sorting](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.paging-and-sorting)

---

