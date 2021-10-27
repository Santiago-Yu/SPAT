class n1014829 {
	public int readRaw(byte[] buffer, int offset, int length) throws IOException {
		if (offset < 0 || length < 0 || (offset + length) > buffer.length) {
			throw new IndexOutOfBoundsException();
		}
		HttpURLConnection connection = null;
		InputStream is = null;
		int n = 0;
		try {
			connection = (HttpURLConnection) url.openConnection();
			String byteRange = "bytes=" + position + "-" + (position + length - 1);
			connection.setRequestProperty("Range", byteRange);
			is = connection.getInputStream();
			for (; n < length;) {
				int count = is.read(buffer, offset + n, length - n);
				if (count < 0) {
					throw new EOFException();
				}
				n += count;
			}
			position += n;
			return n;
		} catch (EOFException e) {
			return n;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("We're screwed...");
			System.out.println(n);
			if (e.getMessage().contains("response code: 416")) {
				System.out.println("Trying to be mister nice guy, returning " + n);
				return n;
			} else {
				throw e;
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}