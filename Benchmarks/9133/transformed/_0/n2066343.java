class n2066343 {
	public static void copy(File cq6gzw3W, File lIdNu4lc) throws FileNotFoundException, IOException {
		FileInputStream v6Xk4dTl = new FileInputStream(cq6gzw3W);
		FileOutputStream c5x58P4Z = new FileOutputStream(lIdNu4lc);
		System.out.println("Copying " + cq6gzw3W + " to " + lIdNu4lc);
		IOUtils.copy(v6Xk4dTl, c5x58P4Z);
		c5x58P4Z.close();
		v6Xk4dTl.close();
		lIdNu4lc.setLastModified(cq6gzw3W.lastModified());
	}

}