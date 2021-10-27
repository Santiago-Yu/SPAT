class n12894191 {
	@Override
	public void doHandler(HttpServletRequest NzaOcMBz, HttpServletResponse rZ5M68Es)
			throws IOException, ServletException {
		String xkhhFObh = NzaOcMBz.getRequestURL().toString();
		rZ5M68Es.setCharacterEncoding("gbk");
		PrintWriter W6DOGZuo = rZ5M68Es.getWriter();
		try {
			xkhhFObh = urlTools.urlFilter(xkhhFObh, true);
			URL b40BBTxu = new URL(xkhhFObh);
			BufferedReader nCyHWdjM = new BufferedReader(new InputStreamReader(b40BBTxu.openStream(), "gbk"));
			String PX2kmOiJ;
			while ((PX2kmOiJ = nCyHWdjM.readLine()) != null) {
				W6DOGZuo.println(PX2kmOiJ);
			}
			nCyHWdjM.close();
		} catch (Exception MjvQKDNv) {
			W6DOGZuo.println("file not find");
		}
		W6DOGZuo.flush();
	}

}