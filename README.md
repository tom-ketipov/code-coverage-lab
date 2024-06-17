# Code-coverage-lab

- [*Challenge*](#challenge)
- [*Repository Structure*](#repository-structure)
- [*Getting Started*](#getting-started)
- [*Running Tests*](#running-tests)

## Challenge

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side of
the DNA (string).

You need to return the other complementary side. ***DNA strand is never empty or there is no DNA at all .***

**Example**: (***input --> output***)

```
"ATTGC" --> "TAACG"
"GTAT" --> "CATA"
```

<br>

**Important to know:**

* *DNA strand is never empty or there is no DNA at all!*
* *DNA length: 1 <= dna <= 10 symbols*

### ⚠️ Your tasks !

- [ ] Checkout a feature branch named after yourself from the master branch.
- [ ] Navigate to the src/test/java directory within your project structure and create a new Java class with the naming pattern YourNameSolutionTest. For example, if your name is Alex, the class should be named AlexSolutionTest.java.
- [ ] Write unit tests with the goal of achieving 100% statement and branch coverage.
- [ ] Analyze your tests to identify any edge cases or scenarios that might not be covered, even if you have achieved 100% coverage.
  If you discover any bugs during this process, fix them and write additional tests to ensure the fixes are covered.
- [ ] Push your branch to the remote repository.

## Repository Structure

*The repository is organized as follows:*

    . 
    └── src/ 
        ├── main/ 
        │ 	└── java/ 
        │ 		├── Solution.java
        └── test/ 
            └── java/ 
                ├── YourNameSolutionTest.java

## Getting Started

To get a local copy up and running, follow these simple steps:

### Prerequisites

* **Java Development Kit (JDK) 19:** Make sure you have Java Development Kit (JDK) 19: installed on your machine.

  To check, run:

      java -version

<bt>

* **Apache Maven:** Ensure you have Maven 3.6 or later installed

  To check, run:

      mvn -version

### Installation

1. Clone the repo

       git clone https://github.com/tom-ketipov/code-coverage-lab.git

2. Navigate to the project directory

       cd code-coverage-lab

## Running Tests

You can run all tests in the repository using the following command from the root directory:

	mvn clean test





