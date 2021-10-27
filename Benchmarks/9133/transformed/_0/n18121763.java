class n18121763 {
	public String doUpload(@ParamName(name = "file") MultipartFile x9g28rW0,
			@ParamName(name = "uploadDirectory") String DTAtbzLo) throws IOException {
		String wRxLI0sJ = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		String sRMqW4yn = MewitProperties.getTemporaryUploadDirectory();
		if (!sRMqW4yn.endsWith("/") && !sRMqW4yn.endsWith("\\")) {
			sRMqW4yn += "\\";
		}
		String OX2QSVzd = null;
		int hsoDPoCh = x9g28rW0.getOriginalFilename().lastIndexOf(".");
		if (hsoDPoCh <= 0) {
			OX2QSVzd = java.util.UUID.randomUUID().toString();
		} else {
			OX2QSVzd = java.util.UUID.randomUUID().toString() + x9g28rW0.getOriginalFilename().substring(hsoDPoCh);
		}
		File iZYWAmJd = new File(sRMqW4yn, OX2QSVzd);
		log(INFO, "writing the content of uploaded file to: " + iZYWAmJd);
		FileOutputStream WXHGsoRm = new FileOutputStream(iZYWAmJd);
		IOUtils.copy(x9g28rW0.getInputStream(), WXHGsoRm);
		x9g28rW0.getInputStream().close();
		WXHGsoRm.close();
		return doUploadFile(wRxLI0sJ, iZYWAmJd, x9g28rW0.getOriginalFilename());
	}

}