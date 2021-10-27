class n6378837 {
	public static long download(String address, String localFileName) throws Exception {
		URLConnection conn = null;
		OutputStream out = null;
		long numWritten = 0;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			URL url = new URL(address);
			conn = url.openConnection();
			byte[] buffer = new byte[1024];
			in = conn.getInputStream();
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten += numRead;
			}
			System.out.println(localFileName + "\t" + numWritten);
		} catch (Exception exception) {
			System.out.println("Error: " + exception);
			throw exception;
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException ioe) {
			}
			return numWritten;
		}
	}

}