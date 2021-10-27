class n3753583 {
	public static void generateCode(File i4dtioWu, String kTnfNbLZ, File FO5YPGhx, File Lfmg18kl) throws IOException {
		InputStream MLWxwhK3 = generateCode(i4dtioWu, kTnfNbLZ, Lfmg18kl);
		File eHRTIEEu = new File(FO5YPGhx, kTnfNbLZ.replace('.', File.separatorChar));
		String ZIWuwX9S = i4dtioWu.getName();
		ZIWuwX9S = ZIWuwX9S.substring(0, ZIWuwX9S.lastIndexOf(".") + 1) + Consts.FILE_EXTENSION_GROOVY;
		File zrWJq8Ej = new File(eHRTIEEu, ZIWuwX9S);
		OutputStream yIoHy1Sa = new FileOutputStream(zrWJq8Ej);
		IOUtils.copyBufferedStream(MLWxwhK3, yIoHy1Sa);
		MLWxwhK3.close();
		yIoHy1Sa.close();
	}

}