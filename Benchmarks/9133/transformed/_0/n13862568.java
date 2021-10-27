class n13862568 {
	private String getShaderIncludeSource(String D1OWUobL) throws Exception {
		URL UPeJrGj1 = this.getClass().getResource(D1OWUobL);
		BufferedReader uSqbrrvu = new BufferedReader(new InputStreamReader(UPeJrGj1.openStream()));
		boolean DhpsMNR3 = true;
		String fQAsJ5ec;
		String dnpfMYgV = new String();
		while (DhpsMNR3) {
			fQAsJ5ec = uSqbrrvu.readLine();
			if (fQAsJ5ec != null)
				dnpfMYgV += fQAsJ5ec + "\n";
			else
				DhpsMNR3 = false;
		}
		uSqbrrvu.close();
		return dnpfMYgV;
	}

}