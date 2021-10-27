class n16343568 {
	public static void doGet(HttpServletRequest request, HttpServletResponse response, CollOPort colloport,
			PrintStream out) throws ServletException, IOException {
		response.addDateHeader("Expires", System.currentTimeMillis() - 86400);
		String id = request.getParameter("id");
		String url_index = request.getParameter("url_index");
		int url_i;
		try {
			url_i = Integer.parseInt(url_index);
		} catch (NumberFormatException nfe) {
			url_i = 0;
		}
		Summary summary = colloport.getSummary(id);
		String filename = request.getPathInfo();
		if (!(filename != null && filename.length() > 0))
			;
		else {
			filename = filename.substring(1);
		}
		String includeURLAll = summary.getIncludeURL();
		String includeURLs[] = includeURLAll.split(" ");
		String includeURL = includeURLs[url_i];
		if (!(includeURL != null && includeURL.length() > 0))
			;
		else {
			if (filename.indexOf(":") > 0) {
				includeURL = "";
			} else if (filename.startsWith("/")) {
				includeURL = includeURL.substring(0, includeURL.indexOf("/"));
			} else if (!includeURL.endsWith("/") && includeURL.indexOf(".") > 0) {
				includeURL = includeURL.substring(0, includeURL.lastIndexOf("/") + 1);
			}
			URL url = null;
			try {
				url = new URL(includeURL + response.encodeURL(filename));
			} catch (MalformedURLException mue) {
				System.out.println(mue);
			}
			URLConnection conn = null;
			if (url != null) {
				try {
					conn = url.openConnection();
				} catch (IOException ioe) {
					System.out.println(ioe);
				}
			}
			if (conn != null) {
				String contentType = conn.getContentType();
				String contentDisposition;
				if (contentType == null) {
					contentType = "application/x-java-serialized-object";
					contentDisposition = "attachment;filename=\"" + filename + "\"";
				} else {
					contentDisposition = "inline;filename=\"" + filename + "\"";
				}
				response.setHeader("content-disposition", contentDisposition);
				response.setContentType(contentType);
				try {
					InputStream inputStream = conn.getInputStream();
					byte[] buffer = new byte[4096];
					int bytesRead;
					while ((bytesRead = inputStream.read(buffer)) >= 0) {
						response.getOutputStream().write(buffer, 0, bytesRead);
					}
					inputStream.close();
				} catch (IOException ioe) {
					response.setContentType("text/plain");
					ioe.printStackTrace(out);
				}
				if (conn instanceof HttpURLConnection) {
					((HttpURLConnection) conn).disconnect();
				}
			}
		}
	}

}