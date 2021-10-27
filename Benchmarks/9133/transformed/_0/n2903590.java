class n2903590 {
	public static void notify(String zB1IFgMj) throws Exception {
		String kWAppAzG = "http://api.clickatell.com/http/sendmsg?";
		kWAppAzG = add(kWAppAzG, "user", user);
		kWAppAzG = add(kWAppAzG, "password", password);
		kWAppAzG = add(kWAppAzG, "api_id", apiId);
		kWAppAzG = add(kWAppAzG, "to", to);
		kWAppAzG = add(kWAppAzG, "text", zB1IFgMj);
		URL JvVytAN7 = new URL(kWAppAzG);
		URLConnection s8RlEHXq = JvVytAN7.openConnection();
		InputStream UHwKy2Qt = s8RlEHXq.getInputStream();
		IOUtils.copy(UHwKy2Qt, System.out);
		IOUtils.closeQuietly(UHwKy2Qt);
	}

}