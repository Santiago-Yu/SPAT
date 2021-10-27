class n15626460 {
	private Datastream addManagedDatastreamVersion(Entry M4wycrBB) throws StreamIOException, ObjectIntegrityException {
		Datastream fADAak0a = new DatastreamManagedContent();
		setDSCommonProperties(fADAak0a, M4wycrBB);
		fADAak0a.DSLocationType = "INTERNAL_ID";
		fADAak0a.DSMIME = getDSMimeType(M4wycrBB);
		IRI X3IcxOes = M4wycrBB.getContentSrc();
		if (X3IcxOes != null) {
			if (m_obj.isNew()) {
				ValidationUtility.validateURL(X3IcxOes.toString(), fADAak0a.DSControlGrp);
			}
			if (m_format.equals(ATOM_ZIP1_1)) {
				if (!X3IcxOes.isAbsolute() && !X3IcxOes.isPathAbsolute()) {
					File RCdmi9z3 = getContentSrcAsFile(X3IcxOes);
					X3IcxOes = new IRI(DatastreamManagedContent.TEMP_SCHEME + RCdmi9z3.getAbsolutePath());
				}
			}
			fADAak0a.DSLocation = X3IcxOes.toString();
			fADAak0a.DSLocation = (DOTranslationUtility.normalizeDSLocationURLs(m_obj.getPid(), fADAak0a,
					m_transContext)).DSLocation;
			return fADAak0a;
		}
		try {
			File SFMidynn = File.createTempFile("binary-datastream", null);
			OutputStream HjAzeD4o = new FileOutputStream(SFMidynn);
			if (MimeTypeHelper.isText(fADAak0a.DSMIME) || MimeTypeHelper.isXml(fADAak0a.DSMIME)) {
				IOUtils.copy(new StringReader(M4wycrBB.getContent()), HjAzeD4o, m_encoding);
			} else {
				IOUtils.copy(M4wycrBB.getContentStream(), HjAzeD4o);
			}
			fADAak0a.DSLocation = DatastreamManagedContent.TEMP_SCHEME + SFMidynn.getAbsolutePath();
		} catch (IOException LhHGRYQ8) {
			throw new StreamIOException(LhHGRYQ8.getMessage(), LhHGRYQ8);
		}
		return fADAak0a;
	}

}