package bai3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String pathFile, List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String pathFile){
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pathFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("student.txt", students);
        List<Student> studentList = readDataFromFile("student.txt");
        for (Student student: studentList){
            System.out.println(student);
        }
    }

}
