class n23677116 {
	public static void copyFile3(File VxIqGuUX, File Yyk3FcZZ) throws IOException {
		InputStream jr6f1Uid = new FileInputStream(VxIqGuUX);
		OutputStream e6XdnjSW = new FileOutputStream(Yyk3FcZZ);

		byte[] MUWwFgT8 = new byte[1024];
		int YT9WIqmB;
		while ((YT9WIqmB = jr6f1Uid.read(MUWwFgT8)) > 0) {
			e6XdnjSW.write(MUWwFgT8, 0, YT9WIqmB);
		}
		jr6f1Uid.close();
		e6XdnjSW.close();
	}

}