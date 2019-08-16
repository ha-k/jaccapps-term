import java.io.File;

public class TermMain
{
  public static void main (String args[])
    {
      try
        {
          TermTokenizer t;

          if(args.length>0)
            t = new TermTokenizer(new File(args[0]));
          else
            t = new TermTokenizer();

          try
            {
              new TermParser(t).parse();
            }
          catch (Exception e)
            {
              System.err.println("*** Parsing error: "+e);
            }
        }
      catch (Exception e)
        {
          System.err.println("*** Tokenizing error: "+e);
        }
    }
}
