class n7237429 {
	public void readContents() throws IOException {
		fireProgressEvent(new ProgressEvent(this, ProgressEvent.PROGRESS_START, 0.0f, "loading file"));
		URLConnection O2c5KGdz = url.openConnection();
		O2c5KGdz.connect();
		filesize = O2c5KGdz.getContentLength();
		logger.finest("filesize: " + filesize);
		InputStreamReader XB12pmuR = new InputStreamReader(O2c5KGdz.getInputStream());
		readFirstLine(XB12pmuR);
		readHeaderLines(XB12pmuR);
		readData(XB12pmuR);
		fireProgressEvent(new ProgressEvent(this, ProgressEvent.PROGRESS_FINISH, 1.0f, "loading file"));
	}

}