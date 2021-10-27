class n3636960 {
	public void display(WebPage ZGT7BIFF, HttpServletRequest zh1wi58S, HttpServletResponse yeeJWXAT)
			throws DisplayException {
		ZGT7BIFF.getDisplayInitialiser().initDisplay(new HttpRequestDisplayContext(zh1wi58S), zh1wi58S);
		StreamProvider RDJp7dUA = (StreamProvider) zh1wi58S.getAttribute(INPUTSTREAM_KEY);
		if (RDJp7dUA == null) {
			throw new IllegalStateException("No OutputStreamDisplayHandlerXML.InputStream found in request attribute"
					+ " OutputStreamDisplayHandlerXML.INPUTSTREAM_KEY");
		}
		yeeJWXAT.setContentType(RDJp7dUA.getMimeType());
		yeeJWXAT.setHeader("Content-Disposition", "attachment;filename=" + RDJp7dUA.getName());
		try {
			InputStream aBGOR5LD = RDJp7dUA.getInputStream();
			OutputStream MyescyEH = yeeJWXAT.getOutputStream();
			if (aBGOR5LD != null) {
				IOUtils.copy(aBGOR5LD, MyescyEH);
			}
			RDJp7dUA.write(yeeJWXAT.getOutputStream());
			yeeJWXAT.flushBuffer();
		} catch (IOException tDy5qR6X) {
			throw new DisplayException("Error writing input stream to response", tDy5qR6X);
		}
	}

}