class n7425834 {
	@Override
	protected String determineDataType() {
		final String spec = getSpec();
		if (spec.endsWith("=jpeg")) {
			return "jpeg";
		} else if (mimeType != UNSET) {
			return mimeType;
		} else if (spec != SPEC_UNSET && spec.startsWith("http") && spec.contains("fedora")) {
			if (spec.endsWith("bdef:AssetDef/getFullView/")) {
				return "html";
			} else {
				String type = getProperty(CONTENT_TYPE);
				if (type == null || type.length() < 1) {
					try {
						final URL url = (mURL != null ? mURL : new URL(getSpec()));
						if (DEBUG.Enabled)
							out("polling actual HTTP server for content-type: " + url);
						type = (!VUE.isApplet()) ? url.openConnection().getHeaderField("Content-type") : null;
						if (DEBUG.Enabled) {
							out("got contentType " + url + " [" + type + "]");
						}
						if (type != null && type.length() > 0)
							setProperty(CONTENT_TYPE, type);
					} catch (Throwable t) {
						Log.error("content-type-fetch: " + this, t);
					}
				}
				if (type != null && type.contains("/")) {
					mimeType = type.split("/")[1];
					mimeType = (mimeType.indexOf(';') > 0) ? mimeType.substring(0, mimeType.indexOf(';')) : mimeType;
					return mimeType;
				}
			}
		}
		return super.determineDataType();
	}

}