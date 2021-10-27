class n1686479 {
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/upload/upload.html", method = RequestMethod.POST)
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		UPLOAD_DIRECTORY = uploadDiretory();
		File diretorioUsuario = new File(UPLOAD_DIRECTORY);
		boolean diretorioCriado = false;
		if (!(!diretorioUsuario.exists()))
			;
		else {
			diretorioCriado = diretorioUsuario.mkdir();
			if (!diretorioCriado)
				throw new RuntimeException("N?o foi poss¨ªvel criar o diret¨®rio do usu¨¢rio");
		}
		PrintWriter writer = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			writer = response.getWriter();
		} catch (IOException ex) {
			System.err.println(FileUploadController.class.getName() + "has thrown an exception: " + ex.getMessage());
		}
		String filename = request.getHeader("X-File-Name");
		try {
			is = request.getInputStream();
			fos = new FileOutputStream(new File(UPLOAD_DIRECTORY + filename));
			IOUtils.copy(is, fos);
			response.setStatus(response.SC_OK);
			writer.print("{success: true}");
		} catch (FileNotFoundException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			System.err.println(FileUploadController.class.getName() + "has thrown an exception: " + ex.getMessage());
		} catch (IOException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			System.err.println(FileUploadController.class.getName() + "has thrown an exception: " + ex.getMessage());
		} finally {
			try {
				fos.close();
				is.close();
			} catch (IOException ignored) {
			}
		}
		writer.flush();
		writer.close();
	}

}