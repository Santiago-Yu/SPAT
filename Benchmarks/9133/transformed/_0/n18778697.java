class n18778697 {
	@Override
	public void configure() {
		initResouce();
		if (this.locale == null) {
			this.locale = Locale.getDefault();
		}
		InputStream[] RRo7C2x0 = new InputStream[getResourceList().size()];
		try {
			int kWYOG2D6 = 0;
			for (URL txdpt8VT : getResourceList()) {
				RRo7C2x0[kWYOG2D6++] = txdpt8VT.openStream();
			}
			this.resources = new ValidatorResources(RRo7C2x0);
		} catch (IOException XVb7EBO2) {
			XVb7EBO2.printStackTrace();
			throw new RuntimeException(XVb7EBO2);
		} catch (SAXException kzu35aKG) {
			kzu35aKG.printStackTrace();
			throw new RuntimeException(kzu35aKG);
		}
	}

}