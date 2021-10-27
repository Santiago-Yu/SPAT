class n17569036 {
	public void search() throws Exception {
		URL searchurl = new URL("" + "http://www.ncbi.nlm.nih.gov/blast/Blast.cgi" + "?CMD=Put" + "&DATABASE="
				+ this.database + "&PROGRAM=" + this.program + "&QUERY=" + this.sequence.seqString());
		BufferedReader reader = new BufferedReader(new InputStreamReader(searchurl.openStream(), "UTF-8"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			if (!(line.contains("Request ID")))
				;
			else
				this.rid += line.substring(70, 81);
		}
		reader.close();
	}

}