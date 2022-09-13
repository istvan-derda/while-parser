import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;

@Command
public class Main implements Runnable {

    @Parameters(index = "0", description = "path of source file to parse")
    String whileProgramSourceName;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        try {
            CharStream inputStream = CharStreams.fromFileName(whileProgramSourceName);
            WhileLexer lexer = new WhileLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            WhileParser parser = new WhileParser(tokenStream);
            WhileParser.ProgramsContext programContext = parser.programs();
            PrintToConsoleListener printToConsoleListener = new PrintToConsoleListener();
            ParseTreeWalker.DEFAULT.walk(printToConsoleListener, programContext);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
