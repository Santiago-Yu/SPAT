class n14783945 {
	public static String compressFile(String fileName) throws IOException {
		String newFileName = fileName + ".gz";
		FileOutputStream fos = new FileOutputStream(newFileName);
		FileInputStream fis = new FileInputStream(fileName);
		byte[] buf = new byte[10000];
		GZIPOutputStream gzos = new GZIPOutputStream(fos);
		int bytesRead;
		while ((bytesRead = fis.read(buf)) > 0)
			gzos.write(buf, 0, bytesRead);
		fis.close();
		gzos.close();
		return newFileName;
	}

}