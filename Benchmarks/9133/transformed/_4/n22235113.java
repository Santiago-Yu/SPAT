class n22235113 {
	protected Object unmarshallXml(final Unmarshaller unmarshaller, final String accessUrl, final String nameSpace,
			final String replace, final String with) throws Exception {
		final URL url = new URL(accessUrl);
		final BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
		String xmlContent = readWithStringBuffer(inputStream);
		xmlContent = (replace != null) ? xmlContent.replace(replace, with) : xmlContent;
		LOGGER.info("Calls " + accessUrl);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("\nXml:" + accessUrl + "\n" + xmlContent);
		}
		if (LOGGER.isDebugEnabled()) {
			final BufferedWriter out = new BufferedWriter(
					new FileWriter("target/XmlAgentLog" + xmlRequestNumber++ + ".txt"));
			out.write(xmlContent);
			out.close();
		}
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlContent.getBytes());
		Source source;
		source = (nameSpace != null) ? setNameSpaceOnXmlStream(byteArrayInputStream, nameSpace)
				: new StreamSource(byteArrayInputStream);
		return unmarshaller.unmarshal(source);
	}

}