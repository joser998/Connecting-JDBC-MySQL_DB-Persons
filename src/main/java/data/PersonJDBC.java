/*This class is available to manage operations in table to DB...
Operations like:
-Select
-Insert
-Update
-Delete*/
package data;

import domain.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonJDBC {
    /*This are the queries to manage our DB in MySQL*/
    private static final String SQL_SELECT = "SELECT id_person, Name, Last_Name, Email, Phone FROM person"; 
    private static final String SQL_INSERT = "INSERT INTO person(Name, Last_Name, Email, Phone) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE person SET Name=?, Last_Name=?, Email=?, Phone=? WHERE id_person = ?"; 
    private static final String SQL_DELETE = "DELETE FROM person WHERE id_person=?"; 
    
    /*Select method: We are able to return objects in list way...
        With this method we are gonna be able to see what is happening in DB*/
    public List<Person> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Person person = null;
        
        /*Array List Person*/
        List<Person> persons = new ArrayList<Person>();
        try {
            conn = EstablishingConnection.getConnection(); /*We get connection with our DataBase*/
            stmt = conn.prepareStatement(SQL_SELECT); /*Executing sentence: Select*/                                
            rs = stmt.executeQuery(); /*Assign query to our variable 'rs'*/
            
            /*We recover each one of values from our sentence Select*/  
            while(rs.next()){   
                int id_person = rs.getInt("id_person");
                String name = rs.getString("Name");
                String lastName = rs.getString("Last_Name");  
                String email = rs.getString("Email");
                String phone = rs.getString("Phone");
                
                /*We build and object from: Person*/
                person = new Person();
                person.setId_person(id_person);
                person.setName(name);
                person.setLastName(lastName);
                person.setEmail(email);
                person.setPhone(phone);
                
                /*Here we can add each object from ResultSet to our list <Persona>*/
                persons.add(person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);/*Just in error case, we print exception to know what is happening*/
        }
        finally{
        /*Finally we close every object to avoid any kind of problem*/
            EstablishingConnection.close(rs);
            EstablishingConnection.close(stmt);
            EstablishingConnection.close(conn);
        }
        /*Return list <Personas>*/
        return persons;
    }
    
   
    
    /*Insert method: We are able to add some registry to our table in DB*/
    /*Receive Person object from class Person wich one have all the elements we gonna insert*/
    public int insert(Person person){
        Connection  conn = null; /*Define variable connection*/
        PreparedStatement stmt = null;
        int rows = 0; /*This variable is used to know how many records have been affected, once we insert one registry*/
        try {
            conn = EstablishingConnection.getConnection(); 
            stmt = conn.prepareStatement(SQL_INSERT); /*We use PreparedStatement method and we gave Insert sentence*/
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getPhone());
            
            System.out.println("Executing QUERY: "+SQL_INSERT); /*This is only message about sentence SQL_INSERT*/
            /*We received an int, once the method  executeUpdate() is executed. This is to know how many records have been affected*/
            rows = stmt.executeUpdate();
            System.out.println("\nRecords Affected: "+rows + "\n");/*Information about how many records have been affected*/
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);/*Just in error case, we print exception to know what is happening*/
        }
        finally{
            EstablishingConnection.close(stmt);/*Close object stmt*/
            EstablishingConnection.close(conn);/*Close object conn*/
        }
        return rows;/*Return affected records*/
    }
    
    
    /*Update method: This method must have object with primary key, so it can do the modification in any registry*/
    /*This method is going to return us records affected*/
    public int update(Person person){
        Connection conn = null;/*Define variable connection*/
        PreparedStatement stmt = null;
        int rows = 0;/*This variable is used to know how many records have been affected, once we update one registry*/
        try {
            conn = EstablishingConnection.getConnection(); /*Getting connection*/
            System.out.println("Executing QUERY: "+SQL_UPDATE);/*This is only message about sentence SQL_UPDATE*/
            stmt = conn.prepareStatement(SQL_UPDATE);/*We use PreparedStatement method to Update the record choosen*/
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getEmail());
            stmt.setString(4, person.getPhone());
            stmt.setInt(5, person.getId_person());
        /*We received an int, once the method  executeUpdate() is executed. This is to know how many records have been affected*/
            rows = stmt.executeUpdate(); 
        /*Information about how many records have been affected*/    
            System.out.println("Records Affected: "+rows+ "\n"); 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);/*Just in error case, we print exception to know what is happening*/
        }
        finally{
            EstablishingConnection.close(stmt);/*Close object stmt*/
            EstablishingConnection.close(conn);/*Close object conn*/
        }
        return rows;/*Return affected records*/
    }
    
    
    
   /*Delete method: This one is used to delete the entire registry in DB, we only need to type the ID to delete registry*/
   public int delete(Person person){
       Connection conn = null;/*Define variable connection*/
       PreparedStatement stmt = null;
       int rows = 0;/*This variable is used to know how many records have been affected, once we delete the registry*/
        try {
            conn = EstablishingConnection.getConnection();/*Getting connection*/
            System.out.println("Executing QUERY: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);/*We use PreparedStatement method to Delete the record choosen*/
            stmt.setInt(1, person.getId_person());
        /*We received an int, once the method  executeUpdate() is executed. This is to know how many records have been affected*/
            rows = stmt.executeUpdate();
        /*Information about how many records have been affected*/    
            System.out.println("Records Deleted: "+rows + "\n");
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);/*Just in error case, we print exception to know what is happening*/
        }finally{
            EstablishingConnection.close(stmt);/*Close object stmt*/
            EstablishingConnection.close(conn);/*Close object conn*/
        }
        return rows;/*Return affected records*/
   }
}