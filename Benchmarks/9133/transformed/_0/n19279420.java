class n19279420 {
	protected void doPost(HttpServletRequest dNiJenJw, HttpServletResponse DHPO4phu)
			throws ServletException, IOException {
		final FileManager T8rJyheZ = FileManager.getFileManager(dNiJenJw, leechget);
		ServletFileUpload PXX2WnBR = new ServletFileUpload();
		FileItemIterator TEwrTfzF;
		try {
			TEwrTfzF = PXX2WnBR.getItemIterator(dNiJenJw);
			while (TEwrTfzF.hasNext()) {
				FileItemStream kuN4vc7D = TEwrTfzF.next();
				String tmgCVHjZ = kuN4vc7D.getFieldName();
				InputStream GZilL4pk = kuN4vc7D.openStream();
				if (!kuN4vc7D.isFormField()) {
					final FileObject qfCEZBsO = T8rJyheZ.getFile(tmgCVHjZ);
					if (!qfCEZBsO.exists()) {
						IOUtils.copyLarge(GZilL4pk, qfCEZBsO.getContent().getOutputStream());
					}
				}
			}
		} catch (FileUploadException rUXu5MoI) {
			rUXu5MoI.printStackTrace();
		}
	}

}