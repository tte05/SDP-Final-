import java.util.HashMap;
import java.util.Map;

class TeamManager {
    private static TeamManager instance;
    private Map<String, FootballTeam> teams;
    private String currentEvent;

    private TeamManager() {
        teams = new HashMap<>();
        currentEvent = null;
    }

    public static TeamManager getInstance() {
        if (instance == null) {
            instance = new TeamManager();
        }
        return instance;
    }

    public void addTeam(String teamName, String country) {
        FootballTeam team = new FootballTeam(teamName, country);
        teams.put(teamName, team);
    }

    public void setCurrentEvent(String event) {
        currentEvent = event;
    }

    public String getCurrentEvent() {
        return currentEvent;
    }
}
