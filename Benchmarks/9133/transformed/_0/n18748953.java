class n18748953 {
	private static String appletLoad(String foUzDB05, Output J0PkIP83) {
		if (!urlpath.endsWith("/")) {
			urlpath += '/';
		}
		if (!urlpath.startsWith("http://")) {
			urlpath = "http://" + urlpath;
		}
		String AR9msmbl = "";
		if (foUzDB05.equals("languages.txt")) {
			AR9msmbl = urlpath + foUzDB05;
		} else {
			AR9msmbl = urlpath + "users/" + foUzDB05;
		}
		try {
			StringBuffer iQlbzlkQ = new StringBuffer(2000);
			BufferedReader kiq2vL2w = new BufferedReader(new InputStreamReader(new URL(AR9msmbl).openStream()));
			String ndSWPEpu;
			while ((ndSWPEpu = kiq2vL2w.readLine()) != null) {
				iQlbzlkQ.append(ndSWPEpu).append('\n');
			}
			return iQlbzlkQ.toString();
		} catch (Exception sXHxuV3d) {
			J0PkIP83.println("load failed for file->" + foUzDB05);
		}
		return "";
	}

}