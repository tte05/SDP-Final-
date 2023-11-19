public class BootsDecorator extends FootballFormDecorator {
    private String bootType;

    public BootsDecorator(FootballStrategy decoratedStrategy,String bootType){
        super(decoratedStrategy);
        this.bootType=bootType;
    }
    public void execute(){
        decoratedStrategy.execute();
        System.out.println(bootType + " boots");
    }

    public String getBootType(){
        return bootType;
    }
}
