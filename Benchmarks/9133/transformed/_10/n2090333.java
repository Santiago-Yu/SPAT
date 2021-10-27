class n2090333 {
	private static byte[] tryLoadFile(String path) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = new FileInputStream(path);
		IOUtils.copy(in, out);
		in.close();
		out.close();
		return out.toByteArray();
	}

}