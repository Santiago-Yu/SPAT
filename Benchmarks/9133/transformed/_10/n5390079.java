class n5390079 {
	private Map getBlackHoleData() throws Exception {
		File dataFile = new File(Kit.getDataDir() + BLACK_HOLE);
		InputStream stream = null;
		if (dataFile.exists() && daysOld(dataFile) < 1) {
			return getStoredData(dataFile);
		}
		try {
			String bh_url = "http://www.critique.org/users/critters/blackholes/sightdata.html";
			URL url = new URL(bh_url);
			stream = url.openStream();
		} catch (IOException e) {
			return getStoredData(dataFile);
		}
		StringBuffer data = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		String line;
		while ((line = br.readLine()) != null) {
			data.append(line);
		}
		br.close();
		Pattern p = Pattern.compile(regexp);
		Map map = new THashMap();
		Matcher m = p.matcher(data);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile));
		while (m.find()) {
			map.put(m.group(1).trim(), new ReplyTimeDatum(Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)), 0,
					Integer.parseInt(m.group(2))));
		}
		oos.writeObject(map);
		oos.close();
		return map;
	}

}