class n6172173 {
	public int read(String HLvoq8pI) {
		status = STATUS_OK;
		try {
			HLvoq8pI = HLvoq8pI.trim().toLowerCase();
			if ((HLvoq8pI.indexOf("file:") >= 0) || (HLvoq8pI.indexOf(":/") > 0)) {
				URL eloKWHp1 = new URL(HLvoq8pI);
				in = new BufferedInputStream(eloKWHp1.openStream());
			} else {
				in = new BufferedInputStream(new FileInputStream(HLvoq8pI));
			}
			status = read(in);
		} catch (IOException TvU5jiJB) {
			status = STATUS_OPEN_ERROR;
		}
		return status;
	}

}