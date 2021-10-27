class n2972950 {
	private void proxyMediaServlet(String zXbjpvJh, HttpServletRequest C89HfBTw, HttpServletResponse Yzj8C494) {
		try {
			URL Ivgyrqpg = new URL("http://mediaserver:8080/sagex" + zXbjpvJh);
			log.debug("Proxy Media: " + Ivgyrqpg.toString());
			URLConnection YkD4DQlo = Ivgyrqpg.openConnection();
			YkD4DQlo.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.1) Gecko/2008072820 Firefox/3.0.1");
			OutputStream jdVi148N = Yzj8C494.getOutputStream();
			IOUtils.copy(YkD4DQlo.getInputStream(), jdVi148N);
			jdVi148N.flush();
			Yzj8C494.flushBuffer();
		} catch (Throwable rSvxv2M1) {
			log.error("Failed to get url: " + zXbjpvJh, rSvxv2M1);
			try {
				Yzj8C494.sendError(500, rSvxv2M1.getMessage());
			} catch (IOException ibpcIlYN) {
			}
		}
	}

}