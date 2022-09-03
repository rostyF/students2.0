import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GroupFileStorage {

    public void saveGroupToCSV(Group gr) {
        List<Student> students = gr.getStudents();
        CSVStringConverter cnvrt = new CSVStringConverter();
        String fileName = gr.getGroupName() + ".csv";
        File fileOut = new File(fileName);


        for (int i = 0; i < students.size(); i++) {
            String csv = cnvrt.toStringRepresentation(students.get(i)) + "\n";

            try {
                saveStringToFile(csv, fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void saveStringToFile(String text, File file) throws IOException {
        try (Writer writer = new FileWriter(file, true)) {
            writer.write(text);
        } catch (IOException e) {
            throw e;
        }
    }

    public Group loadGroupFromCSV(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String temp = "";
            Group result = new Group();
            CSVStringConverter cnvrt = new CSVStringConverter();
            for (; ; ) {
                temp = br.readLine();
                if (temp == null) {
                    break;
                }
                if(result.getStudents().size() == 10){
                    System.out.println("Група переповнена");
                    break;
                }
                try {
                    result.addStudent(cnvrt.fromStringRepresentation(temp));
                } catch (GroupOverflowException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    public File findFileByGroupName(String groupName, File workFolder){
        File [] files = workFolder.listFiles();
        for(int i=0;i<files.length; i++){
            if(files[i].isFile()){
                if(files[i].getName().contains(groupName)){
                    return files[i];

                }
            }
        }
        System.out.println("Група не знайдена");
        return null;
    }
}