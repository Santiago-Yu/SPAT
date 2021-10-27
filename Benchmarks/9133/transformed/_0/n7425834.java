class n7425834 {
	@Override
	protected String determineDataType() {
		final String wffukN4K = getSpec();
		if (wffukN4K.endsWith("=jpeg")) {
			return "jpeg";
		} else if (mimeType != UNSET) {
			return mimeType;
		} else if (wffukN4K != SPEC_UNSET && wffukN4K.startsWith("http") && wffukN4K.contains("fedora")) {
			if (wffukN4K.endsWith("bdef:AssetDef/getFullView/")) {
				return "html";
			} else {
				String obYVJRpW = getProperty(CONTENT_TYPE);
				if (obYVJRpW == null || obYVJRpW.length() < 1) {
					try {
						final URL jwQipIBu = (mURL != null ? mURL : new URL(getSpec()));
						if (DEBUG.Enabled)
							out("polling actual HTTP server for content-type: " + jwQipIBu);
						if (!VUE.isApplet())
							obYVJRpW = jwQipIBu.openConnection().getHeaderField("Content-type");
						else
							obYVJRpW = null;
						if (DEBUG.Enabled) {
							out("got contentType " + jwQipIBu + " [" + obYVJRpW + "]");
						}
						if (obYVJRpW != null && obYVJRpW.length() > 0)
							setProperty(CONTENT_TYPE, obYVJRpW);
					} catch (Throwable nDHz5UFs) {
						Log.error("content-type-fetch: " + this, nDHz5UFs);
					}
				}
				if (obYVJRpW != null && obYVJRpW.contains("/")) {
					mimeType = obYVJRpW.split("/")[1];
					if (mimeType.indexOf(';') > 0) {
						mimeType = mimeType.substring(0, mimeType.indexOf(';'));
					}
					return mimeType;
				}
			}
		}
		return super.determineDataType();
	}

}