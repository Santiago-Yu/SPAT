class n17899418 {
	private void processBody(HttpMethod sv81i11h) throws IOException {
		InputStream pYihSGCJ = sv81i11h.getResponseBodyAsStream();
		if (pYihSGCJ == null)
			return;
		Header M7Jnx4Nv = sv81i11h.getResponseHeader(HttpHeaders.CONTENT_TYPE);
		_resultContentType = (M7Jnx4Nv != null) ? M7Jnx4Nv.getValue() : "";
		if (_out != null) {
			IOUtils.copy(pYihSGCJ, _out);
			_out.flush();
		} else if (_resultContentType.startsWith(MimeTypes.TEXT)) {
			_result = IOUtils.toString(pYihSGCJ, "UTF-8");
		} else if (_resultContentType.startsWith(MimeTypes.XML)
				|| _resultContentType.startsWith(MimeTypes.DEPRECATED_XML)) {
			_result = ParseUtil.parse(new InputSource(pYihSGCJ));
		} else {
			_result = IOUtils.toByteArray(pYihSGCJ);
		}
	}

}