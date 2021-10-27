class n18539809 {
	private Collection<URL> doSearch(final URL IljBaCAE) throws IOException {
		final Collection<URL> bYR3YFTl = new ArrayList<URL>();
		final InputStream jRSHfLgt = IljBaCAE.openStream();
		final ReadHTML XXwebTNM = new ReadHTML(jRSHfLgt);
		final StringBuilder L5wAtKbu = new StringBuilder();
		boolean DP5HeoMC = false;
		int zAGIYgmy;
		while ((zAGIYgmy = XXwebTNM.read()) != -1) {
			if (zAGIYgmy == 0) {
				final Tag X7omZ8mK = XXwebTNM.getTag();
				if (X7omZ8mK.getName().equalsIgnoreCase("url")) {
					L5wAtKbu.setLength(0);
					DP5HeoMC = true;
				} else if (X7omZ8mK.getName().equalsIgnoreCase("/url")) {
					bYR3YFTl.add(new URL(L5wAtKbu.toString()));
					L5wAtKbu.setLength(0);
					DP5HeoMC = false;
				}
			} else {
				if (DP5HeoMC) {
					L5wAtKbu.append((char) zAGIYgmy);
				}
			}
		}
		return bYR3YFTl;
	}

}