class n6214331 {
	public static void copyFile(File src, File dest) {
		try {
			FileOutputStream out = new FileOutputStream(dest);
			FileInputStream in = new FileInputStream(src);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}

}