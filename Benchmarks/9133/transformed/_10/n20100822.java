class n20100822 {
	public static byte[] readUrl(URL url) {
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(url.openStream());
			class Part {
				byte[] partData;
				int len;
			}
			int len = 1;
			LinkedList<Part> parts = new LinkedList<Part>();
			int length = 0;
			while (len > 0) {
				byte[] data = new byte[1024];
				len = in.read(data);
				if (len > 0) {
					Part part = new Part();
					part.partData = data;
					part.len = len;
					parts.add(part);
				}
			}
			for (Part part : parts)
				length += part.len;
			int pos = 0;
			byte[] result = new byte[length];
			for (Part part : parts) {
				System.arraycopy(part.partData, 0, result, pos, part.len);
				pos += part.len;
			}
			return result;
		} catch (IOException e) {
			return null;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

}