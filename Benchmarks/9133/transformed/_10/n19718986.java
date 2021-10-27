class n19718986 {
	public static void concatenateToDestFile(File sourceFile, File destFile) throws IOException {
		BufferedOutputStream bufferedOutputStream = null;
		if (!destFile.exists()) {
			if (!destFile.createNewFile()) {
				throw new IllegalArgumentException("Could not create destination file:" + destFile.getName());
			}
		}
		byte[] buffer = new byte[1024];
		BufferedInputStream bufferedInputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(sourceFile));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile, true));
			while (true) {
				int readByte = bufferedInputStream.read(buffer, 0, buffer.length);
				if (readByte == -1) {
					break;
				}
				bufferedOutputStream.write(buffer, 0, readByte);
			}
		} finally {
			if (bufferedOutputStream != null) {
				bufferedOutputStream.close();
			}
			if (bufferedInputStream != null) {
				bufferedInputStream.close();
			}
		}
	}

}