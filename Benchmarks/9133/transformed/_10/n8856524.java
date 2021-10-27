class n8856524 {
	@Action(value = "ajaxFileUploads", results = {})
	public void ajaxFileUploads() throws IOException {
		String extName = "";
		String newFilename = "";
		String nowTimeStr = "";
		String realpath = "";
		SimpleDateFormat sDateFormat;
		if (Validate.StrNotNull(this.getImgdirpath())) {
			realpath = "Uploads/" + this.getImgdirpath() + "/";
		} else {
			realpath = this.isexistdir();
		}
		String savePath = ServletActionContext.getServletContext().getRealPath("");
		Random r = new Random();
		HttpServletResponse response = ServletActionContext.getResponse();
		savePath = savePath + realpath;
		sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		int rannum = (int) (r.nextDouble() * (99999 - 1000 + 1)) + 10000;
		nowTimeStr = sDateFormat.format(new Date());
		String filename = request.getHeader("X-File-Name");
		if (filename.lastIndexOf(".") >= 0) {
			extName = filename.substring(filename.lastIndexOf("."));
		}
		PrintWriter writer = null;
		newFilename = nowTimeStr + rannum + extName;
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			writer = response.getWriter();
		} catch (IOException ex) {
			log.debug(ImgTAction.class.getName() + "has thrown an exception:" + ex.getMessage());
		}
		try {
			fos = new FileOutputStream(new File(savePath + newFilename));
			is = request.getInputStream();
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