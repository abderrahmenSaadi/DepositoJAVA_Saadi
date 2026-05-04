import java.util.function.Function;

public class User implements Observer {

    private String name;
    private Function<Message, Message> decorator;

    public User(String name, Function<Message, Message> decorator) {
        this.name = name;
        this.decorator = decorator;
    }

    @Override
    public void update(Message message) {
        Message finalMessage = decorator.apply(message);
        System.out.println(name + " receives: " + finalMessage.getContent());
    }
}