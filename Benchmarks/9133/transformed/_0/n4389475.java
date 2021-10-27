class n4389475 {
	@Override
	public URLConnection openConnection(URL XW3Atx7i) throws IOException {
		if (!XW3Atx7i.getProtocol().equals("file")) {
			String rovppOtT = XW3Atx7i.getFile();
			File mKpyBOMA = new File(cacheFolder,
					((rovppOtT.charAt(0) == '/') ? rovppOtT.substring(1) : rovppOtT).replace('/', File.separatorChar));
			if (!mKpyBOMA.exists()) {
				File SHlXssDH = new File(mKpyBOMA.getParentFile(), mKpyBOMA.getName() + "-not_found");
				if (!SHlXssDH.exists()) {
					try {
						mKpyBOMA.getParentFile().mkdirs();
						downloadFile(XW3Atx7i, mKpyBOMA);
					} catch (IOException D46tV4pW) {
						mKpyBOMA.delete();
						throw D46tV4pW;
					}
				}
			}
			return mKpyBOMA.toURI().toURL().openConnection();
		}
		return super.openConnection(XW3Atx7i);
	}

}