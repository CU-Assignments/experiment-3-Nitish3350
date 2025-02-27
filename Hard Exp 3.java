import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class UniversityEnrollmentSystem {
    private static final int MAX_ENROLLMENT = 2;
    private Map<String, List<String>> courses = new HashMap<>();
    private Map<String, String> prerequisites = new HashMap<>();
    private Map<String, List<String>> studentEnrollments = new HashMap<>();

    public UniversityEnrollmentSystem() {
        prerequisites.put("Advanced Java", "Core Java");
        courses.put("Advanced Java", new ArrayList<>());
    }

    public void enrollStudent(String student, String course, String completedCourse) throws CourseFullException, PrerequisiteNotMetException {
        if (prerequisites.containsKey(course) && !prerequisites.get(course).equals(completedCourse)) {
            throw new PrerequisiteNotMetException("Error: PrerequisiteNotMetException - Complete " + prerequisites.get(course) + " before enrolling in " + course + ".");
        }
        
        List<String> enrolledStudents = courses.get(course);
        if (enrolledStudents.size() >= MAX_ENROLLMENT) {
            throw new CourseFullException("Error: CourseFullException - " + course + " is already full.");
        }
        
        enrolledStudents.add(student);
        studentEnrollments.putIfAbsent(student, new ArrayList<>());
        studentEnrollments.get(student).add(course);
        System.out.println(student + " successfully enrolled in " + course);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UniversityEnrollmentSystem system = new UniversityEnrollmentSystem();

        try {
            System.out.print("Enter Student Name: ");
            String student = scanner.nextLine();
            System.out.print("Enroll in Course: ");
            String course = scanner.nextLine();
            System.out.print("Completed Prerequisite (if any): ");
            String completedCourse = scanner.nextLine();
            
            system.enrollStudent(student, course, completedCourse);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
