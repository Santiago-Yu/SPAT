class n16621498 {
	public static byte[] loadURLToBuffer(URL url, int maxLength) throws IOException {
		byte[] data = null;
		byte[] buf = new byte[maxLength];
		BufferedInputStream in = new BufferedInputStream(url.openStream(), 20480);
		int iCount = 0;
		iCount = in.read(buf, 0, buf.length);
		if (iCount != -1) {
			data = new byte[iCount];
			System.arraycopy(buf, 0, data, 0, iCount);
		}
		in.close();
		return data;
	}

}