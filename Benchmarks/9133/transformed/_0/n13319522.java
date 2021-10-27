class n13319522 {
	protected void loadXslFromUri(URI hNjLffW3) {
		URLConnection xvHI8qTn;
		try {
			xvHI8qTn = hNjLffW3.toURL().openConnection();
			InputStream cPO5ecqr = xvHI8qTn.getInputStream();
			Reader rlvh5PbX = new InputStreamReader(cPO5ecqr);
			Source QVpMfPV4 = new StreamSource(rlvh5PbX);
			try {
				xslTemplate = factory.newTemplates(QVpMfPV4);
			} catch (TransformerConfigurationException QzPZK5xv) {
				QzPZK5xv.printStackTrace();
			}
		} catch (IOException z3eb5Zun) {
			z3eb5Zun.printStackTrace();
		}
	}

}