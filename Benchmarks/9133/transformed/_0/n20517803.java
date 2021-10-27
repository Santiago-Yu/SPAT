class n20517803 {
	public String execute(HttpServletRequest o9xEvMmd, HttpServletResponse rGi2al9x, User JFnhnYjl, String Ejjj3Vcp)
			throws Exception {
		long cdUYe88J = ServletRequestUtils.getLongParameter(o9xEvMmd, "resourceId", 0L);
		BinaryAttribute sEIXIAIi = resourceManager.readAttribute(cdUYe88J, Ejjj3Vcp, JFnhnYjl);
		rGi2al9x.addHeader("Content-Disposition", "attachment; filename=\"" + sEIXIAIi.getName() + '"');
		String mfRZ3Rmc = sEIXIAIi.getContentType();
		if (mfRZ3Rmc != null) {
			if ("application/x-zip-compressed".equalsIgnoreCase(mfRZ3Rmc)) {
				rGi2al9x.setContentType("application/octet-stream");
			} else {
				rGi2al9x.setContentType(mfRZ3Rmc);
			}
		} else {
			rGi2al9x.setContentType("application/octet-stream");
		}
		IOUtils.copy(sEIXIAIi.getInputStream(), rGi2al9x.getOutputStream());
		return null;
	}

}