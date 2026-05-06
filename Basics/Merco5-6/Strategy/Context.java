// Strategy interface
interface Strategy {
    void execute();
}

// Concrete Strategy A
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

// Concrete Strategy B
class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }

    public static void main(String[] args) {

        // Client usage
        Context context = new Context();

        context.setStrategy(new ConcreteStrategyA());
        context.performTask();

        context.setStrategy(new ConcreteStrategyB());
        context.performTask();
    }
}