class n20394588 {
	public static Font createTrueTypeFont(URL HglOsEHF, int bQlnve0X, float zWqYrdDG) {
		Font jXyVKlzu = null;
		try {
			jXyVKlzu = Font.createFont(Font.TRUETYPE_FONT, HglOsEHF.openStream());
		} catch (IOException Ywk1N56D) {
			System.err.println("ERROR: " + HglOsEHF + " is not found or can not be read");
			jXyVKlzu = new Font("Verdana", 0, 0);
		} catch (FontFormatException YHNky0oJ) {
			System.err.println("ERROR: " + HglOsEHF + " is not a valid true type font");
			jXyVKlzu = new Font("Verdana", 0, 0);
		}
		return jXyVKlzu.deriveFont(bQlnve0X, zWqYrdDG);
	}

}