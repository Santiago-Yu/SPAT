class n21674149 {
	public static String md5(String xPXlm59H, String iwNPnIfu) {
		MessageDigest LoLVe24u = null;
		try {
			LoLVe24u = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException maAQ2WTG) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}
		LoLVe24u.update(xPXlm59H.getBytes());
		byte[] B5S6KQiE = LoLVe24u.digest();
		byte N6XHTCJS;
		char pxYsn9pP;
		char PZKicOCl;
		char Iy3enFMy;
		String JbGcCmvE = new String();
		for (int LPxojZ1H = 0; LPxojZ1H < B5S6KQiE.length; LPxojZ1H++) {
			N6XHTCJS = B5S6KQiE[LPxojZ1H];
			Iy3enFMy = (char) ((N6XHTCJS >>> 4) & 0x000f);
			if (Iy3enFMy >= 10) {
				PZKicOCl = (char) (('a' + Iy3enFMy) - 10);
			} else {
				PZKicOCl = (char) ('0' + Iy3enFMy);
			}
			JbGcCmvE += PZKicOCl;
			Iy3enFMy = (char) (N6XHTCJS & 0x000f);
			if (Iy3enFMy >= 10) {
				pxYsn9pP = (char) (('a' + Iy3enFMy) - 10);
			} else {
				pxYsn9pP = (char) ('0' + Iy3enFMy);
			}
			JbGcCmvE += pxYsn9pP;
		}
		return JbGcCmvE;
	}

}