class n16343568 {
	public static void doGet(HttpServletRequest request, HttpServletResponse response, CollOPort colloport,
			PrintStream out) throws ServletException, IOException {
		response.addDateHeader("Expires", System.currentTimeMillis() - 86400);
		String id = request.getParameter("id");
		int url_i;
		String url_index = request.getParameter("url_index");
		Summary summary = colloport.getSummary(id);
		try {
			url_i = Integer.parseInt(url_index);
		} catch (NumberFormatException nfe) {
			url_i = 0;
		}
		String filename = request.getPathInfo();
		String includeURLAll = summary.getIncludeURL();
		if (filename != null && filename.length() > 0) {
			filename = filename.substring(1);
		}
		String includeURLs[] = includeURLAll.split(" ");
		String includeURL = includeURLs[url_i];
		if (includeURL != null && includeURL.length() > 0) {
			URL url = null;
			if (filename.indexOf(":") > 0) {
				includeURL = "";
			} else if (filename.startsWith("/")) {
				includeURL = includeURL.substring(0, includeURL.indexOf("/"));
			} else if (!includeURL.endsWith("/") && includeURL.indexOf(".") > 0) {
				includeURL = includeURL.substring(0, includeURL.lastIndexOf("/") + 1);
			}
			URLConnection conn = null;
			try {
				url = new URL(includeURL + response.encodeURL(filename));
			} catch (MalformedURLException mue) {
				System.out.println(mue);
			}
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
					contentDisposition = "attachment;filename=\"" + filename + "\"";
					contentType = "application/x-java-serialized-object";
				} else {
					contentDisposition = "inline;filename=\"" + filename + "\"";
				}
				response.setHeader("content-disposition", contentDisposition);
				response.setContentType(contentType);
				try {
					byte[] buffer = new byte[4096];
					InputStream inputStream = conn.getInputStream();
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