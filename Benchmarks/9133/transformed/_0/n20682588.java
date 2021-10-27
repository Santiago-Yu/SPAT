class n20682588 {
	public MapInfo getMap(double n4ip2tYZ, double NX9RslmN, double bZLU9x3A, int RAyOh50A, int unQXMcnQ,
			String MVXbu3uS, ProgressListener tdoQel3f) throws IOException {
		try {
			double MElrJh4N = getDownloadScale(bZLU9x3A);
			URL HCHHGIfo = new URL(getUrl(n4ip2tYZ, NX9RslmN, MElrJh4N, RAyOh50A, unQXMcnQ));
			if (Debug.DEBUG)
				Debug.println("map_download", "loading map from url: " + HCHHGIfo);
			URLConnection bSxK3Wh1 = HCHHGIfo.openConnection();
			if (resources_.getBoolean(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USE)) {
				String WbYYaH2h = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USERNAME);
				String M4rD3zqq = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_PASSWORD);
				String b8VeprHX = WbYYaH2h + ":" + M4rD3zqq;
				b8VeprHX = "Basic " + new sun.misc.BASE64Encoder().encode(b8VeprHX.getBytes());
				bSxK3Wh1.setRequestProperty("Proxy-Authorization", b8VeprHX);
			}
			bSxK3Wh1 = setRequestProperties(bSxK3Wh1);
			bSxK3Wh1.connect();
			String G6IJYF59 = bSxK3Wh1.getContentType().toLowerCase();
			if (!G6IJYF59.startsWith("image")) {
				if (G6IJYF59.startsWith("text")) {
					HTMLViewerFrame f32HH7vA = new HTMLViewerFrame(HCHHGIfo);
					f32HH7vA.setSize(640, 480);
					f32HH7vA.setTitle("ERROR on loading url: " + HCHHGIfo);
					f32HH7vA.setVisible(true);
					throw new IOException("Invalid mime type (expected 'image/*'): received " + G6IJYF59
							+ "\nPage is displayed in HTML frame.");
				}
				throw new IOException("Invalid mime type (expected 'image/*'): received " + G6IJYF59);
			}
			int vpKW5BZu = bSxK3Wh1.getContentLength();
			if (vpKW5BZu < 0)
				tdoQel3f.actionStart(PROGRESS_LISTENER_ID, 0, Integer.MIN_VALUE);
			else
				tdoQel3f.actionStart(PROGRESS_LISTENER_ID, 0, vpKW5BZu);
			String L2WTaqEB = G6IJYF59.substring(G6IJYF59.indexOf('/') + 1);
			String XCFbjyUp = MVXbu3uS + L2WTaqEB;
			MapInfo udtWlYVf = new MapInfo();
			udtWlYVf.setLatitude(n4ip2tYZ);
			udtWlYVf.setLongitude(NX9RslmN);
			udtWlYVf.setScale((float) getCorrectedMapblastScale(bZLU9x3A));
			udtWlYVf.setWidth(RAyOh50A);
			udtWlYVf.setHeight(unQXMcnQ);
			udtWlYVf.setFilename(XCFbjyUp);
			FileOutputStream j3sKvT8K = new FileOutputStream(XCFbjyUp);
			byte[] AYzncBOQ = new byte[BUFFER_SIZE];
			BufferedInputStream H33qyJBl = new BufferedInputStream(bSxK3Wh1.getInputStream(), BUFFER_SIZE);
			int Y3HBipfs = 0;
			int XcRdspbQ = 0;
			while ((XcRdspbQ = H33qyJBl.read(AYzncBOQ)) != -1) {
				j3sKvT8K.write(AYzncBOQ, 0, XcRdspbQ);
				Y3HBipfs += XcRdspbQ;
				tdoQel3f.actionProgress(PROGRESS_LISTENER_ID, Y3HBipfs);
			}
			tdoQel3f.actionEnd(PROGRESS_LISTENER_ID);
			H33qyJBl.close();
			j3sKvT8K.close();
			return (udtWlYVf);
		} catch (NoRouteToHostException Bnc6P8gf) {
			Bnc6P8gf.printStackTrace();
			tdoQel3f.actionEnd(PROGRESS_LISTENER_ID);
			String HQZzyS4b = Bnc6P8gf.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_NO_ROUTE_TO_HOST_MESSAGE);
			throw new IOException(HQZzyS4b);
		} catch (FileNotFoundException qc58kjRG) {
			qc58kjRG.printStackTrace();
			tdoQel3f.actionEnd(PROGRESS_LISTENER_ID);
			String z2mEgfHh = qc58kjRG.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_FILE_NOT_FOUND_MESSAGE);
			throw new IOException(z2mEgfHh);
		} catch (Exception qqBAqcoV) {
			tdoQel3f.actionEnd(PROGRESS_LISTENER_ID);
			qqBAqcoV.printStackTrace();
			String kSedbqQS = qqBAqcoV.getMessage();
			if (kSedbqQS == null) {
				Throwable LVPoxAJy = qqBAqcoV.getCause();
				if (LVPoxAJy != null)
					kSedbqQS = LVPoxAJy.getMessage();
			}
			throw new IOException(kSedbqQS);
		}
	}

}