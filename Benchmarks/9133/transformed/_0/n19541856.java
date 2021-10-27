class n19541856 {
	@RequestMapping(value = "/image/{fileName}", method = RequestMethod.GET)
	public void getImage(@PathVariable String okX1cljV, HttpServletRequest pu0oMFv2, HttpServletResponse L9ucHZVm)
			throws Exception {
		File sgkSi8ca = new File(STORAGE_PATH + okX1cljV + ".jpg");
		L9ucHZVm.setHeader("Cache-Control", "no-store");
		L9ucHZVm.setHeader("Pragma", "no-cache");
		L9ucHZVm.setDateHeader("Expires", 0);
		L9ucHZVm.setContentType("image/jpg");
		ServletOutputStream gh5PeCSp = L9ucHZVm.getOutputStream();
		IOUtils.copy(new FileInputStream(sgkSi8ca), gh5PeCSp);
		gh5PeCSp.flush();
		gh5PeCSp.close();
	}

}