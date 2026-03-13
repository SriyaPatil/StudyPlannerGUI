# AI Based Study Planner

A Java Swing application that helps students plan their study schedule intelligently. The program allocates study time for each subject based on difficulty and pending chapters.

## Features

- Add multiple subjects with details:
- Subject name
- Difficulty level (1-5)
- Total chapters
- Completed chapters
- Input available study hours for the day
- Automatically generate a study plan with recommended hours per subject
- View subjects and generated plan in a scrollable output area
- Simple and user-friendly GUI built with Java Swing

## How It Works

1. **Calculate Priority**  
   Each subject’s priority = `difficulty × pending chapters`.

2. **Distribute Time**  
   Total available hours are distributed proportionally according to each subject's priority.

Example:

| Subject | Difficulty | Pending Chapters | Priority | Allocated Time (hours) |
|---------|------------|-----------------|---------|----------------------|
| DSA     | 5          | 4               | 20      | 3.85                 |
| Java    | 3          | 2               | 6       | 1.15                 |

## Requirements

- Java JDK 8 or above
- No external libraries required (uses standard Java Swing)

## How to Run

1. Clone or download the repository
2. Open the project in a Java IDE (IntelliJ, Eclipse, NetBeans, etc.)
3. Compile and run `StudyPlannerGUI.java`
4. Enter subject details and available study hours to generate your plan

## Future Enhancements

- Add a daily timetable view
- Save/load study plans
- Export plan to PDF or CSV
- Add progress tracking and notifications
- Improve UI with colors and icons
