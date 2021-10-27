class n21302551 {
	public static Document convertHtmlToXml(final InputStream htmlInputStream, final String classpathXsltResource,
			final String encoding) {
		javax.xml.parsers.DocumentBuilder db;
		Parser p = new Parser();
		try {
			db = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			log.error("", e);
			throw new RuntimeException();
		}
		InputStream is = htmlInputStream;
		Document document = db.newDocument();
		if (log.isDebugEnabled()) {
			ByteArrayOutputStream baos;
			baos = new ByteArrayOutputStream();
			try {
				IOUtils.copy(is, baos);
			} catch (IOException e) {
				log.error("Fail to make input stream copy.", e);
			}
			IOUtils.closeQuietly(is);
			ByteArrayInputStream byteArrayInputStream;
			byteArrayInputStream = new ByteArrayInputStream(baos.toByteArray());
			try {
				IOUtils.toString(new ByteArrayInputStream(baos.toByteArray()), "UTF-8");
			} catch (IOException e) {
				log.error("", e);
			}
			IOUtils.closeQuietly(byteArrayInputStream);
			is = new ByteArrayInputStream(baos.toByteArray());
		}
		try {
			InputSource iSource = new InputSource(is);
			iSource.setEncoding(encoding);
			Result result = new DOMResult(document);
			Source transformerSource = new SAXSource(p, iSource);
			Transformer xslTransformer = getTransformerByName(classpathXsltResource, false);
			try {
				xslTransformer.transform(transformerSource, result);
			} catch (TransformerException e) {
				throw new RuntimeException(e);
			}
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				log.warn("", e);
			}
		}
		return document;
	}

}