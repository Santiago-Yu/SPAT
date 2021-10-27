class n492307{
    public In(URL url) {
        try {
            URLConnection site = url.openConnection();
            InputStream is = site.getInputStream();
            scanner = new Scanner(is, charsetName);
            scanner.useLocale(usLocale);
        } catch (IOException ioe) {
            System.err.println("Could not open " + url);
        }
    }

}