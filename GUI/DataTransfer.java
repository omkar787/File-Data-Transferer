import java.io.*;
public class DataTransfer {
    File in;
    File out;

    FileReader input = null;
    FileWriter output = null;

    public void doit(String a, String b) throws IOException {
        try {
            in = new File(a);
            out = new File(b);
            input = new FileReader(in);
            output = new FileWriter(out);
            int ch;
            while ((ch = input.read()) != -1) {
                System.out.println(ch);
                output.write(ch);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            input.close();
            output.close();
        }
    }


}
