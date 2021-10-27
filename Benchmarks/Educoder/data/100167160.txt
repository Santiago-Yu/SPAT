import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Java_LexAnalysis
{
    private static String[] strings =
            {
                  //   1     2         3     4       5       6             7      8
                    "auto","break", "case","char", "const","continue", "default","do",
                  //   9       10       11     12        13     14    15    16
                    "double","else", "enum","extern", "float","for", "goto","if",
                  //  17     18     19         20        21       22        23      24
                    "int","long", "register","return", "short","signed", "sizeof","static",
                  //  25         26     27         28        29      30        31         32
                    "struct","switch", "typedef","union", "unsigned","void", "volatile","while",
                  // 33  34    35   36   37   38   39   40   41   42   43   44  45   46   47   48
                    "-","--", "-=","->", "!","!=", "%","%=", "&","&&", "&=","(", ")","*", "*=",",",
                  //49  50   51   52   53  54  55  56  57    58   59  60   61   62    63  64   65  66
                    ".","/", "/=",":", ";","?","[","]", "^","^=", "{","|", "||","|=", "}","~", "+","++",
                  // 67  68  69      70   71   72   73     74   75   76     77     78
                    "+=","<", "<<","<<=", "<=","=", "==", ">", ">=", ">>", ">>=", "\""
                  //     79      80     81
                  // "/*注释*/和//注释 ", "常数", "标识符"
                  // 这三个分别处理
            };
    private static Character[] ops =
            {
                    '+','-','*','/','=','<','>','!','%','&','(',')','*',',','.',':',';','[',']','^','{','}',
                    '|','~','"'
            };
    private static HashSet<Character> opmap;
    private static StringBuffer prog = new StringBuffer();
    private static HashMap<String,Integer> map;
    private static int count = 1;

    /**
     *  this method is to read the standard input
     */
    private static void read_prog()
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            prog.append(sc.nextLine());
            prog.append('\n');
        }
    }

    // add your method here!!

    private static void solution()
    {
        String temp = new String(prog);
        temp += '?';//终止
        String word = "";
        char ch;
        int length = prog.length();
        for(int i = 0; i < length; i++)
        {
            //处理标识符和关键字
            ch = temp.charAt(i);
            if(isLetter(ch))
            {
                while(isLetter(ch)||isDigit(ch))
                {
                    word += ch;
                    ch = temp.charAt(++i);
                }
                coutWithLetters(word);
                word = "";
                i--;
            }
            //处理常数
            else if(isDigit(ch))
            {
                while(isDigit(ch))
                {
                    word += ch;
                    ch = temp.charAt(++i);
                }
                coutWithDigits(word);
                word = "";
                i--;
            }
            //处理操作符
            else if(isOp(ch))
            {
                while(isOp(ch))
                {
                    word += ch;
                    char next = temp.charAt(i+1);
                    //处理""内字符串
                    if(ch=='"')
                    {
                        coutWithOps(word);
                        word = "";
                        while(true)
                        {
                            ch = temp.charAt(++i);
                            if(ch=='"')
                            {
                                coutWithLetters(word);
                                word = "";
                                word += ch;
                                break;
                            }
                            else
                            {
                                word += ch;
                            }
                        }
                    }
                    //处理/* */注释
                    else if(ch=='/' && next=='*')
                    {
                        word += next;
                        i++;
                        while(true)
                        {
                            ch = temp.charAt(++i);
                            next = temp.charAt(i+1);
                            word += ch;
                            if(ch=='*' && next=='/')
                            {
                                word += next;
                                i++;
                                break;
                            }
                        }
                    }
                    //处理//注释
                    else if(ch=='/' && next=='/')
                    {
                        word += next;
                        i++;
                        while(true)
                        {
                            ch = temp.charAt(++i);
                            if(ch!='\n'&& ch!='\r')
                            {
                                word += ch;
                            }
                            else
                            {
                                ch = temp.charAt(++i);
                                break;
                            }

                        }
                    }
                    //处理形如 ++ -- +=的操作符
                    if(canAppendOp(ch,next))
                    {
                        i++;
                        ch = next;
                    }
                    //单个的操作符 如 +-/*
                    else
                    {
                        break;
                    }
                }
                coutWithOps(word);
                word = "";
            }
        }
    }

    private static Boolean canAppendOp(char ch,char next)
    {
        switch(next){
            case '-':
                return ch == '-';
            case '=':
                return ch == '-' || ch == '!' || ch == '%' || ch == '&' || ch == '*'
                        || ch == '/' || ch == '^' || ch == '|' || ch == '+' || ch == '<'
                        || ch == '>' || ch == '=';
            case '&':
                return ch == '&';
            case '|':
                return ch == '|';
            case '+':
                return ch == '+';
            case '<':
                return ch == '<';
            case '>':
                return ch == '>';
            default:
                return false;
        }
    }

    private static void coutWithLetters(String word)
    {
        if(count>1)
            System.out.print("\n");
        System.out.print(count + ": <" + word + "," + map.getOrDefault(word, 81) + ">");
        count++;
    }

    private static void coutWithDigits(String word)
    {
        if(count>1)
            System.out.print("\n");
        System.out.print(count+": <"+word +","+ 80+">");
        count++;
    }

    private static void coutWithOps(String word)
    {
        if(count>1)
            System.out.print("\n");
        if(map.containsKey(word))
        {
            System.out.print(count+": <"+word +","+ map.get(word)+">");
        }
        else
        {
            System.out.print(count+": <"+word +","+ 79+">");
        }
        count++;
    }

    private static Boolean isLetter(char c)
    {
        return Character.isLetter(c) || c=='_';
    }

    private static Boolean isDigit(char c)
    {
        return Character.isDigit(c);
    }

    private static Boolean isBlank(char c)
    {
        return Character.isWhitespace(c);
    }
    //是操作符
    private static Boolean isOp(char c)
    {
        return opmap.contains(c);
    }

    private static void initHashMap()
    {
        map = new HashMap<>();
        for(int i = 0; i < strings.length; i++)
        {
            map.put(strings[i],i+1);
        }
        opmap = new HashSet<>();
        Collections.addAll(opmap, ops);

    }


    /**
     *  you should add some code in this method to achieve this lab
     */
    private static void analysis()
    {
        initHashMap();
        read_prog();
        solution();
        //System.out.print(prog);
    }

    /**
     * this is the main method
     * @param args
     */
    public static void main(String[] args)
    {
        analysis();
    }
}
