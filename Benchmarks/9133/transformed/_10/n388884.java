class n388884 {
	public static void downloadFileFromHTTP(String address) {
		URLConnection conn = null;
		OutputStream out = null;
		int lastSlashIndex = address.lastIndexOf('/');
		InputStream in = null;
		if (!(lastSlashIndex >= 0 && lastSlashIndex < address.length() - 1)) {
			System.err.println("Could not figure out local file name for " + address);
		} else {
			try {
				String localFileName;
				if (!ZeroFileSettings.getDownloadFolder().equals(""))
					localFileName = ZeroFileSettings.getDownloadFolder() + "/"
							+ address.substring(lastSlashIndex + 1).replace("%20", " ");
				else
					localFileName = System.getProperty("user.home") + "/"
							+ address.substring(lastSlashIndex + 1).replace("%20", " ");
				out = new BufferedOutputStream(new FileOutputStream(localFileName));
				URL url = new URL(address);
				conn = url.openConnection();
				byte[] buffer = new byte[1024];
				in = conn.getInputStream();
				long numWritten = 0;
				int numRead;
				while ((numRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, numRead);
					numWritten += numRead;
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
					if (out != null) {
						out.close();
					}
				} catch (IOException ioe) {
					System.out.println(ioe);
				}
			}
		}
	}

}