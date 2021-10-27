class n2451974 {
	@Override
	public void doHandler(HttpServletRequest lRnOETjC, HttpServletResponse FUoSuZpx)
			throws IOException, ServletException {
		if (lRnOETjC.getRequestURI().indexOf("png") != -1) {
			FUoSuZpx.setContentType("image/png");
		} else if (lRnOETjC.getRequestURI().indexOf("gif") != -1) {
			FUoSuZpx.setContentType("image/gif");
		} else {
			FUoSuZpx.setContentType("image/x-icon");
		}
		BufferedOutputStream GvJZADRG = new BufferedOutputStream(FUoSuZpx.getOutputStream());
		try {
			URL gmsyd5Fa = new URL("http://" + configCenter.getUcoolOnlineIp() + lRnOETjC.getRequestURI());
			BufferedInputStream VEIYhdAZ = new BufferedInputStream(gmsyd5Fa.openStream());
			byte[] Gs0J3Lvq = new byte[4096];
			int RnqTNIqj = VEIYhdAZ.read(Gs0J3Lvq);
			while (RnqTNIqj != -1) {
				GvJZADRG.write(Gs0J3Lvq, 0, RnqTNIqj);
				RnqTNIqj = VEIYhdAZ.read(Gs0J3Lvq);
			}
			VEIYhdAZ.close();
			GvJZADRG.flush();
			GvJZADRG.close();
			VEIYhdAZ.close();
		} catch (Exception J2Uq0BNP) {
		}
		GvJZADRG.flush();
	}

}