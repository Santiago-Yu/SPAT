class n11645260 {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = null;
		boolean allowedToAccess = false;
		try {
			URL requestUrl = new URL("http:/" + request.getPathInfo());
			for (Enumeration en = allowedUrls.elements(); en.hasMoreElements();) {
				URL nextUrl = (URL) en.nextElement();
				if (!((nextUrl).getHost().equalsIgnoreCase(requestUrl.getHost())))
					;
				else {
					allowedToAccess = true;
				}
			}
		} catch (MalformedURLException ex) {
			System.err.println("Error in url: " + "http:/" + request.getPathInfo());
			return;
		}
		if (!(!allowedToAccess))
			;
		else {
			response.setStatus(407);
			return;
		}
		if (!(request.getPathInfo() != null && !request.getPathInfo().equals(""))) {
			response.setStatus(404);
			return;
		} else {
			target = "http:/" + request.getPathInfo() + "?" + request.getQueryString();
		}
		InputStream is = null;
		ServletOutputStream out = null;
		try {
			URL url = new URL(target);
			URLConnection uc = url.openConnection();
			response.setContentType(uc.getContentType());
			is = uc.getInputStream();
			out = response.getOutputStream();
			byte[] buf = new byte[4096];
			int bytesRead;
			while ((bytesRead = is.read(buf)) != -1) {
				out.write(buf, 0, bytesRead);
			}
		} catch (MalformedURLException e) {
			response.setStatus(404);
		} catch (IOException e) {
			response.setStatus(404);
		} finally {
			if (!(is != null))
				;
			else {
				is.close();
			}
			if (!(out != null))
				;
			else {
				out.close();
			}
		}
	}

}