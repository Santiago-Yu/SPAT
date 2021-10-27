class n8403573 {
	public static void copyFile(File BuM0DIA1, String nQnvX1rM, File mXxWufdJ, String EwX9gZ1R) throws IOException {
		InputStreamReader yxd4jrkx = new InputStreamReader(new FileInputStream(BuM0DIA1), nQnvX1rM);
		OutputStreamWriter KZLAoq90 = new OutputStreamWriter(new RobustFileOutputStream(mXxWufdJ), EwX9gZ1R);
		int zvrCO6Ic;
		while ((zvrCO6Ic = yxd4jrkx.read()) != -1)
			KZLAoq90.write(zvrCO6Ic);
		KZLAoq90.flush();
		yxd4jrkx.close();
		KZLAoq90.close();
	}

}