import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Marston", Gender.MALE, 1111, "GroupName");
        Student student2 = new Student("Maria", "Depp", Gender.FEMALE, 2222, "GroupName");
        Student student3 = new Student("Jake", "Abraham", Gender.MALE, 3333, "GroupName");
        Student student4 = new Student("Jake", "Willson2", Gender.MALE, 3333, "GroupName");
        Student student5 = new Student("Jake", "Willson3", Gender.MALE, 3333, "GroupName");
        Student student6 = new Student("Jake", "Willson4", Gender.MALE, 3333, "GroupName");
        Student student7 = new Student("Jake", "Willson5", Gender.MALE, 3333, "GroupName");
        Student student8 = new Student("Jake", "Willson6", Gender.MALE, 3333, "GroupName");
        Student student9 = new Student("Jake", "Willson7", Gender.MALE, 3333, "GroupName");
        Student student10 = new Student("Jake", "Willson8", Gender.MALE, 3333, "GroupName");
        Group group1 = new Group("GroupOne");
        //CreateStudentByConsole test = new CreateStudentByConsole();
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
            group1.addStudent(student10);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        System.out.println(group1.getStudents());
        System.out.println(group1.sortByLastName());
        createArrayList();



        /* GroupFileStorage gr = new GroupFileStorage();
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

        group1.checkStudentsForUnique();




*/
    }

    public static void createArrayList(){
        List<Integer> myArray = new ArrayList<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.add(7);
        myArray.add(8);
        myArray.add(9);
        myArray.add(10);

        myArray.remove(0);
        myArray.remove(myArray.size() -1);
        myArray.remove(myArray.size() -1);
        System.out.println(myArray);

    }

    }

