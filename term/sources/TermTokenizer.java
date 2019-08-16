// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/term/sources/TermTokenizer.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Wed Jun 20 14:13:55 2012

// Last modified on Sun Jun 10 18:46:41 2018 by hak

/**
 * This defines a tokenizer for the classical Prolog terms. 
 *
 * As usual, the details are in the method <tt>nextToken()</tt>.
 *
 * @version     Last modified on Wed Jun 20 13:51:44 2012 by hak
 * @author      <a href="mailto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

import java.io.*;
import java.util.Date;
import hlt.language.syntax.*;
import hlt.language.util.Location;
import hlt.language.io.StreamTokenizer;

public class TermTokenizer implements Tokenizer
{
  BufferedReader reader;
  StreamTokenizer input;
  String file = "stdin";

  TermTokenizer () throws IOException
    {
      setupReader(new InputStreamReader(System.in));
      interactive = true;
      banner();
      prompt();
    }

  TermTokenizer (File file) throws IOException
    {
      setupReader(new FileReader(file));
      this.file = file.toString();
      interactive = false;
      banner();
      System.out.println("*** Parsing file: "+file);
    }

  private void setupReader (Reader rd)
    {
      setReader(rd);
      input = new StreamTokenizer(reader);
      input.ordinaryChars("+-./");
      input.quoteChar('\'',0); // no escape allowed
    }

  public final int lineNumber()
    {
      return input.getLineNumber();
    }

  public final void setReader (Reader rd)
    {
      reader = new BufferedReader(rd);
    }

  public final Reader getReader ()
    {
      return reader;
    }

  public static boolean interactive;
  static String prompt = "> ";

  public static final void prompt ()
    {
      if (interactive)
        {
          System.out.print(prompt);
        }
    }

  static public final void setPrompt(String p)
    {
      prompt = p;
    }

  static String banner = "*** Welcome to the dynamic operator Term Parser!\n"+
                         "*** Version of "+ (new Date());

  public static final void banner ()
    {
      System.out.println(banner);
    }

  final boolean isOtherChar (int c)
    {
      return input.isOrdinaryChar(c)
        && !(input.isWhitespaceChar(c) || c == '(' || c == ')' || c == ',');
    }

  final ParseNode locate (ParseNode node)
    {
      return ((ParseNode)node.setStart(input.tokenStart()).setEnd(input.tokenEnd()))
	.setFile(file);
    }

  final ParseNode locate (ParseNode node, Location start)
    {
      return ((ParseNode)node.setStart(start).setEnd(input.tokenEnd()))
	.setFile(file);
    }

  public ParseNode nextToken() throws IOException
    {
      ParseNode t = null;

      switch (input.nextToken())
        {
        case StreamTokenizer.TT_EOF:
          reader.close();
          locate(t = GenericParser.E_O_I);
          break;
        case '\'': case '"':
        case StreamTokenizer.TT_WORD:
	  if (input.sval == "exit")
	    t = GenericParser.literalToken("exit");
	  else
	    t = GenericParser.symbolToken("FUNCTOR",input.sval);
	  locate(t);
          break;
        case StreamTokenizer.TT_NUMBER:
          if (input.isInteger)
            t = GenericParser.numberToken("NUMBER",(int)input.nval);
          else
            t = GenericParser.numberToken("NUMBER",input.nval);
	  locate(t);
          break;
        case '(': case ')': case ',': case '.':
          locate(t = GenericParser.literalToken(String.valueOf((char)input.ttype)));
          break;
        default: // read the longest possible token and return it as a symbol
	  Location start = input.tokenStart();
          StringBuffer functor = new StringBuffer(String.valueOf((char)input.ttype));
          input.spaceIsSignificant(true);
	  while (isOtherChar(input.peek()))
	    functor.append(String.valueOf((char)input.nextToken()));	  
          input.spaceIsSignificant(false);
          t = GenericParser.symbolToken("FUNCTOR",functor.toString());
	  locate(t,start);
          break;
        }
      return t;
    }
}
