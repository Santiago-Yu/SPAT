class n3022474 {
	public static boolean isAnimated(Icon icon) {
		if (icon instanceof ImageIcon) {
			Image image = ((ImageIcon) icon).getImage();
			if (image != null) {
				Object comment = image.getProperty("comment", null);
				if (decoded.containsKey(image)) {
					return Boolean.TRUE.equals(decoded.get(image));
				}
				if (String.valueOf(comment).startsWith("GifBuilder"))
					return true;
				InputStream is = null;
				try {
					URL url = new URL(icon.toString());
					is = url.openConnection().getInputStream();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (is == null) {
					try {
						ImageProducer p = image.getSource();
						if (p instanceof InputStreamImageSource) {
							Method m = InputStreamImageSource.class.getDeclaredMethod("getDecoder", null);
							m.setAccessible(true);
							ImageDecoder d = (ImageDecoder) m.invoke(p, null);
							if (d instanceof GifImageDecoder) {
								Field input = ImageDecoder.class.getDeclaredField("input");
								GifImageDecoder gd = (GifImageDecoder) d;
								input.setAccessible(true);
								is = (InputStream) input.get(gd);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (is != null) {
					GifDecoder decoder = new GifDecoder();
					decoder.read(is);
					boolean animated = decoder.getFrameCount() > 1;
					decoded.put(image, Boolean.valueOf(animated));
					return animated;
				}
			}
			return false;
		}
		return icon instanceof AnimatedIcon;
	}

}