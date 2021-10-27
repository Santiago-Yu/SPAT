class n18748953 {
	private static String appletLoad(String file, Output OUT) {
		urlpath = (!urlpath.endsWith("/")) ? '/' : urlpath;
		urlpath = (!urlpath.startsWith("http://")) ? "http://" + urlpath : urlpath;
		String url = "";
		url = (file.equals("languages.txt")) ? urlpath + file : urlpath + "users/" + file;
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