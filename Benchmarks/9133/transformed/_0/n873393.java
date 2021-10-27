class n873393 {
	public static boolean download(String j5RIzRLP, File DyBGWMRG) {
		HttpURLConnection POtNmRsJ = null;
		BufferedInputStream yRdzq7gm = null;
		BufferedOutputStream ckO3JsfE = null;
		try {
			POtNmRsJ = (HttpURLConnection) new URL(j5RIzRLP).openConnection();
			POtNmRsJ.connect();
			if (POtNmRsJ.getResponseCode() == 200) {
				System.out.println("length:" + POtNmRsJ.getContentLength());
				yRdzq7gm = new BufferedInputStream(POtNmRsJ.getInputStream());
				ckO3JsfE = new BufferedOutputStream(new FileOutputStream(DyBGWMRG));
				byte[] VhpWkzYh = new byte[1024 << 10];
				int c6rqqa2K = 0;
				while ((c6rqqa2K = yRdzq7gm.read(VhpWkzYh)) > -1) {
					if (c6rqqa2K > 0)
						ckO3JsfE.write(VhpWkzYh, 0, c6rqqa2K);
				}
				return true;
			} else {
				System.out.println(POtNmRsJ.getResponseCode() + ":" + j5RIzRLP);
			}
		} catch (Exception ys4uvnUG) {
			ys4uvnUG.printStackTrace();
		} finally {
			if (yRdzq7gm != null)
				try {
					yRdzq7gm.close();
				} catch (IOException RFvSawjE) {
					RFvSawjE.printStackTrace();
				}
			if (ckO3JsfE != null)
				try {
					ckO3JsfE.close();
				} catch (IOException bA1a2ABw) {
					bA1a2ABw.printStackTrace();
				}
			if (POtNmRsJ != null)
				POtNmRsJ.disconnect();
		}
		return false;
	}

}