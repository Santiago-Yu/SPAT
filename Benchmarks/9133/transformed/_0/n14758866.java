class n14758866 {
	public synchronized InputStream getResourceAsStream(String dh6XEWCD) {
		InputStream VPCuap6W = null;
		BufferedInputStream g6eDIceP = null;
		BufferedOutputStream Z1zdqRFp = null;
		try {
			URL EUaN2WMj = getResource(dh6XEWCD);
			String tymotamX = EUaN2WMj.toExternalForm();
			String tGXJo1kX = (String) cacheHashtable.get(tymotamX);
			if (tGXJo1kX != null) {
				System.out.println("Retrieving \"" + tGXJo1kX + "\"...");
				return new FileInputStream(tGXJo1kX);
			}
			String uEJqjHmk = EUaN2WMj.getHost();
			String gHcs47el = EUaN2WMj.getProtocol();
			int tbFvhRdY = EUaN2WMj.getPort();
			File kdVn3pff = new File(cacheDir, gHcs47el + File.separator + uEJqjHmk + File.separator + "port"
					+ (tbFvhRdY == -1 ? "" : Integer.toString(tbFvhRdY)) + File.separator + dh6XEWCD);
			kdVn3pff = new File(kdVn3pff.getCanonicalPath());
			tGXJo1kX = kdVn3pff.getCanonicalPath();
			System.out.println("Comparing \"" + tGXJo1kX + "\"...");
			URLConnection IIYgbhW7 = EUaN2WMj.openConnection();
			if (kdVn3pff.exists()) {
				IIYgbhW7.setIfModifiedSince(kdVn3pff.lastModified());
			}
			if (IIYgbhW7 instanceof HttpURLConnection) {
				HttpURLConnection j3VzCK6e = (HttpURLConnection) IIYgbhW7;
				j3VzCK6e.setFollowRedirects(true);
				j3VzCK6e.setRequestMethod("GET");
				int PreMkSQb = j3VzCK6e.getResponseCode();
				System.out.println(j3VzCK6e.getResponseMessage() + ", " + j3VzCK6e.getContentLength() + " bytes" + ", "
						+ new Date(j3VzCK6e.getDate()) + ", " + new Date(j3VzCK6e.getLastModified()));
				if (PreMkSQb != HttpURLConnection.HTTP_OK) {
					return null;
				}
			}
			VPCuap6W = IIYgbhW7.getInputStream();
			if (VPCuap6W == null)
				return null;
			if (kdVn3pff.exists()) {
				long M1SzPQmq = IIYgbhW7.getLastModified();
				if ((M1SzPQmq > 0) && (M1SzPQmq < kdVn3pff.lastModified())) {
					VPCuap6W.close();
					cacheHashtable.put(tymotamX, tGXJo1kX);
					System.out.println("Retrieving \"" + tGXJo1kX + "\"...");
					return new FileInputStream(kdVn3pff);
				}
			}
			File KqCVZDiJ = new File(kdVn3pff.getParent());
			KqCVZDiJ.mkdirs();
			tGXJo1kX = kdVn3pff.getCanonicalPath();
			System.out.println("CACHING \"" + tGXJo1kX + "\"...");
			g6eDIceP = new BufferedInputStream(VPCuap6W);
			Z1zdqRFp = new BufferedOutputStream(new FileOutputStream(kdVn3pff));
			int ZdFa3buz;
			while ((ZdFa3buz = g6eDIceP.read()) > -1)
				Z1zdqRFp.write(ZdFa3buz);
			Z1zdqRFp.close();
			g6eDIceP.close();
			cacheHashtable.put(tymotamX, tGXJo1kX);
			System.out.println("Retrieving \"" + tGXJo1kX + "\"...");
			return new FileInputStream(tGXJo1kX);
		} catch (Exception ir1ru99c) {
			try {
				VPCuap6W.close();
			} catch (Exception rQkrHFt1) {
			}
			try {
				g6eDIceP.close();
			} catch (Exception j4S7dZHO) {
			}
			try {
				Z1zdqRFp.close();
			} catch (Exception bTQItDm9) {
			}
			ir1ru99c.printStackTrace();
			return null;
		}
	}

}