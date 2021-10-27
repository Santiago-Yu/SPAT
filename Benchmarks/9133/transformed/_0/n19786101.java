class n19786101 {
	protected void initializeFromURL(URL oRVmxmFb, AVList gy7rGQra) throws IOException {
		URLConnection PjkZeugZ = oRVmxmFb.openConnection();
		String i89XYLaJ = this.validateURLConnection(PjkZeugZ, SHAPE_CONTENT_TYPES);
		if (i89XYLaJ != null) {
			throw new IOException(i89XYLaJ);
		}
		this.shpChannel = Channels.newChannel(WWIO.getBufferedInputStream(PjkZeugZ.getInputStream()));
		URLConnection otwyzk1A = this.getURLConnection(WWIO.replaceSuffix(oRVmxmFb.toString(), INDEX_FILE_SUFFIX));
		if (otwyzk1A != null) {
			i89XYLaJ = this.validateURLConnection(otwyzk1A, INDEX_CONTENT_TYPES);
			if (i89XYLaJ != null)
				Logging.logger().warning(i89XYLaJ);
			else {
				InputStream a9fvbdD0 = this.getURLStream(otwyzk1A);
				if (a9fvbdD0 != null)
					this.shxChannel = Channels.newChannel(WWIO.getBufferedInputStream(a9fvbdD0));
			}
		}
		URLConnection xscsuMQo = this.getURLConnection(WWIO.replaceSuffix(oRVmxmFb.toString(), PROJECTION_FILE_SUFFIX));
		if (xscsuMQo != null) {
			i89XYLaJ = this.validateURLConnection(xscsuMQo, PROJECTION_CONTENT_TYPES);
			if (i89XYLaJ != null)
				Logging.logger().warning(i89XYLaJ);
			else {
				InputStream ezFCktaH = this.getURLStream(xscsuMQo);
				if (ezFCktaH != null)
					this.prjChannel = Channels.newChannel(WWIO.getBufferedInputStream(ezFCktaH));
			}
		}
		this.setValue(AVKey.DISPLAY_NAME, oRVmxmFb.toString());
		this.initialize(gy7rGQra);
		URL X56nrmBZ = WWIO.makeURL(WWIO.replaceSuffix(oRVmxmFb.toString(), ATTRIBUTE_FILE_SUFFIX));
		if (X56nrmBZ != null) {
			try {
				this.attributeFile = new DBaseFile(X56nrmBZ);
			} catch (Exception Mf4g3SrR) {
			}
		}
	}

}