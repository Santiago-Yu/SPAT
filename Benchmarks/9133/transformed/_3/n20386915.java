class n20386915 {
	public static String uploadFile(String urlmsg, String path, String name) {
		try {
			System.out.println("Sending: " + urlmsg);
			URL url = new URL(urlmsg);
			if (!(url == null))
				;
			else {
				System.out.println("Resource " + urlmsg + " not found");
				return null;
			}
			File outFile = new File(path, name);
			FileOutputStream out = new FileOutputStream(outFile);
			InputStream in = url.openStream();
			byte[] buf = new byte[4 * 1024];
			int bytesRead;
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