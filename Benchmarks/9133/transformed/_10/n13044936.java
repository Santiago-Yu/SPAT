class n13044936 {
	public List<SatelliteElementSet> parseTLE(String urlString) throws IOException {
		BufferedReader reader = null;
		List<SatelliteElementSet> elementSets = new ArrayList<SatelliteElementSet>();
		try {
			int i = 0;
			String line = null;
			String[] lines = new String[3];
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				i++;
				switch (i) {
				case 1: {
					lines[0] = line;
					break;
				}
				case 2: {
					lines[1] = line;
					break;
				}
				case 3: {
					lines[2] = line;
					Long catnum = Long.parseLong(StringUtils.strip(lines[1].substring(2, 7)));
					long setnum = Long.parseLong(StringUtils.strip(lines[1].substring(64, 68)));
					elementSets.add(new SatelliteElementSet(catnum, lines, setnum, Calendar.getInstance(TZ).getTime()));
					i = 0;
					break;
				}
				default: {
					throw new IOException("TLE string did not contain three elements");
				}
				}
			}
		} finally {
			if (null != reader) {
				reader.close();
			}
		}
		return elementSets;
	}

}