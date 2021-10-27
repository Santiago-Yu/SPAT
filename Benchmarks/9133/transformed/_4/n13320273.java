class n13320273 {
	@Override
	public IMedium createMedium(String urlString, IMetadata optionalMetadata)
			throws MM4UCannotCreateMediumElementsException {
		Debug.println("createMedium(): URL: " + urlString);
		IAudio tempAudio = null;
		try {
			String cachedFileUri = null;
			try {
				URL url = new URL(urlString);
				InputStream is = url.openStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int len;
				while ((len = is.read(buf)) > 0)
					out.write(buf, 0, len);
				MediaCache cache = new MediaCache();
				cachedFileUri = cache.addAudio(urlString, out).getURI().substring(5);
			} catch (MalformedURLException e) {
				cachedFileUri = urlString;
			}
			TAudioFileFormat fFormat = null;
			try {
				fFormat = (TAudioFileFormat) new MpegAudioFileReader().getAudioFileFormat(new File(cachedFileUri));
			} catch (Exception e) {
				System.err.println("getAudioFileFormat() failed: " + e);
			}
			int length = Constants.UNDEFINED_INTEGER;
			length = (fFormat != null)
					? Math.round(Integer.valueOf(fFormat.properties().get("duration").toString()).intValue() / 1000)
					: length;
			String mimeType = Utilities.getMimetype(Utilities.getURISuffix(urlString));
			optionalMetadata.addIfNotNull(IMedium.MEDIUM_METADATA_MIMETYPE, mimeType);
			tempAudio = (length != Constants.UNDEFINED_INTEGER) ? new Audio(this, length, urlString, optionalMetadata)
					: tempAudio;
		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}
		return tempAudio;
	}

}