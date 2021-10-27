class n11645260 {
	public void doGet(HttpServletRequest jx5SkFe9, HttpServletResponse BoXVKDIS) throws ServletException, IOException {
		String QzJYzmkk = null;
		boolean AkJ9AAGb = false;
		try {
			URL ZFRZ7ly7 = new URL("http:/" + jx5SkFe9.getPathInfo());
			for (Enumeration iwWB5vcb = allowedUrls.elements(); iwWB5vcb.hasMoreElements();) {
				URL FntWtwhF = (URL) iwWB5vcb.nextElement();
				if ((FntWtwhF).getHost().equalsIgnoreCase(ZFRZ7ly7.getHost())) {
					AkJ9AAGb = true;
				}
			}
		} catch (MalformedURLException mJetSqMv) {
			System.err.println("Error in url: " + "http:/" + jx5SkFe9.getPathInfo());
			return;
		}
		if (!AkJ9AAGb) {
			BoXVKDIS.setStatus(407);
			return;
		}
		if (jx5SkFe9.getPathInfo() != null && !jx5SkFe9.getPathInfo().equals("")) {
			QzJYzmkk = "http:/" + jx5SkFe9.getPathInfo() + "?" + jx5SkFe9.getQueryString();
		} else {
			BoXVKDIS.setStatus(404);
			return;
		}
		InputStream VIZoJOhZ = null;
		ServletOutputStream gdcvV29m = null;
		try {
			URL lfa5GfNW = new URL(QzJYzmkk);
			URLConnection k0Hu1YiT = lfa5GfNW.openConnection();
			BoXVKDIS.setContentType(k0Hu1YiT.getContentType());
			VIZoJOhZ = k0Hu1YiT.getInputStream();
			gdcvV29m = BoXVKDIS.getOutputStream();
			byte[] efDxG9EE = new byte[4096];
			int iosOztyW;
			while ((iosOztyW = VIZoJOhZ.read(efDxG9EE)) != -1) {
				gdcvV29m.write(efDxG9EE, 0, iosOztyW);
			}
		} catch (MalformedURLException klgC6WXo) {
			BoXVKDIS.setStatus(404);
		} catch (IOException tixO9RoG) {
			BoXVKDIS.setStatus(404);
		} finally {
			if (VIZoJOhZ != null) {
				VIZoJOhZ.close();
			}
			if (gdcvV29m != null) {
				gdcvV29m.close();
			}
		}
	}

}