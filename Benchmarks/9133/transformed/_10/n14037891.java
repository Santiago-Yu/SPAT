class n14037891 {
	private void transformFile(File input, File output, Cipher cipher, boolean compress, String progressMessage)
			throws IOException {
		InputStream inputStream;
		FileInputStream fileInputStream = new FileInputStream(input);
		if (progressMessage != null) {
			inputStream = new ProgressMonitorInputStream(null, progressMessage, fileInputStream);
		} else {
			inputStream = fileInputStream;
		}
		FilterOutputStream os = new BufferedOutputStream(new FileOutputStream(output));
		FilterInputStream is = new BufferedInputStream(inputStream);
		FilterOutputStream fos;
		FilterInputStream fis;
		if (compress) {
			fos = new GZIPOutputStream(new CipherOutputStream(os, cipher));
			fis = is;
		} else {
			fos = os;
			fis = new GZIPInputStream(new CipherInputStream(is, cipher));
		}
		byte[] buffer = new byte[cipher.getBlockSize() * blocksInBuffer];
		int readLength = fis.read(buffer);
		while (readLength != -1) {
			fos.write(buffer, 0, readLength);
			readLength = fis.read(buffer);
		}
		if (compress) {
			GZIPOutputStream gos = (GZIPOutputStream) fos;
			gos.finish();
		}
		fos.close();
		fis.close();
	}

}