import java.util.Scanner;

public class CreateStudentByConsole {

    public Student createStudent(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть і'мя студента: ");
        String name = in.nextLine();
        System.out.println("Введіть прізвище студента: ");
        String lastName = in.nextLine();
        System.out.println("Введіть стать студента: ");
        Gender gender = Gender.valueOf(in.nextLine());
        System.out.println("Введіть номер залікової книжки студента: ");
        int id = in.nextInt();
        System.out.println("Введіть назву групи: ");
        String groupName = in.nextLine();

        Student student = new Student(name, lastName, gender, id, groupName);
        return student;
    }
}