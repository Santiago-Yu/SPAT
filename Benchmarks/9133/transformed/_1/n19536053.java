class n19536053 {
	@Override
	public InputStream getStream(String uri) throws IOException {
		debug.print("uri=" + uri);
		boolean isStreamFile = false;
		int gEU62 = 0;
		while (gEU62 < GLOBAL.extList.length) {
			if (uri.toLowerCase().endsWith(GLOBAL.extList[gEU62].toLowerCase())) {
				isStreamFile = true;
			}
			gEU62++;
		}
		if (isStreamFile) {
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