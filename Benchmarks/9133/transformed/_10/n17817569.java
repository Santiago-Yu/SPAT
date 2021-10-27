class n17817569 {
	public String getFeatureInfoHTML(Point3d GKposition, String[] layerIds, int featureCount) {
		String html = "";
		try {
			String request = null;
			if (version == VERSION_030) {
				org.gdi3d.xnavi.services.w3ds.x030.GetFeatureInfo getFeatureInfo = new org.gdi3d.xnavi.services.w3ds.x030.GetFeatureInfo(
						this.serviceEndPoint);
				request = getFeatureInfo.createRequest(GKposition, layerIds, featureCount);
			} else if (version == VERSION_040) {
				org.gdi3d.xnavi.services.w3ds.x040.GetFeatureInfo getFeatureInfo = new org.gdi3d.xnavi.services.w3ds.x040.GetFeatureInfo(
						this.serviceEndPoint);
				request = getFeatureInfo.createRequest(GKposition, layerIds, featureCount);
			} else if (version == VERSION_041) {
				org.gdi3d.xnavi.services.w3ds.x041.GetFeatureInfo getFeatureInfo = new org.gdi3d.xnavi.services.w3ds.x041.GetFeatureInfo(
						this.serviceEndPoint);
				request = getFeatureInfo.createRequest(GKposition, layerIds, featureCount);
			}
			if (Navigator.isVerbose())
				System.out.println(request);
			int contentLength = -1;
			URL url = new URL(request);
			URLConnection urlc;
			urlc = url.openConnection();
			urlc.setReadTimeout(Navigator.TIME_OUT);
			if (getEncoding() != null) {
				urlc.setRequestProperty("Authorization", "Basic " + getEncoding());
			}
			urlc.connect();
			String content_type = urlc.getContentType();
			if (content_type.equalsIgnoreCase("text/html")
					|| content_type.equalsIgnoreCase("text/html;charset=UTF-8")) {
				InputStream is = urlc.getInputStream();
				StringBuffer sb = new StringBuffer();
				BufferedInputStream bis = new BufferedInputStream(is);
				char chars[] = new char[10240];
				InputStreamReader isr = new InputStreamReader(bis);
				contentLength = 0;
				int len = 0;
				while ((len = isr.read(chars, 0, chars.length)) >= 0) {
					sb.append(chars, 0, len);
					contentLength += len;
				}
				chars = null;
				isr.close();
				bis.close();
				is.close();
				html = sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}

}