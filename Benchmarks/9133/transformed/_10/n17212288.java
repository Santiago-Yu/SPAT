class n17212288 {
	private void copyFile(File source, File destination) throws IOException {
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileOutputStream = new FileOutputStream(destination);
			fileInputStream = new FileInputStream(source);
			int bufferLength = 1024;
			int readCount = 0;
			byte[] buffer = new byte[bufferLength];
			while ((readCount = fileInputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, readCount);
			}
		} finally {
			if (fileInputStream != null) {
				fileInputStream.close();
			}
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
		}
	}

}