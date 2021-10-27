class n8898759 {
	public static List<String> getFiles(int year, int month, int day, String type) throws Exception {
		URL url = new URL(baseUrl + "/" + year + "/" + ((month > 9) ? month : ("0" + month)) + "/"
				+ ((day > 9) ? day : ("0" + day)));
		ArrayList<String> list = new ArrayList<String>();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((line = br.readLine()) != null && line != "") {
			if (line.startsWith("<tr>") && line.indexOf("[TXT]") >= 0) {
				int i = line.indexOf("href=");
				i = i + 6;
				int j = line.indexOf("\"", i);
				String filename = line.substring(i, j);
				if (filename.matches(".*" + type + ".*")) {
					list.add(filename);
				}
			}
		}
		br.close();
		return list;
	}

}