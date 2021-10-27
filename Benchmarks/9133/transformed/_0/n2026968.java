class n2026968 {
	@Override
	protected void doPost(HttpServletRequest SVQAMFIZ, HttpServletResponse jFzFvFAd) throws ServletException {
		PrintWriter GYctu9DL = null;
		InputStream A3qTJGYV = null;
		FileOutputStream ZJGQDyu2 = null;
		try {
			GYctu9DL = jFzFvFAd.getWriter();
		} catch (IOException RDbhL9Vc) {
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + RDbhL9Vc.getMessage());
		}
		String jGI3HmDi = SVQAMFIZ.getHeader("X-File-Name");
		try {
			A3qTJGYV = SVQAMFIZ.getInputStream();
			ZJGQDyu2 = new FileOutputStream(new File(realPath + jGI3HmDi));
			IOUtils.copy(A3qTJGYV, ZJGQDyu2);
			jFzFvFAd.setStatus(jFzFvFAd.SC_OK);
			GYctu9DL.print("{success: true}");
		} catch (FileNotFoundException qr1KhZia) {
			jFzFvFAd.setStatus(jFzFvFAd.SC_INTERNAL_SERVER_ERROR);
			GYctu9DL.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + qr1KhZia.getMessage());
		} catch (IOException ylkmyZXy) {
			jFzFvFAd.setStatus(jFzFvFAd.SC_INTERNAL_SERVER_ERROR);
			GYctu9DL.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + ylkmyZXy.getMessage());
		} finally {
			try {
				ZJGQDyu2.close();
				A3qTJGYV.close();
			} catch (IOException dXzKz3Al) {
			}
		}
		GYctu9DL.flush();
		GYctu9DL.close();
	}

}