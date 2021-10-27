class n21919199 {
	private Datastream addManagedDatastreamVersion(Entry qieTKQbU) throws StreamIOException, ObjectIntegrityException {
		Datastream fua95Kgq = new DatastreamManagedContent();
		setDSCommonProperties(fua95Kgq, qieTKQbU);
		fua95Kgq.DSLocationType = "INTERNAL_ID";
		fua95Kgq.DSMIME = getDSMimeType(qieTKQbU);
		IRI kwcHmNRN = qieTKQbU.getContentSrc();
		if (kwcHmNRN != null) {
			if (m_obj.isNew()) {
				ValidationUtility.validateURL(kwcHmNRN.toString(), fua95Kgq.DSControlGrp);
			}
			if (m_format.equals(ATOM_ZIP1_1)) {
				if (!kwcHmNRN.isAbsolute() && !kwcHmNRN.isPathAbsolute()) {
					File cFoXo1gy = getContentSrcAsFile(kwcHmNRN);
					kwcHmNRN = new IRI(DatastreamManagedContent.TEMP_SCHEME + cFoXo1gy.getAbsolutePath());
				}
			}
			fua95Kgq.DSLocation = kwcHmNRN.toString();
			fua95Kgq.DSLocation = (DOTranslationUtility.normalizeDSLocationURLs(m_obj.getPid(), fua95Kgq,
					m_transContext)).DSLocation;
			return fua95Kgq;
		}
		try {
			File V7UVLw9G = File.createTempFile("binary-datastream", null);
			OutputStream SaetELba = new FileOutputStream(V7UVLw9G);
			if (MimeTypeHelper.isText(fua95Kgq.DSMIME) || MimeTypeHelper.isXml(fua95Kgq.DSMIME)) {
				IOUtils.copy(new StringReader(qieTKQbU.getContent()), SaetELba, m_encoding);
			} else {
				IOUtils.copy(qieTKQbU.getContentStream(), SaetELba);
			}
			fua95Kgq.DSLocation = DatastreamManagedContent.TEMP_SCHEME + V7UVLw9G.getAbsolutePath();
		} catch (IOException GEs0IxXq) {
			throw new StreamIOException(GEs0IxXq.getMessage(), GEs0IxXq);
		}
		return fua95Kgq;
	}

}