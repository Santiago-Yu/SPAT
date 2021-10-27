class n11499799 {
	public InputLattice(String Ta5eS8oA, int a9fYxFAd, boolean xO3gcUKk) throws FileNotFoundException, IOException {
        InputStream wZqMBSvD = null;
        labels = new Vector();
        upperCoversVector = new Vector();
        Vector gTs4Uhl6 = new Vector();
        edgeColors = new Hashtable();
        Vector QDi4i9qR = new Vector();
        int SnbIYY2M = 0;
        String BnROZAyQ;
        String QDZsk6I1 = null;
        String KjO9MmYh = null;
        boolean kPdg4g7D = true;
        StreamTokenizer e2nkbNiW;
        switch(a9fYxFAd) {
            case FILE:
                wZqMBSvD = new FileInputStream(Ta5eS8oA);
                break;
            case STRING:
                wZqMBSvD = new StringBufferInputStream(Ta5eS8oA);
                break;
            case URL:
                URL HiODAZqu = new URL("http", Config.HOST, Config.PORT, "/" + Config.HASSE + "/" + Config.URL_STREAMER + Ta5eS8oA);
                System.out.println("url is " + HiODAZqu);
                URLConnection v9kktkpl = HiODAZqu.openConnection();
                wZqMBSvD = new DataInputStream(v9kktkpl.getInputStream());
                break;
        }
        e2nkbNiW = new StreamTokenizer(wZqMBSvD);
        e2nkbNiW.wordChars('^', '_');
        e2nkbNiW.wordChars('*', '.');
        while (e2nkbNiW.nextToken() != StreamTokenizer.TT_EOF) {
            if (e2nkbNiW.ttype == StreamTokenizer.TT_WORD || e2nkbNiW.ttype == StreamTokenizer.TT_NUMBER || e2nkbNiW.ttype == '"') {
                if (e2nkbNiW.ttype == StreamTokenizer.TT_NUMBER) {
                    BnROZAyQ = "" + Math.round(e2nkbNiW.nval);
                } else {
                    BnROZAyQ = e2nkbNiW.sval;
                }
                if (xO3gcUKk && SnbIYY2M > 1) {
                    BnROZAyQ = stringSubstitute(BnROZAyQ, joinStr, joinSign);
                    BnROZAyQ = stringSubstitute(BnROZAyQ, meetStr, meetSign);
                }
                if (SnbIYY2M == 1) {
                    name = new String(BnROZAyQ);
                }
                if (SnbIYY2M == 2) {
                    labels.addElement(BnROZAyQ);
                    QDZsk6I1 = BnROZAyQ;
                }
                if (SnbIYY2M == 3) {
                    gTs4Uhl6.addElement(BnROZAyQ);
                }
                if (SnbIYY2M == 4) {
                    if (kPdg4g7D) {
                        gTs4Uhl6.addElement(BnROZAyQ);
                        KjO9MmYh = BnROZAyQ;
                        kPdg4g7D = false;
                    } else {
                        edgeColors.put(new Edge(QDZsk6I1, KjO9MmYh), BnROZAyQ);
                    }
                }
            }
            if (e2nkbNiW.ttype == '(') {
                SnbIYY2M++;
                if (SnbIYY2M == 3) gTs4Uhl6 = new Vector();
            }
            if (e2nkbNiW.ttype == ')') {
                SnbIYY2M--;
                if (SnbIYY2M == 3) kPdg4g7D = true;
                if (SnbIYY2M == 2) upperCoversVector.addElement(gTs4Uhl6);
                if (SnbIYY2M == 0) {
                    if (wZqMBSvD != null) wZqMBSvD.close();
                    return;
                }
            }
        }
    }

}