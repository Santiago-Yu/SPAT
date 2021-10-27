class n17520336 {
	private void validateODFDoc(String url, String ver, ValidationReport commentary)
			throws IOException, MalformedURLException {
		logger.debug("Beginning document validation ...");
		synchronized (ODFValidationSession.class) {
			String[] segments = url.split("/");
			PropertyMapBuilder builder = new PropertyMapBuilder();
			CommentatingErrorHandler h = new CommentatingErrorHandler(commentary, segments[segments.length - 1]);
			ValidateProperty.ERROR_HANDLER.put(builder, h);
			InputStream candidateStream = null;
			ValidationDriver driver = new ValidationDriver(builder.toPropertyMap());
			try {
				logger.debug("Loading schema version " + ver);
				byte[] schemaBytes = getSchemaForVersion(ver);
				driver.loadSchema(new InputSource(new ByteArrayInputStream(schemaBytes)));
				URLConnection conn = new URL(url).openConnection();
				candidateStream = conn.getInputStream();
				logger.debug("Calling validate()");
				commentary.incIndent();
				boolean isValid = driver.validate(new InputSource(candidateStream));
				logger.debug("Errors in instance:" + h.getInstanceErrCount());
				if (h.getInstanceErrCount() > CommentatingErrorHandler.THRESHOLD) {
					commentary.addComment("(<i>" + (h.getInstanceErrCount() - CommentatingErrorHandler.THRESHOLD)
							+ " error(s) omitted for the sake of brevity</i>)");
				}
				commentary.decIndent();
				if (isValid) {
					commentary.addComment("The document is valid");
				} else {
					commentary.addComment("ERROR", "The document is invalid");
				}
			} catch (SAXException e) {
				commentary.addComment("FATAL", "The resource is not conformant XML: " + e.getMessage());
				logger.error(e.getMessage());
			} finally {
				Utils.streamClose(candidateStream);
			}
		}
	}

}