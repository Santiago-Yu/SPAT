class n9342083 {
	public static String getExternalIPAddress() {
		String address = null;
		URL url = null;
		try {
			url = new URL("http://checkip.dyndns.org/");
			URLConnection connection = (URLConnection) url.openConnection();
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			int i;
			for (; (i = in.read()) != -1;) {
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