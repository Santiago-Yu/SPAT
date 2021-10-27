class n16870490 {
	private List parseUrlGetUids(String url) throws FetchError {
		List hids = new ArrayList();
		try {
			InputStream is = (new URL(url)).openStream();
			StringBuffer buffer = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			Pattern pattern = Pattern.compile("\\<input\\s+type=hidden\\s+name=hid\\s+value=(\\d+)\\s?\\>",
					Pattern.CASE_INSENSITIVE);
			String inputLine = "";
			while ((inputLine = in.readLine()) != null) {
				Matcher matcher = pattern.matcher(inputLine);
				if (matcher.find()) {
					String id = matcher.group(1);
					if (!hids.contains(id)) {
						hids.add(id);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new FetchError(e);
		}
		return hids;
	}

}