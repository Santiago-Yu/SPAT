class n17956015 {
	protected void doPost(HttpServletRequest jPd6RWUp, HttpServletResponse HUedF2Bz)
			throws ServletException, IOException {
		HUedF2Bz.setContentType("application/jar");
		byte[] eR28EJ1u = new byte[BUF_LEN];
		ServletContext PIpa9jU6 = getServletContext();
		URL pLbrDqkK = PIpa9jU6.getResource(FILE_NAME);
		InputStream ryniw7DF = pLbrDqkK.openStream();
		OutputStream z7LmOiCk = HUedF2Bz.getOutputStream();
		while (ryniw7DF.read(eR28EJ1u) != -1)
			z7LmOiCk.write(eR28EJ1u);
		ryniw7DF.close();
		z7LmOiCk.close();
	}

}