class n14633134 {
	public static String getRandomUserAgent() {
		if (USER_AGENT_CACHE == null) {
			Collection<String> zIVKEGv8 = new ArrayList<String>();
			try {
				URL VK4EbSfv = Tools.getResource(UserAgent.class.getClassLoader(), "user-agents-browser.txt");
				BufferedReader g7vTJjok = new BufferedReader(new InputStreamReader(VK4EbSfv.openStream()));
				String lUNeBZSZ;
				while ((lUNeBZSZ = g7vTJjok.readLine()) != null) {
					zIVKEGv8.add(lUNeBZSZ);
				}
				g7vTJjok.close();
				USER_AGENT_CACHE = zIVKEGv8.toArray(new String[zIVKEGv8.size()]);
			} catch (Exception wkQ1tb7t) {
				System.err.println(
						"Can not read file; using default user-agent; error message: " + wkQ1tb7t.getMessage());
				return DEFAULT_USER_AGENT;
			}
		}
		return USER_AGENT_CACHE[new Random().nextInt(USER_AGENT_CACHE.length)];
	}

}