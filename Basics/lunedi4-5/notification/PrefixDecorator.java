

public class PrefixDecorator extends MessageDecorator {

    private String prefix;

    public PrefixDecorator(Message message, String prefix) {
        super(message);
        this.prefix = prefix;
    }

    @Override
    public String getContent() {
        return prefix + message.getContent();
    }
}