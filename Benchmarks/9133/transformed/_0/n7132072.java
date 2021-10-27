class n7132072 {
	public void doGet(HttpServletRequest YKYUldJY, HttpServletResponse lBeT1JJ6) throws ServletException, IOException {
		HttpSession dmbzRMwl = YKYUldJY.getSession(false);
		if (dmbzRMwl == null) {
			log.warn("HttpProxyServlet: no session");
			lBeT1JJ6.setStatus(404);
			return;
		}
		User LjvWoAhU = (User) dmbzRMwl.getAttribute("user");
		if (LjvWoAhU == null) {
			log.warn("HttpProxyServlet: user not logged in");
			lBeT1JJ6.setStatus(404);
			return;
		}
		String ZH2MvmCW = null;
		if (YKYUldJY.getPathInfo() != null && !YKYUldJY.getPathInfo().equals("")) {
			ZH2MvmCW = "http:/" + YKYUldJY.getPathInfo() + "?" + YKYUldJY.getQueryString();
			log.info("HttpProxyServlet: target=" + ZH2MvmCW);
		} else {
			log.warn("HttpProxyServlet: missing pathInfo");
			lBeT1JJ6.setStatus(404);
			return;
		}
		InputStream xfRzg8jV = null;
		ServletOutputStream txQZth59 = null;
		try {
			URL j48N63Jk = new URL(ZH2MvmCW);
			URLConnection Ehb0nXaT = j48N63Jk.openConnection();
			lBeT1JJ6.setContentType(Ehb0nXaT.getContentType());
			xfRzg8jV = Ehb0nXaT.getInputStream();
			txQZth59 = lBeT1JJ6.getOutputStream();
			byte[] tNxbByU6 = new byte[4096];
			int DOQpvCwA;
			while ((DOQpvCwA = xfRzg8jV.read(tNxbByU6)) != -1) {
				txQZth59.write(tNxbByU6, 0, DOQpvCwA);
			}
		} catch (MalformedURLException KwxZGUCQ) {
			log.warn("HttpProxyServlet: malformed URL");
			lBeT1JJ6.setStatus(404);
		} catch (IOException mpSRjZi6) {
			log.warn("HttpProxyServlet: I/O exception");
			lBeT1JJ6.setStatus(404);
		} finally {
			if (xfRzg8jV != null) {
				xfRzg8jV.close();
			}
			if (txQZth59 != null) {
				txQZth59.close();
			}
		}
	}

}