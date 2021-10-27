class n16005062 {
	private void addAuditDatastream() throws ObjectIntegrityException, StreamIOException {
		if (m_obj.getAuditRecords().size() == 0) {
			return;
		}
		String UIpFzked = m_pid.toURI() + "/AUDIT";
		String gG3Gq8Dy = UIpFzked + "/" + DateUtility.convertDateToString(m_obj.getCreateDate());
		Entry NZfs7zAN = m_feed.addEntry();
		NZfs7zAN.setId(UIpFzked);
		NZfs7zAN.setTitle("AUDIT");
		NZfs7zAN.setUpdated(m_obj.getCreateDate());
		NZfs7zAN.addCategory(MODEL.STATE.uri, "A", null);
		NZfs7zAN.addCategory(MODEL.CONTROL_GROUP.uri, "X", null);
		NZfs7zAN.addCategory(MODEL.VERSIONABLE.uri, "false", null);
		NZfs7zAN.addLink(gG3Gq8Dy, Link.REL_ALTERNATE);
		Entry HIxyhSfN = m_feed.addEntry();
		HIxyhSfN.setId(gG3Gq8Dy);
		HIxyhSfN.setTitle("AUDIT.0");
		HIxyhSfN.setUpdated(m_obj.getCreateDate());
		ThreadHelper.addInReplyTo(HIxyhSfN, m_pid.toURI() + "/AUDIT");
		HIxyhSfN.addCategory(MODEL.FORMAT_URI.uri, AUDIT1_0.uri, null);
		HIxyhSfN.addCategory(MODEL.LABEL.uri, "Audit Trail for this object", null);
		if (m_format.equals(ATOM_ZIP1_1)) {
			String oKjL80qs = "AUDIT.0.xml";
			try {
				m_zout.putNextEntry(new ZipEntry(oKjL80qs));
				Reader kstV1u5l = new StringReader(DOTranslationUtility.getAuditTrail(m_obj));
				IOUtils.copy(kstV1u5l, m_zout, m_encoding);
				m_zout.closeEntry();
				kstV1u5l.close();
			} catch (IOException KUHDIEdI) {
				throw new StreamIOException(KUHDIEdI.getMessage(), KUHDIEdI);
			}
			IRI WjCwhSaM = new IRI(oKjL80qs);
			HIxyhSfN.setSummary("AUDIT.0");
			HIxyhSfN.setContent(WjCwhSaM, "text/xml");
		} else {
			HIxyhSfN.setContent(DOTranslationUtility.getAuditTrail(m_obj), "text/xml");
		}
	}

}