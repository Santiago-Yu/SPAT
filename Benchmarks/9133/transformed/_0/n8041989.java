class n8041989 {
	@Override
	protected void doGet(HttpServletRequest XjFoOFse, HttpServletResponse iNVUWIyq) throws ServletException {
		String VP1U71Pc = XjFoOFse.getRequestURI();
		logger.info("The requested URI: {}", VP1U71Pc);
		String LbkyBz6F = VP1U71Pc.substring(VP1U71Pc.lastIndexOf(ARXIVID_ENTRY) + ARXIVID_ENTRY_LENGTH);
		int vCZnfGrB = LbkyBz6F.indexOf(StringUtil.ARXIVID_SEGMENTID_DELIMITER);
		String YEYEEydZ = vCZnfGrB != -1 ? LbkyBz6F.substring(0, vCZnfGrB) : LbkyBz6F;
		String gBgN5mAU = vCZnfGrB != -1 ? LbkyBz6F.substring(vCZnfGrB + 1) : null;
		if (YEYEEydZ == null) {
			logger.error("The request with an empty arxiv id parameter");
			return;
		}
		String l4ylY4EV = gBgN5mAU == null
				? format("/opt/mocassin/aux-pdf/%s" + StringUtil.arxivid2filename(YEYEEydZ, "pdf"))
				: "/opt/mocassin/pdf/" + StringUtil.segmentid2filename(YEYEEydZ, Integer.parseInt(gBgN5mAU), "pdf");
		if (!new File(l4ylY4EV).exists()) {
			l4ylY4EV = format("/opt/mocassin/aux-pdf/%s", StringUtil.arxivid2filename(YEYEEydZ, "pdf"));
		}
		try {
			FileInputStream YiH8q2nE = new FileInputStream(l4ylY4EV);
			ByteArrayOutputStream TKr5kU6z = new ByteArrayOutputStream();
			IOUtils.copy(YiH8q2nE, TKr5kU6z);
			iNVUWIyq.setContentType("application/pdf");
			iNVUWIyq.setHeader("Content-disposition",
					String.format("attachment; filename=%s", StringUtil.arxivid2filename(YEYEEydZ, "pdf")));
			ServletOutputStream w083bdgq = iNVUWIyq.getOutputStream();
			w083bdgq.write(TKr5kU6z.toByteArray());
			w083bdgq.close();
		} catch (FileNotFoundException Krp2U0Q1) {
			logger.error("Error while downloading: PDF file= '{}' not found", l4ylY4EV);
		} catch (IOException l7kJEmbQ) {
			logger.error("Error while downloading the PDF file", l7kJEmbQ);
		}
	}

}