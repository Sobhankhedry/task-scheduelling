# 📅 Task Scheduling

A **Java-based implementation of a Task Scheduling problem** using a **Greedy approach**.

The project focuses on the fundamental algorithmic idea of selecting tasks based on their **profit** and **deadline** in order to maximize the total achievable profit.

This project was developed as an algorithmic exercise to practice **sorting, greedy algorithms, arrays, deadlines, and optimization problems**.

---

## 📌 Overview

Task Scheduling is a classic optimization problem where each task has:

* 💰 A **profit**
* ⏰ A **deadline**
* 🕐 A limited time slot in which it can be completed

The objective is to select and schedule tasks in a way that maximizes the total profit while respecting their deadlines.

In this implementation:

```text
Pi → Profit of task i
Di → Deadline of task i
```

The input is represented using two integer arrays:

```java
int[] Pi = {40, 30, 50, 20, 35, 45, 10, 15};
int[] Di = {3, 2, 3, 1, 3, 2, 4, 4};
```

The two arrays represent corresponding task information, meaning `Pi[i]` and `Di[i]` belong to the same task.

---

# 🎯 Problem Definition

Given a collection of tasks where every task has a profit and deadline, the goal is to determine a profitable scheduling order while considering the available time slots.

For example:

```text
Task    Profit    Deadline
--------------------------
T1        40         3
T2        30         2
T3        50         3
T4        20         1
T5        35         3
T6        45         2
T7        10         4
T8        15         4
```

The scheduling problem can be viewed as:

```text
             Task Scheduling
                    │
                    ▼
          ┌───────────────────┐
          │ Tasks with Profit  │
          │   & Deadlines      │
          └─────────┬─────────┘
                    │
                    ▼
          Sort by Profit
                    │
                    ▼
          Consider Deadlines
                    │
                    ▼
          Select Tasks
                    │
                    ▼
          Calculate Total Profit
```

---

# 🧠 Greedy Strategy

The main idea behind the implementation is a **Greedy strategy**.

Instead of considering every possible combination of tasks, the algorithm starts by prioritizing tasks with higher profit.

The project first sorts the `Pi` array in **descending order** while simultaneously swapping the corresponding values in `Di`.

For example:

```text
Before sorting:

Profit:    40  30  50  20  35  45  10  15
Deadline:   3   2   3   1   3   2   4   4


After sorting by profit:

Profit:    50  45  40  35  30  20  15  10
Deadline:   3   2   3   3   2   1   4   4
```

The implementation uses **Bubble Sort** to perform this ordering.

---

# 🔄 Sorting Process

The sorting logic compares adjacent profit values:

```java
if (Pi[j - 1] < Pi[j]) {
    temp = Pi[j - 1];
    Pi[j - 1] = Pi[j];
    Pi[j] = temp;
}
```

Whenever two profit values are swapped, their corresponding deadlines are swapped as well:

```java
temp = Di[j - 1];
Di[j - 1] = Di[j];
Di[j] = temp;
```

This is important because the relationship between a task's profit and deadline must remain intact.

In other words:

```text
Profit[i] ↔ Deadline[i]
```

must always represent the same task.

---

# ⚙️ Algorithm Flow

The current implementation follows this general process:

```text
Start
  │
  ▼
Define task profits
  │
  ▼
Define task deadlines
  │
  ▼
Sort tasks by descending profit
  │
  ▼
Keep corresponding deadlines synchronized
  │
  ▼
Process tasks according to deadlines
  │
  ▼
Calculate accumulated profit
  │
  ▼
Print result
  │
  ▼
End
```

---

# 🧩 `FindMaximum` Method

The main scheduling calculation is implemented inside:

```java
private static int FindMaximum(int[] pi, int[] di, int i)
```

The method iterates through the sorted tasks and checks deadline conditions before adding the corresponding profit to the accumulated result.

A simplified representation of the logic is:

