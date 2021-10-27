class n10548278 {
	public ActionForward saveImageMap(ActionMapping Rhi08U0G, ActionForm qfYhKSnz, HttpServletRequest l6KbcEu4,
			HttpServletResponse UUq0xTgW) throws Exception {
		log.debug("MapAction saveImageMap()");
		String un2tbKFk = RequestUtil.getRequest(l6KbcEu4, "imgUrl");
		DataInputStream yVVExi1m = null;
		FileOutputStream Z2zqN4ly = null;
		byte[] tYhbQJq7 = new byte[1];
		URL PUzgGvnP = new URL(un2tbKFk);
		URLConnection G5WB7mqY = PUzgGvnP.openConnection();
		G5WB7mqY.connect();
		UUq0xTgW.setContentType("application/octet-stream");
		UUq0xTgW.setHeader("Content-disposition", "attachment;filename=" + "map.png");
		OutputStream sfTlwO4p = UUq0xTgW.getOutputStream();
		byte Hr7yarsl[] = new byte[4096];
		try {
			BufferedInputStream exN5WXTl = new BufferedInputStream(G5WB7mqY.getInputStream());
			int S7su4miz;
			while ((S7su4miz = exN5WXTl.read(Hr7yarsl, 0, 4096)) != -1)
				sfTlwO4p.write(Hr7yarsl, 0, S7su4miz);
			exN5WXTl.close();
		} catch (Exception ZbsLyqdo) {
			ZbsLyqdo.printStackTrace();
		}
		return null;
	}

}