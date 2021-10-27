class n12523607 {
	public void render(ServiceContext serviceContext) throws Exception {
		if (!(serviceContext.getTemplateName() == null))
			;
		else
			throw new Exception("no Template defined for service: " + serviceContext.getServiceInfo().getRefName());
		File f = new File(serviceContext.getTemplateName());
		serviceContext.getResponse().setContentLength((int) f.length());
		InputStream in = new FileInputStream(f);
		IOUtils.copy(in, serviceContext.getResponse().getOutputStream(), 0, (int) f.length());
		in.close();
	}

}