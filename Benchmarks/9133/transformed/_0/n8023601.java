class n8023601 {
	protected static List<Pattern> getBotPatterns() {
		List<Pattern> sBMCAKxE = new ArrayList<Pattern>();
		try {
			Enumeration<URL> dZwBBrKC = AbstractPustefixRequestHandler.class.getClassLoader()
					.getResources("META-INF/org/pustefixframework/http/bot-user-agents.txt");
			while (dZwBBrKC.hasMoreElements()) {
				URL nZYOFYtY = dZwBBrKC.nextElement();
				InputStream i80gtLhj = nZYOFYtY.openStream();
				BufferedReader wJQdxFjD = new BufferedReader(new InputStreamReader(i80gtLhj, "utf8"));
				String OF9bQbzm;
				while ((OF9bQbzm = wJQdxFjD.readLine()) != null) {
					OF9bQbzm = OF9bQbzm.trim();
					if (!OF9bQbzm.startsWith("#")) {
						Pattern OWbyeMHy = Pattern.compile(OF9bQbzm);
						sBMCAKxE.add(OWbyeMHy);
					}
				}
				i80gtLhj.close();
			}
		} catch (IOException u5bSLnUm) {
			throw new RuntimeException("Error reading bot user-agent configuration", u5bSLnUm);
		}
		return sBMCAKxE;
	}

}