class n3749038 {
	public MapInfo getMap(double gXDUogek, double jylIrsDl, double Xbl9xKc8, int IfCs7xu9, int FfD5xuF2,
			String iYZNo9Fe, ProgressListener KeQWjnJz) throws IOException {
		try {
			if (web_request_ == null) {
				web_request_ = new HttpRequester(HOST_NAME);
			}
			int LFhBf8IS = getZoomLevelIndex(Xbl9xKc8);
			int a0m9SFbb = GOOGLE_ZOOM_LEVELS[LFhBf8IS];
			double gJgaasEt = POSSIBLE_GOOGLE_SCALES[LFhBf8IS];
			Tile okFE5NIk = new Tile(gXDUogek, jylIrsDl, a0m9SFbb);
			SimplePoint LozhJzcO = okFE5NIk.getTileLatLong();
			SimplePoint qlCrrnnk = okFE5NIk.getTileCoord();
			MapInfo pHjg2diN = new MapInfo();
			pHjg2diN.setLatitude(LozhJzcO.getX());
			pHjg2diN.setLongitude(LozhJzcO.getY());
			pHjg2diN.setScale((float) gJgaasEt);
			pHjg2diN.setWidth(256);
			pHjg2diN.setHeight(256);
			pHjg2diN.setFilename(iYZNo9Fe + "png");
			Object[] qleBr9xN = new Object[] { new Integer(qlCrrnnk.getX()), new Integer(qlCrrnnk.getY()),
					new Integer(a0m9SFbb) };
			MessageFormat JcVXl6BU = new MessageFormat(GOOGLE_MAPS_URL, Locale.US);
			String ytq74Rip = JcVXl6BU.format(qleBr9xN);
			URL Y8DeoG53 = new URL(ytq74Rip);
			if (Debug.DEBUG)
				Debug.println("map_download", "loading map from url: " + Y8DeoG53);
			URLConnection zg0h0uvA = Y8DeoG53.openConnection();
			if (resources_.getBoolean(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USE)) {
				String sser0d4p = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_USERNAME);
				String hE7GzqNA = resources_.getString(GpsylonKeyConstants.KEY_HTTP_PROXY_AUTHENTICATION_PASSWORD);
				String TVZyz8tR = sser0d4p + ":" + hE7GzqNA;
				TVZyz8tR = "Basic " + new sun.misc.BASE64Encoder().encode(TVZyz8tR.getBytes());
				zg0h0uvA.setRequestProperty("Proxy-Authorization", TVZyz8tR);
			}
			zg0h0uvA.connect();
			String HMaV0x96 = zg0h0uvA.getContentType().toLowerCase();
			if (!HMaV0x96.startsWith("image")) {
				if (HMaV0x96.startsWith("text")) {
					HTMLViewerFrame g6vwxeSR = new HTMLViewerFrame(Y8DeoG53);
					g6vwxeSR.setSize(640, 480);
					g6vwxeSR.setTitle("ERROR on loading url: " + Y8DeoG53);
					g6vwxeSR.setVisible(true);
					throw new IOException("Invalid mime type (expected 'image/*'): received " + HMaV0x96
							+ "\nPage is displayed in HTML frame.");
				}
				throw new IOException("Invalid mime type (expected 'image/*'): received " + HMaV0x96);
			}
			int r7zJfWXu = zg0h0uvA.getContentLength();
			if (r7zJfWXu < 0)
				KeQWjnJz.actionStart(PROGRESS_LISTENER_ID, 0, Integer.MIN_VALUE);
			else
				KeQWjnJz.actionStart(PROGRESS_LISTENER_ID, 0, r7zJfWXu);
			String kR2AW6wQ = HMaV0x96.substring(HMaV0x96.indexOf('/') + 1);
			String jmT49W7S = iYZNo9Fe + kR2AW6wQ;
			FileOutputStream pTgw2ykN = new FileOutputStream(jmT49W7S);
			byte[] RlmNQ4DU = new byte[BUFFER_SIZE];
			BufferedInputStream laPkUCB4 = new BufferedInputStream(zg0h0uvA.getInputStream(), BUFFER_SIZE);
			int rsYyz54G = 0;
			int RiGb5iuQ = 0;
			while ((RiGb5iuQ = laPkUCB4.read(RlmNQ4DU)) != -1) {
				pTgw2ykN.write(RlmNQ4DU, 0, RiGb5iuQ);
				rsYyz54G += RiGb5iuQ;
				KeQWjnJz.actionProgress(PROGRESS_LISTENER_ID, rsYyz54G);
			}
			KeQWjnJz.actionEnd(PROGRESS_LISTENER_ID);
			laPkUCB4.close();
			pTgw2ykN.close();
			return (pHjg2diN);
		} catch (NoRouteToHostException lSE4qBmy) {
			lSE4qBmy.printStackTrace();
			KeQWjnJz.actionEnd(PROGRESS_LISTENER_ID);
			String mnKatqVF = lSE4qBmy.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_NO_ROUTE_TO_HOST_MESSAGE);
			throw new IOException(mnKatqVF);
		} catch (FileNotFoundException gohCpd1E) {
			gohCpd1E.printStackTrace();
			KeQWjnJz.actionEnd(PROGRESS_LISTENER_ID);
			String axHgpAWM = gohCpd1E.getMessage() + ":\n" + resources_
					.getString(DownloadMouseModeLayer.KEY_LOCALIZE_MESSAGE_DOWNLOAD_ERROR_FILE_NOT_FOUND_MESSAGE);
			throw new IOException(axHgpAWM);
		} catch (Exception tDCjGsuJ) {
			KeQWjnJz.actionEnd(PROGRESS_LISTENER_ID);
			tDCjGsuJ.printStackTrace();
			String ARJ3rH3P = tDCjGsuJ.getMessage();
			if (ARJ3rH3P == null) {
				Throwable RKzTCqQm = tDCjGsuJ.getCause();
				if (RKzTCqQm != null)
					ARJ3rH3P = RKzTCqQm.getMessage();
			}
			throw new IOException(ARJ3rH3P);
		}
	}

}