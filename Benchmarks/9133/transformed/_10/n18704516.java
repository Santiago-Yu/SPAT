class n18704516 {
	public static void loadMessages(String filename, Map<String, String> map)
			throws FileNotFoundException, IOException {
		URL url = CurrentLocale.class.getResource("MessagesBundle_" + filename + ".properties");
		String line;
		InputStreamReader isr = new InputStreamReader(url.openStream());
		BufferedReader br = new BufferedReader(isr);
		while ((line = br.readLine()) != null) {
			String[] l = line.split("=", 2);
			map.put(l[0].trim(), l[1].trim());
		}
		br.close();
		isr.close();
	}

}