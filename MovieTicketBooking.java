import java.util.Scanner;


public class MovieTicketBooking {

   
    static class Movie {
        String name;
        
        int availableTickets;
        double ticketPrice;

        Movie(String name, int availableTickets, double ticketPrice) {
            this.name = name;
            
            this.availableTickets = availableTickets;
            this.ticketPrice = ticketPrice;
        }

        void displayMovieDetails() {
            System.out.println("Movie: " + name +  " | Available Tickets: " + availableTickets + " | Price: $" + ticketPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        Movie[] movies = {
            new Movie("Devara", 10, 12.50),
            new Movie("Visvam",8, 10.00),
            new Movie("Game changer",  5, 15.00),
            new Movie("Puspa", 6, 9.00)
        };

        System.out.println("Welcome to the Movie Ticket Booking System!");
        boolean continueBooking = true;

        while (continueBooking) {
            
            System.out.println("\nAvailable Movies:");
            for (int i = 0; i < movies.length; i++) {
                System.out.print((i + 1) + ". ");
                movies[i].displayMovieDetails();
            }

            
            System.out.print("\nEnter the movie number you want to book tickets for: ");
            int movieChoice = scanner.nextInt() - 1;

            if (movieChoice < 0 || movieChoice >= movies.length) {
                System.out.println("Invalid movie selection. Try again.");
                continue;
            }

            Movie selectedMovie = movies[movieChoice];

            
            System.out.print("Enter the number of tickets you want to book: ");
            int numTickets = scanner.nextInt();

            
            if (numTickets <= selectedMovie.availableTickets) {
                selectedMovie.availableTickets -= numTickets;
                double totalCost = numTickets * selectedMovie.ticketPrice;

                
                System.out.println("\nBooking Successful!");
                System.out.println("Movie: " + selectedMovie.name);
                System.out.println("Number of tickets: " + numTickets);
                System.out.println("Total cost: $" + totalCost);
            } else {
                System.out.println("Sorry, only " + selectedMovie.availableTickets + " tickets are available.");
            }

            
            System.out.print("\nDo you want to book another movie? (yes/no): ");
            String response = scanner.next();
            continueBooking = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for using the Movie Ticket Booking System. Goodbye!");
        scanner.close();
    }
}

