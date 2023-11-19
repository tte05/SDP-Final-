class TicketAdapter {
    private TeamShop teamShop;

    public TicketAdapter(TeamShop teamShop) {
        this.teamShop = teamShop;
    }

    public void buyTicket(String teamName, int quantity) {
        teamShop.sellTickets(teamName, quantity);
    }

    public void sellTicket(String teamName, int quantity) {
        teamShop.buyTickets(teamName, quantity);
    }
}

class TeamShop {
    public void sellTickets(String teamName, int quantity) {
        System.out.println(quantity + " tickets bought for " + teamName + " from the team shop.");
    }

    public void buyTickets(String teamName, int quantity) {
        System.out.println(quantity + " tickets sold to the team shop for " + teamName + ".");
    }
}