class n3459107 {
	private static boolean hardCopy(File RIUkAPFy, File n24quqD4, StringBuffer Hats29ZX) {
		boolean XBUsntCX = true;
		try {
			notifyCopyStart(n24quqD4);
			n24quqD4.getParentFile().mkdirs();
			byte[] ZV0RoxMM = new byte[4096];
			int EUXXLD7O = 0;
			FileInputStream JWoVz7O7 = new FileInputStream(RIUkAPFy);
			FileOutputStream p6VianR9 = new FileOutputStream(n24quqD4);
			while ((EUXXLD7O = JWoVz7O7.read(ZV0RoxMM)) != -1)
				p6VianR9.write(ZV0RoxMM, 0, EUXXLD7O);
			JWoVz7O7.close();
			p6VianR9.close();
		} catch (Exception ShAK6fHY) {
			XBUsntCX = false;
			handleException("\n Error in method: copy!\n", ShAK6fHY, Hats29ZX);
		} finally {
			notifyCopyEnd(n24quqD4);
		}
		return XBUsntCX;
	}

}