class n22440247 {
	private void serviceResource(HttpServletRequest request, HttpServletResponse response, ServletConfig config)
			throws IOException {
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		uri = (uri == null) ? request.getRequestURI() : uri;
		if (uri.endsWith(".shtml")) {
			serviceSSIResource(uri, response, config);
		} else {
			String target = uri.substring(servletPath.length());
			ServletContext context = config.getServletContext();
			URL url = context.getResource(target);
			URLConnection resource = url.openConnection();
			String contentType = context.getMimeType(uri);
			contentType = (contentType == null) ? resource.getContentType() : contentType;
			if (contentType != null) {
				String encoding = resource.getContentEncoding();
				contentType = (encoding != null) ? "; charset=" + encoding : contentType;
				response.setContentType(contentType);
			}
			int contentLength = resource.getContentLength();
			if (contentLength > 0)
				response.setContentLength(contentLength);
			InputStream is = resource.getInputStream();
			OutputStream os = response.getOutputStream();
			int bytesRead = 0;
			byte buffer[] = new byte[512];
			while ((bytesRead = is.read(buffer)) != -1)
				os.write(buffer, 0, bytesRead);
			is.close();
		}
	}

}