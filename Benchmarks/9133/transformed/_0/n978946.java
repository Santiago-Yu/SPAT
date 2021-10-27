class n978946 {
	public static void copyFile(File m4XXTdQo, File Xnzd8Gxs) throws IOException {
		FileChannel xJDqvG76 = new FileInputStream(m4XXTdQo).getChannel();
		FileChannel q0e76fL0 = new FileOutputStream(Xnzd8Gxs).getChannel();
		try {
			xJDqvG76.transferTo(0, xJDqvG76.size(), q0e76fL0);
		} catch (IOException P2NVf3Fk) {
			throw P2NVf3Fk;
		} finally {
			if (xJDqvG76 != null)
				xJDqvG76.close();
			if (q0e76fL0 != null)
				q0e76fL0.close();
		}
	}

}