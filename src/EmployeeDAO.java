import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeDAO {
   private Connection connection;
   private PreparedStatement query;
   private ResultSet resultSet;


   EmployeeDAO() {
       try {
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           connection = DriverManager.getConnection("jdbc:ucanaccess://employees.accdb");
       } catch (Exception e) {
           System.out.println("Exception Occured in database " + e);
       }
   }

   public ArrayList<Employee> getAllEmployees(){
       ArrayList<Employee> employeeArrayList =  new ArrayList<>();
       try{
           query = connection.prepareStatement("SELECT * FROM Employee");
           resultSet = query.executeQuery();
           while(resultSet.next()){
            employeeArrayList.add(new Employee(resultSet.getInt(1), resultSet.getInt(5), resultSet.getInt(3),resultSet.getString(2),resultSet.getString(4)));
           }

       }catch(Exception e){
           System.out.println("Error occurred in getting the employee from database "+e);
       }

       return employeeArrayList;
   }


public void addEmployeeToDB(Employee employee){
       try{

           query = connection.prepareStatement("INSERT INTO Employee (Name , Age , Department , Salary) VALUES (?,?,?,?)");
           query.setString(1,employee.getName());
           query.setInt(2,employee.getAge());
           query.setString(3,employee.getDepartment());
           query.setInt(4,employee.getSalary());
           query.executeUpdate();
           System.out.println("Employee has been added to the database");
       }catch (Exception e){
           System.out.println("Error Occurred in inserting employee into the database !! + "+e);
       }

}


public void deleteEmployee(int id){
       try{

        query = connection.prepareStatement("DELETE FROM Employee WHERE ID = ?");
        query.setInt(1,id);
        query.executeUpdate();
        System.out.println("Employee has been deleted");
       }catch(Exception e){
           System.out.println("Error Occurred while deleting the employee : "+e);
       }
}


public void updateEmployee(int id ,Employee employee){
    try{

        query = connection.prepareStatement("UPDATE Employee SET Name = ? , Age = ? , Department = ? , Salary = ? WHERE ID = ?");
        query.setString(1,employee.getName());
        query.setInt(2,employee.getAge());
        query.setString(3,employee.getDepartment());
        query.setInt(4,employee.getSalary());
        query.setInt(5,id);
        query.executeUpdate();
        System.out.println("Employee record has been updated");
    }catch (Exception e){
        System.out.println("Error Occurred in inserting employee into the database !! + "+e);
    }
}


public Employee getEmployeeById(int id){
    Employee employee = null;
       try{
        query = connection.prepareStatement("SELECT * FROM Employee WHERE ID = ?");
        query.setInt(1,id);
        resultSet = query.executeQuery();
        resultSet.next();
        employee = new Employee(resultSet.getInt(1), resultSet.getInt(5),resultSet.getInt(3),resultSet.getString(2), resultSet.getString(4));

    }catch(Exception e){
        System.out.println("Error occurred in getting the employee from database "+e);
    }

    return employee;
}


}
