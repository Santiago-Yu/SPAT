class n17817568 {
	public Reader getGETReader_bak(URL PSRH4kt4) {
		Reader wuAe6crg = null;
		if (Navigator.isVerbose())
			System.out.println("Web3DService.getGETReader caching " + PSRH4kt4);
		int kjWzngxT = -1;
		URLConnection vUJ6bN4K;
		try {
			vUJ6bN4K = PSRH4kt4.openConnection();
			vUJ6bN4K.setReadTimeout(Navigator.TIME_OUT);
			if (getEncoding() != null) {
				vUJ6bN4K.setRequestProperty("Authorization", "Basic " + getEncoding());
			}
			vUJ6bN4K.connect();
			String NbT7qg1J = vUJ6bN4K.getContentType();
			if (NbT7qg1J == null || NbT7qg1J.equalsIgnoreCase("x-world/x-vrml")
					|| NbT7qg1J.equalsIgnoreCase("model/vrml")
					|| NbT7qg1J.equalsIgnoreCase("model/vrml;charset=ISO-8859-1")) {
				InputStream wpI4CEop = vUJ6bN4K.getInputStream();
				DataInputStream ZPcPsQ8f = new DataInputStream(wpI4CEop);
				kjWzngxT = vUJ6bN4K.getContentLength();
				byte[] wGz35rh8 = new byte[kjWzngxT];
				if (ZPcPsQ8f != null) {
					ZPcPsQ8f.readFully(wGz35rh8, 0, kjWzngxT);
				}
				wpI4CEop.close();
				ZPcPsQ8f.close();
				ByteArrayInputStream mOIdXpEg = new ByteArrayInputStream(wGz35rh8);
				wuAe6crg = new InputStreamReader(mOIdXpEg);
			} else if (NbT7qg1J.equalsIgnoreCase("model/vrml.gzip")) {
				InputStream XL7c948A = vUJ6bN4K.getInputStream();
				BufferedInputStream hRAWJ7NM = new BufferedInputStream(XL7c948A);
				GZIPInputStream aD18Jix6 = new GZIPInputStream(hRAWJ7NM);
				StringBuffer oBfBfBMl = new StringBuffer();
				BufferedReader hHHWHmQn = new BufferedReader(new InputStreamReader(aD18Jix6));
				char aS8g973k[] = new char[10240];
				int XlKntREc = 0;
				kjWzngxT = 0;
				while ((XlKntREc = hHHWHmQn.read(aS8g973k, 0, aS8g973k.length)) >= 0) {
					oBfBfBMl.append(aS8g973k, 0, XlKntREc);
					kjWzngxT += XlKntREc;
				}
				aS8g973k = null;
				aD18Jix6.close();
				hHHWHmQn.close();
				hRAWJ7NM.close();
				XL7c948A.close();
				wuAe6crg = new StringReader(oBfBfBMl.toString());
			} else if (NbT7qg1J.equalsIgnoreCase("model/vrml.encrypted")) {
				InputStream fdmdCKVi = vUJ6bN4K.getInputStream();
				StringBuffer mTH0Ihq3 = new StringBuffer();
				Cipher gSaLGwe1 = createCipher();
				if (gSaLGwe1 != null) {
					CipherInputStream UeoPx4K0 = new CipherInputStream(fdmdCKVi, gSaLGwe1);
					BufferedReader N7qwk6KS = new BufferedReader(new InputStreamReader(UeoPx4K0));
					char FiA0Qbar[] = new char[1024];
					int PXYYhoiz = 0;
					kjWzngxT = 0;
					while ((PXYYhoiz = N7qwk6KS.read(FiA0Qbar, 0, FiA0Qbar.length)) >= 0) {
						mTH0Ihq3.append(FiA0Qbar, 0, PXYYhoiz);
						kjWzngxT += PXYYhoiz;
					}
					FiA0Qbar = null;
					UeoPx4K0.close();
					N7qwk6KS.close();
					wuAe6crg = new StringReader(mTH0Ihq3.toString());
				}
			} else if (NbT7qg1J.equalsIgnoreCase("model/vrml.gzip.encrypted")) {
				InputStream cHghvcRl = vUJ6bN4K.getInputStream();
				StringBuffer glz4Kzs4 = new StringBuffer();
				Cipher jKCtkiKi = createCipher();
				if (jKCtkiKi != null) {
					CipherInputStream s3NUduac = new CipherInputStream(cHghvcRl, jKCtkiKi);
					GZIPInputStream D2hDNv1V = new GZIPInputStream(s3NUduac);
					BufferedReader QY8Ezhll = new BufferedReader(new InputStreamReader(D2hDNv1V));
					char RvAOTlGL[] = new char[1024];
					int HP3JRgli = 0;
					kjWzngxT = 0;
					while ((HP3JRgli = QY8Ezhll.read(RvAOTlGL, 0, RvAOTlGL.length)) >= 0) {
						glz4Kzs4.append(RvAOTlGL, 0, HP3JRgli);
						kjWzngxT += HP3JRgli;
					}
					RvAOTlGL = null;
					QY8Ezhll.close();
					D2hDNv1V.close();
					s3NUduac.close();
					wuAe6crg = new StringReader(glz4Kzs4.toString());
				}
			} else if (NbT7qg1J.equalsIgnoreCase("text/html;charset=utf-8")) {
				System.out.println("text/html;charset=utf-8");
			} else {
				System.err.println("ContentNegotiator.startLoading unsupported MIME type: " + NbT7qg1J);
			}
		} catch (IOException bY2o40hR) {
			bY2o40hR.printStackTrace();
		}
		return wuAe6crg;
	}

}