class n22870704 {
	public static byte[] readHTTPFile(String fYGjNri6, StringBuffer HEOXiBb5, StringBuffer gQtUY7qP) {
		try {
			URL sCaSsabM = new URL(fYGjNri6);
			URLConnection kw87B2zK = sCaSsabM.openConnection();
			kw87B2zK.setReadTimeout(10 * 1000);
			kw87B2zK.setConnectTimeout(10 * 1000);
			kw87B2zK.setDoInput(true);
			kw87B2zK.setDoOutput(false);
			String EbXqOhbS = kw87B2zK.getHeaderField(null).toLowerCase();
			String ukYZdbpv = kw87B2zK.getHeaderField("Location");
			String XLjQukt7 = kw87B2zK.getHeaderField("Set-Cookie");
			int ElYP4T7h = 0;
			while ((EbXqOhbS.indexOf("http/1.1 3") >= 0 || EbXqOhbS.indexOf("http/1.0 3") >= 0)
					&& !HelperStd.isEmpty(ukYZdbpv)) {
				if (!HelperStd.isEmpty(kw87B2zK.getHeaderField("Set-Cookie")))
					XLjQukt7 = kw87B2zK.getHeaderField("Set-Cookie");
				sCaSsabM = new URL(ukYZdbpv);
				kw87B2zK = sCaSsabM.openConnection();
				kw87B2zK.setReadTimeout(10 * 1000);
				kw87B2zK.setConnectTimeout(10 * 1000);
				kw87B2zK.setDoInput(true);
				kw87B2zK.setDoOutput(false);
				kw87B2zK.setRequestProperty("Cookie", XLjQukt7);
				EbXqOhbS = kw87B2zK.getHeaderField(null).toLowerCase();
				ukYZdbpv = kw87B2zK.getHeaderField("Location");
				ElYP4T7h++;
				if (ElYP4T7h > 10)
					break;
			}
			System.out.println(kw87B2zK.getHeaderField(null) + ":" + kw87B2zK.getContentLength() + ":" + sCaSsabM);
			if (HEOXiBb5 != null)
				HEOXiBb5.append(kw87B2zK.getContentType());
			if (gQtUY7qP != null) {
				String IoyodXQL = null, xmd8yVed = kw87B2zK.getContentType();
				if (xmd8yVed != null && xmd8yVed.indexOf("charset=") > 0) {
					int TvwNM8vt = xmd8yVed.indexOf("charset=") + "charset=".length();
					IoyodXQL = xmd8yVed.substring(TvwNM8vt);
				}
				if (IoyodXQL == null)
					IoyodXQL = kw87B2zK.getContentEncoding();
				if (IoyodXQL == null)
					IoyodXQL = "ISO-8859-1";
				gQtUY7qP.append(IoyodXQL);
			}
			BufferedInputStream DVE793GI = new BufferedInputStream(kw87B2zK.getInputStream());
			ByteArrayOutputStream xIK8240X = new ByteArrayOutputStream();
			byte[] tQgKqYm8 = new byte[1024];
			int hpmaKxZ7 = 0;
			while (hpmaKxZ7 != -1) {
				hpmaKxZ7 = DVE793GI.read(tQgKqYm8);
				if (hpmaKxZ7 > 0)
					xIK8240X.write(tQgKqYm8, 0, hpmaKxZ7);
			}
			DVE793GI.close();
			System.out.println(xIK8240X.size());
			return xIK8240X.toByteArray();
		} catch (Exception GGntC02H) {
			GGntC02H.printStackTrace();
			System.out.println("readHTTPFile:" + GGntC02H.getMessage() + "," + fYGjNri6);
		}
		return new byte[0];
	}

}