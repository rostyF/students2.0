public class CSVStringConverter implements StringConvertor{

    public String toStringRepresentation(Student student) {
        StringBuilder sb = new StringBuilder();

        sb.append(student.getName());
        sb.append(",");
        sb.append(student.getLastName());
        sb.append(",");
        sb.append(student.getGender().toString());
        sb.append(",");
        sb.append(student.getId());
        sb.append(",");
        sb.append(student.getGroupName());
        sb.append(";");

        return (sb == null) ? null : sb.toString();

    }

    public Student fromStringRepresentation(String str) {

        String[] arrStudent = str.split(",");
        Student student = new Student(arrStudent[0], arrStudent[1], setStudentGender(arrStudent[2]), Integer.parseInt(arrStudent[3]), arrStudent[4]);

        return student;
    }



    private Gender setStudentGender(String gender) {

        for (int i = 0; i < Gender.values().length; i++) {
            if (Gender.values()[i].toString().equals(gender))
                return Gender.values()[i];
        }
        return null;
    }



    @Override
    public String toString() {
        return "CSVStringConverter [getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
    }
}