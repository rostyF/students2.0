import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Group {
    private String groupName;

    //private Student [] students = new Student[10];
    private List<Student> students = new ArrayList<>();

    public Group() {
        super();
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + "\n" +
                ", students sorted by last name: "+ "\n" + sortByLastName() +
                '}';
    }

    public void addStudent(Student student) throws GroupOverflowException{
        if(students.size() == 10) throw new GroupOverflowException("Група переповнена");
        else students.add(student);
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student: students) {
            if(student.getLastName().equals(lastName))
                return student;
        }
        throw new StudentNotFoundException("Студента не знайдено в групі");
    }


    public boolean removeStudentByID(int id){
        for(Student student: students){
            if(student.getId() == id) {
                students.remove(student);
                System.out.println("Студента було видалено");
            }
        }
        return false;
    }


    public String sortByLastName(){
        Student[] resultArray = new Student[students.size()];
        int i=0;
        for(Student student: students){
            resultArray[i] = student;
            i++;
        }

        Arrays.sort(resultArray, new StudentLastNameComparator());
        String result = "";
        for(Student student : resultArray){
            result = result + student + "\n";
        }
        return result;
    }

    public void checkStudentsForUnique(){
        List<Student> array = this.getStudents();
        boolean isClone = false;
        for(int i=0; i<array.size(); i++){
            for(int k=0; k< array.size(); k++){
                if(i==9 && k==9){
                    System.out.println("Повторів немає");
                    break;
                }
                if(i==k) k++;
                if(array.get(i).equals(array.get(k))){
                    System.out.println("Студент " + array.get(i) + "повторюється");
                    isClone = true;
                    break;
                }
                if(isClone == true) break;
            }


        }



    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students);
    }
}