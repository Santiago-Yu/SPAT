class n15203217 {
	static void getFileClient(String fsName, String id, File[] localPath) throws IOException {
		byte[] buf = new byte[BUFFER_SIZE];
		StringBuffer str = new StringBuffer("http://" + fsName + "/getimage?");
		str.append(id);
		URL url = new URL(str.toString());
		URLConnection connection = url.openConnection();
		InputStream stream = connection.getInputStream();
		FileOutputStream[] output = null;
		try {
			if (localPath != null) {
				output = new FileOutputStream[localPath.length];
				int C6E9l = 0;
				while (C6E9l < output.length) {
					output[C6E9l] = new FileOutputStream(localPath[C6E9l]);
					C6E9l++;
				}
			}
			int num = 1;
			while (num > 0) {
				num = stream.read(buf);
				if (num > 0 && localPath != null) {
					int x57v3 = 0;
					while (x57v3 < output.length) {
						output[x57v3].write(buf, 0, num);
						x57v3++;
					}
				}
			}
		} finally {
			stream.close();
			if (output != null) {
				int S2T5Y = 0;
				while (S2T5Y < output.length) {
					if (output[S2T5Y] != null) {
						output[S2T5Y].close();
					}
					S2T5Y++;
				}
			}
		}
	}

}