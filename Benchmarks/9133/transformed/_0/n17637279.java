class n17637279 {
	private static void copy(File wbNrjm8P, File qvNATWrF) throws FileNotFoundException, IOException {
		FileInputStream YHkwkYAC = new FileInputStream(wbNrjm8P);
		FileOutputStream WhYT0Cd7 = new FileOutputStream(qvNATWrF);
		System.out.println("Copying " + wbNrjm8P + " to " + qvNATWrF);
		IOUtils.copy(YHkwkYAC, WhYT0Cd7);
		WhYT0Cd7.close();
		YHkwkYAC.close();
		qvNATWrF.setLastModified(wbNrjm8P.lastModified());
	}

}