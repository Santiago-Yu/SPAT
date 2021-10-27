class n4441118 {
	private void chopFileDisk() throws IOException {
		BufferedInputStream bis = null;
		File tempFile = new File("" + logFile + ".tmp");
		long startCopyPos;
		BufferedOutputStream bos = null;
		int readCount;
		byte readBuffer[] = new byte[2048];
		if (reductionRatio > 0 && logFile.length() > 0) {
			startCopyPos = logFile.length() / reductionRatio;
		} else {
			startCopyPos = 0;
		}
		long totalBytesRead = 0;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(tempFile));
			bis = new BufferedInputStream(new FileInputStream(logFile));
			do {
				readCount = bis.read(readBuffer, 0, readBuffer.length);
				if (readCount > 0) {
					totalBytesRead += readCount;
					if (totalBytesRead > startCopyPos) {
						bos.write(readBuffer, 0, readCount);
					}
				}
			} while (readCount > 0);
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException ex) {
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException ex) {
				}
			}
		}
		if (tempFile.isFile()) {
			if (!logFile.delete()) {
				throw new IOException("Error when attempting to delete the " + logFile + " file.");
			}
			if (!tempFile.renameTo(logFile)) {
				throw new IOException("Error when renaming the " + tempFile + " to " + logFile + ".");
			}
		}
	}

}