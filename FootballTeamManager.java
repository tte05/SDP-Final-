import java.util.Scanner;

public class FootballTeamManager {
    public static void main(String[] args) {
        TeamManager teamManager = TeamManager.getInstance();
        EventNotifier eventNotifier = new EventNotifier();
        TeamShop teamShop = new TeamShop();

        // Adapter Pattern
        TicketAdapter ticketAdapter = new TicketAdapter(teamShop);

        // CLI
        Scanner scanner = new Scanner(System.in);

        // Get user input for TeamA
        System.out.println("Enter the name of TeamA:");
        String teamAName = scanner.nextLine();
        System.out.println("Enter the country of TeamA:");
        String teamACountry = scanner.nextLine();
        FootballTeam teamA = TeamFactory.createTeam(teamAName, teamACountry);

        // Get user input for TeamB
        System.out.println("Enter the name of TeamB:");
        String teamBName = scanner.nextLine();
        System.out.println("Enter the country of TeamB:");
        String teamBCountry = scanner.nextLine();
        FootballTeam teamB = TeamFactory.createTeam(teamBName, teamBCountry);

        // Set the current event
        System.out.println("Date of ivent");
        String currentEvent = scanner.nextLine();
        teamManager.setCurrentEvent(currentEvent);

        // Display match information using the new method
        teamA.displayTeamInfo();
        teamB.displayTeamInfo();
        System.out.println("Match between " + teamA.getTeamName() + " and " + teamB.getTeamName() +
                " will be on " + teamManager.getCurrentEvent());

        // Observer registration
        eventNotifier.addObserver(new MatchEventObserver());

        // Notify observers about the current event
        eventNotifier.notifyObservers(teamManager.getCurrentEvent());

        // Strategy pattern example
        FootballStrategy runStrategyTeamA = new RunStrategy();
        FootballStrategy defendStrategyTeamB = new DefendStrategy();

        // Get user input for strategies
        System.out.println("Enter the color for Run strategy of TeamA:");
        String runColor = scanner.nextLine();
        System.out.println("Enter the boot type for Run strategy of TeamA:");
        String runBootType = scanner.nextLine();

        FootballStrategy coloredRunStrategyTeamA = new ColorDecorator(runStrategyTeamA, runColor);
        FootballStrategy bootedRunStrategyTeamA = new BootsDecorator(coloredRunStrategyTeamA, runBootType);

        System.out.println("Enter the color for Defend strategy of TeamB:");
        String defendColor = scanner.nextLine();
        System.out.println("Enter the boot type for Defend strategy of TeamB:");
        String defendBootType = scanner.nextLine();

        FootballStrategy coloredDefendStrategyTeamB = new ColorDecorator(defendStrategyTeamB, defendColor);
        FootballStrategy bootedDefendStrategyTeamB = new BootsDecorator(coloredDefendStrategyTeamB, defendBootType);

        // Execute strategies
        bootedRunStrategyTeamA.execute(); // Run strategy for TeamA
        bootedDefendStrategyTeamB.execute(); // Defend strategy for TeamB

        // Display strategy information
        displayStrategyInfo(bootedRunStrategyTeamA);
        displayStrategyInfo(bootedDefendStrategyTeamB);

        // Adapter pattern example
        // Users buy tickets
        System.out.println("Enter the number of tickets to buy for TeamA:");
        int ticketsToBuy = scanner.nextInt();
        ticketAdapter.buyTicket("TeamA", ticketsToBuy);

        // Team shop sells tickets
        System.out.println("Enter the number of tickets to sell for TeamB:");
        int ticketsToSell = scanner.nextInt();
        ticketAdapter.sellTicket("TeamB", ticketsToSell);

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    // Display strategy information method
    private static void displayStrategyInfo(FootballStrategy strategy) {
        if (strategy instanceof ColorDecorator) {
            System.out.println("Color Decorator Strategy: " + ((ColorDecorator) strategy).getColor());
        } else if (strategy instanceof BootsDecorator) {
            System.out.println("Boots Decorator Strategy: " + ((BootsDecorator) strategy).getBootType());
        } else {
            System.out.println("Base Strategy");
        }
    }
}
