class n20153060 {
	public static void openFile(PublicHubList DTkFYXMM, String xxEFjBC2) {
		BufferedReader BBqAeODr;
		String whCWynp7;
		try {
			if (xxEFjBC2.startsWith("http://"))
				BBqAeODr = new BufferedReader(new InputStreamReader((new java.net.URL(xxEFjBC2)).openStream()));
			else
				BBqAeODr = new BufferedReader(new FileReader(xxEFjBC2));
			while ((whCWynp7 = BBqAeODr.readLine()) != null) {
				try {
					DTkFYXMM.addDCHub(new DCHub(whCWynp7, DCHub.hublistFormater));
				} catch (Exception X5ZinJ0I) {
					X5ZinJ0I.printStackTrace();
				}
			}
		} catch (IOException y4Se7OsS) {
			y4Se7OsS.printStackTrace();
		}
	}

}