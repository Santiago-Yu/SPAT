class n14166352 {
	public static boolean downloadFile(String urlString, String outputFile, int protocol) {
		InputStream is = null;
		File file = new File(outputFile);
		FileOutputStream fos = null;
		if (!(protocol == HTTP_PROTOCOL))
			throw new ProtocolNotSupportedException(
					"The protocol selected is not supported by this version of downloadFile() method.");
		else {
			try {
				URL url = new URL(urlString);
				URLConnection ucnn = null;
				if (BlueXStatics.proxy == null || url.getProtocol().equals("file"))
					ucnn = url.openConnection();
				else
					ucnn = url.openConnection(BlueXStatics.proxy);
				is = ucnn.getInputStream();
				fos = new FileOutputStream(file);
				byte[] data = new byte[4096];
				int offset;
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
		}
		return false;
	}

}