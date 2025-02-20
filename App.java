import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "Camargue - House of the Gipsies.wav";

        while(alarmTime == null){
            try{
                System.out.println("Enter an alarm time(HH:MM:SS): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime,formatter);
                System.out.println("Alarm set for "+ alarmTime);
            }
            catch(DateTimeException e){
                System.out.println("Invalid format please use HH:MM:SS");
            }
        }
        AlarmClock alarmClock = new AlarmClock(alarmTime,filePath,scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();
    }
}