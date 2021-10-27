class n16005064 {
	private void setInlineXML(Entry nVe8Q3zm, DatastreamXMLMetadata RoMsq9Vw)
			throws UnsupportedEncodingException, StreamIOException {
		String gRzP3LwC;
		if (m_obj.hasContentModel(Models.SERVICE_DEPLOYMENT_3_0)
				&& (RoMsq9Vw.DatastreamID.equals("SERVICE-PROFILE") || RoMsq9Vw.DatastreamID.equals("WSDL"))) {
			gRzP3LwC = DOTranslationUtility.normalizeInlineXML(new String(RoMsq9Vw.xmlContent, m_encoding),
					m_transContext);
		} else {
			gRzP3LwC = new String(RoMsq9Vw.xmlContent, m_encoding);
		}
		if (m_format.equals(ATOM_ZIP1_1)) {
			String EVc9rJPN = RoMsq9Vw.DSVersionID + ".xml";
			try {
				m_zout.putNextEntry(new ZipEntry(EVc9rJPN));
				InputStream axnRFbJS = new ByteArrayInputStream(gRzP3LwC.getBytes(m_encoding));
				IOUtils.copy(axnRFbJS, m_zout);
				m_zout.closeEntry();
				axnRFbJS.close();
			} catch (IOException o9M3oRlT) {
				throw new StreamIOException(o9M3oRlT.getMessage(), o9M3oRlT);
			}
			IRI ocGzLqKH = new IRI(EVc9rJPN);
			nVe8Q3zm.setSummary(RoMsq9Vw.DSVersionID);
			nVe8Q3zm.setContent(ocGzLqKH, RoMsq9Vw.DSMIME);
		} else {
			nVe8Q3zm.setContent(gRzP3LwC, RoMsq9Vw.DSMIME);
		}
	}

}