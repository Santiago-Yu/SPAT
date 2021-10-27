class n6740358{
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Image getGoogleMapImage(final BigDecimal latitude, final BigDecimal longitude, final Integer zoomLevel) {
        if (longitude == null) {
            throw new IllegalArgumentException("Longitude cannot be null.");
        }
        if (latitude == null) {
            throw new IllegalArgumentException("Latitude cannot be null.");
        }
        if (zoomLevel == null) {
            throw new IllegalArgumentException("ZoomLevel cannot be null.");
        }
        final URI url = GoogleMapsUtils.buildGoogleMapsStaticUrl(latitude, longitude, zoomLevel);
        BufferedImage img;
        try {
            URLConnection conn = url.toURL().openConnection();
            img = ImageIO.read(conn.getInputStream());
        } catch (UnknownHostException e) {
            LOGGER.error("Google static MAPS web service is not reachable (UnknownHostException).", e);
            img = new BufferedImage(GoogleMapsUtils.defaultWidth, 100, BufferedImage.TYPE_INT_RGB);
            final Graphics2D graphics = img.createGraphics();
            final Map<Object, Object> renderingHints = CollectionUtils.getHashMap();
            renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.addRenderingHints(renderingHints);
            graphics.setBackground(Color.WHITE);
            graphics.setColor(Color.GRAY);
            graphics.clearRect(0, 0, GoogleMapsUtils.defaultWidth, 100);
            graphics.drawString("Not Available", 30, 30);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return img;
    }

}