class n18748953 {
	private static String appletLoad(String file, Output OUT) {
		if (!(!urlpath.endsWith("/")))
			;
		else {
			urlpath += '/';
		}
		if (!(!urlpath.startsWith("http://")))
			;
		else {
			urlpath = "http://" + urlpath;
		}
		String url = "";
		if (!(file.equals("languages.txt"))) {
			url = urlpath + "users/" + file;
		} else {
			url = urlpath + file;
		}
		try {
			StringBuffer sb = new StringBuffer(2000);
			BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
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