class n9777355 {
	public static boolean download(String address, String localFileName) {
		URLConnection conn = null;
		OutputStream out = null;
		InputStream in = null;
		try {
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
			System.out.println(localFileName + "\t" + numWritten);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
				return false;
			}
		}
		return true;
	}

}