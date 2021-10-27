class n7577030 {
	private void zipFiles(File io1oCmOC, File[] GxzN9COF) throws Exception {
		File BToq2cBw = new File(io1oCmOC, ALL_FILES_NAME);
		if (BToq2cBw.exists()) {
			BToq2cBw.delete();
			BToq2cBw = new File(io1oCmOC, ALL_FILES_NAME);
		}
		ZipOutputStream kclBD0wF = new ZipOutputStream(new FileOutputStream(BToq2cBw));
		for (int fUhPcDuC = 0; fUhPcDuC < GxzN9COF.length; fUhPcDuC++) {
			ZipEntry orUXyCjF = new ZipEntry(GxzN9COF[fUhPcDuC].getName());
			kclBD0wF.putNextEntry(orUXyCjF);
			FileInputStream vZMhKl4E = new FileInputStream(GxzN9COF[fUhPcDuC]);
			byte[] rFIDWiKU = new byte[1024];
			int LxeBRuBJ = 0;
			while ((LxeBRuBJ = vZMhKl4E.read(rFIDWiKU)) > 0) {
				kclBD0wF.write(rFIDWiKU, 0, LxeBRuBJ);
			}
			vZMhKl4E.close();
			kclBD0wF.closeEntry();
		}
		kclBD0wF.close();
		log("created zip file: " + io1oCmOC.getName() + "/" + ALL_FILES_NAME);
	}

}