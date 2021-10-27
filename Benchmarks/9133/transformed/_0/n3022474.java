class n3022474 {
	public static boolean isAnimated(Icon XmRZRFYK) {
		if (XmRZRFYK instanceof ImageIcon) {
			Image nMG7wBKv = ((ImageIcon) XmRZRFYK).getImage();
			if (nMG7wBKv != null) {
				Object wErvhv7H = nMG7wBKv.getProperty("comment", null);
				if (String.valueOf(wErvhv7H).startsWith("GifBuilder"))
					return true;
				if (decoded.containsKey(nMG7wBKv)) {
					return Boolean.TRUE.equals(decoded.get(nMG7wBKv));
				}
				InputStream uxPWP3QB = null;
				try {
					URL nLefQ4sX = new URL(XmRZRFYK.toString());
					uxPWP3QB = nLefQ4sX.openConnection().getInputStream();
				} catch (Exception tYAiIhQ6) {
					tYAiIhQ6.printStackTrace();
				}
				if (uxPWP3QB == null) {
					try {
						ImageProducer JIhTAAC3 = nMG7wBKv.getSource();
						if (JIhTAAC3 instanceof InputStreamImageSource) {
							Method xLhCn7H2 = InputStreamImageSource.class.getDeclaredMethod("getDecoder", null);
							xLhCn7H2.setAccessible(true);
							ImageDecoder Xsgvup2J = (ImageDecoder) xLhCn7H2.invoke(JIhTAAC3, null);
							if (Xsgvup2J instanceof GifImageDecoder) {
								GifImageDecoder uucPCTU3 = (GifImageDecoder) Xsgvup2J;
								Field UdfRwyh1 = ImageDecoder.class.getDeclaredField("input");
								UdfRwyh1.setAccessible(true);
								uxPWP3QB = (InputStream) UdfRwyh1.get(uucPCTU3);
							}
						}
					} catch (Exception fCtJUwPJ) {
						fCtJUwPJ.printStackTrace();
					}
				}
				if (uxPWP3QB != null) {
					GifDecoder TWokt1Hq = new GifDecoder();
					TWokt1Hq.read(uxPWP3QB);
					boolean ndrzkWi4 = TWokt1Hq.getFrameCount() > 1;
					decoded.put(nMG7wBKv, Boolean.valueOf(ndrzkWi4));
					return ndrzkWi4;
				}
			}
			return false;
		}
		return XmRZRFYK instanceof AnimatedIcon;
	}

}