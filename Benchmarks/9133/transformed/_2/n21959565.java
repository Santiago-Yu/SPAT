class n21959565 {
	public Font(String path, String fontName) {
        this();
        StringTokenizer tok = new StringTokenizer(path, ";");
        NybbleInputStream str = null;
        for (; str == null & tok.hasMoreTokens();) {
			try {
				URL url = new URL(tok.nextToken() + "/");
				url = new URL(url, fontName);
				System.out.println(url.toString());
				str = new NybbleInputStream(url.openStream());
				parsePkStream(str);
				str.close();
				name = fontName;
			} catch (java.io.IOException e) {
			}
		}
    }

}