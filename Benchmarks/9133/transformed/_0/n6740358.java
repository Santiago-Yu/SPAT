class n6740358 {
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Image getGoogleMapImage(final BigDecimal kcFtGT2X, final BigDecimal Cn862aGZ, final Integer HlAIdSUP) {
		if (Cn862aGZ == null) {
			throw new IllegalArgumentException("Longitude cannot be null.");
		}
		if (kcFtGT2X == null) {
			throw new IllegalArgumentException("Latitude cannot be null.");
		}
		if (HlAIdSUP == null) {
			throw new IllegalArgumentException("ZoomLevel cannot be null.");
		}
		final URI lPKhT7eX = GoogleMapsUtils.buildGoogleMapsStaticUrl(kcFtGT2X, Cn862aGZ, HlAIdSUP);
		BufferedImage hhUN2z0j;
		try {
			URLConnection P2qILImC = lPKhT7eX.toURL().openConnection();
			hhUN2z0j = ImageIO.read(P2qILImC.getInputStream());
		} catch (UnknownHostException sQVa6YBE) {
			LOGGER.error("Google static MAPS web service is not reachable (UnknownHostException).", sQVa6YBE);
			hhUN2z0j = new BufferedImage(GoogleMapsUtils.defaultWidth, 100, BufferedImage.TYPE_INT_RGB);
			final Graphics2D tYgB5did = hhUN2z0j.createGraphics();
			final Map<Object, Object> e8Q9eViy = CollectionUtils.getHashMap();
			e8Q9eViy.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			tYgB5did.addRenderingHints(e8Q9eViy);
			tYgB5did.setBackground(Color.WHITE);
			tYgB5did.setColor(Color.GRAY);
			tYgB5did.clearRect(0, 0, GoogleMapsUtils.defaultWidth, 100);
			tYgB5did.drawString("Not Available", 30, 30);
		} catch (IOException ZjCWJNoV) {
			throw new IllegalStateException(ZjCWJNoV);
		}
		return hhUN2z0j;
	}

}