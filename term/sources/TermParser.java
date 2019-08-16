// *******************************************************************
// This file has been automatically generated from the grammar in file
// Term.grm by hlt.language.syntax.ParserGenerator on
// Sun Jun 10 19:47:36 CEST 2018 --- !!! PLEASE DO NO EDIT !!!
// *******************************************************************

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import hlt.language.util.ArrayList;
import hlt.language.util.FiniteStack;
import hlt.language.syntax.*;
import java.util.*;


/* ************ */
/* PARSER CLASS */
/* ************ */

class TermParser extends DynamicParser
{
  /* ************************ */
  /* PARSER CLASS CONSTRUCTOR */
  /* ************************ */

  public TermParser (Tokenizer t)
    {
      input = t;
      xmlroot = "Session";
      choiceStack = new FiniteStack(10);
      trailStack = new FiniteStack(100);
      resolveRRsWithPrecedence = false;

      /* **************** */
      /* OPERATOR SYMBOLS */
      /* **************** */

      operators = new ArrayList(27);

      newOperator(":-",3,1,2,2);
      newOperator(":-",3,1,2,0);
      newOperator("-->",3,1,2,2);
      newOperator(";",3,101,1,2);
      newOperator(",",3,201,1,2);
      newOperator("=",3,501,2,2);
      newOperator("\\=",3,501,2,2);
      newOperator("==",3,501,2,2);
      newOperator("\\==",3,501,2,2);
      newOperator("=..",3,501,2,2);
      newOperator("is",3,501,2,2);
      newOperator("=:=",3,501,2,2);
      newOperator("=\\=",3,501,2,2);
      newOperator("<",3,501,2,2);
      newOperator("<=",3,501,2,2);
      newOperator(">",3,501,2,2);
      newOperator(">=",3,501,2,2);
      newOperator("+",3,701,0,2);
      newOperator("-",3,701,0,2);
      newOperator("*",3,801,0,2);
      newOperator("/",3,801,0,2);
      newOperator("&",3,1001,1,2);
      newOperator("^",3,1001,1,2);
      newOperator("-",3,1001,1,0);
      newOperator("if",3,401,2,0);
      newOperator("then",3,351,1,2);
      newOperator("else",3,381,2,2);
    }

  /* ************************* */
  /* PARSER CLASS DECLARATIONS */
  /* ************************* */

  Stack terms = new Stack();
  Term term, temp;


  /* ********************** */
  /* STATIC INITIALIZATIONS */
  /* ********************** */

  static
    {
      initializeTerminals();
      initializeNonTerminals();
      initializeRules();
      initializeParserActions();
      initializeParserStates();
      initializeActionTables();
      initializeGotoTables();
      initializeStateTables();
    }

  /* ********************* */
  /* PARTIAL PARSE METHODS */
  /* ********************* */

  final static ParseNode $SESSION_SWITCH$ = new ParseNode(terminals[3]);

  public final void parseSession (String s) throws IOException
    {
      parseSession(new StringReader(s));
    }

  public final void parseSession (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($SESSION_SWITCH$);
      parse();
    }

  /* **************** */
  /* SEMANTIC ACTIONS */
  /* **************** */

