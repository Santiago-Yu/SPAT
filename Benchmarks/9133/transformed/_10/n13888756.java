class n13888756 {
	protected Template read(URL url) throws TemplateException {
		String parent = Parent(url);
		String contents;
		TemplateLoaderContext context = new TemplateLoaderContext(this, parent, false);
		InputStream in = null;
		try {
			in = url.openStream();
			contents = this.readToString(new java.io.InputStreamReader(in));
		} catch (IOException exc) {
			throw new TemplateException(url.toString(), exc);
		} finally {
			try {
				in.close();
			} catch (IOException ignore) {
			}
		}
		TemplateParser parser = this.parser;
		if (null == parser)
			return (new Template(contents, context));
		else
			return (new Template(parser, contents, context));
	}

}