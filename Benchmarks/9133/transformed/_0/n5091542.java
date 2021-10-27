class n5091542 {
	@Override
	public void doHandler(HttpServletRequest omIZuESv, HttpServletResponse oZQAWUH4)
			throws IOException, ServletException {
		if (omIZuESv.getRequestURI().indexOf(".swf") != -1) {
			String YsW2MPKm = (String) omIZuESv.getAttribute("fullUrl");
			YsW2MPKm = urlTools.urlFilter(YsW2MPKm, true);
			oZQAWUH4.setCharacterEncoding("gbk");
			oZQAWUH4.setContentType("application/x-shockwave-flash");
			PrintWriter gbXQx9nH = oZQAWUH4.getWriter();
			try {
				URL vl6MXJbq = new URL(YsW2MPKm);
				BufferedReader jA64GRFe = new BufferedReader(new InputStreamReader(vl6MXJbq.openStream(), "gbk"));
				fileEditor.pushStream(gbXQx9nH, jA64GRFe, null, true);
			} catch (Exception KqJIQ8hE) {
			}
			gbXQx9nH.flush();
		} else if (omIZuESv.getRequestURI().indexOf(".xml") != -1) {
			oZQAWUH4.setContentType("text/xml");
			PrintWriter UeJXj74W = oZQAWUH4.getWriter();
			try {
				URL qV1RtMmv = new URL("http://" + configCenter.getUcoolOnlineIp() + omIZuESv.getRequestURI());
				BufferedReader reHTVe63 = new BufferedReader(new InputStreamReader(qV1RtMmv.openStream()));
				fileEditor.pushStream(UeJXj74W, reHTVe63, null, true);
			} catch (Exception I5ZkX5fi) {
			}
			UeJXj74W.flush();
		}
	}

}