class n16830682 {
	public void install(Session session) throws Exception {
		String cfgPath = ConfigurationFactory.getConfigSonInstance().getConfigurationPath();
		InputStream is = null;
		File setupKson = new File(cfgPath, "setup.kson");
		if (setupKson.exists()) {
			log.debug("Reagind kson from " + setupKson.getAbsolutePath());
			is = new FileInputStream(setupKson);
		} else {
			String ksonCp = "/org/chon/cms/core/setup/setup.kson";
			is = Setup.class.getResourceAsStream(ksonCp);
			log.info("Creating initial setup.kson in " + setupKson.getAbsolutePath());
			IOUtils.copy(is, new FileOutputStream(setupKson));
			is = new FileInputStream(setupKson);
		}
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			lines.add(line);
		}
		List<NodeCreation> ncList = readKSon(lines.toArray(new String[lines.size()]));
		for (NodeCreation nc : ncList) {
			try {
				createNode(session, nc);
			} catch (Exception e) {
				System.err.println("error crating node " + nc.path + " -> " + e.getMessage());
			}
		}
		session.save();
	}

}