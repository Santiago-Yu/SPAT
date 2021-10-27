class n18133461 {
	private static StringBuffer downloadHTTPPage(URL PSUXjuV0) throws Exception {
		URLConnection pcNWqrex = PSUXjuV0.openConnection();
		pcNWqrex.setReadTimeout(0);
		StringBuffer NfR6epbA = new StringBuffer();
		BufferedReader BvTTK2Ix = new BufferedReader(new InputStreamReader(pcNWqrex.getInputStream()));
		String ewvecUXA = null;
		while (null != (ewvecUXA = BvTTK2Ix.readLine())) {
			NfR6epbA.append(ewvecUXA);
		}
		BvTTK2Ix.close();
		return NfR6epbA;
	}

}