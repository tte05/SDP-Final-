// Strategy Pattern
interface FootballStrategy {
    void execute();
}

class RunStrategy implements FootballStrategy {
    @Override
    public void execute() {
        System.out.println("Running ");
    }
}

class DefendStrategy implements FootballStrategy {
    @Override
    public void execute() {
        System.out.println("Defending ");
    }
}

class ShootStrategy implements FootballStrategy {
    @Override
    public void execute() {
        System.out.println("Shooting ");
    }
}

class SaveStrategy implements FootballStrategy {
    @Override
    public void execute() {
        System.out.println("Saving ");
    }
}