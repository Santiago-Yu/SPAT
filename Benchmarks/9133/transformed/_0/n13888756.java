class n13888756 {
	protected Template read(URL aaiaXN2z) throws TemplateException {
		String HPmYtFu7 = Parent(aaiaXN2z);
		TemplateLoaderContext ySlKdYKK = new TemplateLoaderContext(this, HPmYtFu7, false);
		String C9Ry7wAG;
		InputStream dt2XttSy = null;
		try {
			dt2XttSy = aaiaXN2z.openStream();
			C9Ry7wAG = this.readToString(new java.io.InputStreamReader(dt2XttSy));
		} catch (IOException aEjNPDhy) {
			throw new TemplateException(aaiaXN2z.toString(), aEjNPDhy);
		} finally {
			try {
				dt2XttSy.close();
			} catch (IOException Ja8wnRFU) {
			}
		}
		TemplateParser bQNXYtbF = this.parser;
		if (null == bQNXYtbF)
			return (new Template(C9Ry7wAG, ySlKdYKK));
		else
			return (new Template(bQNXYtbF, C9Ry7wAG, ySlKdYKK));
	}

}