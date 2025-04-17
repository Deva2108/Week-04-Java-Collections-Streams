import java.util.*;

abstract class CourseType {
    String name;
    CourseType(String name) { this.name = name; }
}

class ExamCourse extends CourseType {
    ExamCourse(String name) { super(name); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String name) { super(name); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String name) { super(name); }
}

class Course<T extends CourseType> {
    T courseType;
    Course(T courseType) { this.courseType = courseType; }
    static void showCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) System.out.println(course.name);
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        List<CourseType> courses = new ArrayList<>();
        courses.add(new ExamCourse("Math Exam"));
        courses.add(new AssignmentCourse("Physics Assignment"));
        courses.add(new ResearchCourse("AI Research"));

        Course.showCourses(courses);
    }
}
