class n5907126 {
	@Override
	protected void doGet(HttpServletRequest TbCrk75M, HttpServletResponse iGsk4OtF)
			throws ServletException, IOException {
		String MXaeQvxO = TbCrk75M.getParameter(CONTENT_ID);
		String Nm2eM7ei = TbCrk75M.getParameter(CONTENT_TYPE);
		if (MXaeQvxO == null || Nm2eM7ei == null) {
			iGsk4OtF.sendError(HttpServletResponse.SC_BAD_REQUEST, "Content id or content type not specified");
			return;
		}
		try {
			switch (ContentType.valueOf(Nm2eM7ei)) {
			case IMAGE:
				iGsk4OtF.setContentType("image/jpeg");
				break;
			case AUDIO:
				iGsk4OtF.setContentType("audio/mp3");
				break;
			case VIDEO:
				iGsk4OtF.setContentType("video/mpeg");
				break;
			default:
				throw new IllegalStateException("Invalid content type specified");
			}
		} catch (IllegalArgumentException qp1yWs5O) {
			iGsk4OtF.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid content type specified");
			return;
		}
		String mAo0PjIc = this.getServletContext().getInitParameter(BASE_URL);
		URL E0RARvbk = new URL(mAo0PjIc + "/" + Nm2eM7ei.toLowerCase() + "/" + MXaeQvxO);
		URLConnection RixhC9CA = E0RARvbk.openConnection();
		iGsk4OtF.setContentLength(RixhC9CA.getContentLength());
		IOUtils.copy(RixhC9CA.getInputStream(), iGsk4OtF.getOutputStream());
	}

}