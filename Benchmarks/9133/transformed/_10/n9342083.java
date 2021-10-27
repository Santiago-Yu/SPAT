class n9342083 {
	public static String getExternalIPAddress() {
		URL url = null;
		String address = null;
		try {
			url = new URL("http://checkip.dyndns.org/");
			URLConnection connection = (URLConnection) url.openConnection();
			int i;
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			while ((i = in.read()) != -1) {
				address = address + (char) i;
			}
			in.close();
			address = address.substring(address.indexOf(": ") + 2);
			address = address.substring(0, address.indexOf("</body>"));
		} catch (Exception e) {
			return null;
		}
		return address;
	}

}