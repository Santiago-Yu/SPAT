class n10584420 {
	public static String checkUpdate() {
		URL url = null;
		InputStream html = null;
		try {
			url = new URL("http://googlemeupdate.bravehost.com/");
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		try {
			int c = 0;
			html = url.openStream();
			String Buffer = "";
			while (c != -1) {
				try {
					c = html.read();
				} catch (IOException ex) {
				}
				Buffer = Buffer + (char) c;
			}
			String Code = "";
			return Buffer.substring(Buffer.lastIndexOf("Google.mE Version: ") + 19, Buffer.indexOf("||"));
		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		}
	}

}