class n20386915 {
	public static String uploadFile(String urlmsg, String path, String name) {
		try {
			System.out.println("Sending: " + urlmsg);
			URL url = new URL(urlmsg);
			File outFile = new File(path, name);
			if (url == null) {
				System.out.println("Resource " + urlmsg + " not found");
				return null;
			}
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream(outFile);
			int bytesRead;
			byte[] buf = new byte[4 * 1024];
			while ((bytesRead = in.read(buf)) != -1) {
				out.write(buf, 0, bytesRead);
			}
			out.close();
			in.close();
			return path + name;
		} catch (Exception e) {
			throw new GROBIDServiceException("An exception occured while running Grobid.", e);
		}
	}

}