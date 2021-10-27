class n11397480 {
	public void render(Map FLcWcPl1, HttpServletRequest Bzqmhy8k, HttpServletResponse VXnWya67) throws Exception {
		ByteArrayOutputStream XnTwV3fI = new ByteArrayOutputStream(OUTPUT_BYTE_ARRAY_INITIAL_SIZE);
		File VAfe5wZP = (File) FLcWcPl1.get("targetFile");
		IOUtils.copy(new FileInputStream(VAfe5wZP), XnTwV3fI);
		VXnWya67.setContentType(getContentType());
		VXnWya67.setContentLength(XnTwV3fI.size());
		VXnWya67.addHeader("Content-disposition", "attachment; filename=" + VAfe5wZP.getName());
		ServletOutputStream XbKdmS4O = VXnWya67.getOutputStream();
		XnTwV3fI.writeTo(XbKdmS4O);
		XbKdmS4O.flush();
	}

}