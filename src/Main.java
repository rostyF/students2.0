import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Marston", Gender.MALE, 1111, "GroupName");
        Student student2 = new Student("Maria", "Depp", Gender.FEMALE, 2222, "GroupName");
        Student student3 = new Student("Jake", "Willson1", Gender.MALE, 3333, "GroupName");
        Student student4 = new Student("Jake", "Willson2", Gender.MALE, 3333, "GroupName");
        Student student5 = new Student("Jake", "Willson3", Gender.MALE, 3333, "GroupName");
        Student student6 = new Student("Jake", "Willson4", Gender.MALE, 3333, "GroupName");
        Student student7 = new Student("Jake", "Willson5", Gender.MALE, 3333, "GroupName");
        Student student8 = new Student("Jake", "Willson6", Gender.MALE, 3333, "GroupName");
        Student student9 = new Student("Jake", "Willson7", Gender.MALE, 3333, "GroupName");
        Student student10 = new Student("Jake", "Willson8", Gender.MALE, 3333, "GroupName");
        Group group1 = new Group("GroupOne");
        CreateStudentByConsole test = new CreateStudentByConsole();
        try {
            group1.addStudent(student1);
            group1.addStudent(student2);
            group1.addStudent(student3);
            group1.addStudent(student4);
            group1.addStudent(student5);
            group1.addStudent(student6);
            group1.addStudent(student7);
            group1.addStudent(student8);
            group1.addStudent(student9);
            group1.addStudent(student9);
        }
        catch (GroupOverflowException e){
            e.printStackTrace();
        }
        GroupFileStorage gr = new GroupFileStorage();
        gr.saveGroupToCSV(group1);
        File file = new File("GroupOne.csv");

        Group group2 = new Group();
        try{
            group2 = gr.loadGroupFromCSV(file);

        }
        catch (IOException e){
            e.printStackTrace();
        }
        File file1 = new File("C:/Users/naugh/IdeaProjects/students1");
        System.out.println(group2.toString());

        System.out.println(gr.findFileByGroupName("GroupOne", file1).getName());





    }
}
