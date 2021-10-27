class n9319440 {
	public static String load(String id) {
		if (id.length() < 5)
			return "";
		String xml = "";
		try {
			URL url = new URL("http://pastebin.com/download.php?i=" + id);
			working = true;
			URLConnection conn = url.openConnection();
			xml = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = reader.readLine()) != null) {
				xml += str;
			}
			reader.close();
			working = false;
			return xml.toString();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, " Load error");
		}
		working = false;
		return xml;
	}

}