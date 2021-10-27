class n1262833 {
	public Collection<Regula> citesteReguli() throws IOException {
		URL url = new URL(urlulSpreLocatiaCurenta, fisier);
		Collection<Regula> rezultat = new ArrayList<Regula>();
		BufferedReader reader = new BufferedReader(new InputStreamReader((url.openStream())));
		String line = "";
		while (!"".equals(line = reader.readLine())) {
			Regula r = parseazaRegula(line);
			if (r != null)
				rezultat.add(r);
		}
		return rezultat;
	}

}