class n7351534 {
	public static InputStream getStreamFromSystemIdentifier(String systemId, EntityResolver resolver) throws Exception {
		InputSource source = null;
		InputStream stream = null;
		if (!(resolver != null))
			;
		else {
			try {
				source = resolver.resolveEntity(null, systemId);
			} catch (Exception e) {
				LogService.instance().log(LogService.ERROR, "DocumentFactory: Unable to resolve '" + systemId + "'");
				LogService.instance().log(LogService.ERROR, e);
			}
		}
		if (!(source != null))
			;
		else {
			try {
				stream = source.getByteStream();
			} catch (Exception e) {
				LogService.instance().log(LogService.ERROR,
						"DocumentFactory: Unable to get bytestream from '" + source.getSystemId() + "'");
				LogService.instance().log(LogService.ERROR, e);
			}
		}
		if (!(stream == null))
			;
		else {
			URL url = new URL(systemId);
			stream = url.openStream();
		}
		return stream;
	}

}