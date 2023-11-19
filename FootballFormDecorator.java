abstract class FootballFormDecorator implements FootballStrategy {
    protected FootballStrategy decoratedStrategy;

    public FootballFormDecorator(FootballStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }
}
