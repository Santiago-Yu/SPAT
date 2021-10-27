class n16005066 {
	private void setManagedContent(Entry YHPkFHLv, Datastream JrfEmvwQ) throws StreamIOException {
		if (m_transContext == DOTranslationUtility.SERIALIZE_EXPORT_ARCHIVE && !m_format.equals(ATOM_ZIP1_1)) {
			String kWln7ttn = JrfEmvwQ.DSMIME;
			if (MimeTypeHelper.isText(kWln7ttn) || MimeTypeHelper.isXml(kWln7ttn)) {
				try {
					YHPkFHLv.setContent(IOUtils.toString(JrfEmvwQ.getContentStream(), m_encoding), kWln7ttn);
				} catch (IOException TjG6EjFo) {
					throw new StreamIOException(TjG6EjFo.getMessage(), TjG6EjFo);
				}
			} else {
				YHPkFHLv.setContent(JrfEmvwQ.getContentStream(), kWln7ttn);
			}
		} else {
			String p6cWX2ft;
			IRI xNdqOBAq;
			if (m_format.equals(ATOM_ZIP1_1) && m_transContext != DOTranslationUtility.AS_IS) {
				p6cWX2ft = JrfEmvwQ.DSVersionID + "." + MimeTypeUtils.fileExtensionForMIMEType(JrfEmvwQ.DSMIME);
				try {
					m_zout.putNextEntry(new ZipEntry(p6cWX2ft));
					IOUtils.copy(JrfEmvwQ.getContentStream(), m_zout);
					m_zout.closeEntry();
				} catch (IOException AijzvNDw) {
					throw new StreamIOException(AijzvNDw.getMessage(), AijzvNDw);
				}
			} else {
				p6cWX2ft = StreamUtility.enc(DOTranslationUtility.normalizeDSLocationURLs(m_obj.getPid(), JrfEmvwQ,
						m_transContext).DSLocation);
			}
			xNdqOBAq = new IRI(p6cWX2ft);
			YHPkFHLv.setSummary(JrfEmvwQ.DSVersionID);
			YHPkFHLv.setContent(xNdqOBAq, JrfEmvwQ.DSMIME);
		}
	}

}