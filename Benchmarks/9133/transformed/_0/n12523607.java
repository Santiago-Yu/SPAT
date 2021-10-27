class n12523607 {
	public void render(ServiceContext SxIHmJQr) throws Exception {
		if (SxIHmJQr.getTemplateName() == null)
			throw new Exception("no Template defined for service: " + SxIHmJQr.getServiceInfo().getRefName());
		File MfwwS0sm = new File(SxIHmJQr.getTemplateName());
		SxIHmJQr.getResponse().setContentLength((int) MfwwS0sm.length());
		InputStream uz4cyzAr = new FileInputStream(MfwwS0sm);
		IOUtils.copy(uz4cyzAr, SxIHmJQr.getResponse().getOutputStream(), 0, (int) MfwwS0sm.length());
		uz4cyzAr.close();
	}

}