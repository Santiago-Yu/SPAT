class n5845421 {
	private void download(Downloadable yAcoLUrn, HttpServletResponse HQIFOXPY) throws Exception {
		String RJJCrEng = yAcoLUrn.getContentType();
		try {
			HQIFOXPY.setContentType(RJJCrEng);
			HQIFOXPY.setHeader("Content-Disposition",
					"attachment;" + " filename=" + new String(yAcoLUrn.getName().getBytes(), "ISO-8859-1"));
			OutputStream kYQWwQlm = HQIFOXPY.getOutputStream();
			IOUtils.copy(yAcoLUrn.getInputStream(), kYQWwQlm);
			kYQWwQlm.flush();
		} catch (IOException VlBuMIEC) {
		}
	}

}