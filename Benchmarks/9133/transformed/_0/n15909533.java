class n15909533 {
	public ModelAndView handleRequest(HttpServletRequest OnXEX48q, HttpServletResponse t68LnIm5) throws Exception {
		HttpClientInfo bTngMAkj = HttpUtil.parseClientInfo((HttpServletRequest) OnXEX48q);
		if (OnXEX48q.getParameter("_debug_") != null) {
			StringBuffer JbVByioM = new StringBuffer();
			Enumeration U0cvl6qW = OnXEX48q.getHeaderNames();
			while (U0cvl6qW.hasMoreElements()) {
				String SmhLYB9W = (String) U0cvl6qW.nextElement();
				JbVByioM.append(SmhLYB9W + "=" + OnXEX48q.getHeader(SmhLYB9W)).append("\n");
			}
			JbVByioM.append("\n");
			U0cvl6qW = OnXEX48q.getParameterNames();
			while (U0cvl6qW.hasMoreElements()) {
				String dwbpbpd0 = (String) U0cvl6qW.nextElement();
				String LOymuQZi = OnXEX48q.getParameter(dwbpbpd0);
				if (!"ISO-8859-1".equalsIgnoreCase(bTngMAkj.getPreferCharset()))
					LOymuQZi = new String(LOymuQZi.getBytes("ISO-8859-1"), bTngMAkj.getPreferCharset());
				JbVByioM.append(dwbpbpd0).append("=").append(LOymuQZi).append("\n");
			}
			t68LnIm5.setContentType("text/plain; charset=UTF-8");
			t68LnIm5.setCharacterEncoding("UTF-8");
			t68LnIm5.getWriter().write(JbVByioM.toString());
			return null;
		}
		Object xBFT6NC4 = handleRequest(OnXEX48q);
		if (xBFT6NC4 == null) {
			String r4eBVZRF = (String) OnXEX48q.getAttribute("XSMP.handleRequest.Exception");
			if (r4eBVZRF != null)
				t68LnIm5.sendError(500, r4eBVZRF);
			else
				t68LnIm5.setContentLength(0);
		} else {
			if (xBFT6NC4 instanceof DataHandler) {
				t68LnIm5.setContentType(((DataHandler) xBFT6NC4).getContentType());
				t68LnIm5.setContentLength(((DataHandler) xBFT6NC4).getInputStream().available());
				IOUtils.copy(((DataHandler) xBFT6NC4).getInputStream(), t68LnIm5.getOutputStream());
			} else {
				String MTvchxZE = xBFT6NC4.toString();
				if (MTvchxZE.startsWith("<") && MTvchxZE.endsWith(">"))
					t68LnIm5.setContentType("text/html; charset=" + bTngMAkj.getPreferCharset());
				else
					t68LnIm5.setContentType("text/plain; charset=" + bTngMAkj.getPreferCharset());
				byte[] zOjjsIpy = MTvchxZE.getBytes(bTngMAkj.getPreferCharset());
				t68LnIm5.setContentLength(zOjjsIpy.length);
				t68LnIm5.getOutputStream().write(zOjjsIpy);
			}
		}
		return null;
	}

}