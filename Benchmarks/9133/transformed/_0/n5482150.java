class n5482150 {
	private static void writeUrl(String ApEWRPbO, String G0MfZM9t, String fiNjDb4w, boolean xDohqljc)
			throws IOException {
		int NwnddEAZ;
		OutputStream RBVTCPhS = null;
		try {
			if (!xDohqljc) {
				URL w6HzS7JO = new URL(ApEWRPbO);
				URLConnection b3GfhCMG = w6HzS7JO.openConnection();
				RBVTCPhS = b3GfhCMG.getOutputStream();
				if (fiNjDb4w == null) {
					String L5DJYnzp = b3GfhCMG.getContentType();
					if (L5DJYnzp != null) {
						fiNjDb4w = getCharCodingFromType(L5DJYnzp);
					}
				}
			} else {
				File XY2nuQaw = new File(ApEWRPbO);
				RBVTCPhS = new FileOutputStream(XY2nuQaw);
			}
			Writer QyXsQuRj;
			if (fiNjDb4w == null) {
				QyXsQuRj = new OutputStreamWriter(RBVTCPhS);
			} else {
				QyXsQuRj = new OutputStreamWriter(RBVTCPhS, fiNjDb4w);
			}
			QyXsQuRj.write(G0MfZM9t);
			QyXsQuRj.flush();
		} finally {
			if (RBVTCPhS != null)
				RBVTCPhS.close();
		}
	}

}