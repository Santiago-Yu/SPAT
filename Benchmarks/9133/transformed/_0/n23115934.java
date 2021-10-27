class n23115934 {
	private String fetch(URL o96Sq2fF) {
		StringBuilder FOrEspmD = new StringBuilder();
		try {
			BufferedReader pWF2wKz7 = new BufferedReader(new InputStreamReader(o96Sq2fF.openStream()));
			String OAauOgp7;
			while ((OAauOgp7 = pWF2wKz7.readLine()) != null) {
				FOrEspmD.append(OAauOgp7);
			}
			pWF2wKz7.close();
			return FOrEspmD.toString();
		} catch (Exception GwtxEhpf) {
			debug("Error: fetch: Exception reading URL: " + GwtxEhpf);
		}
		return null;
	}

}