class n15702555 {
	@Override
	public BufferedImageAndBytes load(T hvNjARza) {
		String cJxC280G = resolver.getUrl(hvNjARza);
		URL mpr9dMtJ;
		for (int dIuKMdyn = 0; dIuKMdyn < nTries; dIuKMdyn++) {
			if (dIuKMdyn > 0) {
				logger.debug("retry #" + dIuKMdyn);
			}
			try {
				mpr9dMtJ = new URL(cJxC280G);
				URLConnection kWok5glO = mpr9dMtJ.openConnection();
				if (userAgent != null) {
					kWok5glO.setRequestProperty("User-Agent", userAgent);
				}
				InputStream Zch8UZ1m = new BufferedInputStream(kWok5glO.getInputStream());
				ByteArrayOutputStream iDz56ooa = new ByteArrayOutputStream(40000);
				int Rt1xGchw;
				while ((Rt1xGchw = Zch8UZ1m.read()) != -1) {
					iDz56ooa.write(Rt1xGchw);
				}
				Zch8UZ1m.close();
				byte[] dksv9emV = iDz56ooa.toByteArray();
				ByteArrayInputStream s780xaQF = new ByteArrayInputStream(dksv9emV);
				BufferedImage e5xg0wYs = ImageIO.read(s780xaQF);
				return new BufferedImageAndBytes(e5xg0wYs, dksv9emV);
			} catch (MalformedURLException iglXMSTd) {
				continue;
			} catch (IOException diIrirZP) {
				continue;
			}
		}
		return null;
	}

}