  protected ParseNode semanticAction(ParserRule $rule$) throws IOException
    {
      ParseNode $head$ = new ParseNode($rule$.head);

      switch($rule$.index())
        {
          case 2:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 8:
            {
            System.out.println("*** Bye bye!...");
  	    System.exit(0);
            break;
            }
          case 12:
            {
            /* Bottom-up reduction semantic action: */
            terms = new Stack();
            break;
            }
          case 13:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
  
            // Operator (re)definition:
            if (term.functor != null && term.functor.equals("op")
                && term.body != null && term.body.size() == 3)
              {
                try
                  {
                    Op(((Term)term.body.get(2)).functor,
                       ((Term)term.body.get(1)).functor,
                       (int)((Term)term.body.get(0)).number);
                  }
                catch (Exception e)
                  {
                    System.err.println("*** Bad op declaration: "+term);
                  }
              }
  
            out.println(term.toString()); // print out the term's canonical form
            cutAll();                     // delete all pending token choices
            TermTokenizer.prompt();
            break;
            }
          case 15:
            {
            errorManager().reportErrors(true);
            TermTokenizer.prompt();
            break;
            }
          case 18:
            {
            /* Bottom-up reduction semantic action: */
            terms.push(node($rule$,1).isInteger() ? new Term((int)node($rule$,1).nvalue())
                                    : new Term(node($rule$,1).nvalue()));
            break;
            }
          case 19:
            {
            /* Bottom-up reduction semantic action: */
            terms.push(new Term(node($rule$,1).svalue()));
            break;
            }
          case 20:
            {
            /* Bottom-up reduction semantic action: */
            terms.push(new Term(node($rule$,-1).svalue(),new Vector()));
            break;
            }
          case 22:
            {
            /* Bottom-up reduction semantic action: */
            terms.push(new Term(node($rule$,0).svalue(),new Vector()));
            break;
            }
          case 23:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 24:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            terms.push(new Term(node($rule$,0).svalue(),new Vector()));
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 25:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 26:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            terms.push(new Term(node($rule$,2).svalue(),new Vector()));
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 28:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 29:
            {
            /* Bottom-up reduction semantic action: */
            term = (Term)terms.pop();
            ((Term)terms.peek()).body.add(term);
            break;
            }
          case 0: case 1: 
            break;
          default:
            $head$ = $head$.copy(node($rule$,1));
            break;
        }
      return $head$;
    }

  /* ********************* */
  /* UNDO SEMANTIC ACTIONS */
  /* ********************* */

  protected void undoSemanticAction(ParserRule $rule$,ParseNode $head$) throws IOException
    {
      switch($rule$.index())
        {
          case 18:
            {
            /* Top-down undo semantic action: */
            terms.pop();
            break;
            }
          case 19:
            {
            /* Top-down undo semantic action: */
            terms.pop();
            break;
            }
          case 20:
            {
            /* Top-down undo semantic action: */
            terms.pop();
            break;
            }
          case 22:
            {
            /* Top-down undo semantic action: */
            terms.pop();
            break;
            }
          case 23:
            {
            /* Top-down undo semantic action: */
            temp = (Term)terms.peek();
            term = (Term)temp.body.lastElement();
            temp.body.removeElementAt(temp.body.size()-1);
            terms.push(term);
            break;
            }
          case 24:
            {
            /* Top-down undo semantic action: */
            temp = (Term)terms.pop();
            term = (Term)temp.body.lastElement();
            terms.push(term);
            break;
            }
          case 25:
            {
            /* Top-down undo semantic action: */ 
            temp = (Term)terms.peek();
            term = (Term)temp.body.lastElement();
            temp.body.removeElementAt(temp.body.size()-1);
            terms.push(term);
            break;
            }
          case 26:
            {
            /* Top-down undo semantic action: */
            temp = (Term)terms.pop();
            term = (Term)temp.body.lastElement();
            terms.push(term);
            break;
            }
          case 28:
            {
            /* Top-down undo semantic action: */ 
            temp = (Term)terms.peek();
            term = (Term)temp.body.lastElement();
            temp.body.removeElementAt(temp.body.size()-1);
            terms.push(term);
            break;
            }
          case 29:
            {
            /* Top-down undo semantic action: */ 
            temp = (Term)terms.peek();
            term = (Term)temp.body.lastElement();
            temp.body.removeElementAt(temp.body.size()-1);
            terms.push(term);
            break;
            }
        }
      }

  /* *************************** */
  /* OPERATOR DEFINITION METHODS */
  /* *************************** */

  public final void Op (String o, String s, int p) throws NonFatalParseErrorException
    {
      defineOperator("Op",o,s,p);
    }

  /* **************** */
  /* TERMINAL SYMBOLS */
  /* **************** */

  static void initializeTerminals ()
    {
      terminals = new ParserTerminal[14];

      newTerminal(0,"$EMPTY$",1,2);
      newTerminal(1,"$E_O_I$",1,2);
      newTerminal(2,"error",1,2);
      newTerminal(3,"$Session_switch$",1,2);
      newTerminal(4,"NUMBER",1,2);
      newTerminal(5,"FUNCTOR",1,2);
      newTerminal(6,"OP_",1,2);
      newTerminal(7,"_OP_",1,2);
      newTerminal(8,"_OP",1,2);
      newTerminal(9,"exit",1,2);
      newTerminal(10,".",1,2);
      newTerminal(11,"(",1,2);
      newTerminal(12,")",1,2);
      newTerminal(13,",",1,2);
    }

  /* ******************** */
  /* NON-TERMINAL SYMBOLS */
  /* ******************** */

  static void initializeNonTerminals ()
    {
      nonterminals = new ParserNonTerminal[16];

      newNonTerminal(0,"$START$");
      newNonTerminal(1,"$ROOTS$");
      newNonTerminal(2,"Session");
      newNonTerminal(3,"Op");
      newNonTerminal(4,"Clauses");
      newNonTerminal(5,"Exit");
      newNonTerminal(6,"$ACTION0$");
      newNonTerminal(7,"Clause");
      newNonTerminal(8,"Term");
      newNonTerminal(9,"$ACTION1$");
      newNonTerminal(10,"$ACTION2$");
      newNonTerminal(11,"$ACTION3$");
      newNonTerminal(12,"Body");
      newNonTerminal(13,"$ACTION4$");
      newNonTerminal(14,"$ACTION5$");
      newNonTerminal(15,"$ACTION6$");
    }

  /* **************** */
  /* PRODUCTION RULES */
  /* **************** */

  static void initializeRules ()
    {
      rules = new ParserRule[30];

      rules[0] = new ParserRule(0,1,0,1,2);
      rules[1] = new ParserRule(1,1,1,1,2);
      rules[2] = new ParserRule(1,2,2,1,2);
      rules[3] = new ParserRule(3,1,3,1);
      rules[4] = new ParserRule(3,1,4,1);
      rules[5] = new ParserRule(3,1,5,1);
      rules[6] = new ParserRule(2,2,6,1,2);
      rules[7] = new ParserRule(2,1,7,1,2);
      rules[8] = new ParserRule(6,0,8,1,2);
      rules[9] = new ParserRule(5,3,9,1,2);
      rules[10] = new ParserRule(4,1,10,1,2);
      rules[11] = new ParserRule(4,2,11,1,2);
      rules[12] = new ParserRule(9,0,12,1,2);
      rules[13] = new ParserRule(10,0,13,1,2);
      rules[14] = new ParserRule(7,4,14,1,2);
      rules[15] = new ParserRule(11,0,15,1,2);
      rules[16] = new ParserRule(7,3,16,1,2);
      rules[17] = new ParserRule(3,1,17,1,2);
      rules[18] = new ParserRule(8,1,18,1,2);
      rules[19] = new ParserRule(8,1,19,1,2);
      rules[20] = new ParserRule(13,0,20,1,2);
      rules[21] = new ParserRule(8,5,21,1,2);
      rules[22] = new ParserRule(14,0,22,1,2);
      rules[23] = new ParserRule(8,3,23,1);
      rules[24] = new ParserRule(15,0,24,1,2);
      rules[25] = new ParserRule(8,4,25,2);
      rules[26] = new ParserRule(8,2,26,2);
      rules[27] = new ParserRule(8,3,27,1,2);
      rules[28] = new ParserRule(12,1,28,1,2);
      rules[29] = new ParserRule(12,3,29,1,2);
    }

  /* ************** */
  /* PARSER ACTIONS */
  /* ************** */

  static void initializeParserActions ()
    {
      actions = new ParserAction[210];

      newAction(0,5,0);
      newAction(1,2,0);
      newAction(2,0,3);
      newAction(3,0,7);
      newAction(4,0,9);
      newAction(5,1,12);
      newAction(6,1,12);
      newAction(7,1,12);
      newAction(8,1,12);
      newAction(9,1,12);
      newAction(10,1,12);
      newAction(11,1,1);
      newAction(12,0,7);
      newAction(13,0,9);
      newAction(14,1,12);
      newAction(15,1,12);
      newAction(16,1,12);
      newAction(17,1,12);
      newAction(18,1,12);
      newAction(19,1,12);
      newAction(20,0,7);
      newAction(21,0,9);
      newAction(22,1,12);
      newAction(23,1,12);
      newAction(24,1,12);
      newAction(25,1,12);
      newAction(26,1,12);
      newAction(27,1,12);
      newAction(28,1,7);
      newAction(29,1,10);
      newAction(30,1,10);
      newAction(31,1,10);
      newAction(32,1,10);
      newAction(33,1,10);
      newAction(34,1,10);
      newAction(35,1,10);
      newAction(36,1,10);
      newAction(37,1,8);
      newAction(38,0,13);
      newAction(39,0,14);
      newAction(40,0,15);
      newAction(41,0,16);
      newAction(42,0,17);
      newAction(43,0,19);
      newAction(44,1,15);
      newAction(45,0,11);
      newAction(46,1,16);
      newAction(47,1,16);
      newAction(48,1,16);
      newAction(49,1,16);
      newAction(50,1,16);
      newAction(51,1,16);
      newAction(52,1,16);
      newAction(53,1,16);
      newAction(54,0,21);
      newAction(55,0,22);
      newAction(56,1,13);
      newAction(57,1,3);
      newAction(58,1,3);
      newAction(59,1,3);
      newAction(60,1,3);
      newAction(61,1,3);
      newAction(62,1,3);
      newAction(63,1,22);
      newAction(64,1,22);
      newAction(65,1,22);
      newAction(66,1,22);
      newAction(67,3,0);
      newAction(68,1,22);
      newAction(69,3,0);
      newAction(70,1,22);
      newAction(71,3,0);
      newAction(72,1,4);
      newAction(73,1,4);
      newAction(74,1,4);
      newAction(75,1,4);
      newAction(76,1,4);
      newAction(77,1,4);
      newAction(78,1,5);
      newAction(79,1,5);
      newAction(80,1,5);
      newAction(81,1,5);
      newAction(82,1,5);
      newAction(83,1,5);
      newAction(84,1,17);
      newAction(85,1,17);
      newAction(86,1,17);
      newAction(87,1,17);
      newAction(88,1,17);
      newAction(89,1,17);
      newAction(90,1,18);
      newAction(91,1,18);
      newAction(92,1,18);
      newAction(93,1,18);
      newAction(94,1,18);
      newAction(95,1,19);
      newAction(96,1,19);
      newAction(97,1,19);
      newAction(98,1,19);
      newAction(99,1,19);
      newAction(100,0,26);
      newAction(101,0,13);
      newAction(102,0,14);
      newAction(103,0,15);
      newAction(104,0,16);
      newAction(105,0,17);
      newAction(106,0,19);
      newAction(107,0,21);
      newAction(108,0,22);
      newAction(109,0,23);
      newAction(110,1,24);
      newAction(111,1,24);
      newAction(112,1,24);
      newAction(113,1,24);
      newAction(114,1,24);
      newAction(115,1,24);
      newAction(116,1,26);
      newAction(117,1,26);
      newAction(118,1,26);
      newAction(119,1,26);
      newAction(120,1,26);
      newAction(121,1,27);
      newAction(122,1,27);
      newAction(123,1,27);
      newAction(124,1,27);
      newAction(125,1,27);
      newAction(126,0,13);
      newAction(127,0,14);
      newAction(128,0,15);
      newAction(129,0,16);
      newAction(130,0,17);
      newAction(131,0,19);
      newAction(132,0,21);
      newAction(133,1,25);
      newAction(134,3,0);
      newAction(135,1,25);
      newAction(136,1,25);
      newAction(137,1,25);
      newAction(138,1,25);
      newAction(139,0,22);
      newAction(140,3,1);
      newAction(141,1,20);
      newAction(142,1,20);
      newAction(143,1,20);
      newAction(144,1,20);
      newAction(145,1,20);
      newAction(146,1,20);
      newAction(147,0,13);
      newAction(148,0,14);
      newAction(149,0,15);
      newAction(150,0,16);
      newAction(151,0,17);
      newAction(152,0,19);
      newAction(153,0,30);
      newAction(154,0,31);
      newAction(155,0,21);
      newAction(156,0,22);
      newAction(157,1,28);
      newAction(158,1,28);
      newAction(159,1,21);
      newAction(160,1,21);
      newAction(161,1,21);
      newAction(162,1,21);
      newAction(163,1,21);
      newAction(164,0,13);
      newAction(165,0,14);
      newAction(166,0,15);
      newAction(167,0,16);
      newAction(168,0,17);
      newAction(169,0,19);
      newAction(170,0,21);
      newAction(171,0,22);
      newAction(172,1,29);
      newAction(173,1,29);
      newAction(174,0,13);
      newAction(175,0,14);
      newAction(176,0,15);
      newAction(177,0,16);
      newAction(178,0,17);
      newAction(179,0,19);
      newAction(180,1,23);
      newAction(181,1,23);
      newAction(182,1,23);
      newAction(183,1,23);
      newAction(184,1,23);
      newAction(185,0,21);
      newAction(186,3,0);
      newAction(187,0,22);
      newAction(188,3,1);
      newAction(189,0,36);
      newAction(190,1,14);
      newAction(191,1,14);
      newAction(192,1,14);
      newAction(193,1,14);
      newAction(194,1,14);
      newAction(195,1,14);
      newAction(196,1,14);
      newAction(197,1,14);
      newAction(198,0,38);
      newAction(199,1,9);
      newAction(200,1,6);
      newAction(201,1,11);
      newAction(202,1,11);
      newAction(203,1,11);
      newAction(204,1,11);
      newAction(205,1,11);
      newAction(206,1,11);
      newAction(207,1,11);
      newAction(208,1,11);
      newAction(209,1,2);
    }

  /* ************* */
  /* PARSER STATES */
  /* ************* */

  static void initializeParserStates ()
    {
      states = new ParserState[42];

      for (int i=0; i<42; i++) newState(i);
    }

  /* ************* */
  /* ACTION TABLES */
  /* ************* */

  static void initializeActionTables ()
    {
      newActionTables(36);

      newActionTable(0,9);
	setAction(0,2,4);
	setAction(0,3,2);
	setAction(0,4,5);
	setAction(0,5,6);
	setAction(0,6,7);
	setAction(0,7,8);
	setAction(0,8,9);
	setAction(0,9,3);
	setAction(0,11,10);

      newActionTable(1,1);
	setAction(1,1,1);

      newActionTable(2,1);
	setAction(2,1,11);

      newActionTable(3,8);
	setAction(3,2,13);
	setAction(3,4,14);
	setAction(3,5,15);
	setAction(3,6,16);
	setAction(3,7,17);
	setAction(3,8,18);
	setAction(3,9,12);
	setAction(3,11,19);

      newActionTable(4,1);
	setAction(4,1,28);

      newActionTable(5,8);
	setAction(5,2,29);
	setAction(5,4,30);
	setAction(5,5,31);
	setAction(5,6,32);
	setAction(5,7,33);
	setAction(5,8,34);
	setAction(5,9,35);
	setAction(5,11,36);

      newActionTable(6,1);
	setAction(6,10,37);

      newActionTable(7,6);
	setAction(7,4,42);
	setAction(7,5,41);
	setAction(7,6,38);
	setAction(7,7,39);
	setAction(7,8,40);
	setAction(7,11,43);

      newActionTable(8,1);
	setAction(8,10,44);

      newActionTable(9,1);
	setAction(9,10,45);

      newActionTable(10,8);
	setAction(10,2,46);
	setAction(10,4,47);
	setAction(10,5,48);
	setAction(10,6,49);
	setAction(10,7,50);
	setAction(10,8,51);
	setAction(10,9,52);
	setAction(10,11,53);

      newActionTable(11,3);
	setAction(11,7,54);
	setAction(11,8,55);
	setAction(11,10,56);

      newActionTable(12,9);
	setAction(12,4,63);
	setAction(12,5,64);
	setAction(12,6,65);
	setAction(12,7,67);
	setAction(12,8,69);
	setAction(12,10,59);
	setAction(12,11,71);
	setAction(12,12,61);
	setAction(12,13,62);

      newActionTable(13,6);
	setAction(13,7,72);
	setAction(13,8,73);
	setAction(13,10,74);
	setAction(13,11,75);
	setAction(13,12,76);
	setAction(13,13,77);

      newActionTable(14,6);
	setAction(14,7,78);
	setAction(14,8,79);
	setAction(14,10,80);
	setAction(14,11,81);
	setAction(14,12,82);
	setAction(14,13,83);

      newActionTable(15,6);
	setAction(15,7,84);
	setAction(15,8,85);
	setAction(15,10,86);
	setAction(15,11,87);
	setAction(15,12,88);
	setAction(15,13,89);

      newActionTable(16,5);
	setAction(16,7,90);
	setAction(16,8,91);
	setAction(16,10,92);
	setAction(16,12,93);
	setAction(16,13,94);

      newActionTable(17,6);
	setAction(17,7,95);
	setAction(17,8,96);
	setAction(17,10,97);
	setAction(17,11,100);
	setAction(17,12,98);
	setAction(17,13,99);

      newActionTable(18,3);
	setAction(18,7,107);
	setAction(18,8,108);
	setAction(18,12,109);

      newActionTable(19,6);
	setAction(19,4,110);
	setAction(19,5,111);
	setAction(19,6,112);
	setAction(19,7,113);
	setAction(19,8,114);
	setAction(19,11,115);

      newActionTable(20,5);
	setAction(20,7,116);
	setAction(20,8,117);
	setAction(20,10,118);
	setAction(20,12,119);
	setAction(20,13,120);

      newActionTable(21,5);
	setAction(21,7,121);
	setAction(21,8,122);
	setAction(21,10,123);
	setAction(21,12,124);
	setAction(21,13,125);

      newActionTable(22,5);
	setAction(22,7,134);
	setAction(22,8,140);
	setAction(22,10,136);
	setAction(22,12,137);
	setAction(22,13,138);

      newActionTable(23,6);
	setAction(23,4,141);
	setAction(23,5,142);
	setAction(23,6,143);
	setAction(23,7,144);
	setAction(23,8,145);
	setAction(23,11,146);

      newActionTable(24,2);
	setAction(24,12,153);
	setAction(24,13,154);

      newActionTable(25,4);
	setAction(25,7,155);
	setAction(25,8,156);
	setAction(25,12,157);
	setAction(25,13,158);

      newActionTable(26,5);
	setAction(26,7,159);
	setAction(26,8,160);
	setAction(26,10,161);
	setAction(26,12,162);
	setAction(26,13,163);

      newActionTable(27,4);
	setAction(27,7,170);
	setAction(27,8,171);
	setAction(27,12,172);
	setAction(27,13,173);

      newActionTable(28,5);
	setAction(28,7,186);
	setAction(28,8,188);
	setAction(28,10,182);
	setAction(28,12,183);
	setAction(28,13,184);

      newActionTable(29,1);
	setAction(29,10,189);

      newActionTable(30,8);
	setAction(30,2,190);
	setAction(30,4,191);
	setAction(30,5,192);
	setAction(30,6,193);
	setAction(30,7,194);
	setAction(30,8,195);
	setAction(30,9,196);
	setAction(30,11,197);

      newActionTable(31,1);
	setAction(31,10,198);

      newActionTable(32,1);
	setAction(32,1,199);

      newActionTable(33,1);
	setAction(33,1,200);

      newActionTable(34,8);
	setAction(34,2,201);
	setAction(34,4,202);
	setAction(34,5,203);
	setAction(34,6,204);
	setAction(34,7,205);
	setAction(34,8,206);
	setAction(34,9,207);
	setAction(34,11,208);

      newActionTable(35,1);
	setAction(35,1,209);

    }

  /* *********** */
  /* GOTO TABLES */
  /* *********** */

  static void initializeGotoTables ()
    {
      newGotoTables(16);

      newGotoTable(0,6);
	setGoto(0,1,1);
	setGoto(0,2,2);
	setGoto(0,4,4);
	setGoto(0,5,5);
	setGoto(0,7,6);
	setGoto(0,9,8);

      newGotoTable(1,0);

      newGotoTable(2,5);
	setGoto(2,2,41);
	setGoto(2,4,4);
	setGoto(2,5,5);
	setGoto(2,7,6);
	setGoto(2,9,8);

      newGotoTable(3,3);
	setGoto(3,5,39);
	setGoto(3,7,40);
	setGoto(3,9,8);

      newGotoTable(4,1);
	setGoto(4,6,37);

      newGotoTable(5,2);
	setGoto(5,3,18);
	setGoto(5,8,12);

      newGotoTable(6,1);
	setGoto(6,11,10);

      newGotoTable(7,1);
	setGoto(7,10,35);

      newGotoTable(8,1);
	setGoto(8,14,33);

      newGotoTable(9,2);
	setGoto(9,3,18);
	setGoto(9,8,20);

      newGotoTable(10,1);
	setGoto(10,15,24);

      newGotoTable(11,2);
	setGoto(11,3,18);
	setGoto(11,8,25);

      newGotoTable(12,1);
	setGoto(12,13,27);

      newGotoTable(13,3);
	setGoto(13,3,18);
	setGoto(13,8,29);
	setGoto(13,12,28);

      newGotoTable(14,2);
	setGoto(14,3,18);
	setGoto(14,8,32);

      newGotoTable(15,2);
	setGoto(15,3,18);
	setGoto(15,8,34);

    }

  /* ************ */
  /* STATE TABLES */
  /* ************ */

  static void initializeStateTables ()
    {
      setTables(0,0,0);
      setTables(1,1,1);
      setTables(2,2,1);
      setTables(3,3,2);
      setTables(4,3,3);
      setTables(5,4,1);
      setTables(6,5,1);
      setTables(7,6,4);
      setTables(8,7,5);
      setTables(9,8,6);
      setTables(10,9,1);
      setTables(11,10,1);
      setTables(12,11,7);
      setTables(13,12,8);
//    Dynamic Actions in State 13:
	 newDynamicActionTable(13,1);
	     newDynamicActions(13,0,2);
	      setDynamicAction(13,0,0,57);
	      setDynamicAction(13,0,1,66);
      setTables(14,13,1);
      setTables(15,14,1);
      setTables(16,15,1);
      setTables(17,16,1);
      setTables(18,17,1);
      setTables(19,7,9);
      setTables(20,18,1);
      setTables(21,19,10);
      setTables(22,20,1);
      setTables(23,21,1);
      setTables(24,7,11);
      setTables(25,22,1);
//    Dynamic Actions in State 25:
	 newDynamicActionTable(25,2);
	     newDynamicActions(25,0,2);
	      setDynamicAction(25,0,0,132);
	      setDynamicAction(25,0,1,133);
	     newDynamicActions(25,1,2);
	      setDynamicAction(25,1,0,135);
	      setDynamicAction(25,1,1,139);
      setTables(26,23,12);
      setTables(27,7,13);
      setTables(28,24,1);
      setTables(29,25,1);
      setTables(30,26,1);
      setTables(31,7,14);
      setTables(32,27,1);
      setTables(33,7,15);
      setTables(34,28,1);
//    Dynamic Actions in State 34:
	 newDynamicActionTable(34,2);
	     newDynamicActions(34,0,2);
	      setDynamicAction(34,0,0,180);
	      setDynamicAction(34,0,1,185);
	     newDynamicActions(34,1,2);
	      setDynamicAction(34,1,0,181);
	      setDynamicAction(34,1,1,187);
      setTables(35,29,1);
      setTables(36,30,1);
      setTables(37,31,1);
      setTables(38,32,1);
      setTables(39,33,1);
      setTables(40,34,1);
      setTables(41,35,1);
    }
}

/* ***************** */
/* ANCILLARY CLASSES */
/* ***************** */


/**
 * Ancillary classes
 */

class Term
{
  String functor = null;
  Vector body = null;
  double number = Double.NaN;
  boolean isInteger = false;

  Term (double n)
    {
      number = n;
    }

  Term (int n)
    {
      number = n;
      isInteger = true;
    }

  Term (String functor)
    {
      this.functor = functor;
    }

  Term (String functor, Vector body)
    {
      this.functor = functor;
      this.body = body;
    }

  public final boolean isNumber ()
    {
      return !Double.isNaN(number);
    }

  public final boolean hasBody ()
    {
      return (body != null && !body.isEmpty());
    }

  public String toString ()
    {
      if (isNumber())
        return(isInteger ? String.valueOf((int)number)
                         : String.valueOf(number));

      if (!hasBody())
        return functor;
      
      StringBuffer s = new StringBuffer(functor);

      s.append("(");
      for (int i=0; i<body.size(); i++)
        {
          s.append(body.get(i));
          if (i<body.size()-1) s.append(",");
        }
      s.append(")");

      return s.toString();
    }
}


