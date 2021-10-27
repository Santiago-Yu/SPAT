class n11499799 {
	public InputLattice(String file, int type, boolean convertJoinMeet) throws FileNotFoundException, IOException {
        InputStream latStream = null;
        labels = new Vector();
        upperCoversVector = new Vector();
        Vector upperCovers = new Vector();
        edgeColors = new Hashtable();
        Vector upperCovering = new Vector();
        int level = 0;
        String str;
        String currentElt = null;
        String cover = null;
        boolean first = true;
        StreamTokenizer in;
        switch(type) {
            case FILE:
                latStream = new FileInputStream(file);
                break;
            case STRING:
                latStream = new StringBufferInputStream(file);
                break;
            case URL:
                URL url = new URL("http", Config.HOST, Config.PORT, "/" + Config.HASSE + "/" + Config.URL_STREAMER + file);
                System.out.println("url is " + url);
                URLConnection connection = url.openConnection();
                latStream = new DataInputStream(connection.getInputStream());
                break;
        }
        in = new StreamTokenizer(latStream);
        in.wordChars('^', '_');
        in.wordChars('*', '.');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD || in.ttype == StreamTokenizer.TT_NUMBER || in.ttype == '"') {
                str = (in.ttype == StreamTokenizer.TT_NUMBER) ? "" + Math.round(in.nval) : in.sval;
                if (convertJoinMeet && level > 1) {
                    str = stringSubstitute(str, joinStr, joinSign);
                    str = stringSubstitute(str, meetStr, meetSign);
                }
                name = (level == 1) ? new String(str) : name;
                if (level == 2) {
                    labels.addElement(str);
                    currentElt = str;
                }
                if (level == 3) {
                    upperCovers.addElement(str);
                }
                if (level == 4) {
                    if (first) {
                        upperCovers.addElement(str);
                        cover = str;
                        first = false;
                    } else {
                        edgeColors.put(new Edge(currentElt, cover), str);
                    }
                }
            }
            if (in.ttype == '(') {
                level++;
                upperCovers = (level == 3) ? new Vector() : upperCovers;
            }
            if (in.ttype == ')') {
                level--;
                first = (level == 3) ? true : first;
                if (level == 2) upperCoversVector.addElement(upperCovers);
                if (level == 0) {
                    if (latStream != null) latStream.close();
                    return;
                }
            }
        }
    }

}