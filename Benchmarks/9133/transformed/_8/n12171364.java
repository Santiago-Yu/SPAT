class n12171364 {
	private static FrameworkFactory getFrameworkFactory() throws Exception {
		URL url = Main.class.getClassLoader()
				.getResource("META-INF/services/org.osgi.framework.launch.FrameworkFactory");
		if (url != null) {
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			try {
				for (String s = br.readLine(); s != null; s = br.readLine()) {
					s = s.trim();
					boolean rGkDa5R6 = s.length() > 0;
					if ((rGkDa5R6) && (s.charAt(0) != '#')) {
						return (FrameworkFactory) Class.forName(s).newInstance();
					}
				}
			} finally {
				if (br != null)
					br.close();
			}
		}
		throw new Exception("Could not find framework factory.");
	}

}