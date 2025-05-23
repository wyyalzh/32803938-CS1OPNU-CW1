# 📊 Data Science Data Manager - CW1

## 👤 Student Info

- **Student ID:** 32803938
- **Module:** CS1OPNU - Object-Oriented Programming
- **Coursework:** CW1 - Source Code Submission (Due: 29 May 2025)

---

## 📦 Project Overview

A Java-based data management tool for data scientists to import, analyze, transform, and export structured data (CSV format). The application applies Object-Oriented Programming principles and integrates **three core design patterns**.

---

## 🎯 Key Features

- 📥 Import data from CSV
- 🔄 Filter data using customizable conditions
- 🧠 Analyze data: Mean, Median, Standard Deviation
- 📤 Export filtered dataset to CSV
- 🔔 Notify observers on dataset changes
- ✅ Modular, maintainable, and testable structure

---

## 🧠 Design Patterns Implemented

| Pattern    | Class(es) Used                             | Purpose                                                   |
|------------|---------------------------------------------|-----------------------------------------------------------|
| Singleton  | `DataManager`                               | Manage shared global state and active dataset             |
| Factory    | `TransformerFactory`, `Transformer`         | Dynamically create data transformation components         |
| Observer   | `Observer`, `ConsoleObserver`               | Notify when dataset is updated                            |

---

## 📂 Project Structure

src/
├── datamanager/
│ ├── Main.java # Entry point
│ ├── core/ # DataManager (Singleton)
│ ├── io/ # CSVImporter / Exporter
│ ├── model/ # DataRecord, DataSet
│ ├── observer/ # Observer interface & implementation
│ ├── transform/ # DataTransformer, filters, factory
│ ├── util/ # StatCalculator for analysis
│ └── test/ # JUnit tests for StatCalculator
sample.csv # Sample input file
exported.csv # Output after filtering
README.md # This file
---

## 🚀 How to Run

1. Place your input file `sample.csv` in the project root directory.
2. Run `Main.java` from Eclipse.
3. Console output includes:
   - Record count
   - Filtered dataset (e.g., `age > 26`)
   - Mean / Median / Std Dev of a column
   - Export confirmation
   - Observer notification

---

## ✅ Sample Console Output

Welcome to the Data Science Data Manager!
DataManager initialized.
Imported records: 3
Filtered records (age > 26): 2
Factory filtered (age > 26): 2
🔔 Observer: Data has been updated!
📊 Statistics on field 'age':
Mean: 27.666666666666668
Median: 28.0
Std Dev: 2.0548046676563256
✅ Export completed: exported.csv
---

## 🧪 Unit Testing

JUnit 4 tests were created for:

- `StatCalculatorTest.java`
  - ✅ Mean
  - ✅ Median
  - ✅ Std Deviation (optional)

To run: Right-click test class → Run As → JUnit Test

---

## 📤 Files to Include in Submission

- `src/` folder (all source code)
- `sample.csv` (test input file)
- `exported.csv` (generated output file)
- `README.md` (this file)
- `.project`, `.classpath` (optional for Eclipse)

> 📦 Submit everything as `32803938_CS1OPNU_CW1.zip`

---

## ✍️ Notes

- All three required design patterns are clearly implemented and tested.
- Application runs through `Main.java` and covers full data pipeline.
- Code is modular, testable, and well-structured for evaluation.
