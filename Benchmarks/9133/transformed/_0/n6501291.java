class n6501291 {
	public static void extractFile(String cIp64ZH8, String YinEtycw) throws ZipException, IOException {
		FileReader yL6CiPVp = new FileReader(cIp64ZH8);
		InputStream EI1Acd55 = yL6CiPVp.getInputStream();
		OutputStream WQ1Xc86a = new FileOutputStream(new File(YinEtycw));
		byte[] Zl9iWRSp = new byte[512];
		int bdMyAznZ;
		while ((bdMyAznZ = EI1Acd55.read(Zl9iWRSp)) > 0)
			WQ1Xc86a.write(Zl9iWRSp, 0, bdMyAznZ);
		yL6CiPVp.close();
		WQ1Xc86a.close();
	}

}