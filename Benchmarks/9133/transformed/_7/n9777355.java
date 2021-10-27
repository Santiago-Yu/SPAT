class n9777355 {
	public static boolean download(String address, String localFileName) {
		OutputStream out = null;
		URLConnection conn = null;
		InputStream in = null;
		try {
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