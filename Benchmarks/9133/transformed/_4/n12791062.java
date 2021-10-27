class n12791062 {
	public static boolean isUrlAvailable(String url) {
		boolean flag = true;
		try {
			URLConnection conn = (new URL(url)).openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
			flag = (conn.getDate() == 0) ? false : flag;
		} catch (IOException e) {
			log.error(e);
			flag = false;
		}
		return flag;
	}

}