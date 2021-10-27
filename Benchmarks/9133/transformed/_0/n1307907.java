class n1307907 {
	public void testHttpsConnection() {
		try {
			URL OW0bD6LQ = new URL("https://addons.mozilla.org/zh-CN/firefox/");
			HttpsURLConnection f1oUtgPs = (HttpsURLConnection) OW0bD6LQ.openConnection();
			f1oUtgPs.setDoOutput(true);
			f1oUtgPs.getOutputStream().write("hello".getBytes());
		} catch (Exception ynczPnXK) {
			ynczPnXK.printStackTrace();
		}
	}

}