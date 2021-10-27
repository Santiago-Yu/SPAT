class n4855600 {
	public void schema(final Row U6JnefSY, TestResults YQxGYxKH) throws Exception {
		String b6SJHmYO = U6JnefSY.text(1);
		String WV8VFlPb = null;
		if (U6JnefSY.cellExists(2)) {
			WV8VFlPb = U6JnefSY.text(2);
		}
		try {
			StreamSource JN2LVE5W;
			if (b6SJHmYO.startsWith(CLASS_PREFIX)) {
				InputStream Ys8ZkqKp = XmlValidator.class.getClassLoader()
						.getResourceAsStream(b6SJHmYO.substring(CLASS_PREFIX.length()));
				JN2LVE5W = new StreamSource(Ys8ZkqKp);
			} else {
				URL ZntXZQ63 = new URL(b6SJHmYO);
				URLConnection UIPSq63O = ZntXZQ63.openConnection();
				UIPSq63O.connect();
				InputStream KPWxxLCY = UIPSq63O.getInputStream();
				JN2LVE5W = new StreamSource(KPWxxLCY);
			}
			SchemaFactory MsNkuRTB = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			if (WV8VFlPb != null) {
				DefaultLSResourceResolver vhtmn5Rj = new DefaultLSResourceResolver(WV8VFlPb);
				MsNkuRTB.setResourceResolver(vhtmn5Rj);
			}
			MsNkuRTB.newSchema(new URL(b6SJHmYO));
			Validator pkN1uf5W = MsNkuRTB.newSchema(JN2LVE5W).newValidator();
			StreamSource kFf1KDvh = new StreamSource(new StringReader(xml));
			pkN1uf5W.validate(kFf1KDvh);
			U6JnefSY.pass(YQxGYxKH);
		} catch (SAXException D4xnBO6l) {
			Loggers.SERVICE_LOG.warn("schema error", D4xnBO6l);
			throw new FitFailureException(D4xnBO6l.getMessage());
		} catch (IOException k8lNa3Mo) {
			Loggers.SERVICE_LOG.warn("schema error", k8lNa3Mo);
			throw new FitFailureException(k8lNa3Mo.getMessage());
		}
	}

}