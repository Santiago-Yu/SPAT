class n22235113 {
	protected Object unmarshallXml(final Unmarshaller iMQRzVTC, final String NAoQkyw2, final String P9OfQIWe,
			final String x674hl3Y, final String edIGUxxl) throws Exception {
		final URL hbF4jN6c = new URL(NAoQkyw2);
		final BufferedReader zWXqeSKg = new BufferedReader(new InputStreamReader(hbF4jN6c.openStream()));
		String s5emvWG1 = readWithStringBuffer(zWXqeSKg);
		if (x674hl3Y != null) {
			s5emvWG1 = s5emvWG1.replace(x674hl3Y, edIGUxxl);
		}
		LOGGER.info("Calls " + NAoQkyw2);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("\nXml:" + NAoQkyw2 + "\n" + s5emvWG1);
		}
		if (LOGGER.isDebugEnabled()) {
			final BufferedWriter ZPXY8gP6 = new BufferedWriter(
					new FileWriter("target/XmlAgentLog" + xmlRequestNumber++ + ".txt"));
			ZPXY8gP6.write(s5emvWG1);
			ZPXY8gP6.close();
		}
		final ByteArrayInputStream LeMIBI6G = new ByteArrayInputStream(s5emvWG1.getBytes());
		Source qOveF2bo;
		if (P9OfQIWe != null) {
			qOveF2bo = setNameSpaceOnXmlStream(LeMIBI6G, P9OfQIWe);
		} else {
			qOveF2bo = new StreamSource(LeMIBI6G);
		}
		return iMQRzVTC.unmarshal(qOveF2bo);
	}

}