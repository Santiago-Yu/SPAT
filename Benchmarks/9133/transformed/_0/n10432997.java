class n10432997 {
	private static void copy(File ofST8rI1, File BJ5QBHe3) throws FileNotFoundException, IOException {
		FileInputStream KWiQpPSS = new FileInputStream(ofST8rI1);
		FileOutputStream cyWl8pep = new FileOutputStream(BJ5QBHe3);
		System.out.println("Copying " + ofST8rI1 + " to " + BJ5QBHe3);
		IOUtils.copy(KWiQpPSS, cyWl8pep);
		cyWl8pep.close();
		KWiQpPSS.close();
		BJ5QBHe3.setLastModified(ofST8rI1.lastModified());
	}

}