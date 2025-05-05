# 🎢 Assignment: **RideManagerPro** - Version 1

### Mastering Stack, Queue, OOP, Collections, Maven, and JUnit 5

*Real-Time Systems with Clean Java Architecture*

---

## 🧠 Project Overview

You are building the **RideManagerPro**, a Java-powered system to manage amusement park rides. It handles how guests line up (Queue) and tracks the last ride's riders (Stack) for safety review or photo access.

Each module must follow:

* OOP Principles (Encapsulation, Abstraction, Composition)
* Java Collections (`Queue`, `Stack`)
* Maven for dependency and project management
* Clean CLI-based simulation using `main()`
* Proper Exception Handling
* JUnit 5 for testing

---

# 🛠️ Setup Instructions (MUST FOLLOW)

✅ **Use IntelliJ IDEA**
✅ **Use Maven to create the project**
✅ **Use Java 17+**

---

## 1️⃣ Create a Maven Project in IntelliJ IDEA

**Steps:**

* File → New → Maven Project
* Uncheck "Create from archetype"
* Fill in:

| Field      | Value            |
| ---------- | ---------------- |
| GroupId    | `org.ridepark`   |
| ArtifactId | `RideManagerPro` |
| Version    | default (`1.0`)  |

✅ Project structure will look like:

```
RideManagerPro/
 └── src/
     ├── main/
     │   └── java/
     └── test/
         └── java/
pom.xml
```

---

## 2️⃣ Fix the Maven Dependency

Replace the default JUnit with JUnit 5 in `pom.xml`:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-engine</artifactId>
  <version>5.9.1</version>
  <scope>test</scope>
</dependency>
```

✅ You can now use modern JUnit annotations like `@Test`, `@DisplayName`, etc.

---

## 3️⃣ Project Structure

Organize your files under `src/main/java` like this:

```
RideManagerPro/
├── main/
│   └── RideManagerApp.java
├── ride/
│   ├── Guest.java
│   ├── RideQueueManager.java
│   └── RideHistoryStack.java
├── exception/
│   ├── EmptyQueueException.java
│   └── NoRideHistoryException.java
```

✅ Place your tests in `src/test/java` with the same package structure.

---

## 4️⃣ What to Implement (Tasks)

---

### 🎫 Task 1: Model the Guest

* `Guest` class with:

    * `id` (int)
    * `name` (String)
* Add proper constructor, getters, `toString()`, and `equals()`/`hashCode()`.

---

### 🎢 Task 2: Ride Queue Manager (FIFO)

* Class: `RideQueueManager`
* Uses a `Queue<Guest>` internally.
* Methods:

    * `void addGuest(Guest guest)`
    * `List<Guest> startRide(int rideCapacity)` → Removes N guests from the queue
    * `int getQueueSize()`

✅ Throw `EmptyQueueException` if startRide is called on an empty queue.

---

### 🌀 Task 3: Ride History Stack (LIFO)

* Class: `RideHistoryStack`
* Uses a `Stack<Guest>` to track the last riders.
* Methods:

    * `void saveRide(List<Guest> guests)`
    * `List<Guest> viewLastRide()`
    * `Guest removeLastRider()`

✅ Throw `NoRideHistoryException` when trying to view/remove from an empty stack.

---

### 🛂 Task 4: Exception Handling

* `EmptyQueueException` and `NoRideHistoryException`
* Both should extend `RuntimeException` and include a custom message.

---

### 💻 Task 5: CLI Simulation

* `RideManagerApp` class with:

    * A menu-driven CLI using `Scanner`
    * Options:

        * Add Guest
        * Start Ride
        * View Last Ride
        * Remove Last Rider
        * Exit

✅ Demonstrate Queue (FIFO) and Stack (LIFO) in action via CLI.

---

## 5️⃣ Testing Instructions (JUnit 5)

### ✅ Create Test Classes:

| Class to Test      | Test Class Name        |
| ------------------ | ---------------------- |
| `Guest`            | `GuestTest`            |
| `RideQueueManager` | `RideQueueManagerTest` |
| `RideHistoryStack` | `RideHistoryStackTest` |

### ✅ Each test should cover:

* Normal behavior
* Exception handling
* Edge cases (empty queue/stack)

### ✅ Example Assertion:

```java
@Test
@DisplayName("Should throw if ride started on empty queue")
void shouldThrowOnEmptyRideQueue() {
    RideQueueManager manager = new RideQueueManager();
    assertThrows(EmptyQueueException.class, () -> manager.startRide(3));
}
```

✅ Run with:

```bash
mvn test
```

---

## 📬 Submission Requirements

✅ Full Maven project
✅ Source code + `RideManagerApp.java` CLI
✅ Tests for each major class
✅ GitHub repo: **RideManagerPro-YourName**
✅ `README.md` with:

* Project overview
* Setup instructions
* How to run the simulation
* Concepts covered

---

## 🧪 Expanded Testing Tips

* Keep tests isolated with `@BeforeEach`
* Use `@DisplayName` for clarity
* Always test for both valid and invalid scenarios
* Use `assertAll()` for grouped assertions

---

## 📈 Grading Rubric (Suggested)

| Item                        | Points  |
| --------------------------- | ------- |
| Maven project setup         | 10      |
| Clean OOP design            | 15      |
| Working Queue & Stack logic | 20      |
| Exception handling          | 15      |
| CLI simulation              | 20      |
| Test coverage               | 20      |
| GitHub + README             | 10      |
| **Total**                   | **110** |

---

## 🎯 Bonus Challenges (Optional)

* Add ride history for multiple past rides (`Deque`)
* Allow riders to cancel their queue entry
* Add ride photo previews for last ride

---

## 😄 Motivational Closing

> "Whether you're managing a roller coaster or a REST API, the rules of order matter!
> Stack for memory. Queue for fairness. Code for clarity.
> And remember — if Java handled this ride system, it’d probably just run in a while loop and call it a day. 🎢💥"
