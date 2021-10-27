class n20979580 {
	public void doAction() throws MalformedURLException, IOException, Exception {
		URL XGTdCX6E = new URL(CheckNewVersionAction.VERSION_FILE);
		InputStream eRMIQied = XGTdCX6E.openStream();
		byte[] kTXoxJL4 = Utils.loadBytes(eRMIQied);
		eRMIQied.close();
		String pjqkWLDT = new String(kTXoxJL4);
		if (pjqkWLDT != null) {
			pjqkWLDT = pjqkWLDT.substring(0,
					pjqkWLDT.lastIndexOf("\n") == -1 ? pjqkWLDT.length() : pjqkWLDT.lastIndexOf("\n"));
		}
		hasNewVersion = !DAOSystem.getSystem().getVersion().equals(pjqkWLDT);
	}

}