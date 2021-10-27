class n14166352 {
	public static boolean downloadFile(String urlString, String outputFile, int protocol) {
		File file = new File(outputFile);
		InputStream is = null;
		FileOutputStream fos = null;
		if (protocol == HTTP_PROTOCOL) {
			try {
				URLConnection ucnn = null;
				URL url = new URL(urlString);
				if (BlueXStatics.proxy == null || url.getProtocol().equals("file"))
					ucnn = url.openConnection();
				else
					ucnn = url.openConnection(BlueXStatics.proxy);
				fos = new FileOutputStream(file);
				is = ucnn.getInputStream();
				int offset;
				byte[] data = new byte[4096];
				while ((offset = is.read(data)) != -1) {
					fos.write(data, 0, offset);
				}
				return true;
			} catch (Exception ex) {
			} finally {
				try {
					is.close();
				} catch (Exception e) {
				}
				try {
					fos.close();
				} catch (Exception e) {
				}
			}
		} else
			throw new ProtocolNotSupportedException(
					"The protocol selected is not supported by this version of downloadFile() method.");
		return false;
	}

}