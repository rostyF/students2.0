import java.util.Arrays;

public class Group {
    private String groupName;

    private Student [] students = new Student[10];

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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
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
        Integer index = getArrayIndex();
        if(index == null) throw new GroupOverflowException("Група переповнена");
        students[index] = student;
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        Integer index = getStudentIndex(lastName);
        if (index == null) throw new StudentNotFoundException("Такого студента в групі немає");
        return students[index];
    }

    private Integer getStudentIndex(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName() != null && students[i].getLastName().equals(lastName)) return i;
        }
        return null;
    }

    public boolean removeStudentByID(int id){
        for(int i=0; i< students.length; i++){
            if(students[i] == null) i++;
            else if(students[i].getId() == id){
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    private Integer getArrayIndex(){
        for(int i=0; i< students.length; i++){
            if (students[i] == null) return i;
        }
        return null;
    }

    public String sortByLastName(){
        Student[] resultArray;
        resultArray = students;
        Arrays.sort(resultArray, new StudentLastNameComparator());
        String result = "";
        for(Student student : resultArray){
            result = result + student + "\n";
        }
        return result;
    }


}