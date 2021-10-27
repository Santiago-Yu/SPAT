class n15702555 {
	@Override
	public BufferedImageAndBytes load(T thing) {
		URL url;
		String iurl = resolver.getUrl(thing);
		for (int k = 0; k < nTries; k++) {
			if (k > 0) {
				logger.debug("retry #" + k);
			}
			try {
				url = new URL(iurl);
				URLConnection connection = url.openConnection();
				if (userAgent != null) {
					connection.setRequestProperty("User-Agent", userAgent);
				}
				ByteArrayOutputStream baos = new ByteArrayOutputStream(40000);
				InputStream is = new BufferedInputStream(connection.getInputStream());
				int b;
				while ((b = is.read()) != -1) {
					baos.write(b);
				}
				is.close();
				byte[] bytes = baos.toByteArray();
				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				BufferedImage image = ImageIO.read(bais);
				return new BufferedImageAndBytes(image, bytes);
			} catch (MalformedURLException e) {
				continue;
			} catch (IOException e) {
				continue;
			}
		}
		return null;
	}

}