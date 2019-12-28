package SportClub;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * SportClub.Main Class
 * Test, through a simulation, the classes and methods created
 *
 * 1)   Create initial arrays of SportClub.Admin, Members and SportClub.Activity
 * 2a)  The admins add, remove and edit members
 * 2b)  The admins add, remove and edit activities
 * 3)   A member signs up to a SportClub.Race and to a SportClub.Course, then unsubscribe to one of them
 * 4)   Show information about admins, members and activities
 *
 * @author Daniele Pellegrini <daniele.pellegrini@studenti.unipr.it> - 285240
 * @author Riccardo Fava <riccardo.fava@studenti.unipr.it> - 287516
 */
public class Main extends Application {

    private static String UI = "../Login/Login.fxml";

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(UI));
        Scene frame = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setTitle("SportClub");
        primaryStage.setScene(frame);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);

        /*
        SportClub.Admin a1 = new SportClub.Admin("Giacomo", "Neri", "Jack", "hardtoguess");
        SportClub.Member m1 = new SportClub.Member("Tommaso", "Boni", "Tom", "12345");
        a1.addMember(m1);
        SportClub.Member m2 = new SportClub.Member("Kia", "magika");
        m1.login();
        m2.login();
        a1.login();
        SportClub.Member m3 = new SportClub.Member("Pietro", "Poli", "Pie", "45678");
        SportClub.Admin a3 = new SportClub.Admin("Daniele", "Pellegrini", "Dann", "1234");
        m3.login();
        m3.register();
        m3.login();
        a3.register();
        a3.login();
        SportClub.Race bikeRace = new SportClub.Race("Tour de France");
        SportClub.Course yogaCourse = new SportClub.Course("Jnana Yoga");
        SportClub.Race motorRace = new SportClub.Race("GrandPrix F1");
        m1.unsubscribe(bikeRace);
        a3.removeMember(m1);
        a3.editMember(m3, "Gaia", "Vanni", "Gaietta", "pollice");
        a3.editActivity(bikeRace, motorRace.getName());
        */

        /*
        System.out.println("------ 1) Create initial arrays of SportClub.Admin, Members and SportClub.Activity ------");
        SportClub.Member m1 = new SportClub.Member("Tommaso", "Boni", "Tom", "12345");
        SportClub.Member m2 = new SportClub.Member("Luca", "Perini", "Luke", "98765");
        SportClub.Admin a1 = new SportClub.Admin("Giacomo", "Neri", "Jack", "hardtoguess");
        SportClub.Admin a2 = new SportClub.Admin("Chiara", "Zanetti", "Chicca", "hardtofind");
        SportClub.Person[] persons = new SportClub.Person[]{a1,a2,m1,m2};
        System.out.println("Created 2 administrators and 2 members:\n");
        int counter1 = 1; int counter2 = 1;
        for (SportClub.Person person : persons) {
            if (person.getClass() == SportClub.Admin.class) {
                System.out.println(" a" + counter1 + "\t" + person.show() + " Hash. Pass: " + person.getPassword());
                counter1++;
            } else if (person.getClass() == SportClub.Member.class) {
                System.out.println(" m" + counter2 + "\t" + person.show() + " Hash. Pass: " + person.getPassword());
                counter2++;
            }
        }
        SportClub.Race bikeRace = new SportClub.Race("Tour de France");
        SportClub.Course yogaCourse = new SportClub.Course("Jnana Yoga");
        SportClub.Activity[] activities = new SportClub.Activity[]{bikeRace, yogaCourse};
        System.out.println("\nCreated 1 SportClub.Race and 1 SportClub.Course:\n");
        for (SportClub.Activity a : activities) {
            System.out.println(a.show());
        }

        System.out.println("\n------ 2a) The admins add, remove and edit members ------");
        System.out.println("Created 1 new member m3.");
        System.out.println("The admin " + a2.getUsername() + " adds the new member to the persons array. Here is the members:\n");
        SportClub.Member m3 = new SportClub.Member("Pietro", "Poli", "Pie", "45678");
        persons = a2.addMember(m3, persons);
        for (int i = 0; i < persons.length; i++) {
        	if(persons[i].getClass() == SportClub.Member.class)
            if (i != persons.length-1)
                System.out.println(" m" + (i - 1) + "\t" + persons[i].show());
            else System.out.print(" m" + (i - 1) + "\t" + persons[i].show());
        }
        System.out.println("   <-- new member!\n");
        System.out.println("The admin " + a2.getUsername() + " subscribes the member m2 to the " + bikeRace.getName() + ".\nHere is the subscribers to the activity:\n");
        a2.Subscribe(bikeRace, m2);
        System.out.println(bikeRace.show());
        System.out.println("The admin " + a1.getUsername() + " unsubscribes the member m2 to the " + bikeRace.getName() + ".\nHere is the subscribers to the activity:\n");
        a1.Unsubscribe(bikeRace, m2);
        System.out.println(bikeRace.show());
        System.out.println("\nThe admin " + a1.getUsername() + " edits the member m1 stats. \n" +
                a1.getUsername() + " removes the object from the persons array and reinsert it inside with the updated stats.\n");
        a1.deleteMember(m1, persons);
        System.out.print(m1.show() + "\t Password: " + m1.getPassword());
        System.out.println("\n |\n | changing\n |");
        a1.editMember(m1, "Camilla", "Bacchi", "Cami", "noteasy");
        System.out.print(m1.show() + "\t Password: " + m1.getPassword() + "\n");
        System.out.println("\nHere is the members:\n");
        for (int i = 0; i < persons.length; i++) {
        	if(persons[i].getClass() == SportClub.Member.class) {
        		if (i != 2)
        			System.out.println(" m" + (i - 1) + "\t" + persons[i].show());
        		else{
        			System.out.print(" m" + (i - 1) + "\t" + persons[i].show());
        			System.out.println("   <-- updated member !");
        		}
            }
        }

        System.out.println("\n------ 2b) The admins add, remove and edit activities ------");
        SportClub.Race motorRace = new SportClub.Race("GrandPrix F1");
        System.out.println("Created 1 new activity " + motorRace.getName() + ".");
        System.out.println("The admin " + a1.getUsername() + " adds the new activity to the activities array. Here is the activities:\n");
        activities = a1.addActivity(motorRace, activities);
        for (int i = 0; i < activities.length; i++) {
            if (i != activities.length-1)
                System.out.println(activities[i].show());
            else System.out.print(activities[i].show());
        }
        System.out.println("   <-- new activity!\n");
        System.out.println("The admin " + a2.getUsername() + " edits the activity " + motorRace.getName() + " stats. \n" +
                a2.getUsername() + " removes the object from the activities array and reinsert it inside with the updated stats.\n");
        a2.deleteActivity(motorRace, activities);
        System.out.print(motorRace.show());
        System.out.println("\n |\n | changing\n |");
        a2.editActivity(motorRace, "GrandPrix Gp");
        System.out.println(motorRace.show());
        System.out.println("\nHere is the activities:\n");
        for (int i = 0; i < activities.length; i++) {
            if (i != activities.length-1)
                System.out.println(activities[i].show());
            else{
                System.out.print(activities[i].show());
                System.out.println("   <-- updated activity !");
            }
        }

        System.out.println("\n------ 3) A member signs up to a SportClub.Race and to a SportClub.Course, then unsubscribe to one of them  ------");
        System.out.println(m1.getUsername() + " and " + m3.getUsername() + " both subscribe to " + bikeRace.getName() + " and " + yogaCourse.getName()+".");
        System.out.println("The admin " + a1.getUsername() + " subscribes the member " + m2.getUsername() + " to the " + bikeRace.getName() +
                " and Luke signs up to the " + yogaCourse.getName() + "\n");
        m1.Subscribe(bikeRace);
        m1.Subscribe(yogaCourse);
        m3.Subscribe(bikeRace);
        m3.Subscribe(yogaCourse);
        a1.Subscribe(bikeRace, m2);
        m2.Subscribe(yogaCourse);
        for (SportClub.Activity a : activities){
            System.out.println(a.show());
        }
        System.out.println("\n" + m1.getUsername() + " unsubscribes to " + yogaCourse.getName() + " and " + m3.getUsername() + " unsubscribe to " + bikeRace.getName());
        System.out.println("The admin " + a2.getUsername() + " unsubscribes the member " + m2.getUsername() + " to " + yogaCourse.getName() +
                " and Luke unsubscribes to the " + bikeRace.getName());
        System.out.println(m2.getUsername() + " subscribes to " + motorRace.getName() + ".\n");
        m1.Unsubscribe(yogaCourse);
        m3.Unsubscribe(bikeRace);
        a2.Unsubscribe(yogaCourse, m2);
        m2.Unsubscribe(bikeRace);
        m2.Subscribe(motorRace);
        for (SportClub.Activity a : activities){
            System.out.println(a.show());
        }

        System.out.println("------ 4) Show information about admins, members and activities  ------");
        System.out.println("\nHere's the members:\n");
        counter1 = 1; counter2 = 1;
        for (SportClub.Person person : persons) {
            if (person.getClass() == SportClub.Admin.class) {
                System.out.println(" a" + counter1 + "\t" + person.show());
                counter1++;
            } else if (person.getClass() == SportClub.Member.class) {
                System.out.println(" m" + counter2 + "\t" + person.show());
                counter2++;
            }
        }
        System.out.println("\nHere's the activities:\n");
        for (SportClub.Activity a : activities){
            System.out.println(a.show());
        }
         */
    }
}