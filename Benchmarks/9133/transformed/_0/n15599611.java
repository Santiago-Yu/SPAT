class n15599611 {
	private void setInlineXML(Entry dVDwACrU, DatastreamXMLMetadata Mm34FIcz)
			throws UnsupportedEncodingException, StreamIOException {
		String fV0qyCcX;
		if (m_obj.hasContentModel(Models.SERVICE_DEPLOYMENT_3_0)
				&& (Mm34FIcz.DatastreamID.equals("SERVICE-PROFILE") || Mm34FIcz.DatastreamID.equals("WSDL"))) {
			fV0qyCcX = DOTranslationUtility.normalizeInlineXML(new String(Mm34FIcz.xmlContent, m_encoding),
					m_transContext);
		} else {
			fV0qyCcX = new String(Mm34FIcz.xmlContent, m_encoding);
		}
		if (m_format.equals(ATOM_ZIP1_1)) {
			String mYfHWdWK = Mm34FIcz.DSVersionID + ".xml";
			try {
				m_zout.putNextEntry(new ZipEntry(mYfHWdWK));
				InputStream SHkvVLHQ = new ByteArrayInputStream(fV0qyCcX.getBytes(m_encoding));
				IOUtils.copy(SHkvVLHQ, m_zout);
				m_zout.closeEntry();
				SHkvVLHQ.close();
			} catch (IOException SDepLrB8) {
				throw new StreamIOException(SDepLrB8.getMessage(), SDepLrB8);
			}
			IRI VCoLxHwg = new IRI(mYfHWdWK);
			dVDwACrU.setSummary(Mm34FIcz.DSVersionID);
			dVDwACrU.setContent(VCoLxHwg, Mm34FIcz.DSMIME);
		} else {
			dVDwACrU.setContent(fV0qyCcX, Mm34FIcz.DSMIME);
		}
	}

}