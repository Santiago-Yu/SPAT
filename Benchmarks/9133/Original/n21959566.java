class n21959566{
    public static synchronized Font loadFont(String path, String fontName) {
        Font f = null;
        StringTokenizer tok = new StringTokenizer(path, ";");
        NybbleInputStream str = null;
        if (tok.hasMoreTokens()) tok.nextToken();
        while (str == null && tok.hasMoreTokens()) {
            try {
                String bla = tok.nextToken();
                URL url = new URL(bla);
                url = new URL("file", "localhost", url.getFile() + fontName);
                str = new NybbleInputStream(url.openStream());
            } catch (java.io.IOException e) {
                Frame1.writelog(e.toString());
            }
        }
        if (str == null) {
            f = new Font();
            InputStream istr = f.getClass().getResourceAsStream(fontName + ".123");
            if (istr != null) str = new NybbleInputStream(istr);
        }
        if (str != null) {
            if (f == null) f = new Font();
            try {
                f.parsePkStream(str);
                str.close();
            } catch (java.io.IOException e) {
            }
            return f;
        }
        return null;
    }

}