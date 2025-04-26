# Serializable + Redis + AOP Demo

This project demonstrates how to:

- Serialize and deserialize Java objects using both Redis and ObjectOutputStream/ObjectInputStream.
- Use Spring AOP (`@Aspect`, `@Before`) to log method calls.
- Apply global error handling using `@RestControllerAdvice`.
- Understand the role of `transient` fields in Java serialization.
- Differentiate between Jackson and JDK serialization approaches in Redis.
- Manage multiple `RedisTemplate` beans with `@Qualifier` to control serialization strategies.
- Understand that Jackson serialization **does not require** implementing `Serializable`.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring AOP
- Spring Data Redis
- Redis (via Docker)
- AspectJ Weaver
- Gradle

---

## 🧩 Key Concepts Demonstrated

- **Java Native Serialization**  
  Using `ObjectOutputStream` and `ObjectInputStream` for file-based serialization.

- **Spring AOP Logging**  
  Automatically logging method calls before execution with `@Before` advice.

- **Global Exception Handling**  
  Managing unexpected errors globally with `@RestControllerAdvice`.

- **Redis Integration**  
  Saving and retrieving serialized Java objects through Redis with two strategies:
  - **Jackson Serialization** (`GenericJackson2JsonRedisSerializer`) → Does not require `Serializable`.
  - **JDK Serialization** (`JdkSerializationRedisSerializer`) → Requires `Serializable`.

- **Bean Conflict Resolution**  
  Using `@Qualifier` to differentiate between multiple `RedisTemplate` beans.

---

## 🚀 How to Run

1. Make sure Docker Desktop is installed and running.
2. Start a Redis container:

    ```bash
    docker run --name my-redis -p 6379:6379 -d redis
    ```

3. Run the Spring Boot application:

    ```bash
    ./gradlew bootRun
    ```

4. Use Postman or cURL to test the following endpoints:
    - `POST /api/user/save` → Save a serializable user.
    - `GET /api/user/get/{id}` → Retrieve a user.
    - `POST /api/failure/redis/save` → Try saving a non-serializable object with JDK serialization (should fail).
    - `POST /api/failure/redis-jackson/save` → Save a non-serializable object with Jackson serialization (should succeed).

---

## 📌 Important Notes

- Jackson serialization stores objects as JSON and does not require implementing `Serializable`.
- JDK serialization stores objects in a binary format and strictly requires implementing `Serializable`.
- Redis key-value pairs use string keys and JSON or binary-serialized values depending on the serializer.

---
