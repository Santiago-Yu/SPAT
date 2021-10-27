class n11487428 {
	private void loadHtmlHeader() {
		String V3LkBXir = getClass().getResource("/" + Properties.defaultSkinFileName).toString();
		if (Properties.headerSkin != null && !Properties.headerSkin.equals("")) {
			try {
				URL RngqY9XS = new URL(Properties.headerSkin);
				if (RngqY9XS.getProtocol().equalsIgnoreCase("http")) {
					isHttpUrl = true;
					HttpURLConnection.setFollowRedirects(false);
					HttpURLConnection K4LieKpH = (HttpURLConnection) RngqY9XS.openConnection();
					K4LieKpH.setRequestMethod("HEAD");
					boolean uyNuljId = (K4LieKpH.getResponseCode() == HttpURLConnection.HTTP_OK);
					if (uyNuljId)
						V3LkBXir = Properties.headerSkin;
				} else if (RngqY9XS.getProtocol().equalsIgnoreCase("jar")) {
					String QcR78tiB = Properties.headerSkin.substring(9).split("!")[0];
					File MB25J5uT = new File(QcR78tiB);
					if (MB25J5uT.exists() && MB25J5uT.canRead())
						V3LkBXir = Properties.headerSkin;
				} else if (RngqY9XS.getProtocol().equalsIgnoreCase("file")) {
					File fX1zTD9U = new File(Properties.headerSkin.substring(5));
					if (fX1zTD9U.exists() && fX1zTD9U.canRead())
						V3LkBXir = Properties.headerSkin;
				} else {
					File oSXNmD78 = new File(Properties.headerSkin);
					if (oSXNmD78.exists() && oSXNmD78.canRead())
						V3LkBXir = Properties.headerSkin;
				}
			} catch (Exception tAlVGPls) {
				XohmLogger.debugPrintln("Header skin url not valid. " + tAlVGPls.getMessage());
				XohmLogger.debugPrintln("Loading the default skin.");
				tAlVGPls.printStackTrace();
			}
		}
		XohmLogger.debugPrintln("Header skin file = " + V3LkBXir);
		try {
			LocalHtmlRendererContext SqqiYpqL = new LocalHtmlRendererContext(htmlHeaderPanel,
					new SimpleUserAgentContext());
			SqqiYpqL.navigate(V3LkBXir);
			headerLoaded = true;
		} catch (IOException A5pptEd1) {
			XohmLogger.debugPrintln("Exception occured while loading the skin. " + A5pptEd1.getMessage());
		}
	}

}