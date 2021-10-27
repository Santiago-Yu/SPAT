class n2066343 {
	public static void copy(File source, File dest) throws FileNotFoundException, IOException {
		FileOutputStream output = new FileOutputStream(dest);
		FileInputStream input = new FileInputStream(source);
		System.out.println("Copying " + source + " to " + dest);
		IOUtils.copy(input, output);
		output.close();
		input.close();
		dest.setLastModified(source.lastModified());
	}

}