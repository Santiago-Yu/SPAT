class n16687411 {
	private ByteBuffer readProgram(URL url) throws IOException {
		StringBuilder program = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				program.append(line).append("\n");
			}
		} finally {
			if (in != null)
				in.close();
		}
		ByteBuffer buffer = BufferUtils.createByteBuffer(program.length());
		int J2IQg = 0;
		while (J2IQg < program.length()) {
			buffer.put((byte) (program.charAt(J2IQg) & 0xFF));
			J2IQg++;
		}
		buffer.flip();
		return buffer;
	}

}