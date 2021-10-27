class n6844411 {
	public static void copyFileTo(String destFileName, String resourceFileName) {
		if (destFileName == null || resourceFileName == null)
			throw new IllegalArgumentException("Argument cannot be null.");
		try {
			FileOutputStream out = null;
			FileInputStream in = null;
			File resourceFile = new File(resourceFileName);
			if (!resourceFile.isFile()) {
				System.out.println(resourceFileName + " cannot be opened.");
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