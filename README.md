# Tombola / Bingo Ticket Generator 🎟️

**🇵🇱 Wersja polska poniżej ⬇️**

---

## 🇬🇧 English

### About this project
A Java-based application that generates mathematically correct
and fully unique tickets for the Tombola / Bingo Game.
The project focuses on clean **Object-Oriented Programming** architecture,
separating the core logic, data representation, and execution.

### Tombola Ticket Generation Rules

#### The algorithm adheres to the following structural and logical constraints:
- **Grid Structure:** The ticket is formatted as a 3x9 grid (3 rows and 9 columns).
- **Column Ranges:** Each column represents a specific range of tens
  (e.g. column 0 contains numbers 1-10, column 1 contains 11-20, and so on).
- **Row Limit:** Each row must contain exactly 5 numbers.
- **Total Number Count:** There must be exatly 15 unique numbers marked across
  the entire ticket.
- **Column Distribution:**
  - A minimum of 5 distinct columns must be populated.
  - If more than 5 columns are utilized, some columns will not have
    all of their rows filled (always maintaining the strict limit
    of exactly 15 numbers per ticket).
- **No sorting in column:** Values within individual columns do not need to be sorted.
  For example, reading a column from top to bottom could yield
  a valid sequence like `17, 11, 19`.

### Features
- **Custom Constraints:** Distributes numbers (1-90)
  across a 9-column grid with accurately calculated **blank/rejected fields**.
- **Uniqueness Guarantee:** Ensures no duplicate tickets are generated
  by leveraging `HashSet` with overridden `equals()` and `hashCode()`.
- **High Performance:** Uses `SecureRandom` for cryptographically strong
  randomness and avoids unnecessary object creation for optimal
  generation speed.

---

## 🇵🇱 Polski

### O projekcie
Aplikacja napisana w Javie, służąca do generowania poprawnych matematycznie
i całkowicie unikatowych kuponów do gry Tombola / Bingo.
Projekt stawia na czystą architekturę programowania obiektowego (OOP),
rozdzielając logikę losowania, reprezentację danych i punkt wejścia programu.

### Zasady Generowania Kuponu do gry Tombola

#### Algorytm ściśle trzyma się następujących założeń strukturalnych i logicznych:
- **Struktura siatki:** Kupon przyjmuje format macierzy 3x9 (3 wiersze i 9 kolumn).
- **Zakresy wartości w kolumnach:** Każda kolumna odpowiada kolejnemu przedziałowi dziesiątek
  (np. kolumna 0 to liczby z zakresu 1-10, kolumna 1 to 11-20, itd.).
- **Limit na wiersz:** W każdym z wierszy musi znajdować się dokładnie 5 wartości.
- **Łączna pula liczb:** Na całym kuponie musi być zaznaczone dokładnie 15 unikalnych liczb.
- **Rozkład w kolumnach:**
    - Należy użyć co najmniej 5 różnych kolumn.
    - Dopuszcza się wykorzystanie większej liczby kolumn - w takim przypadku
      wybrane kolumny nie będą miały wypełnionych wszystkich wierszy (z zachowaniem
      bezwzględnego warunku 15 liczb na całym kuponie).
- **Brak konieczności sortowania w kolumnie:** Wartości w poszczególnych kolumnach nie muszą być posortowane.
  Oznacza to, że czytając wartości w danej kolumnie od góry do dołu, poprawną sekwencją jest np. `17, 11, 19`.

### Główne funkcje
- **Zasady losowania:** Rozmieszcza liczby (1-90) na siatce 9-kolumnowej,
  z odpowiednio wyliczonymi pustymi polami.
- **Gwarancja unikalności:** Zapobiega generowaniu powtarzających się kuponów
  dzięki użyciu `HashSet` z nadpisanymi metodami `equals()` i `hashCode()`.
- **Wydajność:** Wykorzystuje `SecureRandom` do zaawansowanego losowania
  i optymalizuje tworzenie obiektów dla szybkiego czasu wykonania.