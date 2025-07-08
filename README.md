#  2048 Game – Spring Boot + Java (Console & Web UI)

A Java-based implementation of the popular 2048 puzzle game using Spring Boot.  
Play the game via a beautiful Thymeleaf-powered UI or using a simple console version.

---

##  Features

-  4x4 dynamic grid with tile merging logic
-  Full game logic implemented in service layer (`GameService`)
-  Random tile (2/4) generation after each move
-  Directional movement: UP, DOWN, LEFT, RIGHT
-  Web UI with Thymeleaf (optional)
-  Console version (for basic Java)
-  Reset game button
-  Clean code structure using MVC

---

## 🛠️ Technologies Used

| Layer      | Tech                      |
|------------|---------------------------|
| Backend    | Java 17, Spring Boot      |
| Frontend   | Thymeleaf (HTML/CSS)      |
| Build Tool | Maven                     |
| IDE        | IntelliJ                  |

---

## 📂 Project Structure

game2048/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com.game2048/
│ │ │ ├── controller/
│ │ │ │ └── GameController.java
│ │ │ ├── service/
│ │ │ │ └── GameService.java
│ │ │ └── Game2048Application.java
│ │ └── resources/
│ │ ├── templates/
│ │ │ └── index.html
│ │ ├── static/
│ │ │ └── styles.css
│ │ └── application.properties
└── README.md

---

##  How to Run the Web Version

### 1 Clone the Repository

git clone https:[//github.com/your-username/game2048.git](https://github.com/pradeepkumar823/game2048)
cd game2048

2️. Run the App
./mvnw spring-boot:run

3️. Open in Browser
http://localhost:8080/
