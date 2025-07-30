# 🧮 Task Manager

Tas manager is an Android application that allows users to add tasks by providing a title and description. All tasks are saved to a local database and displayed in a scrollable list. When the app starts, it loads tasks from the database in the background to ensure a smooth experience. Users can tap on any task to view its full details on a separate screen.

## 🚀 Features

- Java-based structure :
- Two simple activities with state persistence
- Designed a new layout for tasks
- Store data in a local database using SQLite


## 🛠️ Built With

- **Android Studio**
- **Java**
- **XML Layouts**
- **State Persistence**
- **Data Persistence SQLite**

## 📁 Project Structure
```
app/
├── src/
│ ├── main/
│ │ │ └── manifest/
│ │ └── AndroidManifest.xml
│ │ ├── java/
│ │ │ └── pt/pedrorocha/android/android-task-manager/
│ │ │ │ └── model/
│ │ │ │ │ └── Task.class 
│ │ │ │ │ └── Task.class
│ │ │ │ └── view/
│ │ │ │ │ └── MainActivity.class
│ │ │ │ │ └── NewTaskActivity.class
│ │ │ │ │ └── TaskAdapter.class
│ │ ├── res/
│ │ │ ├── layout/
│ │ │ │ └── activity_main.xml
│ │ │ │ └── activity_new_task.xml
│ │ │ │ └── card_layout.xml
│ │ │ └── values/
│ │ │ │ └── strings.xml

```

## 🧠 Learning Goals

- User input handling
- Data persistence with a local database
- Background data loading
- Dynamic UI updates.
- Navigation between two Activities

## 📱 Screenshots

## 🔧 How to Run

1. Clone the repository:
   ```bash
   git clone git@github.com:PedroRocha84/android-task-reminder.git

2. Open the project in Android Studio
3. Launch an emulator or connect a device
4. Click Run (Shift + F10)
