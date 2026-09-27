package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Double.NaN;
import static java.lang.Double.sum;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = null;
        for (Student student : students) {
            if (oldest == null) {
                oldest = student;
            } else if (oldest.getAge() < student.getAge()) {
                oldest = student;
            }
        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int i = 0;
        for (Student student : students) {
            if (student.getAge() >= 18) i++;
        }
        return i;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0) {return NaN;}
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }

        return sum/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students) {
            if (student.getName() == name) {
                return student;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, new StudentComparator());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student student : students) {
            if (student.getGrade() < 15) {continue;}
            System.out.println(student);
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                return true;
            }
        }

        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; i++) {
                if (students[i].getName() == students[j].getName()) {
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        System.out.println("No duplicates were found");
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updatedStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }
        updatedStudents[students.length] = newStudent;
        return students;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student s1 = new Student(1, "Student 1", 17, 19);
        Student s2 = new Student(2, "Student 2", 20, 10);
        Student s3 = new Student(3, "Student 3", 15, 15);
        Student s4 = new Student(4, "Student 4", 19, 4);
        Student s5 = new Student(5, "Student 5", 18, 17);

        Student[] arr = {s1, s2, s3, s4, s5};


        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("== Oldest Student ==");
        System.out.println(findOldest(arr));


        // 3) Count adults
        System.out.println("Adults number: " + countAdults(arr));


        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));


        // 5) Find by name
        System.out.println("Searching for Student 1: \n" + findStudentByName(arr, "Student 1"));


        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        updateGrade(arr, 4, 8);
        System.out.println("\nUpdated id=4? ");
        System.out.println(findStudentByName(arr, "Student 4"));

        // 9) Duplicate names
        hasDuplicateNames(arr);


        // 10) Append new student
        Student s6 = new Student(6, "Student 4", 16, 12);
        arr = appendStudent(arr, s6);
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

    }
}


class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getGrade() - s2.getGrade();
    }
}
