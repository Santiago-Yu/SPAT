class n10548278 {
	public ActionForward saveImageMap(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		log.debug("MapAction saveImageMap()");
		String imageURL = RequestUtil.getRequest(request, "imgUrl");
		DataInputStream di = null;
		FileOutputStream fo = null;
		byte[] b = new byte[1];
		URL url = new URL(imageURL);
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=" + "map.png");
		OutputStream outstream = response.getOutputStream();
		byte abyte0[] = new byte[4096];
		try {
			BufferedInputStream instream = new BufferedInputStream(urlConnection.getInputStream());
			int i;
			for (; (i = instream.read(abyte0, 0, 4096)) != -1;)
				outstream.write(abyte0, 0, i);
			instream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}