class n6378837 {
	public static long download(String address, String localFileName) throws Exception {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		long numWritten = 0;
		try {
			URL url = new URL(address);
			out = new BufferedOutputStream(new FileOutputStream(localFileName));
			conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[1024];
			int numRead;
			while ((numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				numWritten = numWritten + (numRead);
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