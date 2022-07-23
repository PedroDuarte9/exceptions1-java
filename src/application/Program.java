package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {                      //Esse throws propaga a exceção
    public static void main(String[] args) throws ParseException   {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next()); // Aqui eu vou receber a data em forma de texto no sc.next e depois pelo sdf vou transformar para date, sempre fazer a leitura da lógica de trás pra frente

        if(! checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date ");

        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());


                String error = reservation.updateDates(checkOut, checkIn);
                if (error != null){
                    System.out.println("Error in Reservation: " + error );
                }else {
                    System.out.println("Reservation: " + reservation);
                }


        }


        sc.close();
    }
}
