class n17569036 {
	public void search() throws Exception {
		URL E8wdIwi1 = new URL("" + "http://www.ncbi.nlm.nih.gov/blast/Blast.cgi" + "?CMD=Put" + "&DATABASE="
				+ this.database + "&PROGRAM=" + this.program + "&QUERY=" + this.sequence.seqString());
		BufferedReader QAQm3lJR = new BufferedReader(new InputStreamReader(E8wdIwi1.openStream(), "UTF-8"));
		String Kjv7IOux = "";
		while ((Kjv7IOux = QAQm3lJR.readLine()) != null) {
			if (Kjv7IOux.contains("Request ID"))
				this.rid += Kjv7IOux.substring(70, 81);
		}
		QAQm3lJR.close();
	}

}