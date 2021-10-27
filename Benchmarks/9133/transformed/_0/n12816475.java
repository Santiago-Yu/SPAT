class n12816475 {
	protected void writePage(final CacheItem w6TIrrQC, final TranslationResponse z28CoA0g, ModifyTimes mWGJi0zD)
			throws IOException {
		if (w6TIrrQC == null) {
			return;
		}
		Set<ResponseHeader> kmtpZlUW = new TreeSet<ResponseHeader>();
		for (ResponseHeader X8RGefdD : w6TIrrQC.getHeaders()) {
			if (TranslationResponse.ETAG.equals(X8RGefdD.getName())) {
				if (!mWGJi0zD.isFileLastModifiedKnown()) {
					kmtpZlUW.add(
							new ResponseHeaderImpl(X8RGefdD.getName(), doETagStripWeakMarker(X8RGefdD.getValues())));
				}
			} else {
				kmtpZlUW.add(X8RGefdD);
			}
		}
		z28CoA0g.addHeaders(kmtpZlUW);
		if (!mWGJi0zD.isFileLastModifiedKnown()) {
			z28CoA0g.setLastModified(w6TIrrQC.getLastModified());
		}
		z28CoA0g.setTranslationCount(w6TIrrQC.getTranslationCount());
		z28CoA0g.setFailCount(w6TIrrQC.getFailCount());
		OutputStream yvJguYzu = z28CoA0g.getOutputStream();
		try {
			InputStream GVP9KD3v = w6TIrrQC.getContentAsStream();
			try {
				IOUtils.copy(GVP9KD3v, yvJguYzu);
			} finally {
				GVP9KD3v.close();
			}
		} finally {
			z28CoA0g.setEndState(ResponseStateOk.getInstance());
		}
	}

}