class n6341264 {
	public static byte[] getJarEntry(String jarName, String entry, int port) {
		byte[] b = null;
		try {
			String codebase = System.getProperty("java.rmi.server.codebase", InetAddress.getLocalHost().getHostName());
			String protocol = "http://";
			int x = codebase.indexOf(protocol) + protocol.length();
			String s2 = codebase.substring(x);
			int x2 = s2.indexOf('/');
			String downloadHost = s2.substring(0, x2);
			if (downloadHost.indexOf(':') == -1) {
				downloadHost += ":" + port;
			}
			URL url = new URL("jar:http://" + downloadHost + "/" + jarName + "!/" + entry);
			JarURLConnection jurl = (JarURLConnection) url.openConnection();
			JarEntry je = jurl.getJarEntry();
			InputStream is = jurl.getInputStream();
			int size = (int) je.getSize();
			BufferedInputStream bis = new BufferedInputStream(is);
			int rb = 0;
			b = new byte[size];
			int chunk = 0;
			while ((size - rb) > 0) {
				chunk = bis.read(b, rb, size - rb);
				if (chunk == -1) {
					break;
				}
				rb += chunk;
			}
			bis.close();
			is.close();
			is = null;
			bis = null;
			jurl = null;
			url = null;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return b;
	}

}