class n5621042 {
	private void postObject(Object obj, String strURL) throws Exception {
		print("entering post object");
		URL url = new URL(strURL);
		URLConnection urlConn = url.openConnection();
		print("HttpNetworkMessageConnection.postObject:returned from url.openConnection()");
		urlConn.setUseCaches(false);
		urlConn.setDoOutput(true);
		ObjectOutputStream oos = new ObjectOutputStream(urlConn.getOutputStream());
		print("HttpNetworkMessageConnection.postObject:returned from urlConn.getOutputStream()");
		oos.writeObject(obj);
		print("HttpNetworkMessageConnection.postObject:returned from writeObject()");
		oos.flush();
		oos.close();
		InputStream is = urlConn.getInputStream();
		print("HttpNetworkMessageConnection.postObject:returned from getInputStream()");
		for (; is.read() != -1;) {
		}
		is.close();
		print("exiting postObject");
	}

}