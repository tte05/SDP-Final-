class MatchEventObserver implements EventObserver {
    @Override
    public void update(String event) {
        System.out.println("Event notified: " + event);
    }
}