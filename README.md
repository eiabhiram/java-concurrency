# 🧵 Java Concurrency Playground

This repository is a **pure Java learning project** created to understand and experiment with the core concepts of **Java concurrency** using the `java.util.concurrent` package.

Each concurrency concept is implemented as a **separate Java class with its own `main()` method**, making it easy to run, observe, and modify behavior independently.

> 📚 **Reference**  
> This project is based on and inspired by Baeldung’s excellent guide:  
> https://www.baeldung.com/java-util-concurrent

---

## 🎯 Objectives

- Understand **why Java concurrency utilities exist**
- Learn **how different concurrency tools behave**
- Observe **real multithreaded execution**
- Build a strong foundation before moving to:
  - `CompletableFuture`
  - Reactive programming
  - Virtual Threads (Java 21+)

---

## 🗂 Project Structure

```
com.example.concurrency
 ├── ExecutorDemo.java
 ├── ExecutorServiceDemo.java
 ├── ScheduledExecutorDemo.java
 ├── FutureDemo.java
 ├── CountDownLatchDemo.java
 ├── CyclicBarrierDemo.java
 ├── SemaphoreDemo.java
 ├── ThreadFactoryDemo.java
 ├── BlockingQueueDemo.java
 ├── DelayQueueDemo.java
 ├── LockDemo.java
 └── PhaserDemo.java
```

---

## 🔹 2.1 Executor
`Executor` represents a strategy for executing tasks.  
It **does not guarantee asynchronous execution**.

**Key takeaway:**  
> Decouples task submission from execution strategy.

---

## 🔹 2.2 ExecutorService
Provides a **complete asynchronous execution framework** with thread pooling and lifecycle management.

**Key takeaway:**  
> Backbone of async execution in Java.

---

## 🔹 2.3 ScheduledExecutorService
Used for **delayed and periodic tasks** such as polling and heartbeats.

---

## 🔹 2.4 Future
Represents the **result of an asynchronous computation**.

**Limitation:** blocking-only (`get()`).

---

## 🔹 2.5 CountDownLatch
Allows one or more threads to wait until **N operations complete**.

**Mental model:**  
> Wait until all tasks finish.

---

## 🔹 2.6 CyclicBarrier
Allows multiple threads to **wait for each other** at a common point.

**Mental model:**  
> All workers must arrive before proceeding.

---

## 🔹 2.7 Semaphore
Controls **how many threads access a resource simultaneously**.

---

## 🔹 2.8 ThreadFactory
Customizes **thread creation** (naming, daemon status, handlers).

---

## 🔹 2.9 BlockingQueue
Designed for **producer–consumer** scenarios with built-in blocking.

---

## 🔹 2.10 DelayQueue
Elements become available **only after a delay expires**.

---

## 🔹 2.11 Lock (ReentrantLock)
Explicit locking with more control than `synchronized`.

---

## 🔹 2.12 Phaser
Advanced synchronization barrier supporting:
- Multiple phases
- Dynamic registration
- Reusability

---

## ▶️ How to Run

Each class contains a `main()` method.

```bash
javac ClassName.java
java com.example.concurrency.ClassName
```

---

## 📚 Reference

https://www.baeldung.com/java-util-concurrent

---

## ✅ Final Note

This project focuses on understanding:
- why concurrency tools exist
- what problems they solve
- when to use which

Building this intuition is key to mastering Java concurrency.
