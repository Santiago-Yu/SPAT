class n19279420 {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload();
		final FileManager fmanager = FileManager.getFileManager(request, leechget);
		FileItemIterator iter;
		try {
			iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName();
				InputStream stream = item.openStream();
				if (!item.isFormField()) {
					final FileObject file = fmanager.getFile(name);
					if (!file.exists()) {
						IOUtils.copyLarge(stream, file.getContent().getOutputStream());
					}
				}
			}
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
	}

}