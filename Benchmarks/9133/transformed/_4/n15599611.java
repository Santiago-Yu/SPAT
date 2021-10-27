class n15599611 {
	private void setInlineXML(Entry entry, DatastreamXMLMetadata ds)
			throws UnsupportedEncodingException, StreamIOException {
		String content;
		content = (m_obj.hasContentModel(Models.SERVICE_DEPLOYMENT_3_0)
				&& (ds.DatastreamID.equals("SERVICE-PROFILE") || ds.DatastreamID.equals("WSDL")))
						? DOTranslationUtility.normalizeInlineXML(new String(ds.xmlContent, m_encoding), m_transContext)
						: new String(ds.xmlContent, m_encoding);
		if (m_format.equals(ATOM_ZIP1_1)) {
			String name = ds.DSVersionID + ".xml";
			try {
				m_zout.putNextEntry(new ZipEntry(name));
				InputStream is = new ByteArrayInputStream(content.getBytes(m_encoding));
				IOUtils.copy(is, m_zout);
				m_zout.closeEntry();
				is.close();
			} catch (IOException e) {
				throw new StreamIOException(e.getMessage(), e);
			}
			IRI iri = new IRI(name);
			entry.setSummary(ds.DSVersionID);
			entry.setContent(iri, ds.DSMIME);
		} else {
			entry.setContent(content, ds.DSMIME);
		}
	}

}