import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        CharStream inputStream;
        if (args.length == 0) {
            inputStream = CharStreams.fromString("x = 3;" + "y=7;" + "z=y+9;" + "xcpy = x;");
        }
        else {
            inputStream = null; //todo read file
        }
        WhileLexer lexer = new WhileLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        WhileParser parser = new WhileParser(tokenStream);
        WhileParser.ProgramsContext programContext = parser.programs();
        PrintToConsoleListener printToConsoleListener = new PrintToConsoleListener();
        ParseTreeWalker.DEFAULT.walk(printToConsoleListener, programContext);
    }
}
