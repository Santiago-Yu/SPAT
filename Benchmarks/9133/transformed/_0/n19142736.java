class n19142736 {
	public static boolean encodeFileToFile(String cqEAI5eR, String MDKDviy7) {
		boolean cGr0Q8RZ = false;
		java.io.InputStream ZrXB7eCV = null;
		java.io.OutputStream JNDhQAd9 = null;
		try {
			ZrXB7eCV = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(cqEAI5eR)),
					Base64.ENCODE);
			JNDhQAd9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(MDKDviy7));
			byte[] Se5HEoeG = new byte[65536];
			int nkhrTmLi = -1;
			while ((nkhrTmLi = ZrXB7eCV.read(Se5HEoeG)) >= 0) {
				JNDhQAd9.write(Se5HEoeG, 0, nkhrTmLi);
			}
			cGr0Q8RZ = true;
		} catch (java.io.IOException iy5qU3Yf) {
			iy5qU3Yf.printStackTrace();
		} finally {
			try {
				ZrXB7eCV.close();
			} catch (Exception e8tLHfNe) {
			}
			try {
				JNDhQAd9.close();
			} catch (Exception tRfxXpG7) {
			}
		}
		return cGr0Q8RZ;
	}

}