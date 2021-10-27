class n492307 {
	public In(URL Pie0md0b) {
        try {
            URLConnection zILziiqC = Pie0md0b.openConnection();
            InputStream BPIZiuXD = zILziiqC.getInputStream();
            scanner = new Scanner(BPIZiuXD, charsetName);
            scanner.useLocale(usLocale);
        } catch (IOException plzU5PpU) {
            System.err.println("Could not open " + Pie0md0b);
        }
    }

}