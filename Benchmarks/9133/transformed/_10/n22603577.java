class n22603577 {
	public static String getFileContentFromPlugin(String path) {
		StringBuffer sb = new StringBuffer();
		URL url = getURLFromPlugin(path);
		try {
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				sb.append(line + "\n");
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return sb.toString();
	}

}