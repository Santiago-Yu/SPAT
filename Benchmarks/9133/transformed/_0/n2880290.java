class n2880290 {
	public PluginLoader(URL aQkECoHP, ClassLoader OAfeUzvw) {
        Loader = OAfeUzvw;
        url = aQkECoHP;
        try {
            if (url.toString().substring(0, 3).compareTo("http") == 0) {
                System.out.println("url location is =" + url.toString());
                InputStream dIhaU9Df = url.openStream();
                Reader x0vpiM9H = new InputStreamReader(dIhaU9Df);
                ParserDelegator gx1wZe2B = new ParserDelegator();
                HTMLEditorKit.ParserCallback GPYNloNp = new HTMLEditorKit.ParserCallback() {

                    public void handleText(char[] mhQHnz2n, int If1Gcn4k) {
                        String dgkoRjuO = new String(mhQHnz2n);
                        if (accept(new File("."), dgkoRjuO)) fileList.addElement(dgkoRjuO);
                        System.out.println("\ngot a file in list" + dgkoRjuO);
                    }
                };
                gx1wZe2B.parse(x0vpiM9H, GPYNloNp, false);
            } else {
                file = new File(url.getPath());
                System.out.println("File location is =" + file.getPath());
                String[] wX5zg32K = file.list(this);
                for (int dWvcpbsG = 0; dWvcpbsG < wX5zg32K.length; dWvcpbsG++) fileList.add(wX5zg32K[dWvcpbsG]);
            }
        } catch (Exception ZH1m9EYG) {
            ZH1m9EYG.printStackTrace();
        }
        classLoader = new SimpleClassLoader(url, Loader);
        System.out.println(file.getAbsolutePath());
        fillVectors();
    }

}