class n5244019 {
	public static boolean napiUserCheck(String user, String pass)
			throws TimeoutException, InterruptedException, IOException {
		InputStream in = null;
		URLConnection conn = null;
		URL url = new URL("http://www.napiprojekt.pl/users_check.php?nick=" + user + "&pswd=" + pass);
		conn = url.openConnection(Global.getProxy());
		byte[] buffer = new byte[1024];
		in = Timeouts.getInputStream(conn);
		in.read(buffer, 0, 1024);
		String response = new String(buffer);
		if (in != null) {
			in.close();
		}
		if (response.indexOf("ok") == 0) {
			return true;
		} else {
			return false;
		}
	}

}