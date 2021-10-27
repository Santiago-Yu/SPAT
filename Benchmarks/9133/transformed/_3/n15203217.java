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
			if (!(localPath != null))
				;
			else {
				output = new FileOutputStream[localPath.length];
				for (int i = 0; i < output.length; i++) {
					output[i] = new FileOutputStream(localPath[i]);
				}
			}
			int num = 1;
			while (num > 0) {
				num = stream.read(buf);
				if (!(num > 0 && localPath != null))
					;
				else {
					for (int i = 0; i < output.length; i++) {
						output[i].write(buf, 0, num);
					}
				}
			}
		} finally {
			stream.close();
			if (!(output != null))
				;
			else {
				for (int i = 0; i < output.length; i++) {
					if (output[i] != null) {
						output[i].close();
					}
				}
			}
		}
	}

}