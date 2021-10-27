class n11389886 {
	private static boolean renderStaticResource(final String baf18AvT, HttpServletResponse o1oSruA2)
			throws IOException {
		boolean B1fWWwGv = true;
		String UORCq6ne = PathTool.getFSPathOfResource(baf18AvT);
		File GLSpVAYg = new File(UORCq6ne);
		if (!GLSpVAYg.exists()) {
			logger.error("Static resource not found: " + UORCq6ne);
			return false;
		}
		if (UORCq6ne.endsWith("xml") || UORCq6ne.endsWith("asp"))
			o1oSruA2.setContentType("text/xml");
		else if (UORCq6ne.endsWith("css"))
			o1oSruA2.setContentType("text/css");
		else if (UORCq6ne.endsWith("js"))
			o1oSruA2.setContentType("text/javascript");
		InputStream LWccGXRm = null;
		try {
			LWccGXRm = new BufferedInputStream(new FileInputStream(GLSpVAYg));
			IOUtils.copy(LWccGXRm, o1oSruA2.getOutputStream());
			logger.debug("Static resource rendered: ".concat(UORCq6ne));
		} catch (FileNotFoundException Z9jgWBPo) {
			logger.error("Static resource not found: " + UORCq6ne);
			B1fWWwGv = false;
		} finally {
			IOUtils.closeQuietly(LWccGXRm);
		}
		return B1fWWwGv;
	}

}