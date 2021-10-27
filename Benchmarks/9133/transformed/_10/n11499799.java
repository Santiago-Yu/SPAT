class n11499799 {
	public InputLattice(String file, int type, boolean convertJoinMeet) throws FileNotFoundException, IOException {
        labels = new Vector();
        InputStream latStream = null;
        Vector upperCovers = new Vector();
        upperCoversVector = new Vector();
        Vector upperCovering = new Vector();
        edgeColors = new Hashtable();
        String str;
        int level = 0;
        String currentElt = null;
        boolean first = true;
        String cover = null;
        switch (type) {
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
        StreamTokenizer in;
        in = new StreamTokenizer(latStream);
        in.wordChars('^', '_');
        in.wordChars('*', '.');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD || in.ttype == StreamTokenizer.TT_NUMBER || in.ttype == '"') {
                if (in.ttype == StreamTokenizer.TT_NUMBER) {
                    str = "" + Math.round(in.nval);
                } else {
                    str = in.sval;
                }
                if (convertJoinMeet && level > 1) {
                    str = stringSubstitute(str, joinStr, joinSign);
                    str = stringSubstitute(str, meetStr, meetSign);
                }
                if (level == 1) {
                    name = new String(str);
                }
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
                        first = false;
                        cover = str;
                    } else {
                        edgeColors.put(new Edge(currentElt, cover), str);
                    }
                }
            }
            if (in.ttype == '(') {
                level++;
                if (level == 3) upperCovers = new Vector();
            }
            if (in.ttype == ')') {
                level--;
                if (level == 3) first = true;
                if (level == 2) upperCoversVector.addElement(upperCovers);
                if (level == 0) {
                    if (latStream != null) latStream.close();
                    return;
                }
            }
        }
    }

}