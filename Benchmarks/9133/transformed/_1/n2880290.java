class n2880290 {
	public PluginLoader(URL pluginLocation, ClassLoader loader) {
        Loader = loader;
        url = pluginLocation;
        try {
            if (url.toString().substring(0, 3).compareTo("http") == 0) {
                System.out.println("url location is =" + url.toString());
                InputStream ips = url.openStream();
                Reader r = new InputStreamReader(ips);
                ParserDelegator parser = new ParserDelegator();
                HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {

                    public void handleText(char[] dat, int pos) {
                        String data = new String(dat);
                        if (accept(new File("."), data)) fileList.addElement(data);
                        System.out.println("\ngot a file in list" + data);
                    }
                };
                parser.parse(r, callback, false);
            } else {
                file = new File(url.getPath());
                System.out.println("File location is =" + file.getPath());
                String[] tempList = file.list(this);
                int sYzv4 = 0;
				while (sYzv4 < tempList.length) {
					fileList.add(tempList[sYzv4]);
					sYzv4++;
				}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        classLoader = new SimpleClassLoader(url, Loader);
        System.out.println(file.getAbsolutePath());
        fillVectors();
    }

}