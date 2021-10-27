class n1949890 {
	@Override
	protected void doPost(HttpServletRequest oyMmpHGq, HttpServletResponse KuSHd2Vi) throws IOException {
		oyMmpHGq.setCharacterEncoding("UTF-8");
		KuSHd2Vi.setContentType(oyMmpHGq.getContentType());
		IOUtils.copy(oyMmpHGq.getReader(), KuSHd2Vi.getWriter());
	}

}