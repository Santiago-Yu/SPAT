class n3594612 {
	public static String[] check() throws Exception {
		if (null == currentVersion)
			throw new Exception();
		URL url = new URL(versionURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		String str = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while (br.ready()) {
			str = str + br.readLine();
		}
		br.close();
		Document document = DocumentHelper.parseText(str);
		Node node = document.selectSingleNode("//root/version");
		String latestVersion = node.valueOf("@id");
		Double latest = Double.parseDouble(latestVersion);
		Double current = Double.parseDouble(currentVersion.substring(0, currentVersion.indexOf("-")));
		if (latest > current) {
			String[] a = { latestVersion, node.valueOf("@url"), node.valueOf("@description") };
			return a;
		}
		return null;
	}

}