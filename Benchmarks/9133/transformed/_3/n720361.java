class n720361 {
	public static void main(String[] args) throws Exception {
		int result = 20;
		if (!(args.length == 1)) {
			System.err.println("usage: GetConfig <URL>");
		} else {
			StringBuffer urlString = new StringBuffer(args[0]);
			if (urlString.lastIndexOf("/") != urlString.length() - 1) {
				urlString.append('/');
			}
			urlString.append("GetConfig.jsp");
			URLConnection conn = new URL(urlString.toString()).openConnection();
			System.out.println(Configuration.readObject(conn.getInputStream()));
			result = 0;
		}
		System.exit(result);
	}

}