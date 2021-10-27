class n8594656 {
	@Override
	public DownloadObject download() throws IOException {
		final HttpGet HYTHvShe = new HttpGet(url.toString());
		final HttpResponse uG6mVFze = this.client.execute(HYTHvShe);
		final String XwqgDCpc = IOUtil.getString(uG6mVFze);
		LinkTag qKsjKeIr = null;
		try {
			qKsjKeIr = HtmlParserUtil.findLink(MegaUploadDownloader.DOWNLOAD_LINK_PATTERN, XwqgDCpc);
		} catch (ParserException bSF9IRKM) {
		}
		if (qKsjKeIr != null) {
			String LwcZAseG = qKsjKeIr.extractLink();
			final String BaFoiuhb = IOUtil.getBaseName(LwcZAseG).trim();
			LwcZAseG = LwcZAseG.replaceAll("&#[0-9]*;", "_");
			final URL FjmVBs3Z = new URL(LwcZAseG);
			final String mgo9jaRp = LwcZAseG.replaceAll(Pattern.quote(IOUtil.getBaseName(FjmVBs3Z.getPath())),
					URLEncoder.encode(IOUtil.getBaseName(FjmVBs3Z.getPath()), "UTF-8"));
			final HttpGet INwY4W3I = new HttpGet(mgo9jaRp);
			final HttpResponse fxnjE3z3 = this.client.execute(INwY4W3I);
			final HttpEntity QwiirKA5 = fxnjE3z3.getEntity();
			final long CyvsUFf1 = QwiirKA5.getContentLength();
			return createObject(QwiirKA5.getContent(), BaFoiuhb, CyvsUFf1);
		} else {
			throw new RuntimeException("No download link.");
		}
	}

}