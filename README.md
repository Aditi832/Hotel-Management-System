
# Hotel-Management-System

## Description
This project, titled "Hotel Management System," is a comprehensive management software designed for maintaining customer details effectively and efficiently. The system facilitates user-friendly interactions, allowing users to perform tasks with minimal effort and a high degree of automation.

## Features
- User-friendly GUI for easy navigation.
- JDateChooser for date selection within the application.
- CardLayout to manage different panels within the GUI.
- Detailed room information management including room types and services offered.
- Check-in and check-out functionality.
- Reporting features for customer information and revenue calculation.
- Robust user authentication system.

## Modules
### 1. Login Module
This module is responsible for the authorization and authentication of specified users who are allowed to carry out the booking process. It ensures that only authorized personnel can access the system.

### 2. Main Frame Module
It consists of a main panel that contains various buttons directing to different internal frames through the 'card layout'. This is the central hub from which all operations are accessed.

### 3. Room Information Module
This frame consists of all the information about various rooms and their status. It provides the privilege to add delete and clear records from the room information table using buttons like “Add New Record”, “Delete” and “Clear”. The “Add New Record” button when clicked provides the necessary details through java code. It also allows to enter new room types and floors by clicking on the buttons “Add New Room Type” and “Add New Floor”. The panel has details about the status and details of various rooms which serve as an initial stand by in the process of booking.

### 4. Check-In Module
In this module, the selection of room number is done based on user preferences, and customer details are entered and saved as a part of the check-in process.

### 5. Check-Out Module
This module finalizes the booking process. The final bill, including the cost of additional amenities used by the customer, is calculated and displayed.

### 6. Report Module
It generates information regarding the customers within selected dates. It also allows for sorting records according to various criteria and calculates the total revenue collected in the selected period.

### 7. Exit Module
Provides a secure and straightforward way to exit the application.

Each of these modules corresponds to a different aspect of hotel management and is designed to streamline the processes involved in managing a hotel. The modular design ensures that the system is organized, manageable, and scalable, with clear separations between different functionalities. This modular approach also aids in maintenance and future upgrades as changes can be made to individual modules without affecting the entire system.

## System Requirements
- 64-bit Operating System, x64-based processor.
- Windows 10 Home Single Language.
- Java Platform: NetBeans IDE 6.5.1.
- Database Platform: MySQL 5.6.

## Languages and Technologies
The Hotel Management System is developed using Java, a robust and platform-independent programming language. Java Swing is used for creating the graphical user interface (GUI), ensuring a responsive and intuitive user experience. For the backend database operations, MySQL is utilized, providing a reliable and scalable data management solution. The software is developed within the NetBeans IDE, which offers an integrated environment for Java development, simplifying coding, debugging, and deployment processes.

## Languages Used
The Hotel Management System is primarily developed using Java, a versatile and powerful programming language well-suited for building robust, multi-platform applications. Java's platform-independence and extensive library support make it an ideal choice for creating complex systems like hotel management software. The graphical user interface (GUI) is designed using Swing, a Java framework that allows for a highly customizable and user-friendly interface. For database management, SQL is used in conjunction with MySQL, ensuring efficient and secure data handling and storage. This combination of Java and SQL provides a solid foundation for a reliable and efficient management system.
