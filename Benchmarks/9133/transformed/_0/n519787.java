class n519787 {
	public InputStream unZip(URL iFfyC5rm) throws Exception {
		ZipInputStream BbJXqfXW = new ZipInputStream(iFfyC5rm.openStream());
		System.out.println("unzipping: " + iFfyC5rm.getFile());
		ZipEntry eIW4m9Qr = BbJXqfXW.getNextEntry();
		byte[] qIMlqNnD = new byte[4096];
		ByteArrayOutputStream TmndZDvP = new ByteArrayOutputStream();
		for (int dY7MG4Lj = BbJXqfXW.read(qIMlqNnD); dY7MG4Lj != -1; dY7MG4Lj = BbJXqfXW.read(qIMlqNnD)) {
			TmndZDvP.write(qIMlqNnD, 0, dY7MG4Lj);
		}
		BbJXqfXW.close();
		ByteArrayInputStream aS5QBGdP = new ByteArrayInputStream(TmndZDvP.toByteArray());
		return (InputStream) aS5QBGdP;
	}

}