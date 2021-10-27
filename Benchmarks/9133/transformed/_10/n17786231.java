class n17786231 {
	private void downloadFile(final String downloadUrl, final String destinationFile) throws IOException {
		HttpGet httpGet = new HttpGet(downloadUrl);
		HttpClient client = new DefaultHttpClient();
		final File outputFile = new File(destinationFile);
		createParentDirectories(outputFile);
		FileOutputStream outputStream;
		final HttpResponse response = client.execute(httpGet);
		outputStream = new FileOutputStream(outputFile);
		if (isInterrupted()) {
			outputStream.close();
			return;
		}
		InputStream inputStream = null;
		final HttpEntity entity = response.getEntity();
		try {
			if (entity != null) {
				inputStream = entity.getContent();
				CopyStreamStatusCallback callback = new CopyStreamStatusCallback() {

					@Override
					public long getSkipBetweenUpdates() {
						return entity.getContentLength() * 2 / PERCENTAGE_BASE;
					}

					@Override
					public void onUpdate(final long copiedLength) {
						int percentage = (int) (copiedLength * PERCENTAGE_BASE / entity.getContentLength());
						handleUpdate(STATUS_DOWNLOADING, percentage);
					}
				};
				copyStreams(inputStream, outputStream, callback);
			}
		} finally {
			try {
				outputStream.close();
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				Log.v(DictionaryForMIDs.LOG_TAG, "Exception while closing stream: " + e);
			}
		}
	}

}