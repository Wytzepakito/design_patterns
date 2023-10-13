import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class MementoEverydayDemo {

    private static Employee deserialize() {
        Employee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("G:\\Scripts\\Java\\design_patterns_pluralsight\\memento_pattern\\memento_pattern\\temp.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return emp;
    }

    private static void serialize(Employee emp) {
        try {
            FileOutputStream fileOut = new FileOutputStream("G:\\Scripts\\Java\\design_patterns_pluralsight\\memento_pattern\\memento_pattern\\temp.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    public static void main(String args[]) {
        Employee emp = new Employee();
        emp.setName("Bryan Hansen");
        emp.setAddress("111 E Code Street");
        emp.setPhone("888-555-1212");

        serialize(emp);


        Employee newEmp = deserialize();

        System.out.println(newEmp.getName());
    }



}