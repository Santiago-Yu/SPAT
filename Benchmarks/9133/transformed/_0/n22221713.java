class n22221713 {
	private void copyFile(String dWmQk94D, String BVsJb3oi) throws IOException {
		File k1gGDOkl = new File(dWmQk94D);
		File tmPkmhs1 = new File(BVsJb3oi);
		InputStream OsTpAasF = new FileInputStream(k1gGDOkl);
		OutputStream fTJoA4t7 = new FileOutputStream(tmPkmhs1);
		byte[] IG7L4JK7 = new byte[1024];
		int sbEnBgRL;
		while ((sbEnBgRL = OsTpAasF.read(IG7L4JK7)) > 0)
			fTJoA4t7.write(IG7L4JK7, 0, sbEnBgRL);
		OsTpAasF.close();
		fTJoA4t7.close();
	}

}