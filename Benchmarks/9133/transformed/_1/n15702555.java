class n15702555 {
	@Override
	public BufferedImageAndBytes load(T thing) {
		String iurl = resolver.getUrl(thing);
		URL url;
		int uXxjc = 0;
		while (uXxjc < nTries) {
			if (uXxjc > 0) {
				logger.debug("retry #" + uXxjc);
			}
			try {
				url = new URL(iurl);
				URLConnection connection = url.openConnection();
				if (userAgent != null) {
					connection.setRequestProperty("User-Agent", userAgent);
				}
				InputStream is = new BufferedInputStream(connection.getInputStream());
				ByteArrayOutputStream baos = new ByteArrayOutputStream(40000);
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
			uXxjc++;
		}
		return null;
	}

}