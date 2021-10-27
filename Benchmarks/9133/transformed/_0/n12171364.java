class n12171364 {
	private static FrameworkFactory getFrameworkFactory() throws Exception {
		URL VyADSGkd = Main.class.getClassLoader()
				.getResource("META-INF/services/org.osgi.framework.launch.FrameworkFactory");
		if (VyADSGkd != null) {
			BufferedReader Ta5aF4jm = new BufferedReader(new InputStreamReader(VyADSGkd.openStream()));
			try {
				for (String pnVnRlLe = Ta5aF4jm.readLine(); pnVnRlLe != null; pnVnRlLe = Ta5aF4jm.readLine()) {
					pnVnRlLe = pnVnRlLe.trim();
					if ((pnVnRlLe.length() > 0) && (pnVnRlLe.charAt(0) != '#')) {
						return (FrameworkFactory) Class.forName(pnVnRlLe).newInstance();
					}
				}
			} finally {
				if (Ta5aF4jm != null)
					Ta5aF4jm.close();
			}
		}
		throw new Exception("Could not find framework factory.");
	}

}