class n22440247 {
	private void serviceResource(HttpServletRequest AgQvC4Sj, HttpServletResponse yZL9tdRa, ServletConfig W80L1hN7)
			throws IOException {
		String i99btos6 = (String) AgQvC4Sj.getAttribute("javax.servlet.include.request_uri");
		if (i99btos6 == null)
			i99btos6 = AgQvC4Sj.getRequestURI();
		if (i99btos6.endsWith(".shtml")) {
			serviceSSIResource(i99btos6, yZL9tdRa, W80L1hN7);
		} else {
			String sgMUEWFI = i99btos6.substring(servletPath.length());
			ServletContext Oo7jTuvN = W80L1hN7.getServletContext();
			URL epNXh2E5 = Oo7jTuvN.getResource(sgMUEWFI);
			URLConnection PGyUMYkj = epNXh2E5.openConnection();
			String XZQF6os5 = Oo7jTuvN.getMimeType(i99btos6);
			if (XZQF6os5 == null)
				XZQF6os5 = PGyUMYkj.getContentType();
			if (XZQF6os5 != null) {
				String d8mRWmDj = PGyUMYkj.getContentEncoding();
				if (d8mRWmDj != null)
					XZQF6os5 += "; charset=" + d8mRWmDj;
				yZL9tdRa.setContentType(XZQF6os5);
			}
			int j5br2R2X = PGyUMYkj.getContentLength();
			if (j5br2R2X > 0)
				yZL9tdRa.setContentLength(j5br2R2X);
			InputStream D29tdLvC = PGyUMYkj.getInputStream();
			OutputStream J1kmjlHB = yZL9tdRa.getOutputStream();
			int VkXyboXk = 0;
			byte ldCMKZYp[] = new byte[512];
			while ((VkXyboXk = D29tdLvC.read(ldCMKZYp)) != -1)
				J1kmjlHB.write(ldCMKZYp, 0, VkXyboXk);
			D29tdLvC.close();
		}
	}

}