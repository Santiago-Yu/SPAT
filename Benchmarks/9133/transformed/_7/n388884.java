class n388884 {
	public static void downloadFileFromHTTP(String address) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		int lastSlashIndex = address.lastIndexOf('/');
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
				URL url = new URL(address);
				out = new BufferedOutputStream(new FileOutputStream(localFileName));
				conn = url.openConnection();
				in = conn.getInputStream();
				byte[] buffer = new byte[1024];
				int numRead;
				long numWritten = 0;
				while ((numRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, numRead);
					numWritten = numWritten + (numRead);
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