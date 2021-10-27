class n1772401 {
	private void redownloadResource(SchemaResource resource) {
		if (_redownloadSet != null) {
			if (_redownloadSet.contains(resource))
				return;
			_redownloadSet.add(resource);
		}
		String filename = resource.getFilename(), schemaLocation = resource.getSchemaLocation();
		String digest = null;
		if (schemaLocation == null || filename == null)
			return;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			URL url = new URL(schemaLocation);
			URLConnection conn = url.openConnection();
			conn.addRequestProperty("User-Agent", USER_AGENT);
			conn.addRequestProperty("Accept", "application/xml, text/xml, */*");
			DigestInputStream input = digestInputStream(conn.getInputStream());
			IOUtil.copyCompletely(input, buffer);
			digest = HexBin.bytesToString(input.getMessageDigest().digest());
		} catch (Exception e) {
			warning("Could not copy remote resource " + schemaLocation + ":" + e.getMessage());
			return;
		}
		if (digest.equals(resource.getSha1()) && fileExists(filename)) {
			warning("Resource " + filename + " is unchanged from " + schemaLocation + ".");
			return;
		}
		try {
			InputStream source = new ByteArrayInputStream(buffer.toByteArray());
			writeInputStreamToFile(source, filename);
		} catch (IOException e) {
			warning("Could not write to file " + filename + " for " + schemaLocation + ":" + e.getMessage());
			return;
		}
		warning("Refreshed " + filename + " from " + schemaLocation);
	}

}