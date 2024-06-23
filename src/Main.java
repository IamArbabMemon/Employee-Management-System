import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.Temporal;

public class Main {
    public static void main(String[]args){
        memon.page_2();
    }
}






class memon {
    public static JButton s_b,searchBtn,updateBtn,deleteBtn,resetBtn;
    public static JFrame frame;
    public static JLabel l, l_1, l_2, l_3, l_4, l_5, l_6;
    public static JTextField f1, f2, f3, f4, f5,f6;
    public static EmployeeDAO employeeDAO;

    //public static JCheckBox box;

    public static void page_2(){
        employeeDAO = new EmployeeDAO();
        l = new JLabel("Insert Employee ID: ");
        l.setBounds(20, 0, 700, 200);
        l.setFont(new Font("MV Boli", Font.BOLD, 20));
        l.setVerticalAlignment(JLabel.TOP);


        s_b = new JButton("ADD");
        s_b.setFont(new Font("MV Boli",Font.BOLD,20));
        s_b.setBounds(100, 440, 120, 50);
        s_b.setFocusable(false);

        updateBtn = new JButton("UPDATE");
        updateBtn.setFont(new Font("MV Boli",Font.BOLD,20));
        updateBtn.setBounds(250, 440, 120, 50);
        updateBtn.setFocusable(false);


        deleteBtn = new JButton("DELETE");
        deleteBtn.setFont(new Font("MV Boli",Font.BOLD,20));
        deleteBtn.setBounds(400, 440, 120, 50);
        deleteBtn.setFocusable(false);

        resetBtn = new JButton("RESET");
        resetBtn.setFont(new Font("MV Boli",Font.BOLD,20));
        resetBtn.setBounds(550, 440, 120, 50);
        resetBtn.setFocusable(false);



        searchBtn = new JButton("Search");
        searchBtn.setFont(new Font("MV Boli",Font.BOLD,15));
        searchBtn.setBounds(320, 5, 120, 25);
        searchBtn.setFocusable(false);


        f1 = new JTextField();
        f1.setBounds(180, 90, 200, 25);
        f2 = new JTextField();
        f2.setBounds(180, 150, 200, 25);
        f3 = new JTextField();
        f3.setBounds(180, 210, 200, 25);

        f4 = new JTextField(20);
        f4.setBounds(180, 270, 200, 25);
        f5 = new JTextField(20);
        f5.setBounds(180, 340, 200, 25);

        f6 = new JTextField();
        f6.setBounds(230, 5, 70, 25);


        l_1 = new JLabel("ID : ");
        l_1.setBounds(20, 70, 105, 60);
        l_1.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_2 = new JLabel("Name : ");
        l_2.setBounds(20, 130, 105, 60);
        l_2.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_3 = new JLabel("Age : ");
        l_3.setBounds(20, 190, 105, 60);
        l_3.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_4 = new JLabel("Department : ");
        l_4.setBounds(20, 250, 160, 60);
        l_4.setFont(new Font("MV Boli", Font.BOLD, 20));

        l_5 = new JLabel("Salary : ");
        l_5.setBounds(20, 320, 160, 60);
        l_5.setFont(new Font("MV Boli", Font.BOLD, 20));



        frame = new JFrame("Employee Management System");
        frame.setSize(750, 900);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(f1);
        frame.add(f2);
        frame.add(f6);
        frame.add(f3);
        frame.add(f4);
        frame.add(f5);
        frame.add(l);
        frame.add(s_b);
        frame.add(resetBtn);
        frame.add(searchBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(l_1);
        frame.add(l_2);
        frame.add(l_3);
        frame.add(l_4);
        frame.add(l_5);

        frame.getContentPane().setBackground(new Color(220, 220, 220));
        frame.setLocation(300, 60);
        frame.setVisible(true);

        s_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              employeeDAO.addEmployeeToDB(new Employee(Integer.parseInt(f5.getText()),Integer.parseInt(f3.getText()),f2.getText(),f4.getText()));
            }
        });


        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setText("");
                f2.setText("");
                f3.setText("");
                f4.setText("");
                f5.setText("");
                f6.setText("");
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeDAO.deleteEmployee(Integer.parseInt(f6.getText()));
            }
        });


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = employeeDAO.getEmployeeById(Integer.parseInt(f6.getText()));
                f1.setText(String.valueOf(employee.getId()));
                f2.setText(employee.getName());
                f3.setText(String.valueOf(employee.getAge()));
                f4.setText(employee.getDepartment());
                f5.setText(String.valueOf(employee.getSalary()));
            }
        });


    }

}

