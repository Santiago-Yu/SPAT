class n15599613 {
	private void setManagedContent(Entry iq61nwwe, Datastream IM8Pw133) throws StreamIOException {
		if (m_transContext == DOTranslationUtility.SERIALIZE_EXPORT_ARCHIVE && !m_format.equals(ATOM_ZIP1_1)) {
			String DgDhnnGX = IM8Pw133.DSMIME;
			if (MimeTypeHelper.isText(DgDhnnGX) || MimeTypeHelper.isXml(DgDhnnGX)) {
				try {
					iq61nwwe.setContent(IOUtils.toString(IM8Pw133.getContentStream(), m_encoding), DgDhnnGX);
				} catch (IOException Ru0cI9Fo) {
					throw new StreamIOException(Ru0cI9Fo.getMessage(), Ru0cI9Fo);
				}
			} else {
				iq61nwwe.setContent(IM8Pw133.getContentStream(), DgDhnnGX);
			}
		} else {
			String Gg4fItaG;
			IRI o0Igf0wF;
			if (m_format.equals(ATOM_ZIP1_1) && m_transContext != DOTranslationUtility.AS_IS) {
				Gg4fItaG = IM8Pw133.DSVersionID + "." + MimeTypeUtils.fileExtensionForMIMEType(IM8Pw133.DSMIME);
				try {
					m_zout.putNextEntry(new ZipEntry(Gg4fItaG));
					InputStream XqU4g1nT = IM8Pw133.getContentStream();
					IOUtils.copy(XqU4g1nT, m_zout);
					XqU4g1nT.close();
					m_zout.closeEntry();
				} catch (IOException KPOBf4pj) {
					throw new StreamIOException(KPOBf4pj.getMessage(), KPOBf4pj);
				}
			} else {
				Gg4fItaG = StreamUtility.enc(DOTranslationUtility.normalizeDSLocationURLs(m_obj.getPid(), IM8Pw133,
						m_transContext).DSLocation);
			}
			o0Igf0wF = new IRI(Gg4fItaG);
			iq61nwwe.setSummary(IM8Pw133.DSVersionID);
			iq61nwwe.setContent(o0Igf0wF, IM8Pw133.DSMIME);
		}
	}

}