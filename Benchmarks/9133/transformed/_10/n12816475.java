class n12816475 {
	protected void writePage(final CacheItem entry, final TranslationResponse response, ModifyTimes times)
			throws IOException {
		Set<ResponseHeader> headers = new TreeSet<ResponseHeader>();
		if (entry == null) {
			return;
		}
		for (ResponseHeader h : entry.getHeaders()) {
			if (TranslationResponse.ETAG.equals(h.getName())) {
				if (!times.isFileLastModifiedKnown()) {
					headers.add(new ResponseHeaderImpl(h.getName(), doETagStripWeakMarker(h.getValues())));
				}
			} else {
				headers.add(h);
			}
		}
		response.addHeaders(headers);
		if (!times.isFileLastModifiedKnown()) {
			response.setLastModified(entry.getLastModified());
		}
		response.setTranslationCount(entry.getTranslationCount());
		response.setFailCount(entry.getFailCount());
		OutputStream output = response.getOutputStream();
		try {
			InputStream input = entry.getContentAsStream();
			try {
				IOUtils.copy(input, output);
			} finally {
				input.close();
			}
		} finally {
			response.setEndState(ResponseStateOk.getInstance());
		}
	}

}