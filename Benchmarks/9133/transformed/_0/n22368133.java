class n22368133 {
	public static void testMapSource(MapSource afb7L4PL, EastNorthCoordinate jpBzlYC2) {
		try {
			System.out.println("Testing " + afb7L4PL.toString());
			int j5w5Wlso = afb7L4PL.getMinZoom() + ((afb7L4PL.getMaxZoom() - afb7L4PL.getMinZoom()) / 2);
			MapSpace fr1PMlyG = afb7L4PL.getMapSpace();
			int MDa8cx0t = fr1PMlyG.cLonToX(jpBzlYC2.lon, j5w5Wlso) / fr1PMlyG.getTileSize();
			int u8XZxMdX = fr1PMlyG.cLatToY(jpBzlYC2.lat, j5w5Wlso) / fr1PMlyG.getTileSize();
			url = new URL(afb7L4PL.getTileUrl(j5w5Wlso, MDa8cx0t, u8XZxMdX));
			System.out.println("Sample url: " + url);
			c = (HttpURLConnection) url.openConnection();
			System.out.println("Connecting...");
			c.connect();
			System.out.println("Connection established - response HTTP " + c.getResponseCode());
			if (c.getResponseCode() != 200)
				return;
			String pG2qqTLd = c.getContentType();
			System.out.print("Image format          : ");
			if ("image/png".equals(pG2qqTLd))
				System.out.println("png");
			else if ("image/jpeg".equals(pG2qqTLd))
				System.out.println("jpg");
			else
				System.out.println("unknown");
			String GI5XBxTZ = c.getHeaderField("ETag");
			boolean LRtxfRCh = (GI5XBxTZ != null);
			if (LRtxfRCh) {
				System.out.println("eTag                  : " + GI5XBxTZ);
				testIfNoneMatch();
			} else
				System.out.println("eTag                  : -");
			long Ynfqad8Z = c.getDate();
			if (Ynfqad8Z == 0)
				System.out.println("Date time             : -");
			else
				System.out.println("Date time             : " + new Date(Ynfqad8Z));
			long OVyYWiXb = c.getExpiration();
			if (OVyYWiXb == 0)
				System.out.println("Expiration time       : -");
			else
				System.out.println("Expiration time       : " + new Date(OVyYWiXb));
			long zf2R2T4u = c.getLastModified();
			if (zf2R2T4u == 0)
				System.out.println("Last modified time    : not set");
			else
				System.out.println("Last modified time    : " + new Date(zf2R2T4u));
			testIfModified();
		} catch (Exception ovdvi2NS) {
			ovdvi2NS.printStackTrace();
		}
		System.out.println("\n");
	}

}