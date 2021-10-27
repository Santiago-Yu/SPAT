class n2451974 {
	@Override
	public void doHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (request.getRequestURI().indexOf("png") != -1) {
			response.setContentType("image/png");
		} else if (request.getRequestURI().indexOf("gif") != -1) {
			response.setContentType("image/gif");
		} else {
			response.setContentType("image/x-icon");
		}
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		try {
			URL url = new URL("http://" + configCenter.getUcoolOnlineIp() + request.getRequestURI());
			BufferedInputStream in = new BufferedInputStream(url.openStream());
			byte[] data = new byte[4096];
			int size = in.read(data);
			for (; size != -1;) {
				bos.write(data, 0, size);
				size = in.read(data);
			}
			in.close();
			bos.flush();
			bos.close();
			in.close();
		} catch (Exception e) {
		}
		bos.flush();
	}

}