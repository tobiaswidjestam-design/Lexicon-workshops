# Lexicon Workshops — Java exercises

Java practice from the Lexicon Full Stack Developer programme: language basics, collections,
OOP and a weekly workshop series. Built with Maven (Java 26) and JUnit 5.

The `*.drawio.pdf` files in the root are the flowcharts and pseudocode I wrote before the
code — plan first, then implement.

## What's in here

| Folder | Contents |
|---|---|
| `exercises/exercise1` | 13 first-step programs: FizzBuzz, leap year, grade calculator, temperature and time converters, value swapper, guess-the-number, weekday checker |
| `exercises/exercise2` | 13 string and number exercises: palindrome checker, password generator, email slicer, initials, word counter and reverser, string stats, dice statistics, power table |
| `exercises/collections` | 17 collection exercises (1–17): lists, sets, maps and queues — shopping list, phone book, word frequency, merge without duplicates, two sum, top 3 most frequent |
| `exercises/oop_exercise_thebank` | Inheritance: an `Account` base class with `SavingsAccount` and `CheckingAccount` subclasses |
| `workshops/week41` | `CafeApp` and `Order` — totals, VAT and discount calculation |
| `workshops/week42` | Converter app — `LengthConverter` and `SpeedConverter` with a shared data-storage class |
| `workshops/week43` | `ContactApp` — a contact management CLI backed by a `HashSet` |
| `workshops/week44` | `Vehicle` — a class that validates its own fields |
| `workshops/week45` | `Fruit` — a `Product` subclass, built on a feature branch and merged through a pull request |

56 Java files in total.

## Running it

```bash
mvn compile                                   # compile everything
java -cp target/classes se.lexicon.exercises.exercise1.FizzBuzz
java -cp target/classes se.lexicon.workshops.week43.ContactApp
```

Requires JDK 26 (or edit `maven.compiler.source` in `pom.xml` to your version).

JUnit 5 is already configured in `pom.xml`; the tests come with the workshops ahead.

## Appendix: Git commands I used

- `mkdir <folder>` — creates a new directory in the terminal.
- `git init` — initializes a new local Git repository.
- `git --version` — verifies the installed Git version.
- `echo "text" > <file>` — creates a file with text, or overwrites an existing one.
- `git clone <url>` — creates a local copy of a remote repository.
- `git add .` — adds all changes to the staging area.
- `git commit -m "message"` — saves a new commit with your changes.
- `git remote add origin <url>` — adds a name (origin) for a remote repository.
- `git push` — uploads your commits to the remote repository.
