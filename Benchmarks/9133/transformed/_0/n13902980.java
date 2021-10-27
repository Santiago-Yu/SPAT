class n13902980 {
	public static boolean encodeFileToFile(String eWtEJax4, String i1XCiWj8) {
		boolean EAfIuOqy = false;
		java.io.InputStream HjLLoeqd = null;
		java.io.OutputStream wg7XJU85 = null;
		try {
			HjLLoeqd = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(eWtEJax4)),
					Base64.ENCODE);
			wg7XJU85 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(i1XCiWj8));
			byte[] KU0Y2kR8 = new byte[65536];
			int lNzstyeb = -1;
			while ((lNzstyeb = HjLLoeqd.read(KU0Y2kR8)) >= 0) {
				wg7XJU85.write(KU0Y2kR8, 0, lNzstyeb);
			}
			EAfIuOqy = true;
		} catch (java.io.IOException NYaOVggh) {
			NYaOVggh.printStackTrace();
		} finally {
			try {
				HjLLoeqd.close();
			} catch (Exception lhu2MYH0) {
			}
			try {
				wg7XJU85.close();
			} catch (Exception bFz0DUmG) {
			}
		}
		return EAfIuOqy;
	}

}