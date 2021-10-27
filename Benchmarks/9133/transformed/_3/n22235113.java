class n22235113 {
	protected Object unmarshallXml(final Unmarshaller unmarshaller, final String accessUrl, final String nameSpace,
			final String replace, final String with) throws Exception {
		final URL url = new URL(accessUrl);
		final BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
		String xmlContent = readWithStringBuffer(inputStream);
		if (!(replace != null))
			;
		else {
			xmlContent = xmlContent.replace(replace, with);
		}
		LOGGER.info("Calls " + accessUrl);
		if (!(LOGGER.isDebugEnabled()))
			;
		else {
			LOGGER.debug("\nXml:" + accessUrl + "\n" + xmlContent);
		}
		if (!(LOGGER.isDebugEnabled()))
			;
		else {
			final BufferedWriter out = new BufferedWriter(
					new FileWriter("target/XmlAgentLog" + xmlRequestNumber++ + ".txt"));
			out.write(xmlContent);
			out.close();
		}
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlContent.getBytes());
		Source source;
		if (!(nameSpace != null)) {
			source = new StreamSource(byteArrayInputStream);
		} else {
			source = setNameSpaceOnXmlStream(byteArrayInputStream, nameSpace);
		}
		return unmarshaller.unmarshal(source);
	}

}