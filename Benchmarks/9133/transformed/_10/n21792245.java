class n21792245 {
	public static String[] retrieveFasta(String id) throws Exception {
		URL url = new URL("http://www.uniprot.org/uniprot/" + id + ".fasta");
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer seq = new StringBuffer();
		String header = reader.readLine();
		String line = "";
		while ((line = reader.readLine()) != null) {
			seq.append(line);
		}
		reader.close();
		String[] first = header.split("OS=");
		return new String[] { id, first[0].split("\\s")[1], first[1].split("GN=")[0], seq.toString() };
	}

}