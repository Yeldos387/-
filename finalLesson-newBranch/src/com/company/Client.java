package com.company;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args, ObjectOutputStream out, ObjectInputStream in) {
        Students students = new Students("newName", "NewSurname", 1789);
        DAO dao = new DaoImpl();
        dao.addStudent(students);

        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 1789);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData data;
            while (true) {
                System.out.println("1 ADD STUDENT");
                System.out.println("2 LIST STUDENTS");
                System.out.println("0 exit");
                String choice = scanner.next();
                if (choice.equals("1")) {
                    data = new PackageData("1");
                    out.writeObject(data);
                    PackageData list;
                    if ((list = (PackageData) in.readObject()) !=null){
                        System.out.println(list.getStudents());
                    }
                    out.reset();
                } else if (choice.equalsIgnoreCase("0")){
                    System.exit(0);
                }else if (choice.equalsIgnoreCase("2")){
                    System.out.println("age: ");
                    int age = scanner.nextInt();
                    System.out.println("name ");
                    String name = scanner.next();
                    System.out.println("surname ");
                    String surname = scanner.next();
                    Students students1 = new Students(age,name,surname);
                    data = new PackageData("2",students);
                    out.writeObject(data);
                    out.reset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

