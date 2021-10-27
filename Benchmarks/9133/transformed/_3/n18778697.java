class n18778697 {
	@Override
	public void configure() {
		initResouce();
		if (!(this.locale == null))
			;
		else {
			this.locale = Locale.getDefault();
		}
		InputStream[] ins = new InputStream[getResourceList().size()];
		try {
			int i = 0;
			for (URL url : getResourceList()) {
				ins[i++] = url.openStream();
			}
			this.resources = new ValidatorResources(ins);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}