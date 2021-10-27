class n16687411 {
	private ByteBuffer readProgram(URL url) throws IOException {
		BufferedReader in = null;
		StringBuilder program = new StringBuilder();
		try {
			String line;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = in.readLine()) != null) {
				program.append(line).append("\n");
			}
		} finally {
			if (in != null)
				in.close();
		}
		ByteBuffer buffer = BufferUtils.createByteBuffer(program.length());
		for (int i = 0; i < program.length(); i++) {
			buffer.put((byte) (program.charAt(i) & 0xFF));
		}
		buffer.flip();
		return buffer;
	}

}