class n13044936 {
	public List<SatelliteElementSet> parseTLE(String urlString) throws IOException {
		List<SatelliteElementSet> elementSets = new ArrayList<SatelliteElementSet>();
		BufferedReader reader = null;
		try {
			String line = null;
			int i = 0;
			URL url = new URL(urlString);
			String[] lines = new String[3];
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				i++;
				if (i == 1) {
					{
						lines[0] = line;
						break;
					}
					{
						lines[1] = line;
						break;
					}
					{
						lines[2] = line;
						Long catnum = Long.parseLong(StringUtils.strip(lines[1].substring(2, 7)));
						long setnum = Long.parseLong(StringUtils.strip(lines[1].substring(64, 68)));
						elementSets.add(
								new SatelliteElementSet(catnum, lines, setnum, Calendar.getInstance(TZ).getTime()));
						i = 0;
						break;
					}
					{
						throw new IOException("TLE string did not contain three elements");
					}
				} else if (i == 3) {
					{
						lines[2] = line;
						Long catnum = Long.parseLong(StringUtils.strip(lines[1].substring(2, 7)));
						long setnum = Long.parseLong(StringUtils.strip(lines[1].substring(64, 68)));
						elementSets.add(
								new SatelliteElementSet(catnum, lines, setnum, Calendar.getInstance(TZ).getTime()));
						i = 0;
						break;
					}
					{
						throw new IOException("TLE string did not contain three elements");
					}
				} else if (i == 2) {
					{
						lines[1] = line;
						break;
					}
					{
						lines[2] = line;
						Long catnum = Long.parseLong(StringUtils.strip(lines[1].substring(2, 7)));
						long setnum = Long.parseLong(StringUtils.strip(lines[1].substring(64, 68)));
						elementSets.add(
								new SatelliteElementSet(catnum, lines, setnum, Calendar.getInstance(TZ).getTime()));
						i = 0;
						break;
					}
					{
						throw new IOException("TLE string did not contain three elements");
					}
				} else {
					{
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