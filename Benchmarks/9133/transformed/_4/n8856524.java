class n8856524 {
	@Action(value = "ajaxFileUploads", results = {})
	public void ajaxFileUploads() throws IOException {
		String extName = "";
		String newFilename = "";
		String nowTimeStr = "";
		String realpath = "";
		realpath = (Validate.StrNotNull(this.getImgdirpath())) ? "Uploads/" + this.getImgdirpath() + "/"
				: this.isexistdir();
		SimpleDateFormat sDateFormat;
		Random r = new Random();
		String savePath = ServletActionContext.getServletContext().getRealPath("");
		savePath = savePath + realpath;
		HttpServletResponse response = ServletActionContext.getResponse();
		int rannum = (int) (r.nextDouble() * (99999 - 1000 + 1)) + 10000;
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		nowTimeStr = sDateFormat.format(new Date());
		String filename = request.getHeader("X-File-Name");
		extName = (filename.lastIndexOf(".") >= 0) ? filename.substring(filename.lastIndexOf(".")) : extName;
		newFilename = nowTimeStr + rannum + extName;
		PrintWriter writer = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			writer = response.getWriter();
		} catch (IOException ex) {
			log.debug(ImgTAction.class.getName() + "has thrown an exception:" + ex.getMessage());
		}
		try {
			is = request.getInputStream();
			fos = new FileOutputStream(new File(savePath + newFilename));
			IOUtils.copy(is, fos);
			response.setStatus(response.SC_OK);
			writer.print("{success:'" + realpath + newFilename + "'}");
		} catch (FileNotFoundException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: " + ex.getMessage());
		} catch (IOException ex) {
			response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
			writer.print("{success: false}");
			log.debug(ImgTAction.class.getName() + "has thrown an exception: " + ex.getMessage());
		} finally {
			try {
				this.setImgdirpath(null);
				fos.close();
				is.close();
			} catch (IOException ignored) {
			}
		}
		writer.flush();
		writer.close();
	}

}