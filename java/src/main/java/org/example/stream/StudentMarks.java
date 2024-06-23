package org.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

import org.example.stream.model.Student;
import org.example.stream.model.Subject;

public class StudentMarks {
    static record StudentRecord(Student student, int mathMarks) {}

    public static void main(String[] args) {
        Optional<StudentRecord> studentWithMarks = getStudents().stream()
                .filter(StudentMarks::hasMathSubject)
                .map(student -> new StudentRecord(student, getMathMarks(student)))
                .max(Comparator.comparingInt(StudentRecord::mathMarks));

        studentWithMarks.ifPresentOrElse((studentRecord -> {
            System.out.print("Student[" + studentRecord.student().name());
            System.out.println(": Marks:" + studentRecord.mathMarks()+"]");

        }), ()->{
            System.out.println("No Student found with math subject");
        });



    }
    
    static int getMathMarks(Student student) {
        return student.subjects().stream()
                .filter(subject-> "Math".equals(subject.name()))
                .findFirst()
                .get()
                .marks();
    }

    static boolean hasMathSubject(Student student) {
        return student.subjects().stream().anyMatch((subject -> "Math".equals(subject.name())));
    }


    static List<Student> getStudents() {
        return  Arrays.asList(
                new Student("Ram",
                        Arrays.asList(
                                new Subject("Math", 70),
                                new Subject("Physics", 80),
                                new Subject("Chemistry", 80)
                        )
                ),
                new Student("Shyam",
                        Arrays.asList(
                                new Subject("Physics", 80),
                                new Subject("Chemistry", 80)
                        )
                ),
                new Student("Mohan",
                        Arrays.asList(
                                new Subject("Math", 80),
                                new Subject("Physics", 80),
                                new Subject("Chemistry", 80)
                        )
                ),
                new Student("Sohan",
                        Arrays.asList(
                                new Subject("Physics", 80),
                                new Subject("Chemistry", 80)
                        )
                )
        );
    }
}
