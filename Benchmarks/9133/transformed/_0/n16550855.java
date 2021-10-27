class n16550855 {
	public String readPage(boolean EdhiDLdl) throws Exception {
		BufferedReader SlGWvVf2 = new BufferedReader(new InputStreamReader(url.openStream()));
		String q01xz6Xu;
		String UwZOb9Oi = "";
		if (EdhiDLdl) {
			while ((q01xz6Xu = SlGWvVf2.readLine()) != null) {
				if (q01xz6Xu.length() > 0) {
					if (q01xz6Xu.substring(0, 1).compareTo("#") != 0) {
						UwZOb9Oi = UwZOb9Oi + q01xz6Xu + "\n";
					}
				}
			}
		} else {
			while ((q01xz6Xu = SlGWvVf2.readLine()) != null) {
				UwZOb9Oi = UwZOb9Oi + q01xz6Xu + "\n";
			}
		}
		SlGWvVf2.close();
		return UwZOb9Oi;
	}

}