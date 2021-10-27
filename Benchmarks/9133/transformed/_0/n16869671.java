class n16869671 {
	public JavaCodeAnalyzer(String kzNKcw6L, String O253SAVc, String t0UkN6N0) {
        try {
            File K7L3oFBu = File.createTempFile("JavaCodeAnalyzer", "tmp");
            BufferedReader LyRERACW = new BufferedReader(new FileReader(kzNKcw6L));
            BufferedWriter N9ILHgdY = new BufferedWriter(new FileWriter(K7L3oFBu));
            while (LyRERACW.ready()) {
                N9ILHgdY.write(LyRERACW.read());
            }
            LyRERACW.close();
            N9ILHgdY.close();
            jco = new JavaCodeOutput(K7L3oFBu, O253SAVc, t0UkN6N0);
            SourceCodeParser JhrQQufh = new JavaCCParserFactory().createParser(new FileReader(K7L3oFBu), null);
            List dU4gojSH = JhrQQufh.parseCompilationUnit();
            ListIterator TrgWyrhI = dU4gojSH.listIterator();
            eh = new ExpressionHelper(this, jco);
            Node C1yRKh7a;
            printLog("Parsed file " + kzNKcw6L + "\n");
            while (TrgWyrhI.hasNext()) {
                C1yRKh7a = (Node) TrgWyrhI.next();
                parseObject(C1yRKh7a);
            }
            K7L3oFBu.delete();
        } catch (Exception CU5UVHq8) {
            System.err.println(getClass() + ": " + CU5UVHq8);
        }
    }

}