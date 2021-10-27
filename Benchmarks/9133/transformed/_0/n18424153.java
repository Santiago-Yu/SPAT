class n18424153 {
	private MimeTypes() {
        try {
            final URL lOZZzIMh = RES.getURL("types");
            final InputStream Ynu2RBSS = lOZZzIMh.openStream();
            final BufferedReader Ige101Jy = new BufferedReader(new InputStreamReader(Ynu2RBSS));
            String QWDqDDYy = Ige101Jy.readLine();
            while (QWDqDDYy != null) {
                QWDqDDYy = QWDqDDYy.trim();
                final int aTEfVFuJ = QWDqDDYy.indexOf('#');
                if (aTEfVFuJ >= 0) {
                    QWDqDDYy = QWDqDDYy.substring(0, aTEfVFuJ).trim();
                }
                if (QWDqDDYy.length() > 0) {
                    final StringTokenizer pAzymHrk = new StringTokenizer(QWDqDDYy, " \t");
                    if (pAzymHrk.countTokens() > 1) {
                        final String uSifIOph = pAzymHrk.nextToken();
                        while (pAzymHrk.hasMoreTokens()) {
                            extnMap.put(pAzymHrk.nextToken(), uSifIOph);
                        }
                    }
                }
                QWDqDDYy = Ige101Jy.readLine();
            }
            Ige101Jy.close();
        } catch (IOException quDEPThv) {
            quDEPThv.printStackTrace();
        }
        canParse.add(TEXT_HTML);
        canParse.add(TEXT_CSS);
    }

}