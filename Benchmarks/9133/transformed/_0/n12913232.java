class n12913232 {
	@Override
	protected void doGet(HttpServletRequest Hr3jFsi2, HttpServletResponse vXuon4FS)
			throws ServletException, IOException {
		String WSju0Kyb = Hr3jFsi2.getRequestURL().toString();
		if (WSju0Kyb.indexOf(ip) != -1) {
			WSju0Kyb = WSju0Kyb.replaceAll(ip, "a.tbcdn.cn");
		}
		URL DfM3577p = new URL(WSju0Kyb);
		BufferedReader W6krXkD5 = new BufferedReader(new InputStreamReader(DfM3577p.openStream()));
		PrintWriter jUGNzxnz = vXuon4FS.getWriter();
		String ATD6D0h7;
		while ((ATD6D0h7 = W6krXkD5.readLine()) != null) {
			jUGNzxnz.println(ATD6D0h7);
		}
		W6krXkD5.close();
		jUGNzxnz.flush();
	}

}