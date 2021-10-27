class n3573409 {
	public synchronized void handleRequest(HttpServletRequest y9qOg2vF, HttpServletResponse xiWJY4kJ)
			throws ServletException, IOException {
		CacheEntry quwDcNDk = null;
		Tenant QbEgozv4 = null;
		if (!tenantInfo.getTenants().isEmpty()) {
			QbEgozv4 = tenantInfo.getMatchingTenant(y9qOg2vF);
			if (QbEgozv4 == null) {
				QbEgozv4 = tenantInfo.getTenants().get(0);
			}
			quwDcNDk = tenantToCacheEntry.get(QbEgozv4.getName());
		} else {
			quwDcNDk = cacheEntry;
		}
		if (quwDcNDk == null) {
			File D2SeaXIJ = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			D2SeaXIJ = new File(D2SeaXIJ, "pustefix-sitemap-cache");
			if (!D2SeaXIJ.exists()) {
				D2SeaXIJ.mkdirs();
			}
			quwDcNDk = new CacheEntry();
			quwDcNDk.file = new File(D2SeaXIJ, "sitemap" + (QbEgozv4 == null ? "" : "-" + QbEgozv4.getName()) + ".xml");
			try {
				String enf9hyxt = AbstractPustefixRequestHandler.getServerName(y9qOg2vF);
				Document qlcZgkhE = getSearchEngineSitemap(QbEgozv4, enf9hyxt);
				Transformer filXXD1s = TransformerFactory.newInstance().newTransformer();
				filXXD1s.setOutputProperty(OutputKeys.INDENT, "yes");
				FileOutputStream r4CfZYfF = new FileOutputStream(quwDcNDk.file);
				MessageDigest wSsWTzn0;
				try {
					wSsWTzn0 = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException XNKLk3b0) {
					throw new RuntimeException("Can't create message digest", XNKLk3b0);
				}
				DigestOutputStream ynszj1r8 = new DigestOutputStream(r4CfZYfF, wSsWTzn0);
				filXXD1s.transform(new DOMSource(qlcZgkhE), new StreamResult(ynszj1r8));
				ynszj1r8.close();
				byte[] LJds1v1z = wSsWTzn0.digest();
				quwDcNDk.etag = MD5Utils.byteToHex(LJds1v1z);
			} catch (Exception q18mhKlP) {
				throw new ServletException("Error creating sitemap", q18mhKlP);
			}
		}
		String QJR5AyJG = y9qOg2vF.getHeader("If-None-Match");
		if (QJR5AyJG != null) {
			if (quwDcNDk.etag.equals(QJR5AyJG)) {
				xiWJY4kJ.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				xiWJY4kJ.flushBuffer();
				return;
			}
		}
		long E8FSmc0j = y9qOg2vF.getDateHeader("If-Modified-Since");
		if (E8FSmc0j != -1) {
			if (quwDcNDk.file.lastModified() < E8FSmc0j + 1000) {
				xiWJY4kJ.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				xiWJY4kJ.flushBuffer();
				return;
			}
		}
		xiWJY4kJ.setContentType("application/xml");
		xiWJY4kJ.setContentLength((int) quwDcNDk.file.length());
		xiWJY4kJ.setDateHeader("Last-Modified", quwDcNDk.file.lastModified());
		xiWJY4kJ.setHeader("ETag", quwDcNDk.etag);
		OutputStream qZdRdTlZ = new BufferedOutputStream(xiWJY4kJ.getOutputStream());
		InputStream PsLmJgA2 = new FileInputStream(quwDcNDk.file);
		int Y5t21zhF;
		byte[] y0hsLKKa = new byte[8];
		while ((Y5t21zhF = PsLmJgA2.read(y0hsLKKa)) != -1) {
			qZdRdTlZ.write(y0hsLKKa, 0, Y5t21zhF);
		}
		qZdRdTlZ.flush();
		PsLmJgA2.close();
		qZdRdTlZ.close();
	}

}