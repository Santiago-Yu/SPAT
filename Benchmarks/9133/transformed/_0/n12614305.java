class n12614305 {
	public static boolean encodeFileToFile(String obuAyeak, String WTwff1FR) {
		boolean XtGnBMgE = false;
		java.io.InputStream TDTQLDEP = null;
		java.io.OutputStream h4HF7ClT = null;
		try {
			TDTQLDEP = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(obuAyeak)),
					Base64.ENCODE);
			h4HF7ClT = new java.io.BufferedOutputStream(new java.io.FileOutputStream(WTwff1FR));
			byte[] L54oi6md = new byte[65536];
			int VOVr4JwS = -1;
			while ((VOVr4JwS = TDTQLDEP.read(L54oi6md)) >= 0) {
				h4HF7ClT.write(L54oi6md, 0, VOVr4JwS);
			}
			XtGnBMgE = true;
		} catch (java.io.IOException Vk2jag25) {
			Vk2jag25.printStackTrace();
		} finally {
			try {
				TDTQLDEP.close();
			} catch (Exception GaBVNvsF) {
			}
			try {
				h4HF7ClT.close();
			} catch (Exception qtXiOsXy) {
			}
		}
		return XtGnBMgE;
	}

}