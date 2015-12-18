package robert;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by snyder on 2015-05-21.
 */
public class EmployeeDemo extends JFrame{
    private final JTextField firstNameField = new JTextField();
    private final JTextField lastNameField = new JTextField();
    private final JTextField employeeCodeField = new JTextField();
    private final JTextField designationField = new JTextField();

    public EmployeeDemo(){
        super("Employee Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        AddLabeledTextBox(employeeCodeField, "ID:");
        AddLabeledTextBox(designationField, "Designator:");
        AddLabeledTextBox(firstNameField, "First Name:");
        AddLabeledTextBox(lastNameField, "Last Name:");

        pack();
    }
    private void AddLabeledTextBox(JTextField field, String label){
        System.out.println("Adding " + label + "to the panel");

        add(new JLabel(label));
        add(field);
    }

    public static void main(final String... args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeDemo demo = new EmployeeDemo();
            demo.init();
            demo.setVisible(true);
        });
    }

    private void init() {
        String url = "http://localhost/RestWebService/employee";
        String charset = java.nio.charset.StandardCharsets.UTF_8.name();


        try {
            String query;
            query = String.format("id=%s", URLEncoder.encode("9", charset));
            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            String response = convertStreamToString(connection.getInputStream());
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeCodeField.setText("234");
        designationField.setText("Mr");
        firstNameField.setText("Robert");
        lastNameField.setText("Snyder");
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
