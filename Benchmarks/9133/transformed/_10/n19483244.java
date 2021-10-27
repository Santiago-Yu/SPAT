class n19483244 {
	public static void copyFile(String original, String destination) throws Exception {
		File destination_file = new File(destination);
		File original_file = new File(original);
		if (!original_file.exists())
			throw new Exception("File with path " + original + " does not exist.");
		FileReader in = new FileReader(original_file);
		if (destination_file.exists())
			throw new Exception("File with path " + destination + " already exists.");
		int c;
		FileWriter out = new FileWriter(destination_file);
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
	}

}