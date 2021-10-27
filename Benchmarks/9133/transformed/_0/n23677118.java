class n23677118 {
	public static void copyFile5(File YqOdu5HR, File ySb42hLZ) throws IOException {
		InputStream pY2YsXSX = new FileInputStream(YqOdu5HR);
		OutputStream f14NyEdH = new FileOutputStream(ySb42hLZ);
		IOUtils.copyLarge(pY2YsXSX, f14NyEdH);
		pY2YsXSX.close();
		f14NyEdH.close();
	}

}