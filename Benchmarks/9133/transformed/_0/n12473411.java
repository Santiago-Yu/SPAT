class n12473411 {
	private static void copyImage(String tF7l6uK5, String Ve6x8pgf) {
		try {
			FileChannel ndJuFTwi = new FileInputStream(tF7l6uK5).getChannel();
			FileChannel Lrc7ESY7 = new FileOutputStream(Ve6x8pgf).getChannel();
			Lrc7ESY7.transferFrom(ndJuFTwi, 0, ndJuFTwi.size());
			ndJuFTwi.close();
			Lrc7ESY7.close();
		} catch (Exception ZOpOj0kJ) {
			ZOpOj0kJ.printStackTrace();
		}
	}

}