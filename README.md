# Alpha Clinic App

Alpha Clinic App is a comprehensive solution designed for clinics to manage appointments, medical records, and notifications through a user-friendly interface. This application leverages a microservices architecture to ensure scalability, maintainability, and a seamless user experience.

## How to start application

There is a docker-compose.yml file in the root of this project. To start all services
execute the following command:

```bash
docker-compose up
```

If you want to change the code and restart services please run the following command:

```bash
./gradlew clean build
docker-compose build
docker-compose up
```


## Features

- **User Management**: Secure login and profile management.
- **Appointment Scheduling**: Book, update, and cancel appointments.
- **Notification System**: Real-time alerts and reminders for users.
- **Medical Records**: Access and manage patient's medical records.


