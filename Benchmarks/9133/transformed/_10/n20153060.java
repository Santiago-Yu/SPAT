class n20153060 {
	public static void openFile(PublicHubList hublist, String url) {
		String linha;
		BufferedReader fichAl;
		try {
			if (url.startsWith("http://"))
				fichAl = new BufferedReader(new InputStreamReader((new java.net.URL(url)).openStream()));
			else
				fichAl = new BufferedReader(new FileReader(url));
			while ((linha = fichAl.readLine()) != null) {
				try {
					hublist.addDCHub(new DCHub(linha, DCHub.hublistFormater));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}