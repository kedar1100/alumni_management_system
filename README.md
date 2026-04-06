# 🎓 Alumni Management System

A full-stack web application built with **Spring Boot** and **Thymeleaf** that helps institutions manage their alumni network. Alumni can register, create profiles, browse the directory, attend events, post jobs, and stay updated with announcements.

---

## 📸 Pages

| Page | URL | Description |
|---|---|---|
| Home | `/` | Landing page |
| Register | `/register` | Create an account |
| Login | `/login` | Login to your account |
| Dashboard | `/dashboard` | Overview of network activity |
| Directory | `/directory` | Browse and search alumni |
| Events | `/events` | View and register for events |
| Jobs | `/jobs` | Browse job postings |
| Announcements | `/announcements` | Latest news and updates |
| Create Profile | `/profile/create` | Build your alumni profile |
| Admin Panel | `/admin` | Password-protected admin area |

---

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.2**
- **Spring Data JPA** (Hibernate)
- **Spring Security**
- **MySQL**
- **Maven**

### Frontend
- **Thymeleaf**
- **HTML5 / CSS3**
- **Vanilla JavaScript**
- **Fetch API**

---

## 📁 Project Structure

```
alumni-management/
├── src/main/java/com/alumni/
│   ├── config/
│   │   └── SecurityConfig.java
│   ├── controller/
│   │   ├── PageController.java
│   │   ├── UserController.java
│   │   ├── AlumniProfileController.java
│   │   ├── EventController.java
│   │   ├── JobPostController.java
│   │   └── AnnouncementController.java
│   ├── model/
│   │   ├── User.java
│   │   ├── AlumniProfile.java
│   │   ├── Event.java
│   │   ├── EventRegistration.java
│   │   ├── JobPost.java
│   │   └── Announcement.java
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── AlumniProfileRepository.java
│   │   ├── EventRepository.java
│   │   ├── EventRegistrationRepository.java
│   │   ├── JobPostRepository.java
│   │   └── AnnouncementRepository.java
│   ├── service/
│   │   ├── UserService.java
│   │   ├── AlumniProfileService.java
│   │   ├── EventService.java
│   │   ├── JobPostService.java
│   │   └── AnnouncementService.java
│   └── AlumniManagementApplication.java
├── src/main/resources/
│   ├── static/css/
│   │   └── style.css
│   ├── templates/
│   │   ├── home.html
│   │   ├── login.html
│   │   ├── register.html
│   │   ├── dashboard.html
│   │   ├── directory.html
│   │   ├── events.html
│   │   ├── jobs.html
│   │   ├── announcements.html
│   │   ├── create-profile.html
│   │   └── admin.html
│   └── application.properties
└── pom.xml
```

---

## 🗄️ Database Schema

```sql
users
  ├── id, email, password, role, created_at

alumni_profiles
  ├── id, user_id, first_name, last_name, phone
  ├── gender, date_of_birth, batch_year, department
  ├── degree, current_company, current_role
  ├── location, linkedin_url

events
  ├── id, title, description, event_date
  ├── location, created_by, created_at

event_registrations
  ├── id, event_id, alumni_id, registered_at

job_posts
  ├── id, title, company, location
  ├── description, posted_by, posted_at

announcements
  ├── id, title, content, posted_by, posted_at
```

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 17+
- Maven
- MySQL 8.0+
- VS Code (with Java + Spring Boot extensions)

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/alumni-management.git
cd alumni-management
```

### 2. Create MySQL Database
```sql
CREATE DATABASE IF NOT EXISTS alumni_db;
```

### 3. Configure `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/alumni_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

### 4. Run the Application
```bash
.\mvnw spring-boot:run        # Windows
./mvnw spring-boot:run        # Mac/Linux
```

### 5. Open in Browser
```
http://localhost:8080
```

---

## 📡 REST API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login user |

### Alumni Profiles
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/alumni/profile/{userId}` | Create profile |
| GET | `/api/alumni/profile/{userId}` | Get profile by user ID |
| GET | `/api/alumni/all` | Get all alumni |
| PUT | `/api/alumni/profile/{userId}` | Update profile |

### Events
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/events/create/{userId}` | Create event |
| GET | `/api/events/all` | Get all events |
| GET | `/api/events/{id}` | Get single event |
| POST | `/api/events/{eventId}/register/{alumniId}` | Register for event |
| DELETE | `/api/events/{id}` | Delete event |

### Jobs
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/jobs/create/{userId}` | Post a job |
| GET | `/api/jobs/all` | Get all jobs |
| GET | `/api/jobs/{id}` | Get single job |
| GET | `/api/jobs/search/company/{company}` | Search by company |
| GET | `/api/jobs/search/location/{location}` | Search by location |
| DELETE | `/api/jobs/{id}` | Delete job |

### Announcements
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/announcements/create/{userId}` | Post announcement |
| GET | `/api/announcements/all` | Get all announcements |
| GET | `/api/announcements/{id}` | Get single announcement |
| DELETE | `/api/announcements/{id}` | Delete announcement |

---

## 👥 User Roles

| Role | Access |
|---|---|
| **Guest** | Home page, browse directory |
| **Alumni** | Dashboard, profile, events, jobs, announcements |
| **Admin** | Full access + admin panel (password protected) |

---

## ✨ Features

- ✅ User registration and login
- ✅ Alumni profile creation and management
- ✅ Alumni directory with search and filters (by name, batch, department)
- ✅ Events management with registration
- ✅ Job board with search by company and location
- ✅ Announcements/news feed
- ✅ Password-protected admin panel
- ✅ Session management via localStorage
- ✅ Responsive UI

---

## 🔑 Admin Access

Visit `/admin` and enter the admin password to access the admin panel.

Default password: `alumni@admin123`

> ⚠️ Change the admin password in `admin.html` before deploying!


---

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👨‍💻 Author

Built with ❤️ by **Kedar and Team**
