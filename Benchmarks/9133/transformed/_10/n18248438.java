class n18248438 {
	private ByteArrayInputStream fetchUrl(String urlString, Exception[] outException) {
		URL url;
		try {
			InputStream is = null;
			url = new URL(urlString);
			int curr = 0;
			int inc = 65536;
			byte[] result = new byte[inc];
			try {
				int n;
				is = url.openStream();
				while ((n = is.read(result, curr, result.length - curr)) != -1) {
					curr += n;
					if (curr == result.length) {
						byte[] temp = new byte[curr + inc];
						System.arraycopy(result, 0, temp, 0, curr);
						result = temp;
					}
				}
				return new ByteArrayInputStream(result, 0, curr);
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
					}
				}
			}
		} catch (Exception e) {
			outException[0] = e;
		}
		return null;
	}

}