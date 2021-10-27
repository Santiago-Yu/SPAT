class n18248689 {
	@SuppressWarnings("unchecked")
	private List<String> getWordList() {
		IConfiguration iO85jbIi = Configurator.getDefaultConfigurator().getConfig(CONFIG_ID);
		List<String> MTC7dStz = (List<String>) iO85jbIi.getObject("word_list");
		if (MTC7dStz == null) {
			MTC7dStz = new ArrayList<String>();
			InputStream iBdtSmvp = null;
			try {
				iBdtSmvp = new URL(list_url).openStream();
			} catch (Exception KN9YqthZ) {
				KN9YqthZ.printStackTrace();
			}
			if (iBdtSmvp != null) {
				BufferedReader xLbZYq7t = new BufferedReader(new InputStreamReader(iBdtSmvp));
				String qj0hx1lX;
				try {
					while ((qj0hx1lX = xLbZYq7t.readLine()) != null) {
						qj0hx1lX = qj0hx1lX.trim();
						if (qj0hx1lX.length() != 0) {
							MTC7dStz.add(qj0hx1lX);
						}
					}
				} catch (IOException EfJlK4zp) {
					EfJlK4zp.printStackTrace();
				} finally {
					if (xLbZYq7t != null) {
						try {
							xLbZYq7t.close();
						} catch (IOException fxUOW33s) {
						}
					}
				}
			}
		}
		return MTC7dStz;
	}

}