class n2026968 {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		InputStream is = null;
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException ex) {
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + ex.getMessage());
		}
		FileOutputStream fos = null;
		String filename = request.getHeader("X-File-Name");
		try {
			is = request.getInputStream();
			fos = new FileOutputStream(new File(realPath + filename));
			IOUtils.copy(is, fos);
			response.setStatus(response.SC_OK);
			writer.print("{success: true}");
		} catch (FileNotFoundException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + ex.getMessage());
		} catch (IOException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log(OctetStreamReader.class.getName() + "has thrown an exception: " + ex.getMessage());
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