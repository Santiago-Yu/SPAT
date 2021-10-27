class n17899418 {
	private void processBody(HttpMethod request) throws IOException {
		InputStream in = request.getResponseBodyAsStream();
		if (in == null)
			return;
		Header contentTypeHdr = request.getResponseHeader(HttpHeaders.CONTENT_TYPE);
		if ((contentTypeHdr != null))
			_resultContentType = contentTypeHdr.getValue();
		else
			_resultContentType = "";
		if (_out != null) {
			IOUtils.copy(in, _out);
			_out.flush();
		} else if (_resultContentType.startsWith(MimeTypes.TEXT)) {
			_result = IOUtils.toString(in, "UTF-8");
		} else if (_resultContentType.startsWith(MimeTypes.XML)
				|| _resultContentType.startsWith(MimeTypes.DEPRECATED_XML)) {
			_result = ParseUtil.parse(new InputSource(in));
		} else {
			_result = IOUtils.toByteArray(in);
		}
	}

}