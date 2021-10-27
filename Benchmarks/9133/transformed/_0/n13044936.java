class n13044936 {
	public List<SatelliteElementSet> parseTLE(String jYg6DAot) throws IOException {
		List<SatelliteElementSet> uIq7TDp5 = new ArrayList<SatelliteElementSet>();
		BufferedReader gWtJKuFF = null;
		try {
			String I9cCQpPn = null;
			int xrkdIQgD = 0;
			URL XxOLO5X6 = new URL(jYg6DAot);
			String[] kyURP60t = new String[3];
			gWtJKuFF = new BufferedReader(new InputStreamReader(XxOLO5X6.openStream()));
			while ((I9cCQpPn = gWtJKuFF.readLine()) != null) {
				xrkdIQgD++;
				switch (xrkdIQgD) {
				case 1: {
					kyURP60t[0] = I9cCQpPn;
					break;
				}
				case 2: {
					kyURP60t[1] = I9cCQpPn;
					break;
				}
				case 3: {
					kyURP60t[2] = I9cCQpPn;
					Long ulpDEPlV = Long.parseLong(StringUtils.strip(kyURP60t[1].substring(2, 7)));
					long G4wUJhWk = Long.parseLong(StringUtils.strip(kyURP60t[1].substring(64, 68)));
					uIq7TDp5.add(
							new SatelliteElementSet(ulpDEPlV, kyURP60t, G4wUJhWk, Calendar.getInstance(TZ).getTime()));
					xrkdIQgD = 0;
					break;
				}
				default: {
					throw new IOException("TLE string did not contain three elements");
				}
				}
			}
		} finally {
			if (null != gWtJKuFF) {
				gWtJKuFF.close();
			}
		}
		return uIq7TDp5;
	}

}