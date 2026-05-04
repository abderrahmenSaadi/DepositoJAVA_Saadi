// EmojiDecorator.java
public class EmojiDecorator extends MessageDecorator {

    private String emoji;

    public EmojiDecorator(Message message, String emoji) {
        super(message);
        this.emoji = emoji;
    }

    @Override
    public String getContent() {
        return emoji + " " + message.getContent();
    }
}