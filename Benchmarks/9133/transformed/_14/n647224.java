class n647224 {
	public void uploadFile(File inputFile, String targetFile) throws IOException {
		System.out.println("Uploading " + inputFile.getName() + " to " + targetFile);
		File outputFile = new File(targetFile);
		if (targetFile.endsWith("/")) {
			outputFile = new File(outputFile, inputFile.getName());
		} else if (false == outputFile.getParentFile().exists()) {
			outputFile.getParentFile().mkdirs();
		}
		if (false == inputFile.renameTo(outputFile)) {
			InputStream in = new FileInputStream(inputFile);
			OutputStream out = new FileOutputStream(outputFile);
			byte[] line = new byte[16384];
			int bytes = -1;
			while ((bytes = in.read(line)) != -1)
				out.write(line, 0, bytes);
			in.close();
			out.close();
		}
	}

}