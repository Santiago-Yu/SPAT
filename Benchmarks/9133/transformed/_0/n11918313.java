class n11918313 {
	public String[] retrieveFasta(String ojzUlfO0) throws Exception {
		URL v6kE32bw = new URL("http://www.ebi.ac.uk/ena/data/view/" + ojzUlfO0 + "&display=fasta");
		BufferedReader VoGhWDyy = new BufferedReader(new InputStreamReader(v6kE32bw.openStream()));
		String iAXec1ru = VoGhWDyy.readLine();
		StringBuffer Gp5Ep3vT = new StringBuffer();
		String o8ifMbp6 = "";
		while ((o8ifMbp6 = VoGhWDyy.readLine()) != null) {
			Gp5Ep3vT.append(o8ifMbp6);
		}
		VoGhWDyy.close();
		return new String[] { iAXec1ru, Gp5Ep3vT.toString() };
	}

}