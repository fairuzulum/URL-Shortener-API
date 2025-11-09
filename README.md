# 🔗 Shortify — URL Shortener API (Spring Boot)

A simple URL shortener backend built with **Java + Spring Boot + JPA**.  
You can shorten URLs, redirect them, and track visit statistics.

---

## Features
- Shorten long URLs into short, shareable links
- Redirect users to the original URL
- View detailed statistics (visit count, created date)
- Clean JSON error handling
- Simple and lightweight architecture

---

## Setup & Run

### Clone this repo
```bash
git clone https://github.com/fairuzulum/URL-Shortener-API.git
cd shortify
```

### Build & run
```bash
mvn spring-boot:run
```

### Access the app
Base URL:
```
http://localhost:8080
```

---

## API Endpoints

### Shorten a URL
**POST** `/api/shorten`
```json
{
  "originalUrl": "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
}
```

**Response**
```json
{
  "shortUrl": "http://localhost:8080/s/WYTnJD",
  "originalUrl": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
  "createdAt": "2025-11-09T00:52:00.123",
  "visitCount": 0
}
```

---

### Redirect to original URL
**GET** `/s/{shortCode}`  
Redirects user to the original URL

Example:
```
GET http://localhost:8080/s/WYTnJD
```
Redirects to  
`https://www.youtube.com/watch?v=dQw4w9WgXcQ`

---

### Get URL Info
**GET** `/api/info/{shortCode}`
Example Response:
```json
{
  "shortUrl": "http://localhost:8080/s/WYTnJD",
  "originalUrl": "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
  "createdAt": "2025-11-09T00:52:00.123",
  "visitCount": 5
}
```

---

### Error Example
```json
{
  "status": 404,
  "message": "Short code not found: abcxyz",
  "timestamp": "2025-11-09T00:45:31.532"
}
```

---

## Example Flow

1️⃣ POST `/api/shorten` → get short URL  
2️⃣ Access `/s/{code}` → redirect to original URL  
3️⃣ GET `/api/info/{code}` → get stats

---


