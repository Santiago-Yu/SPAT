class n18121763 {
	public String doUpload(@ParamName(name = "file") MultipartFile file,
			@ParamName(name = "uploadDirectory") String _uploadDirectory) throws IOException {
		String sessionId = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		String tempUploadDir = MewitProperties.getTemporaryUploadDirectory();
		tempUploadDir = (!tempUploadDir.endsWith("/") && !tempUploadDir.endsWith("\\")) ? "\\" : tempUploadDir;
		String fileName = null;
		int position = file.getOriginalFilename().lastIndexOf(".");
		fileName = (position <= 0) ? java.util.UUID.randomUUID().toString()
				: java.util.UUID.randomUUID().toString() + file.getOriginalFilename().substring(position);
		File outputFile = new File(tempUploadDir, fileName);
		log(INFO, "writing the content of uploaded file to: " + outputFile);
		FileOutputStream fos = new FileOutputStream(outputFile);
		IOUtils.copy(file.getInputStream(), fos);
		file.getInputStream().close();
		fos.close();
		return doUploadFile(sessionId, outputFile, file.getOriginalFilename());
	}

}