class n17896475 {
	public String installCode(String sHmwcIGH, String VdhmJKg6) throws DeploymentException {
		FileOutputStream kRlM9V9G = null;
		mLog.debug("overwriteWarFile = " + overwriteWarFile);
		String X3VDqjuG = null;
		String qy4s7jmF = VdhmJKg6;
		String[] g9ZhOdut = qy4s7jmF.split("/");
		String ixL0fgos = g9ZhOdut[g9ZhOdut.length - 1];
		int MUEofcDS = ixL0fgos.length();
		warname = ixL0fgos.substring(0, MUEofcDS - 4);
		mLog.debug("WAR file name = " + warname);
		String o8xnLGia = warDesination + File.separator + ixL0fgos;
		ret = "http://" + containerAddress + "/" + warname + "/services/" + sHmwcIGH;
		mLog.debug("filepath2 = " + o8xnLGia);
		mLog.debug("ret = " + ret);
		mLog.debug("filepath = " + qy4s7jmF);
		boolean f3OEXSFf = new File(o8xnLGia).exists();
		boolean HXjxGDrV = true;
		try {
			String z45axKh6 = o8xnLGia.substring(0, (o8xnLGia.length() - 4));
			mLog.debug("Web Application Name = " + z45axKh6);
			HXjxGDrV = new File(z45axKh6).isDirectory();
			if (!HXjxGDrV) {
				URL FxOv75UI = new URL(qy4s7jmF);
				File LC9JRvu2 = new File(o8xnLGia);
				if (!LC9JRvu2.exists()) {
					LC9JRvu2.createNewFile();
				}
				InputStream Ka0N6Dc6 = null;
				try {
					Ka0N6Dc6 = FxOv75UI.openStream();
					kRlM9V9G = new FileOutputStream(LC9JRvu2);
				} catch (Exception OBOR7kIP) {
					OBOR7kIP.printStackTrace();
					throw new DeploymentException("couldn't open stream due to: " + OBOR7kIP.getMessage());
				}
				URLConnection zJrumSEi = FxOv75UI.openConnection();
				int DiqEHhKx = zJrumSEi.getContentLength();
				ReadableByteChannel yGz5VSrO = Channels.newChannel(Ka0N6Dc6);
				FileChannel AOapWMQV = kRlM9V9G.getChannel();
				AOapWMQV.transferFrom(yGz5VSrO, 0, DiqEHhKx);
				yGz5VSrO.close();
				AOapWMQV.close();
				kRlM9V9G.flush();
				kRlM9V9G.close();
				Ka0N6Dc6.close();
				long zR46V5wV = System.currentTimeMillis();
				check(ret, zR46V5wV, STARTCONTROL);
			}
		} catch (Exception RhW3q69H) {
			HXjxGDrV = false;
		}
		mLog.debug("webAppExists = " + HXjxGDrV);
		return (ret);
	}

}