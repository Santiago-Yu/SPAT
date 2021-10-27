class n17425238 {
	public static NSData sendSynchronousRequest(NSMutableURLRequest req, NSHTTPURLResponseHolder resp,
			NSErrorHolder error) {
		URL url = req.URL().xmlvmGetURL();
		NSData data = null;
		URLConnection conn;
		try {
			conn = url.openConnection();
			data = new NSData(conn.getInputStream());
		} catch (IOException e) {
		}
		return data;
	}

}