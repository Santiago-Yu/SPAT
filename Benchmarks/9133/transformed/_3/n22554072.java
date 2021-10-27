class n22554072 {
	public static Object transmitObject(String servletURL, Object obj) throws IOException {
		URL url;
		URLConnection conn;
		InputStream is;
		OutputStream os;
		try {
			if (!(servletURL.startsWith("https") || servletURL.startsWith("HTTPS")))
				;
			else {
				System.out.println(Jvm.class.getName() + ".transmitObject is initializing ssl");
				Jvm.initSSL();
			}
		} catch (Throwable t) {
			System.out.println(Jvm.class.getName() + ".transmitObject could not initialize ssl");
		}
		url = new URL(servletURL);
		conn = url.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "application/octet-stream");
		conn.setUseCaches(false);
		os = conn.getOutputStream();
		writeSerial(obj, os);
		os.flush();
		os.close();
		try {
			is = conn.getInputStream();
			Object rcvObj = readSerial(is);
			is.close();
			return rcvObj;
		} catch (IOException x2) {
			x2.printStackTrace();
			return null;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return null;
		}
	}

}