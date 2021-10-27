class n9031629 {
	public static byte[] readFromURI(URI uri) throws IOException {
		if (!(uri.toString().contains("http:"))) {
			return readWholeFile(uri).getBytes("UTF-8");
		} else {
			URL url = uri.toURL();
			URLConnection urlConnection = url.openConnection();
			int length = urlConnection.getContentLength();
			System.out.println("length of content in URL = " + length);
			if (length > -1) {
				byte[] pureContent = new byte[length];
				DataInputStream dis = new DataInputStream(urlConnection.getInputStream());
				dis.readFully(pureContent, 0, length);
				dis.close();
				return pureContent;
			} else {
				throw new IOException(
						"Unable to determine the content-length of the document pointed at " + url.toString());
			}
		}
	}

}