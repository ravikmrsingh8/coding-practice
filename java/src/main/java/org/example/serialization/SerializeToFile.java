package org.example.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeToFile {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Ravi", 31);
        serializeToFile(student1);
        Student student2 = deserializeObject();
        System.out.println(student2);
    }


    public static void serializeToFile(Student student1) throws IOException{
        try(FileOutputStream fos = new FileOutputStream("student.ser");
            ObjectOutput out = new ObjectOutputStream(fos);) {
            out.writeObject(student1);
            out.flush();
        }
    }

    public static Student deserializeObject() throws ClassNotFoundException, IOException {
        try(FileInputStream inputStream = new FileInputStream("student.ser");
            ObjectInput input = new ObjectInputStream(inputStream)) {
            return (Student)input.readObject();
        }
    }



    private static class Student implements Serializable {
        private static long serialVersionUID = 2L;
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student[" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ']';
        }
    }
}
