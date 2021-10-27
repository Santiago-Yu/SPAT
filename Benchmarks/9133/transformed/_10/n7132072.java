class n7132072 {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			log.warn("HttpProxyServlet: no session");
			response.setStatus(404);
			return;
		}
		User user = (User) session.getAttribute("user");
		String target = null;
		if (user == null) {
			log.warn("HttpProxyServlet: user not logged in");
			response.setStatus(404);
			return;
		}
		InputStream is = null;
		if (request.getPathInfo() != null && !request.getPathInfo().equals("")) {
			target = "http:/" + request.getPathInfo() + "?" + request.getQueryString();
			log.info("HttpProxyServlet: target=" + target);
		} else {
			log.warn("HttpProxyServlet: missing pathInfo");
			response.setStatus(404);
			return;
		}
		ServletOutputStream out = null;
		try {
			URL url = new URL(target);
			URLConnection uc = url.openConnection();
			response.setContentType(uc.getContentType());
			is = uc.getInputStream();
			byte[] buf = new byte[4096];
			out = response.getOutputStream();
			int bytesRead;
			while ((bytesRead = is.read(buf)) != -1) {
				out.write(buf, 0, bytesRead);
			}
		} catch (MalformedURLException e) {
			log.warn("HttpProxyServlet: malformed URL");
			response.setStatus(404);
		} catch (IOException e) {
			log.warn("HttpProxyServlet: I/O exception");
			response.setStatus(404);
		} finally {
			if (is != null) {
				is.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}