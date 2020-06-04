/*In this class we are able to test each sentence like 'Select', 'Insert', 'Update', 'Delete' 
    giving to user an interactive experience like a real software to manage a little DataBase in MySQL*/
package test;

import data.PersonJDBC;
import domain.Person;
import java.util.*;

/*This is the Main class*/
public class ManagingPersons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0, id = 0;
        String name="", lastName="", email="", phone="";
        PersonJDBC personJDBC = new PersonJDBC();
        Person person = new Person();
        /*Here we are using a Menu so we are able to connect and select any option we want, we can see the same information
            than MySQL and add another records, change records and delete some registry...*/
        /*So we are able to change any data from here to MySQL WorkBench*/
        do{
        System.out.println("Welcome to DataBase.\n\nChoose one Option:\n1.-Information."
                + "\n2.-Add Registry.\n3.-Update Registry.\n4.-Delete Registry.\n5.-Exit.\n");
        opc = sc.nextInt();
            switch (opc) {
                case 1:
                    //Select: See all the Records
                    List<Person> persons = personJDBC.select();
                    System.out.println();
                    for (Person show : persons) {
                        System.out.println("DateBase Person: " + show);
                    }
                    System.out.println("\n\n");
                    break;
                case 2:
                    //Insert: Add registry
                    sc.nextLine();
                    System.out.println("Registry: ");
                    System.out.print("Insert Name: ");
                    name = sc.nextLine();
                    person.setName(name);
                    System.out.print("Insert Last Name: ");
                    lastName = sc.nextLine();
                    person.setLastName(lastName);
                    System.out.print("Insert Email: ");
                    email = sc.nextLine();
                    person.setEmail(email);
                    System.out.print("Insert Phone: ");
                    phone = sc.nextLine();
                    person.setPhone(phone);
                    System.out.println("\n\n");
                    personJDBC.insert(person);
                    break;
                case 3:
                    //Update: Change registry using ID
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Last Name: ");
                    lastName = sc.nextLine();
                    System.out.print("Email: ");
                    email = sc.nextLine();
                    System.out.print("Phone: ");
                    phone = sc.nextLine();
                    person.setId_person(id);
                    person.setName(name);
                    person.setLastName(lastName);
                    person.setEmail(email);
                    person.setPhone(phone);
                    personJDBC.update(person);
                    break;
                case 4:
                    //Delete: Delete any record using ID
                    System.out.print("Insert ID to Delete: ");
                    id = sc.nextInt();
                    person.setId_person(id);
                    personJDBC.delete(person);
                    break;
                case 5:
                    System.out.println("End Program...");
                    break;
            }
        }while(opc!=5);
    }
}