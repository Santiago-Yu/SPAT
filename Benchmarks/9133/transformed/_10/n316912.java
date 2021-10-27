class n316912 {
	void copyFile(String src, String dest) throws IOException {
		byte[] buffer = new byte[4096];
		int amount;
		FileOutputStream out = new FileOutputStream(dest);
		FileInputStream in = new FileInputStream(src);
		while ((amount = in.read(buffer)) != -1)
			out.write(buffer, 0, amount);
		in.close();
		out.close();
	}

}