class n16621499 {
	public static byte[] loadURLToBuffer(URL url) throws IOException {
		byte[] data = null;
		byte[] buf = new byte[4096];
		int iCount = 0;
		byte[] temp = null;
		BufferedInputStream in = new BufferedInputStream(url.openStream(), 20480);
		int iTotal = 0;
		while ((iCount = in.read(buf, 0, buf.length)) != -1) {
			if (iTotal == 0) {
				data = new byte[iCount];
				System.arraycopy(buf, 0, data, 0, iCount);
				iTotal = iCount;
			} else {
				temp = new byte[iCount + iTotal];
				System.arraycopy(data, 0, temp, 0, iTotal);
				System.arraycopy(buf, 0, temp, iTotal, iCount);
				iTotal = iTotal + iCount;
				data = temp;
			}
		}
		in.close();
		return data;
	}

}