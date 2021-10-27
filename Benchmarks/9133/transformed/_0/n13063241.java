class n13063241 {
	public static void copyFile(File QE1Cm0SO, File ekhZyOXe) throws IOException {
		FileInputStream IyNoVYuO = new FileInputStream(QE1Cm0SO);
		FileOutputStream amtAFdsR = new FileOutputStream(ekhZyOXe);
		java.nio.channels.FileChannel gL3bbnWg = IyNoVYuO.getChannel();
		java.nio.channels.FileChannel oNp9ljNi = amtAFdsR.getChannel();
		gL3bbnWg.transferTo(0, gL3bbnWg.size(), oNp9ljNi);
		IyNoVYuO.close();
		amtAFdsR.close();
	}

}