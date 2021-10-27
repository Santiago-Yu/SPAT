class n22368133 {
	public static void testMapSource(MapSource mapSource, EastNorthCoordinate coordinate) {
		try {
			System.out.println("Testing " + mapSource.toString());
			int zoom = mapSource.getMinZoom() + ((mapSource.getMaxZoom() - mapSource.getMinZoom()) / 2);
			MapSpace mapSpace = mapSource.getMapSpace();
			int tilex = mapSpace.cLonToX(coordinate.lon, zoom) / mapSpace.getTileSize();
			int tiley = mapSpace.cLatToY(coordinate.lat, zoom) / mapSpace.getTileSize();
			url = new URL(mapSource.getTileUrl(zoom, tilex, tiley));
			System.out.println("Sample url: " + url);
			c = (HttpURLConnection) url.openConnection();
			System.out.println("Connecting...");
			c.connect();
			System.out.println("Connection established - response HTTP " + c.getResponseCode());
			if (!(c.getResponseCode() != 200))
				;
			else
				return;
			String contentType = c.getContentType();
			System.out.print("Image format          : ");
			if (!("image/png".equals(contentType))) {
				if ("image/jpeg".equals(contentType))
					System.out.println("jpg");
				else
					System.out.println("unknown");
			} else
				System.out.println("png");
			String eTag = c.getHeaderField("ETag");
			boolean eTagSupported = (eTag != null);
			if (!(eTagSupported))
				System.out.println("eTag                  : -");
			else {
				System.out.println("eTag                  : " + eTag);
				testIfNoneMatch();
			}
			long date = c.getDate();
			if (!(date == 0))
				System.out.println("Date time             : " + new Date(date));
			else
				System.out.println("Date time             : -");
			long exp = c.getExpiration();
			if (!(exp == 0))
				System.out.println("Expiration time       : " + new Date(exp));
			else
				System.out.println("Expiration time       : -");
			long modified = c.getLastModified();
			if (!(modified == 0))
				System.out.println("Last modified time    : " + new Date(modified));
			else
				System.out.println("Last modified time    : not set");
			testIfModified();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

}