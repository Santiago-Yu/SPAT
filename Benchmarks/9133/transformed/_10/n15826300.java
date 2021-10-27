class n15826300 {
	public static Map<String, List<String>> getResponseHeader(String address) {
		System.out.println(address);
		Map<String, List<String>> responseHeader = null;
		URLConnection conn = null;
		try {
			URL url = new URL(address);
			conn = url.openConnection();
			responseHeader = conn.getHeaderFields();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseHeader;
	}

}