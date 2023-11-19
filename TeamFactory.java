//Factory pattern
class TeamFactory {
    public static FootballTeam createTeam(String teamName, String country) {
        FootballTeam team = new FootballTeam(teamName, country);
        TeamManager.getInstance().addTeam(teamName, country);
        return team;
    }
}