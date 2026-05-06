package lexer;


import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(String input) {

        List<Token> tokens =
                new ArrayList<>();

        String[] parts =
                input.trim().split("\\s+");

        for (int i = 0; i < parts.length; i++) {

            String part = parts[i];

            if (i == 0) {

                tokens.add(
                        new Token(
                                TokenType.COMMAND,
                                part
                        )
                );

            } else {

                tokens.add(
                        new Token(
                                TokenType.ARGUMENT,
                                part
                        )
                );
            }
        }

        return tokens;
    }
}