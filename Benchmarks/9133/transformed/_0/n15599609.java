class n15599609 {
	private void addAuditDatastream() throws ObjectIntegrityException, StreamIOException {
		if (m_obj.getAuditRecords().size() == 0) {
			return;
		}
		String tTM8ZkYE = m_pid.toURI() + "/AUDIT";
		String ew8XLeix = tTM8ZkYE + "/" + DateUtility.convertDateToString(m_obj.getCreateDate());
		Entry xpDxl04g = m_feed.addEntry();
		xpDxl04g.setId(tTM8ZkYE);
		xpDxl04g.setTitle("AUDIT");
		xpDxl04g.setUpdated(m_obj.getCreateDate());
		xpDxl04g.addCategory(MODEL.STATE.uri, "A", null);
		xpDxl04g.addCategory(MODEL.CONTROL_GROUP.uri, "X", null);
		xpDxl04g.addCategory(MODEL.VERSIONABLE.uri, "false", null);
		xpDxl04g.addLink(ew8XLeix, Link.REL_ALTERNATE);
		Entry mxCfHdug = m_feed.addEntry();
		mxCfHdug.setId(ew8XLeix);
		mxCfHdug.setTitle("AUDIT.0");
		mxCfHdug.setUpdated(m_obj.getCreateDate());
		ThreadHelper.addInReplyTo(mxCfHdug, m_pid.toURI() + "/AUDIT");
		mxCfHdug.addCategory(MODEL.FORMAT_URI.uri, AUDIT1_0.uri, null);
		mxCfHdug.addCategory(MODEL.LABEL.uri, "Audit Trail for this object", null);
		if (m_format.equals(ATOM_ZIP1_1)) {
			String cJvL7rMi = "AUDIT.0.xml";
			try {
				m_zout.putNextEntry(new ZipEntry(cJvL7rMi));
				Reader EFaVA94E = new StringReader(DOTranslationUtility.getAuditTrail(m_obj));
				IOUtils.copy(EFaVA94E, m_zout, m_encoding);
				m_zout.closeEntry();
				EFaVA94E.close();
			} catch (IOException fFAzVbsU) {
				throw new StreamIOException(fFAzVbsU.getMessage(), fFAzVbsU);
			}
			IRI ah8Fd7AZ = new IRI(cJvL7rMi);
			mxCfHdug.setSummary("AUDIT.0");
			mxCfHdug.setContent(ah8Fd7AZ, "text/xml");
		} else {
			mxCfHdug.setContent(DOTranslationUtility.getAuditTrail(m_obj), "text/xml");
		}
	}

}