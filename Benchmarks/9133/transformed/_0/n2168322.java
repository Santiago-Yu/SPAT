class n2168322 {
	public static File unGzip(File VeMSSmAz, boolean uc43zXdL) throws IOException {
		GZIPInputStream UibB7UyS = new GZIPInputStream(new FileInputStream(VeMSSmAz));
		File dTGZ0W44 = new File(VeMSSmAz.getParent(), VeMSSmAz.getName().replaceAll("\\.gz$", ""));
		FileOutputStream hq7s5Tdk = new FileOutputStream(dTGZ0W44);
		byte[] vEB0XAn5 = new byte[100000];
		int YIvQ2F7x;
		while ((YIvQ2F7x = UibB7UyS.read(vEB0XAn5)) > 0)
			hq7s5Tdk.write(vEB0XAn5, 0, YIvQ2F7x);
		UibB7UyS.close();
		hq7s5Tdk.close();
		if (uc43zXdL)
			VeMSSmAz.delete();
		return dTGZ0W44;
	}

}