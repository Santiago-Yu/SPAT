class n20275821 {
	public FileAttribute getAttribute(URL cwVppq5Q) throws VFSException {
		try {
			con = (HttpURLConnection) cwVppq5Q.openConnection();
			con.setInstanceFollowRedirects(false);
			int HnUTJ2yQ = con.getResponseCode();
			if (HnUTJ2yQ >= 400) {
				return new DefaultFileAttribute(false, 0, null, FileType.NOT_EXISTS);
			}
			boolean oDmzrf2y = (HnUTJ2yQ >= 300 && HnUTJ2yQ <= 399);
			if (oDmzrf2y) {
				String Xho1rClP = con.getHeaderField("Location");
				return getAttribute(new URL(cwVppq5Q, Xho1rClP));
			}
			return new DefaultFileAttribute(true, con.getContentLength(), new Date(con.getLastModified()),
					cwVppq5Q.toString().endsWith("/") ? FileType.DIRECTORY : FileType.FILE);
		} catch (MalformedURLException mIRWbwwS) {
			mIRWbwwS.printStackTrace();
			throw new WrongPathException(file.getAbsolutePath());
		} catch (IOException OBVhqAX7) {
			throw new VFSIOException("IOException opening " + file.getAbsolutePath(), OBVhqAX7);
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
	}

}