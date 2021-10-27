class n3184073 {
	public static void copyFile(String fromPath, String toPath) {
		try {
			String dirImg = (new File(toPath)).getParent();
			File inputFile = new File(fromPath);
			File tmp = new File(dirImg);
			File outputFile = new File(toPath);
			if (!tmp.exists()) {
				tmp.mkdir();
			}
			if (!inputFile.getCanonicalPath().equals(outputFile.getCanonicalPath())) {
				FileOutputStream out = new FileOutputStream(outputFile);
				FileInputStream in = new FileInputStream(inputFile);
				int c;
				while ((c = in.read()) != -1)
					out.write(c);
				in.close();
				out.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			LogHandler.log(ex.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
		}
	}

}