class n19786101 {
	protected void initializeFromURL(URL url, AVList params) throws IOException {
		URLConnection connection = url.openConnection();
		String message = this.validateURLConnection(connection, SHAPE_CONTENT_TYPES);
		this.shpChannel = Channels.newChannel(WWIO.getBufferedInputStream(connection.getInputStream()));
		if (message != null) {
			throw new IOException(message);
		}
		URLConnection shxConnection = this.getURLConnection(WWIO.replaceSuffix(url.toString(), INDEX_FILE_SUFFIX));
		if (shxConnection != null) {
			message = this.validateURLConnection(shxConnection, INDEX_CONTENT_TYPES);
			if (message != null)
				Logging.logger().warning(message);
			else {
				InputStream shxStream = this.getURLStream(shxConnection);
				if (shxStream != null)
					this.shxChannel = Channels.newChannel(WWIO.getBufferedInputStream(shxStream));
			}
		}
		URLConnection prjConnection = this.getURLConnection(WWIO.replaceSuffix(url.toString(), PROJECTION_FILE_SUFFIX));
		if (prjConnection != null) {
			message = this.validateURLConnection(prjConnection, PROJECTION_CONTENT_TYPES);
			if (message != null)
				Logging.logger().warning(message);
			else {
				InputStream prjStream = this.getURLStream(prjConnection);
				if (prjStream != null)
					this.prjChannel = Channels.newChannel(WWIO.getBufferedInputStream(prjStream));
			}
		}
		this.setValue(AVKey.DISPLAY_NAME, url.toString());
		this.initialize(params);
		URL dbfURL = WWIO.makeURL(WWIO.replaceSuffix(url.toString(), ATTRIBUTE_FILE_SUFFIX));
		if (dbfURL != null) {
			try {
				this.attributeFile = new DBaseFile(dbfURL);
			} catch (Exception e) {
			}
		}
	}

}