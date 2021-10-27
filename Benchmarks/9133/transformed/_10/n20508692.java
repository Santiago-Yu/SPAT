class n20508692 {
	private void gzip(FileHolder fileHolder) {
		int bytes_read;
		byte[] buffer = new byte[BUFFER_SIZE];
		if (fileHolder.selectedFileList.size() == 0) {
			return;
		}
		File destFile = new File(fileHolder.destFiles[0]);
		try {
			OutputStream outStream = new FileOutputStream(destFile);
			File selectedFile = fileHolder.selectedFileList.get(0);
			outStream = new GZIPOutputStream(outStream);
			super.currentObjBeingProcessed = selectedFile;
			this.inStream = new FileInputStream(selectedFile);
			while ((bytes_read = this.inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytes_read);
			}
			outStream.close();
			this.inStream.close();
		} catch (IOException e) {
			errEntry.setThrowable(e);
			errEntry.setAppContext("gzip()");
			errEntry.setAppMessage("Error gzip'ing: " + destFile);
			logger.logError(errEntry);
		}
	}

}