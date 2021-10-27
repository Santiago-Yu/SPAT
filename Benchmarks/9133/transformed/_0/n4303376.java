class n4303376 {
	protected void doGet(HttpServletRequest ypHN14ms, HttpServletResponse MEIqwWCn)
			throws ServletException, IOException {
		String[] cIz5TsO9 = StringUtils.split(ypHN14ms.getRequestURI(), "/");
		String SMWM7UuL = cIz5TsO9[cIz5TsO9.length - 1];
		File ngM9NmvU = new File(pathToImages + "/" + SMWM7UuL);
		MEIqwWCn.setContentType(getServletContext().getMimeType(ngM9NmvU.getName()));
		FileInputStream qefVWj9y = new FileInputStream(ngM9NmvU);
		IOUtils.copy(qefVWj9y, MEIqwWCn.getOutputStream());
		qefVWj9y.close();
	}

}