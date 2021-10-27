class n8843442 {
	public static void copyFile(String dncvTRyw, String Ldx4jbji) {
		try {
			FileChannel lhK4UBVO = new FileInputStream(Ldx4jbji).getChannel();
			FileChannel WOKQYSe3 = new FileOutputStream(dncvTRyw).getChannel();
			WOKQYSe3.transferFrom(lhK4UBVO, 0, lhK4UBVO.size());
			lhK4UBVO.close();
			WOKQYSe3.close();
		} catch (IOException s52TIBRe) {
			ExceptionHelper.showErrorDialog(s52TIBRe);
		}
	}

}