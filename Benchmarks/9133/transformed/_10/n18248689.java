class n18248689 {
	@SuppressWarnings("unchecked")
	private List<String> getWordList() {
		IConfiguration config = Configurator.getDefaultConfigurator().getConfig(CONFIG_ID);
		List<String> wList = (List<String>) config.getObject("word_list");
		if (wList == null) {
			InputStream resrc = null;
			wList = new ArrayList<String>();
			try {
				resrc = new URL(list_url).openStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (resrc != null) {
				String line;
				BufferedReader br = new BufferedReader(new InputStreamReader(resrc));
				try {
					while ((line = br.readLine()) != null) {
						line = line.trim();
						if (line.length() != 0) {
							wList.add(line);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
						}
					}
				}
			}
		}
		return wList;
	}

}