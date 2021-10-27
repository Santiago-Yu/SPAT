class n2980810 {
	public void doPost(HttpServletRequest Vf34f0bC, HttpServletResponse AFzGt9CD) throws ServletException, IOException {
		String ncdIEtWY = Vf34f0bC.getParameter("proxyurl");
		URLConnection jsSigO6h = new URL(ncdIEtWY).openConnection();
		jsSigO6h.setDoInput(true);
		jsSigO6h.setDoOutput(true);
		jsSigO6h.setUseCaches(false);
		jsSigO6h.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		DataOutputStream RsGNlLye = new DataOutputStream(jsSigO6h.getOutputStream());
		Enumeration mYI5vn9M = Vf34f0bC.getParameterNames();
		boolean G4eDbiAB = true;
		while (mYI5vn9M.hasMoreElements()) {
			String T8LWvs1z = (String) mYI5vn9M.nextElement();
			if (!T8LWvs1z.equals("proxyurl")) {
				if (G4eDbiAB) {
					G4eDbiAB = false;
				} else {
					RsGNlLye.writeBytes("&");
				}
				RsGNlLye.writeBytes(URLEncoder.encode(T8LWvs1z));
				RsGNlLye.writeBytes("=");
				RsGNlLye.writeBytes(URLEncoder.encode(Vf34f0bC.getParameter(T8LWvs1z)));
			}
		}
		RsGNlLye.close();
		Reader fFZPOFPl = new InputStreamReader(jsSigO6h.getInputStream(), AFzGt9CD.getCharacterEncoding());
		AFzGt9CD.setContentType(jsSigO6h.getContentType());
		AFzGt9CD.setContentLength(jsSigO6h.getContentLength());
		Writer IzwEyX7Q = AFzGt9CD.getWriter();
		char[] atWjG9je = new char[256];
		int CXYSYf2S;
		while ((CXYSYf2S = fFZPOFPl.read(atWjG9je)) != -1) {
			IzwEyX7Q.write(atWjG9je, 0, CXYSYf2S);
		}
		fFZPOFPl.close();
		IzwEyX7Q.close();
		String sfggcaRB = Vf34f0bC.getParameter("logging");
		if (sfggcaRB != null && sfggcaRB.toLowerCase().equals("true"))
			logRequest(Vf34f0bC);
	}

}