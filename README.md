# Autobody Shop Application

This is the **Autobody Shop Application**, a group capstone project developed as part of a comprehensive effort to streamline and modernize the customer experience for an autobody shop. The system provides an intuitive and robust platform where customers can book services, browse and purchase products, manage their appointments, and securely manage their user profiles. The backend is powered by Microsoft Azure to ensure scalability, reliability, and security for users' data. This application features a rich user interface built using **JavaFX**, **FXML**, and modern **CSS** techniques.

---

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [System Requirements](#system-requirements)
- [Installation Instructions](#installation-instructions)
- [Usage](#usage)
- [Future Enhancements](#future-enhancements)
- [Contributors](#contributors)
- [License](#license)

---

## Introduction

The **Autobody Shop Application** is designed to manage an autobody shop’s customer-facing services, including booking vehicle repair appointments, browsing a product marketplace, and handling payments securely. This application ensures seamless interaction for both customers and staff, backed by a strong and scalable cloud-based infrastructure.

Key Features:
- **Splash Screen**: Welcomes users with a modern interface
- **User Account Management**: Create a new account, log in, and manage credentials (password recovery, authentication)
- **Appointment Scheduling**: Book appointments for services such as vehicle repairs, maintenance, or detailing
- **Product Marketplace**: Browse and purchase automotive accessories or parts
- **Secure Transactions**: Payment handling for product purchases with integration for secure credit/debit card payments
- **User and Management Reports**: View appointment history, transactions, and generate reports for management
- **Data Storage**: All user data, transactions, and appointments are securely stored on **Microsoft Azure Cloud**.

---

## Features

### 1. **User Registration & Authentication**
   - New users can create an account.
   - Existing users can log in securely using email and password.
   - Password recovery and user authentication ensure that only authorized users access the system.

### 2. **Appointment Scheduling**
   - Customers can view available time slots for services like vehicle repair, maintenance, or detailing.
   - Appointments can be scheduled, rescheduled, or canceled with real-time availability updates.

### 3. **Product Marketplace**
   - Customers can browse car accessories and parts.
   - Purchase products directly from the app.
   - Secure payment options using credit/debit cards.

### 4. **Reporting & Analytics**
   - Customers can view their appointment history and upcoming services.
   - Management has access to detailed reports on customer activity, transaction history, and service usage.
   - Insights help make data-driven decisions to improve service offerings and marketing strategies.

### 5. **Cloud Infrastructure (Microsoft Azure)**
   - Utilizes **Azure SQL Database** to store transactional and user data.
   - Azure Blob Storage is used for storing images and product details.
   - **Azure App Services** hosts the application, ensuring reliability and scalability.

---

## Technologies Used

- **JavaFX**: For building the graphical user interface.
- **FXML**: To define the structure and layout of the user interface.
- **CSS**: For modern and responsive styling of the application’s UI.
- **MySQL**: A relational database system used to manage transactional data and service records.
- **Microsoft Azure**: Provides the backend infrastructure and cloud services including:
  - **Azure SQL Database**: For secure, scalable data storage.
  - **Azure Blob Storage**: For storing images and files.
  - **Azure App Services**: Hosts the application for seamless access.
  - **Azure Application Insights**: To monitor app performance and usage metrics.
  
---

## System Requirements

To run the **Autobody Shop Application**, the following software is required:

- **Java Development Kit (JDK)** version 8 or later.
- **JavaFX** libraries (included with JDK 8, or separately for JDK 11+).
- **MySQL Database** (for local development, connect to an Azure instance for production).
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-compatible IDE.
- **Microsoft Azure Account**: For cloud-based infrastructure and database hosting.

---

## Installation Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kekef2002/autobody-shop-app.git
   ```

2. **Setup the MySQL Database**:
   - Install MySQL locally or use an Azure SQL Database.
   - Import the database schema from `db/schema.sql`.
   - Configure the connection settings in `src/config/database.properties`.

3. **Build and Run the Application**:
   - Open the project in your Java IDE.
   - Run the `Main` class (or `MainApp` depending on your IDE) to start the application.

4. **Configure Microsoft Azure**:
   - Create an Azure account if you don’t have one already.
   - Set up Azure SQL Database and Blob Storage.
   - Update connection details in the app to point to the Azure services for production.

5. **Optional (Figma Design)**:
   - If you want to adjust or create UI designs, access the Figma design files here: [Figma Project Link]([https://www.figma.com/yourdesign](https://www.figma.com/design/O9cQBVOTFS2OZp2nMspLNZ/Autobody-Shop-Application-Project?node-id=0-1&node-type=canvas&t=XJ513BwyAScb4HRM-0)).

---

## Usage

1. **Login or Register**:
   - Upon launching the app, users are presented with a splash screen.
   - Create a new account or log in if you already have an account.
   - Password recovery is available.

2. **Book Services**:
   - Choose from available services and select a time slot that works best for your schedule.
   - Confirm your appointment after reviewing the service details.

3. **Browse and Purchase Products**:
   - Visit the product marketplace to browse car parts and accessories.
   - Add items to your cart and proceed to checkout with secure payment options.

4. **View Reports**:
   - As a customer, view past transactions and upcoming appointments.
   - As a shop manager, generate reports on services, sales, and customer interactions.

---

## Future Enhancements

We plan to enhance the **Autobody Shop Application** with the following features:

- **Loyalty Program**: Implement a point-based loyalty system where users earn rewards for every purchase or service, redeemable for discounts or services.
- **Real-time Chat Support**: Integrate **Azure Communication Services** to allow users to chat directly with shop staff for inquiries about services or products.
- **Push Notifications**: Notify users about upcoming appointments, new products, and special promotions.
- **Mobile App Development**: Extend the functionality to mobile platforms such as Android and iOS to improve accessibility.

---

## Contributors

- **[Kervin ]** 
- **[Christopher]** 
- **[Stephanie]** 
- **[Anthony]**
- **[Bryce]**

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

