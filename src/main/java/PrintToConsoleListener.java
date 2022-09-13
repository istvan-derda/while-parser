import org.antlr.v4.runtime.ParserRuleContext;

public class PrintToConsoleListener extends WhileBaseListener {

    @Override
    public void enterProgram(WhileParser.ProgramContext ctx) {
        prettyPrintContext("enterProgram", ctx);
    }

    @Override
    public void exitProgram(WhileParser.ProgramContext ctx) {
        prettyPrintContext("exitProgram", ctx);
    }

    @Override
    public void enterPrograms(WhileParser.ProgramsContext ctx) {
        prettyPrintContext("enterPrograms", ctx);
        super.enterPrograms(ctx);
    }

    @Override
    public void exitPrograms(WhileParser.ProgramsContext ctx) {
        prettyPrintContext("exitPrograms", ctx);
        super.enterPrograms(ctx);
    }

    private void prettyPrintContext(String fnName, ParserRuleContext context) {
        System.out.println(fnName + ":\n" + context.getText().replace(";", ";\n"));
    }
}
