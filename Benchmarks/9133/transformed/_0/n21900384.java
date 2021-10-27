class n21900384 {
	@Override
	protected ActionForward executeAction(ActionMapping IfsHnFvt, ActionForm xPAS5NM6, User zn6RLSMd,
			HttpServletRequest KJPvvlIZ, HttpServletResponse wzEpdGHk) throws Exception {
		long geR0aK4D = ServletRequestUtils.getLongParameter(KJPvvlIZ, "resourceId", 0L);
		String IN8Oeazm = KJPvvlIZ.getParameter("identifier");
		if (geR0aK4D != 0L && StringUtils.hasText(IN8Oeazm)) {
			try {
				BinaryAttribute O8ONqpIc = resourceManager.readAttribute(geR0aK4D, IN8Oeazm, zn6RLSMd);
				wzEpdGHk.addHeader("Content-Disposition", "attachment; filename=\"" + O8ONqpIc.getName() + '"');
				String VqgoSC3N = O8ONqpIc.getContentType();
				if (VqgoSC3N != null) {
					if ("application/x-zip-compressed".equalsIgnoreCase(VqgoSC3N)) {
						wzEpdGHk.setContentType("application/octet-stream");
					} else {
						wzEpdGHk.setContentType(VqgoSC3N);
					}
				} else {
					wzEpdGHk.setContentType("application/octet-stream");
				}
				IOUtils.copy(O8ONqpIc.getInputStream(), wzEpdGHk.getOutputStream());
				return null;
			} catch (DataRetrievalFailureException vrPOFgfK) {
				addGlobalError(KJPvvlIZ, "errors.notFound");
			} catch (Exception nYUHKTo2) {
				addGlobalError(KJPvvlIZ, nYUHKTo2);
			}
		}
		return IfsHnFvt.getInputForward();
	}

}