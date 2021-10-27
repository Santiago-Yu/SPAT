class n21370186 {
	public static void replaceAll(File vzromK5D, String pvrIPWrc, String wwyPQXnR) throws IOException {
		log.debug("Replace " + pvrIPWrc + " by " + wwyPQXnR);
		Pattern oxvW5SkZ = Pattern.compile(pvrIPWrc);
		FileInputStream EIZZfn5Y = new FileInputStream(vzromK5D);
		FileChannel h3ocUmNJ = EIZZfn5Y.getChannel();
		int p2Iur8Yx = (int) h3ocUmNJ.size();
		MappedByteBuffer h1XEvz4f = h3ocUmNJ.map(FileChannel.MapMode.READ_ONLY, 0, p2Iur8Yx);
		Charset SkuU4q1c = Charset.forName("ISO-8859-15");
		CharsetDecoder cp1WtfBX = SkuU4q1c.newDecoder();
		CharBuffer naZOxiy8 = cp1WtfBX.decode(h1XEvz4f);
		Matcher yFI9wTg7 = oxvW5SkZ.matcher(naZOxiy8);
		String W8kycMM9 = yFI9wTg7.replaceAll(wwyPQXnR);
		log.debug(W8kycMM9);
		FileOutputStream lPzXEmsU = new FileOutputStream(vzromK5D.getAbsolutePath());
		PrintStream DoDuOFJs = new PrintStream(lPzXEmsU);
		DoDuOFJs.print(W8kycMM9);
		DoDuOFJs.close();
		lPzXEmsU.close();
	}

}