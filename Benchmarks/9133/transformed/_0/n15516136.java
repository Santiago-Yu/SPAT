class n15516136 {
	public static synchronized BufferedImage loadBufferedJPEGImage(URL A1l5m03S) {
		BufferedImage hjiVM0Cj = null;
		if (A1l5m03S != null) {
			InputStream o4KseiSC = null;
			try {
				o4KseiSC = A1l5m03S.openStream();
				JPEGImageDecoder XLLnwhPM = JPEGCodec.createJPEGDecoder(o4KseiSC);
				hjiVM0Cj = XLLnwhPM.decodeAsBufferedImage();
			} catch (Exception K5h7yJkP) {
				log.severe("URL: " + A1l5m03S + " - " + K5h7yJkP.getMessage());
				hjiVM0Cj = null;
			} finally {
				try {
					if (o4KseiSC != null)
						o4KseiSC.close();
				} catch (IOException Lzvybpua) {
					log.severe("URL: " + A1l5m03S + " - " + Lzvybpua.getMessage());
				}
			}
			if (hjiVM0Cj != null) {
				log.config("Image type : " + hjiVM0Cj.getType());
				if (hjiVM0Cj.getWidth() <= 0 || hjiVM0Cj.getHeight() <= 0) {
					log.severe("URL: " + A1l5m03S + " =0");
					hjiVM0Cj = null;
				}
			}
		}
		return hjiVM0Cj;
	}

}