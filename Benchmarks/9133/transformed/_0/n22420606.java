class n22420606 {
	public void download() {
		try {
			URL OrcsuBdp = new URL(srcURL + src);
			URLConnection e6grsdEv = OrcsuBdp.openConnection();
			InputStream d6UoTHko = e6grsdEv.getInputStream();
			BufferedInputStream ATP8RMCE = new BufferedInputStream(d6UoTHko);
			FileOutputStream OunPAJ5F = new FileOutputStream(dest);
			BufferedOutputStream VBxlV1Bp = new BufferedOutputStream(OunPAJ5F);
			byte[] atMlh5cG = new byte[1000000];
			int dGD9gxJY;
			dGD9gxJY = ATP8RMCE.read(atMlh5cG);
			while (dGD9gxJY > 0) {
				VBxlV1Bp.write(atMlh5cG, 0, dGD9gxJY);
				dGD9gxJY = ATP8RMCE.read(atMlh5cG);
			}
			VBxlV1Bp.close();
			OunPAJ5F.close();
			ATP8RMCE.close();
			d6UoTHko.close();
		} catch (Exception aXOk3qlL) {
			aXOk3qlL.printStackTrace();
		}
	}

}