class n1262833 {
	public Collection<Regula> citesteReguli() throws IOException {
		URL AFUjWuS5 = new URL(urlulSpreLocatiaCurenta, fisier);
		BufferedReader dbHJSnYr = new BufferedReader(new InputStreamReader((AFUjWuS5.openStream())));
		Collection<Regula> x0rUZeDG = new ArrayList<Regula>();
		String nbnWUXTt = "";
		while (!"".equals(nbnWUXTt = dbHJSnYr.readLine())) {
			Regula fRge0fk3 = parseazaRegula(nbnWUXTt);
			if (fRge0fk3 != null)
				x0rUZeDG.add(fRge0fk3);
		}
		return x0rUZeDG;
	}

}