package org.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeObjectDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Ravi", 31);
        byte[] bytes = getSearializedBytes(student1);
        Student student2 = deserializeObject(bytes);
        System.out.println(student2);
    }


    public static byte[] getSearializedBytes(Student student1) throws IOException{
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);) {
            out.writeObject(student1);
            out.flush();
            //Serialized byte Array
            return bos.toByteArray();
        }
    }

    private static Student deserializeObject(byte[] bytes) throws ClassNotFoundException, IOException {
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
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
