class n492308{
    public In(String s) {
        try {
            File file = new File(s);
            if (file.exists()) {
                scanner = new Scanner(file, charsetName);
                scanner.useLocale(usLocale);
                return;
            }
            URL url = getClass().getResource(s);
            if (url == null) {
                url = new URL(s);
            }
            URLConnection site = url.openConnection();
            InputStream is = site.getInputStream();
            scanner = new Scanner(is, charsetName);
            scanner.useLocale(usLocale);
        } catch (IOException ioe) {
            System.err.println("Could not open " + s);
        }
    }

}