import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java_TranslationSchemaAnalysis
{
    static int num = 1;
    static HashMap<String,String> values = new HashMap<>();
    static HashMap<String, ArrayList<String>> expMap = new HashMap<>();
    static HashMap<String, HashSet<String>> firstMap = new HashMap<>();
    static HashMap<String,HashSet<String>> firstMap2 = new HashMap<>();
    static HashMap<String,HashSet<String>> followMap = new HashMap<>();

    static HashMap<String,Integer> expNumberMap = new HashMap<>();
    static HashMap<Integer,String> NumberExp = new HashMap<>();
    static HashMap<String,Integer> tableMap = new HashMap<>();

    static HashSet<String> nonTerminalSet = new HashSet<>();
    static HashSet<String> terminalSet = new HashSet<>();

    static Stack<Pair> stack = new Stack<>();
    static Queue<Pair> output = new LinkedList<>();

    private static StringBuffer prog = new StringBuffer();
    static ArrayList<XX> zz = new ArrayList<>();
    static Pair wrong;

    static ArrayList<String> wr = new ArrayList<>();

    static int valueQueuePos=0;
    static int idQueuePos=0;

    static Queue<String> valueQueue = new LinkedList<String>();
    static Queue<String> idQueue = new LinkedList<String>();


    static class XX{
        int hang;
        String s;

        public XX(int hang, String s) {
            this.hang = hang;
            this.s = s;
        }
        ArrayList<XX> next = new ArrayList<>();
    }

    static class Pair{
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        String value;
        String type;
        int n;
        String s;
        Pair(int n,String s){
            this.n = n;
            this.s = s;
        }
        ArrayList<Pair> next = new ArrayList<Pair>();
    }
    static Pair root;
    static Pair createTree(){
        Pair ro=output.poll();
        Pair temp = ro;
        while(!output.isEmpty()){
            for(Pair p : output){
                assert temp != null;
                if(p.n==temp.n+1) {
                    temp.next.add(p);
                }
                else if(p.n<temp.n+1)
                    break;
            }
            temp = output.poll();
        }
        return ro;
    }


    static String wenfa =  "S  ->  program\n" +
            "program  ->  decls compoundstmt\n" +
            "decls  ->  decl ; decls  |  E\n" +
            "decl  ->  int ID = INTNUM  |  real ID = REALNUM\n" +
            "stmt  ->  ifstmt  |  assgstmt  |  compoundstmt\n" +
            "compoundstmt  ->  { stmts }\n" +
            "stmts  ->  stmt stmts  |  E\n" +
            "ifstmt  ->  if ( boolexpr ) then stmt else stmt\n" +
            "assgstmt  ->  ID = arithexpr ;\n" +
            "boolexpr  ->  arithexpr boolop arithexpr\n" +
            "boolop  ->  <  |  >  |  <=  |  >=  |  ==\n" +
            "arithexpr  ->  multexpr arithexprprime\n" +
            "arithexprprime  ->  + multexpr arithexprprime  |  - multexpr arithexprprime  |  E\n" +
            "multexpr  ->  simpleexpr multexprprime\n" +
            "multexprprime  ->  * simpleexpr multexprprime  |  / simpleexpr multexprprime  |  E\n" +
            "simpleexpr  ->  ID  |  INTNUM  |  REALNUM  |  ( arithexpr )";

    /**
     *  this method is to read the standard input
     */
    private static void read_prog()
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            prog.append(sc.nextLine());
            prog.append("!");
        }
    }


    // add your method here!!

    private static void readIn(String in){
        String reg="-> | [|]";
        String[] a = in.split(reg);
        ArrayList<String> aList = new ArrayList<>();
        for(int i = 1; i < a.length; i++) {
            aList.add(a[i].trim());
            for(String aa : a[i].trim().split(" "))
                if(!aa.equals(""))
                    terminalSet.add(aa.trim());
            expNumberMap.put(a[0].trim()+"->"+a[i].trim(), num);
            NumberExp.put(num++,a[0].trim()+"->"+a[i].trim());
        }
        expMap.put(a[0].trim(), aList);
        nonTerminalSet.add(a[0].trim());
        terminalSet.add(a[0].trim());
    }

    private static void runFirstList(String exp){
        if (firstMap.containsKey(exp))
            return;
        HashSet<String> list = new HashSet<>();
        if (terminalSet.contains(exp)) {
            list.add(exp);
            firstMap.put(exp, list);
            return;
        }
        for (String s : expMap.get(exp)) {
            if ("E".equals(exp)) {
                list.add("E");
            } else {
                for (String temp : s.split(" ")) {
                    if (!firstMap.containsKey(temp))
                        runFirstList(temp);
                    list.addAll(firstMap.get(temp));
                    if (!firstMap.get(temp).contains("E")) {
                        list.remove("E");
                        break;
                    }
                }
            }
        }
        firstMap.put(exp, list);
    }

    private static HashSet<String> getFirst(String ss){
        if(ss.equals("") || ss.equals(" ") )
            return null;
        HashSet<String> set = new HashSet<>();
        if (firstMap2.containsKey(ss))
            return new HashSet<String>(firstMap2.get(ss));
        String[] aa = ss.split(" ");
        for(int i = 0; i < aa.length; i++){
            if(!aa[i].equals("")){
                if (!firstMap.containsKey(aa[i]))
                    runFirstList(aa[i]);
                HashSet<String> temp = firstMap.get(aa[i]);
                set.addAll(temp);
                if (temp.contains("E")) {
                    i++;
                }
                else
                    break;
                if (i == aa.length) {
                    set.add("E");
                }
            }
        }
        firstMap2.put(ss,set);
        return set;
    }

    private static void runFollowList1(String exp){
        HashSet<String> followBegin = followMap.containsKey(exp) ? followMap.get(exp) : new HashSet<>();
        for (String ss : nonTerminalSet) {
            for (String s : expMap.get(ss)) {
                String[] e = s.split(" ");
                for (int i = 0; i < e.length - 1; i++) {
                    if(exp.equals(e[i])){
                        StringBuilder temp = new StringBuilder();
                        for(int j=i+1;j<e.length;j++)
                            temp.append(e[j]+" ");
                        HashSet<String> tt = getFirst(temp.toString().trim());
                        if(tt!=null&&!tt.contains("E"))
                            followBegin.addAll(tt);
                    }
                }
            }
        }
        followMap.put(exp, followBegin);
    }

    private static void runFollowList2(String exp){
        //int change = 0;
        ArrayList<String> exps = expMap.get(exp);
        for(String s : exps){
            String[] ss = s.split(" ");
            for(int i=ss.length-1;i>=0;i--){
                if(nonTerminalSet.contains(ss[i])&& i < ss.length - 1){
                    HashSet<String> follow = new HashSet<>();
                    StringBuilder temp = new StringBuilder();
                    for(int j=i+1;j<ss.length;j++)
                        temp.append(ss[j]+" ");
                    HashSet<String> first = getFirst(temp.toString().trim());
                    if(first.contains("E")){
                        first.remove("E");
                        follow.addAll(first);
                        follow.addAll(followMap.get(exp));
                        follow.addAll(followMap.get(ss[i]));
                        followMap.put(ss[i],follow);
                    }
                }
                else if(nonTerminalSet.contains(ss[i])&& i == ss.length - 1){
                    HashSet<String> follow = new HashSet<>();
                    follow.addAll(followMap.get(exp));
                    follow.addAll(followMap.get(ss[i]));
                    followMap.put(ss[i],follow);
                }

            }
        }

        //return change;
    }

    private static void createTable(){
        for(String nonT : nonTerminalSet){
            for(String ss : expMap.get(nonT)){
                HashSet<String> first = getFirst(ss);
                for(String s : first){
                    tableMap.put(nonT+"->"+s,expNumberMap.get(nonT+"->"+ss));
                }
                if(first.contains("E")){
                    for(String s : followMap.get(nonT)){
                        tableMap.put(nonT+"->"+s,expNumberMap.get(nonT+"->E"));
                    }
                }
            }
        }
    }

    private static boolean isInteger(String str) {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(str);
            if( !isNum.matches() ){
                return false;
            }
            return true;
    }

    private static boolean isDouble(String str) {
        for(char i : str.toCharArray()){
            if(i=='.'){
                return true;
            }
        }
        return false;
    }



    private static void gogogo() {
        int tab = 0;
        stack.push(new Pair(0,"$"));
        stack.push(new Pair(0,"program"));
        Pair top = stack.peek();
        int pos = 0;
        String type = "";
        while(!top.s.equals("$")){
            XX nowIn = zz.get(pos);
            if(nowIn.s.length()==1&&nowIn.s.charAt(0)>='a'&&nowIn.s.charAt(0)<='z')
            {
                idQueue.add(nowIn.s);
                nowIn.s="ID";
            } else if(nowIn.s.equals("int")){
                type="INTNUM";
            }
            else if(nowIn.s.equals("real")){
                type="REALNUM";
            }
            else if(isInteger(nowIn.s)||isDouble(nowIn.s)){
                valueQueue.add(nowIn.s);
                nowIn.s=type;
            }
            if (top.s.equals(nowIn.s)) {
                Pair out = stack.pop();
                output.add(out);
                pos++;
            } else if(tableMap.containsKey(top.s+"->"+nowIn.s)){
                String replace = NumberExp.get(tableMap.get(top.s+"->"+nowIn.s));
                String[] r = replace.split("->");
                String[] re = r[1].trim().split(" ");
                Pair out = stack.pop();
                output.add(out);
                for(int i=re.length-1;i>=0;i--){
                    if(!re[i].equals("")) {
                        stack.push(new Pair(top.n + 1, re[i]));
                    }
                }
            } else if(terminalSet.contains(top.s)) {
                Pair out = stack.pop();
                output.add(new Pair(out.n,out.s));
            }
            else {
                String replace = NumberExp.get(tableMap.get(top.s+"->"+";"));
                String[] r = replace.split("->");
                String[] re = r[1].trim().split(" ");
                Pair out = stack.pop();
                wrong = new Pair(nowIn.hang-1, stack.peek().s);
                output.add(out);
                for(int i=re.length-1;i>=0;i--){
                    if(!re[i].equals("")) {
                        stack.push(new Pair(top.n + 1, re[i]));
                    }
                }
            }
            top = stack.peek();
        }
    }

    private static void printtt(Pair out) {
        for(int i=0;i<out.n;i++){
            System.out.print("\t");
        }
        System.out.print(out.s);
    }

    /**
     *  you should add some code in this method to achieve this lab
     */
    private static void analysis()
    {
        read_prog();
        //System.out.println(prog.toString());
//        Pattern p = Pattern.compile("\\s+|\t|\r|\n");
//        Matcher m = p.matcher(prog.toString());
//        String aaaa = m.replaceAll(" ");
        String aaaa[] = prog.toString().split("!");
        // System.out.println(Arrays.toString(aaaa));
        for(int i =1;i<=aaaa.length;i++)
        {
            String t[] = aaaa[i-1].trim().split(" ");
            for(String s : t){
                zz.add(new XX(i,s));
            }
        }


        String[] in = wenfa.split("\n");
        //System.out.println(in);

        for(String a : in) {
            readIn(a);
        }

        //System.out.println(expMap);
        for(String nonT : nonTerminalSet){
            terminalSet.remove(nonT);
        }
        terminalSet.add("E");
//        System.out.println(terminalSet);
//        System.out.println(terminalSet.size());
//        System.out.println(expNumberMap);
        for(String exp : nonTerminalSet)
            runFirstList(exp);
        //System.out.println(firstMap);
        for(String exp : nonTerminalSet)
            runFollowList1(exp);
        followMap.get("S").add("$");

        //System.out.println(followMap);
        int change = 2;
        while(change != 0) {
            change--;
            for (String exp : nonTerminalSet)
                runFollowList2(exp);
            //change += runFollowList2(exp);
        }
        //System.out.println(followMap);
        //System.out.println(firstMap);
        createTable();
        //System.out.println(tableMap);

        gogogo();
//        if(wrong!=null){
//            System.out.println("语法错误,第"+wrong.n+"行,缺少\""+wrong.s+"\"");
//        }
//        while(output.size()>1){
//            printtt(output.poll());
//            System.out.print("\n");
//        }
//        printtt(output.poll());

        root = createTree();
        //preorder(root);
        program(root);
        num = 1;
    }
    public static void preorder(Pair root) {
        Stack<Pair> st = new Stack<Pair>();
        st.push(root);
        Pair p = null;
        while(!st.empty()){
            p = st.pop();
            if(p!=null){
                printtt(p);
                System.out.println("\n");
                for(int i=p.next.size()-1;i>=0;i--){
                    st.push(p.next.get(i));
                }
            }
        }
    }

    static void program(Pair root){
        decls(root.next.get(0));
        compoundstmt(root.next.get(1));
        myprint();
    }

    private static void myprint() {
        int i = 0;
        if(wr.isEmpty()) {
            for (String key : values.keySet()) {
                System.out.print(key + ": " + values.get(key));
                i++;
                if (i != values.keySet().size()) {
                    System.out.print("\n");
                }
            }
        }
        else{
            for (String key : wr) {
                System.out.print(key);
                i++;
                if (i != wr.size()) {
                    System.out.print("\n");
                }
            }
        }
    }

    private static void compoundstmt(Pair root) {
        stmts(root.next.get(1));
    }

    private static void stmts(Pair root) {
        if(root.next.size()!=1){
            stmt(root.next.get(0));
            stmts(root.next.get(1));
        }
    }

    private static void stmt(Pair root) {
        switch (root.next.get(0).s) {
            case "ifstmt":
                ifstmt(root.next.get(0));
                break;
            case "assgstmt":
                assgstmt(root.next.get(0));
                break;
            case "compoundstmt":
                compoundstmt(root.next.get(0));
                break;
        }
    }

    private static void assgstmt(Pair root) {
        String ID = idQueue.poll();
        Pair ret = arithexpr(root.next.get(2));
        assert ret != null;
        values.put(ID,ret.value);
    }

    private static Pair arithexpr(Pair root) {
        return arithexprprime(multexpr(root.next.get(0)),root.next.get(1));
    }

    private static Pair arithexprprime(Pair before, Pair root) {
        if(root.next.size()==1){
            return before;
        } else if(root.next.get(0).s.equals("+")){
            root.next.get(1).setValue(multexpr(root.next.get(1)).value);
            if(isDouble(before.value)||isDouble(root.next.get(1).value)){
                double ss = Double.parseDouble(before.value)+Double.parseDouble(root.next.get(1).value);
                Pair sum = new Pair(root.n,"sum");
                sum.setValue(String.valueOf(ss));
                return arithexprprime(sum,root.next.get(2));
            }
            else{
                int ss = Integer.parseInt(before.value)+Integer.parseInt(root.next.get(1).value);
                Pair sum = new Pair(root.n,"sum");
                sum.setValue(String.valueOf(ss));
                return arithexprprime(sum,root.next.get(2));
            }

        } else if(root.next.get(0).s.equals("-")){
            root.next.get(1).setValue(multexpr(root.next.get(1)).value);
            if(isDouble(before.value)||isDouble(root.next.get(1).value)){
                double ss = Double.parseDouble(before.value)-Double.parseDouble(root.next.get(1).value);
                Pair sub = new Pair(root.n,"sub");
                sub.setValue(String.valueOf(ss));
                return arithexprprime(sub,root.next.get(2));
            }
            else {
                int ss = Integer.parseInt(before.value)-Integer.parseInt(root.next.get(1).value);
                Pair sub = new Pair(root.n,"sub");
                sub.setValue(String.valueOf(ss));
                return arithexprprime(sub,root.next.get(2));
            }
        }
        return null;
    }

    private static Pair multexpr(Pair root) {
        return multexprprime(simpleexpr(root.next.get(0)),root.next.get(1));
    }

    private static Pair multexprprime(Pair before, Pair root) {
        if(root.next.size()==1){
            return before;
        } else if(root.next.get(0).s.equals("*")){
            root.next.get(1).setValue(simpleexpr(root.next.get(1)).value);
            if(isDouble(before.value)||isDouble(root.next.get(1).value)){
                double ss = Double.parseDouble(before.value)*Double.parseDouble(root.next.get(1).value);
                Pair sum = new Pair(root.n,"chenh");
                sum.setValue(String.valueOf(ss));
                return multexprprime(sum,root.next.get(2));
            } else{
                int ss = Integer.parseInt(before.value)*Integer.parseInt(root.next.get(1).value);
                Pair sum = new Pair(root.n,"chenh");
                sum.setValue(String.valueOf(ss));
                return multexprprime(sum,root.next.get(2));
            }
        } else if(root.next.get(0).s.equals("/")){
            root.next.get(1).setValue(simpleexpr(root.next.get(1)).value);
            if(isDouble(before.value)||isDouble(root.next.get(1).value)){
                if(Double.parseDouble(root.next.get(1).value)==0){
                    wr.add("error message:line 5,division by zero");
                    root.next.get(1).setValue("1");
                }
                double ss = Double.parseDouble(before.value)/Double.parseDouble(root.next.get(1).value);
                Pair sub = new Pair(root.n,"chu");
                sub.setValue(String.valueOf(ss));
                return multexprprime(sub,root.next.get(2));
            } else{
                int ss = Integer.parseInt(before.value)/Integer.parseInt(root.next.get(1).value);
                Pair sub = new Pair(root.n,"chu");
                sub.setValue(String.valueOf(ss));
                return multexprprime(sub,root.next.get(2));
            }
        }
        return null;
    }

    private static Pair simpleexpr(Pair root) {
        Pair ret = new Pair(root.n,"simp");
        switch (root.next.get(0).s) {
            case "ID":
                ret.setValue(values.get(idQueue.poll()));
                break;
            case "INTNUM":
                ret.setValue(valueQueue.poll());
                break;
            case "REALNUM":
                ret.setValue(valueQueue.poll());
                break;
            case "(":
                ret = arithexpr(root.next.get(1));
            break;
        }
        return ret;
    }

    private static void ifstmt(Pair root) {
        if(boolexpr(root.next.get(2))) {
            stmt(root.next.get(5));
            idQueue.poll();
            idQueue.poll();
            valueQueue.poll();
        }
        else {
            idQueue.poll();
            idQueue.poll();
            valueQueue.poll();
            stmt(root.next.get(7));
        }
    }

    private static Boolean boolexpr(Pair root) {
        return boolop(root.next.get(1),arithexpr(root.next.get(0)),arithexpr(root.next.get(2)));
    }

    private static Boolean boolop(Pair pair, Pair arithexpr, Pair arithexpr1) {
        String bb  = pair.next.get(0).s;
        int v1=1;
        int v2=2;
        int val1=1;
        int val2=1;
        double val3=1.0;
        double val4=1.0;
        if(isInteger(arithexpr.value)) {
            val1 = Integer.parseInt(arithexpr.value);
        } else {
            val3 = Double.parseDouble(arithexpr.value);
            v1=3;
        }
        if(isInteger(arithexpr1.value)) {
            val2 = Integer.parseInt(arithexpr1.value);
        } else {
            val4 = Double.parseDouble(arithexpr1.value);
            v2=4;
        }
        switch (bb){
            case "<":{
                return (v1==1?val1:val3)<(v2==2?val2:val4);
            }
            case ">":{
                return (v1==1?val1:val3)>(v2==2?val2:val4);
            }
            case "<=":{
                return (v1==1?val1:val3)<=(v2==2?val2:val4);
            }
            case ">=":{
                return (v1==1?val1:val3)>=(v2==2?val2:val4);
            }
            case "==":{
                return (v1==1?val1:val3)==(v2==2?val2:val4);
            }
            default:{
                return true;
            }
        }
    }

    private static void decls(Pair root) {
        if(root.next.size()!=1){
            decl(root.next.get(0));
            decls(root.next.get(2));
        }
    }

    private static void decl(Pair root) {
        if(root.next.get(0).s.equals("int")||root.next.get(0).s.equals("real")){
            typecheck(root);
            values.put(idQueue.poll(),valueQueue.poll());
        }
    }

    private static void typecheck(Pair root) {
        String ID = idQueue.peek();
        String value = valueQueue.peek();
        if(isDouble(value)){
            if(root.next.get(0).s.equals("int")){
                error(1);
            }
        } else if(isInteger(value)){
            if(root.next.get(0).s.equals("real")){
                error(2);
            }
        }
    }

    private static void error(int errorCode) {
        wr.add("error message:line 1,realnum can not be translated into int type");
    }


    /**
     * this is the main method
     * @param args
     */
    public static void main(String[] args) {
        analysis();
    }
}
