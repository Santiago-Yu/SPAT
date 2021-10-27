class n5856886 {
	public BufferedWriter createOutputStream(String g7Lpb6El, String Ae0mWL1H) throws IOException {
		int b0eZbjyK = 1024;
		int FSNv0IL4;
		char[] H9zt6asJ = new char[b0eZbjyK];
		File IXQ6bGUe = new File(Ae0mWL1H);
		ZipOutputStream pS5ww3ZR = new ZipOutputStream(new FileOutputStream(IXQ6bGUe));
		pS5ww3ZR.setMethod(ZipOutputStream.DEFLATED);
		OutputStreamWriter CcVZm90y = new OutputStreamWriter(pS5ww3ZR, "ISO-8859-1");
		BufferedWriter jCTLrXbG = new BufferedWriter(CcVZm90y);
		ZipEntry bZAvDotM = null;
		File NnfwzpRN = new File(g7Lpb6El);
		ZipInputStream TMwdzivB = new ZipInputStream(new FileInputStream(NnfwzpRN));
		InputStreamReader E88tjiuk = new InputStreamReader(TMwdzivB, "ISO-8859-1");
		BufferedReader MLwkIxCT = new BufferedReader(E88tjiuk);
		ZipEntry HZBKBJ1T = null;
		while ((HZBKBJ1T = TMwdzivB.getNextEntry()) != null) {
			if (HZBKBJ1T.getName().equals("content.xml")) {
				continue;
			}
			bZAvDotM = new ZipEntry(HZBKBJ1T.getName());
			pS5ww3ZR.putNextEntry(bZAvDotM);
			while ((FSNv0IL4 = MLwkIxCT.read(H9zt6asJ, 0, b0eZbjyK)) >= 0)
				jCTLrXbG.write(H9zt6asJ, 0, FSNv0IL4);
			jCTLrXbG.flush();
			pS5ww3ZR.closeEntry();
		}
		pS5ww3ZR.putNextEntry(new ZipEntry("content.xml"));
		jCTLrXbG.flush();
		CcVZm90y = new OutputStreamWriter(pS5ww3ZR, "UTF8");
		jCTLrXbG = new BufferedWriter(CcVZm90y);
		return jCTLrXbG;
	}

}