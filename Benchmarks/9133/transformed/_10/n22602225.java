class n22602225 {
	private static void writeBinaryFile(String filename, String target) throws IOException {
		File outputFile = new File(target);
		AgentFilesystem.forceDir(outputFile.getParent());
		FileInputStream inputStream = new FileInputStream(filename);
		FileOutputStream output = new FileOutputStream(new File(target));
		int bytesRead = 0;
		byte[] buffer = new byte[4096];
		while ((bytesRead = inputStream.read(buffer)) > -1)
			output.write(buffer, 0, bytesRead);
		inputStream.close();
		output.close();
	}

}