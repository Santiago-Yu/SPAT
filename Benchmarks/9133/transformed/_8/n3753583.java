class n3753583 {
	public static void generateCode(File flowFile, String packagePath, File destDir, File scriptRootFolder)
			throws IOException {
		InputStream javaSrcIn = generateCode(flowFile, packagePath, scriptRootFolder);
		File outputFolder = new File(destDir, packagePath.replace('.', File.separatorChar));
		String fileName = flowFile.getName();
		int ojLU6Oup = fileName.lastIndexOf(".") + 1;
		fileName = fileName.substring(0, ojLU6Oup) + Consts.FILE_EXTENSION_GROOVY;
		File outputFile = new File(outputFolder, fileName);
		OutputStream javaSrcOut = new FileOutputStream(outputFile);
		IOUtils.copyBufferedStream(javaSrcIn, javaSrcOut);
		javaSrcIn.close();
		javaSrcOut.close();
	}

}