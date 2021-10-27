class n2753498 {
	void download() throws DownloaderException {
		final HttpClient ag8YT7uj = new DefaultHttpClient();
		try {
			final FileOutputStream uhwaPL3n = this.activity.openFileOutput(APK_FILENAME, Context.MODE_WORLD_READABLE);
			final HttpResponse V9stZ3BJ = ag8YT7uj.execute(new HttpGet(URL));
			downloadFile(V9stZ3BJ, uhwaPL3n);
			uhwaPL3n.close();
		} catch (ClientProtocolException pZ4FOoLN) {
			throw new DownloaderException(pZ4FOoLN);
		} catch (IOException Etyqipyd) {
			throw new DownloaderException(Etyqipyd);
		}
	}

}