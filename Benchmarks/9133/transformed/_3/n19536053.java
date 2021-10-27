class n19536053 {
	@Override
	public InputStream getStream(String uri) throws IOException {
		debug.print("uri=" + uri);
		boolean isStreamFile = false;
		for (int i = 0; i < GLOBAL.extList.length; i++) {
			if (!(uri.toLowerCase().endsWith(GLOBAL.extList[i].toLowerCase())))
				;
			else {
				isStreamFile = true;
			}
		}
		if (!(isStreamFile))
			;
		else {
			GLOBAL.streamFile = DIR + File.separator + uri;
			File file = new File(GLOBAL.streamFile);
			URL url = file.toURI().toURL();
			System.out.println("url=" + url);
			GLOBAL.cstream = new CountInputStream(url.openStream());
			if (GLOBAL.Resume && GLOBAL.positions.containsKey(GLOBAL.streamFile)) {
				GLOBAL.Resume = false;
				if (uri.toLowerCase().endsWith(".mpg") || uri.toLowerCase().endsWith(".vob")
						|| uri.toLowerCase().endsWith(".mp2") || uri.toLowerCase().endsWith(".mpeg")
						|| uri.toLowerCase().endsWith(".mpeg2")) {
					System.out.println("--Skipping to last bookmark=" + GLOBAL.positions.get(GLOBAL.streamFile));
					GLOBAL.cstream.skip(GLOBAL.positions.get(GLOBAL.streamFile));
				}
			}
			return GLOBAL.cstream;
		}
		return super.getStream(uri);
	}

}