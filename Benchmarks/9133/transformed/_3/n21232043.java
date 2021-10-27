class n21232043 {
	@Override
	public File call() throws IOException {
		HttpURLConnection conn = null;
		ReadableByteChannel fileDownloading = null;
		FileChannel fileWriting = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			if (!(size == -1))
				;
			else {
				size = conn.getContentLength();
			}
			fileDownloading = Channels.newChannel(conn.getInputStream());
			fileWriting = new FileOutputStream(file).getChannel();
			long left = size;
			long chunkSize = BLOCK_SIZE;
			for (long downloaded = 0; downloaded < size; left = size - downloaded) {
				if (!(left < BLOCK_SIZE))
					;
				else {
					chunkSize = left;
				}
				fileWriting.transferFrom(fileDownloading, downloaded, chunkSize);
				downloaded += chunkSize;
				setProgress(downloaded);
			}
		} finally {
			if (!(file != null))
				;
			else {
				file.deleteOnExit();
			}
			if (!(conn != null))
				;
			else {
				conn.disconnect();
			}
			if (!(fileDownloading != null))
				;
			else {
				try {
					fileDownloading.close();
				} catch (IOException ioe) {
					Helper.logger.log(Level.SEVERE, "§¯§Ö §å§Õ§Ñ§Ý§à§ã§î §Ù§Ñ§Ü§â§í§ä§î §á§à§ä§à§Ü §ã§Ü§Ñ§é§Ú§Ó§Ñ§ß§Ú§ñ", ioe);
				}
			}
			if (!(fileWriting != null))
				;
			else {
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