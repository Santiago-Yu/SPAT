class n13290531 {
	public static void copyFile(File source, File destination) throws IOException {
		FileOutputStream fos = new FileOutputStream(destination);
		FileInputStream fis = new FileInputStream(source);
		FileChannel inCh = fis.getChannel();
		FileChannel outCh = fos.getChannel();
		inCh.transferTo(0, inCh.size(), outCh);
		inCh.close();
		fis.close();
		outCh.close();
		fos.flush();
		fos.close();
	}

}