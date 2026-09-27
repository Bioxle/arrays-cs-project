package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        registeredCourses = addCourse(registeredCourses, 2000);
        printRegisteredCourses(registeredCourses);
        System.out.println(hasCourse(registeredCourses, 2000));
    }

    public static int[] addCourse(int[] courses, int courseNumber) {
        int[] updatedCourses = new int[courses.length + 1];

        for (int i = 0; i < courses.length; i++) {
            updatedCourses[i] = courses[i];
        }

        updatedCourses[courses.length] = courseNumber;
        return updatedCourses;
    }

    public static void printRegisteredCourses(int[] courses) {
        System.out.println("Registered Courses IDs: ");
        for (int cours : courses) {
            System.out.println(cours + ", ");
        }
    }

    public static boolean hasCourse(int[] courses, int course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == course) {
                return true;
            }
        }

        return false;
    }
}
