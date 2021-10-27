class n16016623 {
	@Override
	protected ModelAndView handleRequestInternal(final HttpServletRequest Xe2ox0N7, final HttpServletResponse VNaVxMjI)
			throws Exception {
		final String JraXuZD3 = ServletRequestUtils.getRequiredStringParameter(Xe2ox0N7, "id");
		final File EUWuYKi0 = new File(path, JraXuZD3 + ".html");
		logger.debug("Getting static content from: " + EUWuYKi0.getPath());
		final InputStream Tu2HFeyo = getServletContext().getResourceAsStream(EUWuYKi0.getPath());
		OutputStream pZtZZpwl = null;
		if (Tu2HFeyo != null) {
			try {
				pZtZZpwl = VNaVxMjI.getOutputStream();
				IOUtils.copy(Tu2HFeyo, pZtZZpwl);
			} catch (IOException URQut20P) {
				logger.error(URQut20P);
			} finally {
				Tu2HFeyo.close();
				if (pZtZZpwl != null) {
					pZtZZpwl.close();
				}
			}
		}
		return null;
	}

}