class n19235554 {
	protected BufferedImage handleKBRException() {
		if (params.uri.startsWith("http://mara.kbr.be/kbrImage/CM/")
				|| params.uri.startsWith("http://mara.kbr.be/kbrImage/maps/")
				|| params.uri.startsWith("http://opteron2.kbr.be/kp/viewer/"))
			try {
				URLConnection zFHDJEKM = new URL(params.uri).openConnection();
				String RQRP1Twv = "get_image.php?intId=";
				BufferedReader FHWMqqW2 = new BufferedReader(new InputStreamReader(zFHDJEKM.getInputStream()));
				String A4IINST2 = null;
				while ((A4IINST2 = FHWMqqW2.readLine()) != null) {
					if (A4IINST2.indexOf(RQRP1Twv) != -1) {
						A4IINST2 = A4IINST2.substring(A4IINST2.indexOf(RQRP1Twv));
						RQRP1Twv = "http://mara.kbr.be/kbrImage/" + A4IINST2.substring(0, A4IINST2.indexOf("\""));
						break;
					}
				}
				zFHDJEKM = new URL(RQRP1Twv).openConnection();
				return processNewUri(zFHDJEKM);
			} catch (Exception roeqOpdR) {
				try {
					String KXgpmAvA = "http://mara.kbr.be/xlimages/maps/thumbnails"
							+ params.uri.substring(params.uri.lastIndexOf("/")).replace(".imgf", ".jpg");
					if (KXgpmAvA != null) {
						URLConnection FrtKmya5 = new URL(KXgpmAvA).openConnection();
						return processNewUri(FrtKmya5);
					}
				} catch (Exception w3yBltHp) {
				}
			}
		return null;
	}

}