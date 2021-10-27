class n6341262 {
	public static Map getResources(String jarFileName, String resource, int port, String protocol) throws Exception {
		if (!(protocol.equalsIgnoreCase("http") || protocol.equalsIgnoreCase("file")))
			throw new IllegalArgumentException("Unsupported protocol; supported is: file or http");
		Hashtable content = new Hashtable();
		URL url = new URL(protocol, InetAddress.getLocalHost().getHostName(), port, jarFileName);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		ZipEntry entry;
		JarInputStream zipIs = new JarInputStream(bis);
		Vector v = new Vector();
		int size = 0;
		ZipEntry ze = null;
		try {
			while ((entry = zipIs.getNextEntry()) != null) {
				Console.log(entry.getName() + ", " + entry.getSize() + "..." + entry.toString());
				content.put(entry.getName(), new ZipEntry(entry));
				v.add(entry);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < v.size(); i++) {
			ZipEntry zipEntry = (ZipEntry) v.elementAt(i);
			if (zipEntry.getName().equals(resource)) {
				ze = zipEntry;
				break;
			}
		}
		size = (int) ze.getSize();
		Console.log("resource size=" + size);
		int rb = 0;
		byte[] buf = new byte[size];
		int chunk = 0;
		while ((size - rb) > 0) {
			chunk = zipIs.read(buf);
			Console.log("chunk = " + chunk + ", rb=" + rb);
			if (chunk == -1) {
				break;
			}
			rb += chunk;
		}
		if (size != buf.length)
			throw new Exception("Resource '" + resource + "' has not been read correctly.");
		try {
			zipIs.close();
			bis.close();
			url = null;
		} catch (IOException e) {
			Console.log("error closing jar " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("buf=" + buf);
		content.put(resource, buf);
		return content;
	}

}