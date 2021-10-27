class n5621042 {
	private void postObject(Object autowyP2, String vSFS3dDq) throws Exception {
		print("entering post object");
		URL ZnDXTjrE = new URL(vSFS3dDq);
		URLConnection hI8po6Af = ZnDXTjrE.openConnection();
		print("HttpNetworkMessageConnection.postObject:returned from url.openConnection()");
		hI8po6Af.setUseCaches(false);
		hI8po6Af.setDoOutput(true);
		ObjectOutputStream isJb7696 = new ObjectOutputStream(hI8po6Af.getOutputStream());
		print("HttpNetworkMessageConnection.postObject:returned from urlConn.getOutputStream()");
		isJb7696.writeObject(autowyP2);
		print("HttpNetworkMessageConnection.postObject:returned from writeObject()");
		isJb7696.flush();
		isJb7696.close();
		InputStream SlemBcwu = hI8po6Af.getInputStream();
		print("HttpNetworkMessageConnection.postObject:returned from getInputStream()");
		while (SlemBcwu.read() != -1) {
		}
		SlemBcwu.close();
		print("exiting postObject");
	}

}