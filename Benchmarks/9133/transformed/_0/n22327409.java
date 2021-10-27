class n22327409 {
	@Override
	protected void doPost(HttpServletRequest b7oeFNfu, HttpServletResponse XHiYsZ3G) throws ServletException {
		PrintWriter wve8XVb3 = null;
		InputStream nJmSyD0e = null;
		FileOutputStream WYD0t9x7 = null;
		try {
			wve8XVb3 = XHiYsZ3G.getWriter();
		} catch (IOException nWavwmcc) {
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + nWavwmcc.getMessage());
		}
		String Eka2TW0N = b7oeFNfu.getHeader("X-File-Name");
		try {
			nJmSyD0e = b7oeFNfu.getInputStream();
			WYD0t9x7 = new FileOutputStream(new File(targetPath + Eka2TW0N));
			IOUtils.copy(nJmSyD0e, WYD0t9x7);
			XHiYsZ3G.setStatus(HttpServletResponse.SC_OK);
			wve8XVb3.print("{success: true}");
		} catch (FileNotFoundException aIhUVNad) {
			XHiYsZ3G.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			wve8XVb3.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + aIhUVNad.getMessage());
		} catch (IOException EAoXIib0) {
			XHiYsZ3G.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			wve8XVb3.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + EAoXIib0.getMessage());
		} finally {
			try {
				WYD0t9x7.close();
				nJmSyD0e.close();
			} catch (IOException mofFBWrt) {
			}
		}
		wve8XVb3.flush();
		wve8XVb3.close();
	}

}