```text
Task
 │
 ├── Is deadline valid for current position?
 │
 ├── Yes → Add profit
 │
 └── No  → Look for another suitable task
```

The accumulated profit is stored in:

```java
int sum = 0;
```

and the final value is returned at the end of the method.

---

# 📊 Input Representation

The current implementation represents the tasks using two arrays:

```java
int[] Pi = {40, 30, 50, 20, 35, 45, 10, 15};
int[] Di = {3, 2, 3, 1, 3, 2, 4, 4};
```

Where:

| Array | Meaning                            |
| ----- | ---------------------------------- |
| `Pi`  | Profit associated with each task   |
| `Di`  | Deadline associated with each task |

The number of tasks is determined using:

```java
int n = Pi.length;
```

Therefore, both arrays are expected to represent the same number of tasks.

---

# 💻 Example

Given:

```text
Profit:
40 30 50 20 35 45 10 15

Deadline:
3  2  3  1  3  2  4  4
```

The program first sorts the profits in descending order while keeping the deadlines associated with their original tasks.

It then prints:

```text
Pi :
50 45 40 35 30 20 15 10

Di :
3 2 3 3 2 1 4 4

final answer:
...
```

The exact final result is produced by the current `FindMaximum` implementation.

---

# 🏗️ Project Structure

The repository currently has a very small and focused structure:

```text
task-scheduelling/
│
├── src/
│   └── Main.java
│
├── .idea/
│
├── maximumProphitActivity.iml
│
└── README.md
```

The core implementation is contained in `src/Main.java`. The repository currently contains four commits and does not include additional source classes or modules.

---

# 🛠️ Technology Stack

| Technology          | Purpose                                |
| ------------------- | -------------------------------------- |
| **Java**            | Programming language                   |
| **Java Arrays**     | Task data representation               |
| **Loops**           | Iteration and algorithm implementation |
| **Bubble Sort**     | Sorting tasks by profit                |
| **Greedy Strategy** | Task selection approach                |
| **IntelliJ IDEA**   | Project environment                    |

The repository is structured as a Java project with `Main.java` as its entry point.

---

# 📚 Concepts Demonstrated

This project focuses on fundamental algorithmic concepts.

### Algorithms

* Greedy algorithms
* Sorting
* Optimization problems
* Scheduling problems
* Deadline-based task selection

### Java

* Arrays
* Methods
* Loops
* Conditional statements
* Variables
* `static` methods
* Console output

### Problem Solving

* Representing tasks using parallel arrays
* Maintaining relationships between task attributes
* Sorting paired data
* Evaluating deadline constraints
* Accumulating an objective value

---

# 🔍 Why Sort by Profit?

Sorting tasks by profit is a common first step in greedy solutions to scheduling problems.

The intuition is straightforward:

```text
Higher Profit
     │
     ▼
Higher Priority
     │
     ▼
Try to Schedule First
```

This allows the algorithm to consider more valuable tasks before lower-value tasks.

However, **profit alone is not enough**. A valid scheduling algorithm must also ensure that selected tasks can actually occupy distinct time slots before their deadlines.

---

# ⚠️ Current Implementation

This repository is primarily an **algorithmic/educational implementation** rather than a production-ready scheduling library.

The current implementation demonstrates the core ideas of:

```text
Task
  ↓
Profit + Deadline
  ↓
Sort by Profit
  ↓
Evaluate Deadline
  ↓
Calculate Profit
```

The current `FindMaximum` method uses deadline comparisons while traversing the sorted arrays, but it does **not explicitly maintain a schedule array or reserve individual time slots**.

For that reason, the implementation should be viewed as a learning exercise around the greedy scheduling concept rather than a complete canonical implementation of the **Job Sequencing with Deadlines** algorithm.

---

# 🚀 Possible Improvements

The project could be extended into a more complete implementation of the classic scheduling problem.

## 1. Represent Tasks as Objects

Instead of two parallel arrays:

```java
int[] Pi
int[] Di
```

a `Task` class could be introduced:

