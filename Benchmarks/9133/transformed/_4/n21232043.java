class n21232043 {
	@Override
	public File call() throws IOException {
		HttpURLConnection conn = null;
		ReadableByteChannel fileDownloading = null;
		FileChannel fileWriting = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			size = (size == -1) ? conn.getContentLength() : size;
			fileDownloading = Channels.newChannel(conn.getInputStream());
			fileWriting = new FileOutputStream(file).getChannel();
			long left = size;
			long chunkSize = BLOCK_SIZE;
			for (long downloaded = 0; downloaded < size; left = size - downloaded) {
				chunkSize = (left < BLOCK_SIZE) ? left : chunkSize;
				fileWriting.transferFrom(fileDownloading, downloaded, chunkSize);
				downloaded += chunkSize;
				setProgress(downloaded);
			}
		} finally {
			if (file != null) {
				file.deleteOnExit();
			}
			if (conn != null) {
				conn.disconnect();
			}
			if (fileDownloading != null) {
				try {
					fileDownloading.close();
				} catch (IOException ioe) {
					Helper.logger.log(Level.SEVERE, "§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §Ù§Ñ§Ü§â§í§ä§î §á§à§ä§à§Ü §ã§Ü§Ñ§é§Ú§Ó§Ñ§ß§Ú§ñ", ioe);
				}
			}
			if (fileWriting != null) {
				try {
					fileWriting.close();
				} catch (IOException ioe) {
					Helper.logger.log(Level.SEVERE, "§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §Ù§Ñ§Ü§â§í§ä§î §á§à§ä§à§Ü §Ù§Ñ§á§Ú§ã§Ú §Ó §æ§Ñ§Û§Ý", ioe);
				}
			}
		}
		return file;
	}

}