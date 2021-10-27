class n16869671 {
	public JavaCodeAnalyzer(String filenameIn, String filenameOut, String lineLength) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filenameIn));
            File tmp = File.createTempFile("JavaCodeAnalyzer", "tmp");
            BufferedWriter out = new BufferedWriter(new FileWriter(tmp));
            while (br.ready()) {
                out.write(br.read());
            }
            br.close();
            out.close();
            jco = new JavaCodeOutput(tmp, filenameOut, lineLength);
            SourceCodeParser p = new JavaCCParserFactory().createParser(new FileReader(tmp), null);
            List statements = p.parseCompilationUnit();
            ListIterator it = statements.listIterator();
            Node n;
            eh = new ExpressionHelper(this, jco);
            printLog("Parsed file " + filenameIn + "\n");
            while (it.hasNext()) {
                n = (Node) it.next();
                parseObject(n);
            }
            tmp.delete();
        } catch (Exception e) {
            System.err.println(getClass() + ": " + e);
        }
    }

}