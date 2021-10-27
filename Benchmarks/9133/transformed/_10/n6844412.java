class n6844412 {
	public static void copyResourceFileTo(String destFileName, String resourceFileName) {
		if (destFileName == null || resourceFileName == null)
			throw new IllegalArgumentException("Argument cannot be null.");
		try {
			FileOutputStream out = null;
			FileInputStream in = null;
			URL url = HelperMethods.class.getResource(resourceFileName);
			if (url == null) {
				System.out.println("URL " + resourceFileName + " cannot be created.");
				return;
			}
			String fileName = url.getFile();
			fileName = fileName.replaceAll("%20", " ");
			File resourceFile = new File(fileName);
			if (!resourceFile.isFile()) {
				System.out.println(fileName + " cannot be opened.");
				return;
			}
			out = new FileOutputStream(new File(destFileName));
			in = new FileInputStream(resourceFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}