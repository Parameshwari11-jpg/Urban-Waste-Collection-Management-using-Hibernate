Urban Waste Collection Management System(Hibernate-Based Java Application)

Project Overview

The Urban Waste Collection Management System is a Java-based console application developed using Hibernate ORM to manage citizen registrations and waste collection complaints in an urban area.
This system helps municipal authorities:

Register citizens
Track waste collection complaints
Schedule pickups
Update complaint status
Manage active/inactive citizens

The project follows a Layered Architecture approach using:

DAO Layer
Service Layer
Hibernate ORM

Relational Database (Oracle / MySQL)

Technology Stack

Java (JDK 8+)
Hibernate ORM
JDBC
Oracle / MySQL Database
Maven / Gradle (optional for dependency management)

Project Architecture
Presentation Layer (Main Class)
        ↓
Service Layer
        ↓
DAO Layer
        ↓
Hibernate ORM
        ↓
Database

🔹 DAO Layer

Handles database operations using Hibernate sessions.

🔹 Service Layer

Contains business logic and validation.

🔹 Hibernate

Manages object-relational mapping and database transactions.

Features
1.Citizen Management

Register new citizen
View all citizens
Deactivate citizen

2.Complaint Management

Register waste collection complaint
View complaints by citizen
Update complaint status (OPEN / IN_PROGRESS / CLOSED)
Schedule pickup date

3.Workflow

Citizen registers into system.
Citizen raises complaint.
Complaint is stored in database.
Admin updates complaint status.
Citizen can be deactivated if required.

Output Screenshots:
<img width="1479" height="721" alt="Screenshot 2026-02-19 202208" src="https://github.com/user-attachments/assets/2cc7b270-3f15-4ad4-9929-431d033bbcdf" />
<img width="1496" height="754" alt="Screenshot 2026-02-19 202229" src="https://github.com/user-attachments/assets/2c46d0b8-5ec7-4b39-9afc-52cf0864e5ec" />
<img width="1494" height="732" alt="Screenshot 2026-02-19 202249" src="https://github.com/user-attachments/assets/c6501acd-83b1-4e25-a629-a90155e996ff" />
<img width="1495" height="741" alt="Screenshot 2026-02-19 202318" src="https://github.com/user-attachments/assets/03875a48-8d4f-4529-847a-e1d6f080c77a" />
<img width="1494" height="727" alt="Screenshot 2026-02-19 202406" src="https://github.com/user-attachments/assets/b9b9a178-680b-41ae-8483-b6a0e02dfd6f" />
<img width="1493" height="729" alt="Screenshot 2026-02-19 202441" src="https://github.com/user-attachments/assets/103cdeae-446a-4e2f-b6f3-0fca8d0fbe69" />
<img width="1496" height="731" alt="Screenshot 2026-02-19 202757" src="https://github.com/user-attachments/assets/a056e5a1-7352-4799-a9f6-9b89eaa2b41f" />
<img width="1494" height="731" alt="Screenshot 2026-02-19 202814" src="https://github.com/user-attachments/assets/d839bc5c-e77a-4160-8098-009cfad6c400" />
<img width="1490" height="247" alt="Screenshot 2026-02-19 202830" src="https://github.com/user-attachments/assets/310b57e9-a9d9-4466-875e-4af5e6e7ca98" />
