class n18748953 {
	private static String appletLoad(String file, Output OUT) {
		if (!urlpath.endsWith("/")) {
			urlpath += '/';
		}
		String url = "";
		if (!urlpath.startsWith("http://")) {
			urlpath = "http://" + urlpath;
		}
		if (file.equals("languages.txt")) {
			url = urlpath + file;
		} else {
			url = urlpath + "users/" + file;
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			StringBuffer sb = new StringBuffer(2000);
			String a;
			while ((a = br.readLine()) != null) {
				sb.append(a).append('\n');
			}
			return sb.toString();
		} catch (Exception e) {
			OUT.println("load failed for file->" + file);
		}
		return "";
	}

}