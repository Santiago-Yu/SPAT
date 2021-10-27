class n16841577 {
	public int read(String QfJAaTpN) {
		status = STATUS_OK;
		try {
			QfJAaTpN = QfJAaTpN.trim();
			if (QfJAaTpN.indexOf("://") > 0) {
				URL AdPNtpdb = new URL(QfJAaTpN);
				in = new BufferedInputStream(AdPNtpdb.openStream());
			} else {
				in = new BufferedInputStream(new FileInputStream(QfJAaTpN));
			}
			status = read(in);
		} catch (IOException m05WDZAA) {
			status = STATUS_OPEN_ERROR;
		}
		return status;
	}

}