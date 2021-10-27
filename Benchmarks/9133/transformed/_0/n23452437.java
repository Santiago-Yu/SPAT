class n23452437 {
	private void internalCopy(File RS6vfS7G, File QeYfH9Rr) throws FileNotFoundException, IOException {
		if (RS6vfS7G.getName().equals("Thums.db"))
			return;
		System.out.println("copying " + RS6vfS7G + " in " + QeYfH9Rr);
		OutputStream uWyVuYRB = new BufferedOutputStream(new FileOutputStream(QeYfH9Rr));
		InputStream ehPPhltq = new BufferedInputStream(new FileInputStream(RS6vfS7G));
		byte[] fX6IWX0f = new byte[8192];
		int u1B2x9jI;
		while ((u1B2x9jI = ehPPhltq.read(fX6IWX0f)) > 0)
			uWyVuYRB.write(fX6IWX0f, 0, u1B2x9jI);
		ehPPhltq.close();
		uWyVuYRB.close();
	}

}