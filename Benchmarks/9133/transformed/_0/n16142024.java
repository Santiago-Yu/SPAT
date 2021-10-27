class n16142024 {
	private static final void copyFile(File FyU2jGFn, File T62PmRII, byte[] tRgkKCEn) {
		try {
			File XxoPDEKH = new File(T62PmRII, FyU2jGFn.getName());
			InputStream PCqK2M2R = new FileInputStream(FyU2jGFn);
			OutputStream WSgXLUHR = new FileOutputStream(XxoPDEKH);
			int AJ90g6EQ;
			while ((AJ90g6EQ = PCqK2M2R.read(tRgkKCEn)) != -1)
				WSgXLUHR.write(tRgkKCEn, 0, AJ90g6EQ);
			PCqK2M2R.close();
			WSgXLUHR.close();
		} catch (IOException U6xq1PZ5) {
			System.err.println("Couldn't copy file '" + FyU2jGFn + "' to directory '" + T62PmRII + "'");
		}
	}

}