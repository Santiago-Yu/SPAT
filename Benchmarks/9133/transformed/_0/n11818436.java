class n11818436 {
	public void zip_compressFiles() throws Exception {
		FileInputStream V5TXpRfF = null;
		File I17hQiOe = new File("C:\\WINDOWS\\regedit.exe");
		File c9iVyPTg = new File("C:\\WINDOWS\\win.ini");
		File O513PolV = new File("C:\\" + NTUtil.class.getName() + ".zip");
		ZipOutputStream ajsaiFjV = new ZipOutputStream(new FileOutputStream(O513PolV));
		ajsaiFjV.putNextEntry(new ZipEntry("regedit.exe"));
		V5TXpRfF = new FileInputStream(I17hQiOe);
		while (V5TXpRfF.available() > 0) {
			ajsaiFjV.write(V5TXpRfF.read());
		}
		V5TXpRfF.close();
		ajsaiFjV.closeEntry();
		ajsaiFjV.putNextEntry(new ZipEntry("win.ini"));
		V5TXpRfF = new FileInputStream(c9iVyPTg);
		while (V5TXpRfF.available() > 0) {
			ajsaiFjV.write(V5TXpRfF.read());
		}
		V5TXpRfF.close();
		ajsaiFjV.closeEntry();
		ajsaiFjV.close();
	}

}