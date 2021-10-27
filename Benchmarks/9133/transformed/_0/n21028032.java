class n21028032 {
	public void convert(File UUX7LZdU, String yd6ik63z, String tZrDinmh) throws IOException {
		InputStream l9cpT1TB = new FileInputStream(UUX7LZdU);
		StringWriter rRAlAKFA = new StringWriter();
		Reader X5nGVw5w = new InputStreamReader(l9cpT1TB, yd6ik63z);
		char[] M4PZgAQD = new char[128];
		int aaD7Sd9T;
		while ((aaD7Sd9T = X5nGVw5w.read(M4PZgAQD)) > -1) {
			rRAlAKFA.write(M4PZgAQD, 0, aaD7Sd9T);
		}
		X5nGVw5w.close();
		l9cpT1TB.close();
		Log.warn(this, "read from file " + UUX7LZdU + " (" + yd6ik63z + "):" + rRAlAKFA);
		OutputStream uG4Pcxqu = new FileOutputStream(UUX7LZdU);
		OutputStreamWriter yfBCbDLe = new OutputStreamWriter(uG4Pcxqu, tZrDinmh);
		yfBCbDLe.write(rRAlAKFA.toString());
		rRAlAKFA.close();
		yfBCbDLe.close();
		uG4Pcxqu.close();
	}

}