package read;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class App 
{
    public static void main( String[] args )
    {
    	AnsiConsole.systemInstall();
    	System.out.println(
    			Ansi.ansi().eraseScreen().fg(Ansi.Color.BLUE).a("Hello").fg(Ansi.Color.YELLOW).a(" World").reset()
    			);
        //System.out.println(Ansi.ansi().eraseScreen().render("@|red Hello|@ @|yellow World|@") );
        AnsiConsole.systemUninstall();
    }
}