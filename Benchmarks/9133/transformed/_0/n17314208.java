class n17314208 {
	public static void main(final String[] rTd3uGe9) {
		if ((rTd3uGe9.length < 1)) {
			String Xis333zn = "1. _BIZVIEW=<filename>or<XAware Bizview name> \r\n";
			Xis333zn += "2. _OUTPUT=DISPLAY|NONE|FILE \r\n";
			Xis333zn += "3. _GEN_OUT=<output filename> \r\n";
			Xis333zn += "4. _POST or _XADATA=<xml data file> \r\n";
			Xis333zn += "5. _UID<=user id> \r\n";
			Xis333zn += "6. _PWD=<password> \r\n";
			Xis333zn += "7. _URL=<appserver url> \r\n";
			Xis333zn += "8. <param>=<value> \r\n";
			System.out.println("Usage: java XABizDoc. Other optional parameters include\r\n" + Xis333zn);
			return;
		}
		final String kNCfpbL8 = System.getProperty("xaware.home");
		if (kNCfpbL8 == null) {
			System.out.println(
					"System property xaware.home not set. Please set xaware.home to XAware installation root directory");
			return;
		}
		if (new File(kNCfpbL8).isDirectory() == false) {
			System.out
					.println(kNCfpbL8 + " is not a valid directory. Please check value of xaware.home system property");
			return;
		}
		System.out.println("Starting XAServletBizDoc Version:" + version);
		sUid = "";
		sPwd = "";
		String FKtIVkf5 = rTd3uGe9[0];
		if (rTd3uGe9[0].startsWith(BIZVIEW)) {
			FKtIVkf5 = rTd3uGe9[0].substring(BIZVIEW.length() + 1);
		}
		if (rTd3uGe9[0].startsWith(XQUERY)) {
			sXQuery = rTd3uGe9[0].substring(XQUERY.length() + 1);
		}
		for (int VsYDKfPl = 1; VsYDKfPl < rTd3uGe9.length; VsYDKfPl++) {
			if (rTd3uGe9[VsYDKfPl].startsWith(SAXDRIVER)) {
				saxDriverClass = rTd3uGe9[VsYDKfPl].substring(SAXDRIVER.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(OUTPUT)) {
				sOutput = rTd3uGe9[VsYDKfPl].substring(OUTPUT.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(FACTORY)) {
				sEjbJndiFactory = rTd3uGe9[VsYDKfPl].substring(FACTORY.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(URL)) {
				sServletUrl = rTd3uGe9[VsYDKfPl].substring(URL.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(COMPRESS)) {
				final String xyt8Skec = rTd3uGe9[VsYDKfPl].substring(COMPRESS.length() + 1);
				if (xyt8Skec.compareTo("YES") == 0) {
					bCompress = true;
				}
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(GEN_OUT)) {
				sGenOut = rTd3uGe9[VsYDKfPl].substring(GEN_OUT.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(UID)) {
				sUid = rTd3uGe9[VsYDKfPl].substring(UID.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(PWD)) {
				sPwd = rTd3uGe9[VsYDKfPl].substring(PWD.length() + 1);
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(POST)) {
				sXmlDataFile = rTd3uGe9[VsYDKfPl].substring(POST.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid POST value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(XADATA)) {
				sXmlDataFile = rTd3uGe9[VsYDKfPl].substring(XADATA.length() + 1);
				if (validateFile(sXmlDataFile) == false) {
					System.err.println("Invalid XADATA value");
					sXmlDataFile = null;
				}
				continue;
			}
			if (rTd3uGe9[VsYDKfPl].startsWith(CONFIG)) {
				sConfigFile = rTd3uGe9[VsYDKfPl].substring(CONFIG.length() + 1);
				if (validateFile(sConfigFile) == true) {
					XAwareConfig.SetConfigFile(sConfigFile);
				} else {
					System.err.println("Invalid CONFIG value");
				}
				continue;
			}
		}
		String LfPuMs8t = "";
		try {
			sServletUrl += "?_BIZVIEW=" + FKtIVkf5;
			for (int TTDydLQC = 1; TTDydLQC < rTd3uGe9.length; TTDydLQC++) {
				if (rTd3uGe9[TTDydLQC].charAt(0) != '_') {
					String tNTMv5rx = URLEncoder.encode(rTd3uGe9[TTDydLQC]);
					final int ZNfJIJrP = tNTMv5rx.indexOf("%3D");
					if (ZNfJIJrP >= 0) {
						final String ZIZ0l9JD = tNTMv5rx.substring(0, ZNfJIJrP);
						tNTMv5rx = ZIZ0l9JD + "=" + tNTMv5rx.substring(ZNfJIJrP + 3);
					}
					sServletUrl += "&" + tNTMv5rx;
				}
			}
			final URL ThReUdSW = new URL(sServletUrl);
			final HttpURLConnection c6mZSG9x = (HttpURLConnection) ThReUdSW.openConnection();
			c6mZSG9x.setDoInput(true);
			if (sXmlDataFile != null && sXmlDataFile.length() > 0) {
				c6mZSG9x.setRequestMethod("POST");
			} else {
				c6mZSG9x.setRequestMethod("GET");
			}
			String ULpzvM1y = "";
			if (sXmlDataFile != null && sXmlDataFile.length() > 0) {
				SAXBuilder EIyOInXi = null;
				if (saxDriverClass.length() > 0) {
					EIyOInXi = new SAXBuilder(saxDriverClass);
				} else {
					EIyOInXi = new SAXBuilder();
				}
				final Document S5iBH3pJ = EIyOInXi.build(new File(sXmlDataFile));
				final StringWriter NdmAwHmH = new StringWriter();
				final XMLOutputter Cs6LRPk0 = new XMLOutputter();
				Cs6LRPk0.output(S5iBH3pJ, NdmAwHmH);
				ULpzvM1y = NdmAwHmH.toString();
			}
			if (ULpzvM1y.length() > 0) {
				if (c6mZSG9x.getDoOutput() == false) {
					c6mZSG9x.setDoOutput(true);
				}
				final OutputStream wPh7qwfi = c6mZSG9x.getOutputStream();
				wPh7qwfi.write(ULpzvM1y.getBytes());
				wPh7qwfi.close();
			}
			final InputStream Yk67P73m = c6mZSG9x.getInputStream();
			final BufferedReader s59ksk4V = new BufferedReader(new InputStreamReader(Yk67P73m));
			int fYFUGs4a;
			final StringBuffer UgOwSsNN = new StringBuffer(1000);
			while ((fYFUGs4a = s59ksk4V.read()) != -1) {
				UgOwSsNN.append((char) fYFUGs4a);
			}
			LfPuMs8t = UgOwSsNN.toString();
		} catch (final IOException GweqbP3T) {
			System.out.println("IO exception:" + GweqbP3T.getMessage());
		} catch (final Exception Md6WbaNh) {
			System.out.println("Unknown exception:" + Md6WbaNh.getMessage());
		}
		if ((sOutput.compareTo("STREAM") == 0) || (sOutput.compareTo("NONE") == 0)) {
			return;
		}
		if (sGenOut != null && sGenOut.length() > 0) {
			try {
				final FileWriter Kf4swr4o = new FileWriter(sGenOut, false);
				Kf4swr4o.write(LfPuMs8t);
				Kf4swr4o.close();
			} catch (final IOException btL2gNzD) {
				System.out.println("IO exception saving to file:" + btL2gNzD.getMessage());
			}
		}
		if (sOutput != null && sOutput.compareTo("DISPLAY") == 0) {
			System.out.println(LfPuMs8t);
		}
	}

}