```java
class Task {
    int id;
    int profit;
    int deadline;
}
```

This would make the relationship between task properties explicit.

---

## 2. Explicit Time Slots

A proper scheduling implementation can maintain an array representing available slots:

```text
Slot 1   Slot 2   Slot 3   Slot 4
  │        │        │        │
  ▼        ▼        ▼        ▼
 Task     Task     Task     Task
```

Each task can then be assigned to the latest available slot before its deadline.

---

## 3. Separate Sorting and Scheduling

The implementation could be divided into independent stages:

```text
Input
  │
  ▼
Create Tasks
  │
  ▼
Sort by Profit
  │
  ▼
Schedule Tasks
  │
  ▼
Calculate Profit
  │
  ▼
Output
```

This would improve readability and maintainability.

---

## 4. Add Test Cases

Different scenarios could be tested:

* Tasks with identical deadlines
* Tasks with identical profits
* One task
* No available slots
* Large number of tasks
* Deadlines larger than the number of tasks
* Multiple optimal schedules

---

# ⏱️ Complexity

The current implementation uses **Bubble Sort** to sort the profit values.

Bubble Sort has:

```text
Time Complexity:
O(n²)
```

The additional traversal performed by `FindMaximum` is linear in the number of tasks for its main traversal, with an additional nested search.

Therefore, the sorting stage is already a significant contributor to the overall runtime for larger inputs.

A more scalable implementation could use:

```text
Arrays.sort()
```

or another efficient sorting algorithm, reducing the sorting component to approximately:

```text
O(n log n)
```

---

# 🎯 Learning Objectives

The project was designed to practice:

* Understanding scheduling problems
* Applying greedy thinking
* Sorting data based on an optimization criterion
* Working with deadlines
* Maintaining relationships between multiple arrays
* Implementing algorithms manually in Java
* Translating a mathematical/algorithmic problem into code

---

# 🔮 Future Roadmap

Possible future versions could include:

* [ ] Create a dedicated `Task` class
* [ ] Implement explicit time-slot scheduling
* [ ] Implement the standard Job Sequencing with Deadlines algorithm
* [ ] Replace Bubble Sort with an efficient sorting algorithm
* [ ] Add user input
* [ ] Add randomized test cases
* [ ] Add automated unit tests
* [ ] Compare greedy approaches
* [ ] Measure algorithm performance
* [ ] Add a visualization of the generated schedule
* [ ] Compare greedy scheduling with brute-force solutions for small inputs

---

# ▶️ Running the Project

## Prerequisites

You need:

* Java JDK
* IntelliJ IDEA or another Java IDE

---

## Clone the Repository

```bash
git clone https://github.com/Sobhankhedry/task-scheduelling.git
```

Navigate to the project:

```bash
cd task-scheduelling
```

Open the project in IntelliJ IDEA and run:

```text
src/Main.java
```

The program prints the sorted profit/deadline arrays and the calculated final answer to the console.

---

# 📌 Project Status

**Status:** Educational / Algorithmic Project

The project currently contains a focused Java implementation of a profit/deadline-based task scheduling problem.

Its primary purpose is to demonstrate the **greedy scheduling concept, sorting, deadline constraints, and algorithmic problem solving**.

---

# 👨‍💻 Author

**Sobhan Khedry**

Computer Engineering Graduate Student
Backend Development Enthusiast

GitHub: [@Sobhankhedry](https://github.com/Sobhankhedry)

---

# ⭐ Summary

This project explores a classic scheduling optimization problem using Java.

At its core:

```text
Tasks
  │
  ├── Profit
  │
  └── Deadline
       │
       ▼
  Sort by Profit
       │
       ▼
  Evaluate Deadlines
       │
       ▼
  Select Tasks
       │
       ▼
  Maximize Profit
```

The repository is intentionally small and focuses on the **algorithmic logic rather than application architecture**, making it a useful exercise for understanding greedy algorithms and task scheduling fundamentals.
