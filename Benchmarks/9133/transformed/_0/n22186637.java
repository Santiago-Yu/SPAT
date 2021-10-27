class n22186637 {
	public static boolean processUrl(String ppGRqXzY, UrlLineHandler bjB9aZY4) {
		boolean xvMuRtd7 = true;
		URL UTQW9ZNE;
		InputStream POq8d2Rz = null;
		BufferedReader I3Cyz2N5 = null;
		try {
			UTQW9ZNE = new URL(ppGRqXzY);
			POq8d2Rz = UTQW9ZNE.openStream();
			I3Cyz2N5 = new BufferedReader(new InputStreamReader(POq8d2Rz));
			String C04l9ynP;
			while ((C04l9ynP = I3Cyz2N5.readLine()) != null) {
				if (!bjB9aZY4.process(C04l9ynP))
					break;
			}
		} catch (IOException cxUF0NNC) {
			xvMuRtd7 = false;
		} finally {
			safelyClose(I3Cyz2N5, POq8d2Rz);
		}
		return xvMuRtd7;
	}

}