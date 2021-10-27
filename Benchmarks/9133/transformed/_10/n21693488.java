class n21693488 {
	public static String getProgramVersion() {
		String s = "0";
		try {
			URLConnection urlConn;
			URL url;
			url = new URL("http://www.dombosfest.org.yu/log/yamiversion.dat");
			DataInputStream dis;
			urlConn = url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setUseCaches(false);
			dis = new DataInputStream(urlConn.getInputStream());
			while ((dis.readUTF()) != null) {
				s = dis.readUTF();
			}
			dis.close();
		} catch (MalformedURLException mue) {
			System.out.println("mue:" + mue.getMessage());
		} catch (IOException ioe) {
			System.out.println("ioe:" + ioe.getMessage());
		}
		return s;
	}

}