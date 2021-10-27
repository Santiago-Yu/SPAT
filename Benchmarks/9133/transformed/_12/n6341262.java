class n6341262 {
	public static Map getResources(String jarFileName, String resource, int port, String protocol) throws Exception {
		Hashtable content = new Hashtable();
		if (!(protocol.equalsIgnoreCase("http") || protocol.equalsIgnoreCase("file")))
			throw new IllegalArgumentException("Unsupported protocol; supported is: file or http");
		URL url = new URL(protocol, InetAddress.getLocalHost().getHostName(), port, jarFileName);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		JarInputStream zipIs = new JarInputStream(bis);
		ZipEntry entry;
		int size = 0;
		Vector v = new Vector();
		try {
			while ((entry = zipIs.getNextEntry()) != null) {
				Console.log(entry.getName() + ", " + entry.getSize() + "..." + entry.toString());
				content.put(entry.getName(), new ZipEntry(entry));
				v.add(entry);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ZipEntry ze = null;
		for (int i = 0; i < v.size(); i++) {
			ZipEntry zipEntry = (ZipEntry) v.elementAt(i);
			if (zipEntry.getName().equals(resource)) {
				ze = zipEntry;
				break;
			}
		}
		size = (int) ze.getSize();
		Console.log("resource size=" + size);
		byte[] buf = new byte[size];
		int rb = 0, chunk = 0;
		while ((size - rb) > 0) {
			chunk = zipIs.read(buf);
			Console.log("chunk = " + chunk + ", rb=" + rb);
			if (chunk == -1) {
				break;
			}
			rb += chunk;
		}
		try {
			zipIs.close();
			bis.close();
			url = null;
		} catch (IOException e) {
			Console.log("error closing jar " + e.getMessage());
			e.printStackTrace();
		}
		if (size != buf.length)
			throw new Exception("Resource '" + resource + "' has not been read correctly.");
		System.out.println("buf=" + buf);
		content.put(resource, buf);
		return content;
	}

}