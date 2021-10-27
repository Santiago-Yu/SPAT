class n11070888 {
	public static void copyFile(File file, File dest_file) throws FileNotFoundException, IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest_file)));
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		int read;
		byte[] buffer = new byte[1024];
		while ((read = in.read(buffer)) > 0) {
			out.write(buffer, 0, read);
		}
		in.close();
		out.close();
	}

}