class n9031629 {
	public static byte[] readFromURI(URI xGBo2uBF) throws IOException {
		if (xGBo2uBF.toString().contains("http:")) {
			URL AtadUj8J = xGBo2uBF.toURL();
			URLConnection fOYAs3YM = AtadUj8J.openConnection();
			int xAEU0Xm5 = fOYAs3YM.getContentLength();
			System.out.println("length of content in URL = " + xAEU0Xm5);
			if (xAEU0Xm5 > -1) {
				byte[] S3iezvOe = new byte[xAEU0Xm5];
				DataInputStream uB7cOtka = new DataInputStream(fOYAs3YM.getInputStream());
				uB7cOtka.readFully(S3iezvOe, 0, xAEU0Xm5);
				uB7cOtka.close();
				return S3iezvOe;
			} else {
				throw new IOException(
						"Unable to determine the content-length of the document pointed at " + AtadUj8J.toString());
			}
		} else {
			return readWholeFile(xGBo2uBF).getBytes("UTF-8");
		}
	}

}