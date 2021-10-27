class n7468318 {
	private List<Intrebare> citesteIntrebari() throws IOException {
		ArrayList<Intrebare> intrebari = new ArrayList<Intrebare>();
		try {
			URL url = new URL(getCodeBase(), "../intrebari.txt");
			String intrebare;
			BufferedReader reader = new BufferedReader(new InputStreamReader((url.openStream())));
			while ((intrebare = reader.readLine()) != null) {
				Collection<String> raspunsuri = new ArrayList<String>();
				Collection<String> predicate = new ArrayList<String>();
				String raspuns = "";
				while (!"".equals(raspuns = reader.readLine())) {
					raspunsuri.add(raspuns);
					predicate.add(reader.readLine());
				}
				Intrebare i = new Intrebare(intrebare, raspunsuri.toArray(new String[raspunsuri.size()]),
						predicate.toArray(new String[predicate.size()]));
				intrebari.add(i);
			}
		} catch (ArgumentExcetpion e) {
			e.printStackTrace();
		}
		return intrebari;
	}

}