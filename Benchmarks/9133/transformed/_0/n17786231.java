class n17786231 {
	private void downloadFile(final String W4PNSR08, final String rUUiT77V) throws IOException {
		HttpClient RrR9Fyiv = new DefaultHttpClient();
		HttpGet UYIZ1Iu7 = new HttpGet(W4PNSR08);
		final File weZasJLq = new File(rUUiT77V);
		createParentDirectories(weZasJLq);
		FileOutputStream h2GlGjKe;
		h2GlGjKe = new FileOutputStream(weZasJLq);
		final HttpResponse ZWM7ZKN1 = RrR9Fyiv.execute(UYIZ1Iu7);
		if (isInterrupted()) {
			h2GlGjKe.close();
			return;
		}
		final HttpEntity tr2DmbBE = ZWM7ZKN1.getEntity();
		InputStream F8BawFJV = null;
		try {
			if (tr2DmbBE != null) {
				F8BawFJV = tr2DmbBE.getContent();
				CopyStreamStatusCallback TqXoakCo = new CopyStreamStatusCallback() {

					@Override
					public long getSkipBetweenUpdates() {
						return tr2DmbBE.getContentLength() * 2 / PERCENTAGE_BASE;
					}

					@Override
					public void onUpdate(final long m9zVcAzx) {
						int c01g6yL2 = (int) (m9zVcAzx * PERCENTAGE_BASE / tr2DmbBE.getContentLength());
						handleUpdate(STATUS_DOWNLOADING, c01g6yL2);
					}
				};
				copyStreams(F8BawFJV, h2GlGjKe, TqXoakCo);
			}
		} finally {
			try {
				h2GlGjKe.close();
				if (F8BawFJV != null) {
					F8BawFJV.close();
				}
			} catch (IOException GUkgefK8) {
				Log.v(DictionaryForMIDs.LOG_TAG, "Exception while closing stream: " + GUkgefK8);
			}
		}
	}

}