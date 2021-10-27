class n8932510 {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		InputStream page = null;
		InputStream is = null;
		String rootUrl = null;
		OutputStream os = null;
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			ServletFileUpload upload = new ServletFileUpload();
			if (!isMultipart) {
				request.setAttribute("error", "Form isn't a multipart form");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/error.jsp");
				rd.forward(request, response);
			}
			FileItemIterator iter = upload.getItemIterator(request);
			String webUrl = null;
			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName();
				if (name.equals("webpage")) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					is = item.openStream();
					IOUtils.copy(is, baos);
					page = new ByteArrayInputStream(baos.toByteArray());
				} else if (name.equals("weburl")) {
					InputStream wpIs = null;
					try {
						webUrl = Streams.asString(item.openStream());
						URL u = new URL(webUrl);
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						wpIs = new BufferedInputStream(u.openStream());
						IOUtils.copy(wpIs, baos);
						page = new ByteArrayInputStream(baos.toByteArray());
					} finally {
						IOUtils.closeQuietly(wpIs);
					}
				} else if (name.equals("rooturl")) {
					rootUrl = Streams.asString(item.openStream());
				}
			}
			if (page == null) {
				request.setAttribute("error", "Form doesn't have an html file");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/error.jsp");
				rd.forward(request, response);
			}
			os = new BufferedOutputStream(response.getOutputStream());
			ToMailerDelegate delegate = new ToMailerDelegate(page, rootUrl);
			os.write(delegate.getMailer());
			os.flush();
		} catch (Exception e) {
			streamException(request, response, e);
		} finally {
			IOUtils.closeQuietly(page);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
		}
	}

}