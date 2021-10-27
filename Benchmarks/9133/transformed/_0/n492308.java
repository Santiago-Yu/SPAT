class n492308 {
	public In(String kO3ZZx7I) {
        try {
            File tvFKTPYX = new File(kO3ZZx7I);
            if (tvFKTPYX.exists()) {
                scanner = new Scanner(tvFKTPYX, charsetName);
                scanner.useLocale(usLocale);
                return;
            }
            URL E23hEyCR = getClass().getResource(kO3ZZx7I);
            if (E23hEyCR == null) {
                E23hEyCR = new URL(kO3ZZx7I);
            }
            URLConnection Nh0lVhxZ = E23hEyCR.openConnection();
            InputStream mNXYpYTZ = Nh0lVhxZ.getInputStream();
            scanner = new Scanner(mNXYpYTZ, charsetName);
            scanner.useLocale(usLocale);
        } catch (IOException LnqSxlpc) {
            System.err.println("Could not open " + kO3ZZx7I);
        }
    }

}