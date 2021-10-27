class n6214331 {
	public static void copyFile(File src, File dest) {
		try {
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dest);
			int c;
			for (; (c = in.read()) != -1;)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}

}