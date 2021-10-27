class n12171364 {
	private static FrameworkFactory getFrameworkFactory() throws Exception {
		URL url = Main.class.getClassLoader()
				.getResource("META-INF/services/org.osgi.framework.launch.FrameworkFactory");
		if (url != null) {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			try {
				String FEdJX = br.readLine();
				while (FEdJX != null) {
					FEdJX = FEdJX.trim();
					if ((FEdJX.length() > 0) && (FEdJX.charAt(0) != '#')) {
						return (FrameworkFactory) Class.forName(FEdJX).newInstance();
					}
					FEdJX = br.readLine();
				}
			} finally {
				if (br != null)
					br.close();
			}
		}
		throw new Exception("Could not find framework factory.");
	}

}