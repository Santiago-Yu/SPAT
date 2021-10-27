class n4577358 {
	private static boolean isXmlApplicationFile(URL ge23bEO9) throws java.io.IOException {
		if (DEBUG) {
			System.out.println("Checking whether file is xml");
		}
		String vsfAqoTL;
		BufferedReader kXMbgBsc = null;
		try {
			kXMbgBsc = new BomStrippingInputStreamReader(ge23bEO9.openStream());
			vsfAqoTL = kXMbgBsc.readLine();
		} finally {
			if (kXMbgBsc != null)
				kXMbgBsc.close();
		}
		if (vsfAqoTL == null) {
			return false;
		}
		for (String KcobfEOF : STARTOFXMLAPPLICATIONFILES) {
			if (vsfAqoTL.length() >= KcobfEOF.length() && vsfAqoTL.substring(0, KcobfEOF.length()).equals(KcobfEOF)) {
				if (DEBUG) {
					System.out.println("isXMLApplicationFile = true");
				}
				return true;
			}
		}
		if (DEBUG) {
			System.out.println("isXMLApplicationFile = false");
		}
		return false;
	}

}