
🚀 Introduction

A Java-based console payroll management application demonstrating key OOP principles—abstraction, inheritance, encapsulation, and polymorphism. 
Supports handling both full-time and part-time employees through a flexible, extensible structure.

🧱 Project Structure

src/

├── Employee (abstract)

├── FullTimeEmployee (extends Employee)

├── PartTimeEmployee (extends Employee)

├── PayrollSystem (manages Employee list)

└── EmployeeUse (main application entry)

<br>

- Employee: Defines shared fields (name, ID) and abstract calculateSalary() & toString() methods.

- FullTimeEmployee: Stores a fixed monthly salary.

- PartTimeEmployee: Tracks hours worked and hourly rate.

- PayrollSystem: Allows adding/removing employees and displaying payroll info.

- EmployeeUse: Demonstrates system usage—creating, managing, and displaying employees.

⭐ Features

- OOP Techniques: Uses abstraction, inheritance, and polymorphism.

- Multiple Employee Types: Supports full-time (fixed salary) and part-time (hourly wage) employees.

- Dynamic Payroll Management: Add, delete, and list employees via PayrollSystem.

- Console-Based Demo: EmployeeUse showcases typical workflow.
