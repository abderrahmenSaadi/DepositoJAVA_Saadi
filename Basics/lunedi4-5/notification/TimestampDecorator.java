// TimestampDecorator.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampDecorator extends MessageDecorator {

    public TimestampDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timestamp = LocalDateTime.now().format(formatter);
        return "[" + timestamp + "] " + message.getContent();
    }
}