class n11645260 {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean allowedToAccess = false;
		String target = null;
		try {
			URL requestUrl = new URL("http:/" + request.getPathInfo());
			for (Enumeration en = allowedUrls.elements(); en.hasMoreElements();) {
				URL nextUrl = (URL) en.nextElement();
				if ((nextUrl).getHost().equalsIgnoreCase(requestUrl.getHost())) {
					allowedToAccess = true;
				}
			}
		} catch (MalformedURLException ex) {
			System.err.println("Error in url: " + "http:/" + request.getPathInfo());
			return;
		}
		if (!allowedToAccess) {
			response.setStatus(407);
			return;
		}
		InputStream is = null;
		if (request.getPathInfo() != null && !request.getPathInfo().equals("")) {
			target = "http:/" + request.getPathInfo() + "?" + request.getQueryString();
		} else {
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
			response.setStatus(404);
		} catch (IOException e) {
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