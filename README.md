# Leave & Employee Management Console App

## Description
A simple Java console-based application to manage employee records and leave requests using JDBC with PostgreSQL. It allows adding employees, viewing employees, applying for leaves, viewing leave requests, updating leave status, and deleting leave records.

## Components
- `dbUtil`: Establishes DB connection using JDBC.
- `EmployeeDao`, `LeaveReq`: DAO layers performing CRUD operations.
- `EmployeeServiceImpl`, `LeaveServiceImpl`: Business logic and validations.
- `empreqController`: Console-based controller to handle user choices.
- `Main`: Entry point instantiating components and launching the controller.
- Custom exceptions: `InvalidDate`, `LeaveReqNotFound`, `EmpNotFound`.
- Entity classes: `Employee`, `LeaveRequest`.

## Design Highlights
- Layered architecture following **DAO → Service → Controller** pattern.
- Input validation in service layers using custom exceptions (e.g. invalid dates, non‑existent IDs).
- Sorted request and employee listings for predictable output.
- Flexible and testable by using interfaces (`LeaveService`, `EmployeeService`) with concrete implementations.

## Purpose
To demonstrate a structured Java application using JDBC and clean separation of concerns for managing employees and leave requests in an interactive console-based workflow.

## Author
Lokeshwaran M
lokeshwaran.m@epssw.com
