class n10601019 {
	public static void copyFile(File p6etWwtz, File vz7snPAR) throws IOException {
		InputStream A6ZY0oly = new FileInputStream(p6etWwtz);
		OutputStream I4ZZ3kF8 = new FileOutputStream(vz7snPAR);
		byte[] rRVEYMeR = new byte[1024];
		int xPMiIGKB;
		while ((xPMiIGKB = A6ZY0oly.read(rRVEYMeR)) > 0)
			I4ZZ3kF8.write(rRVEYMeR, 0, xPMiIGKB);
		A6ZY0oly.close();
		I4ZZ3kF8.close();
	}

}