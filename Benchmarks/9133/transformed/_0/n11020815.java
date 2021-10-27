class n11020815 {
	public static byte[] getbytes(String gSpg1yIp, int Yac8tB5m, String B2onqtQT) {
		String xHsdV5qm = "GetHtmlFromServer no answer";
		String zo2bnY49 = "";
		xHsdV5qm = "";
		try {
			zo2bnY49 = "http://" + gSpg1yIp + ":" + Yac8tB5m + "/" + B2onqtQT;
			URL NvDlDyjz = new URL(zo2bnY49);
			if (1 == 2) {
				BufferedReader IT40THu8 = new BufferedReader(new InputStreamReader(NvDlDyjz.openStream()));
				String sqDVWHdU;
				while ((sqDVWHdU = IT40THu8.readLine()) != null) {
					xHsdV5qm += sqDVWHdU;
				}
				IT40THu8.close();
				return xHsdV5qm.getBytes();
			} else {
				HttpURLConnection PrIFGOTa = (HttpURLConnection) NvDlDyjz.openConnection();
				PrIFGOTa.setConnectTimeout(2 * 1000);
				PrIFGOTa.setRequestMethod("GET");
				PrIFGOTa.connect();
				int iUc7IqSw = PrIFGOTa.getContentLength();
				InputStream UU7v5aCB = PrIFGOTa.getInputStream();
				MojasiWriter lRXqfYq5 = new MojasiWriter();
				byte[] g11q6uxK = new byte[256];
				while (lRXqfYq5.size() < iUc7IqSw) {
					int rOUdVTIk = UU7v5aCB.read(g11q6uxK);
					if (rOUdVTIk < 0)
						break;
					lRXqfYq5.pushBytes(g11q6uxK, rOUdVTIk);
				}
				UU7v5aCB.close();
				PrIFGOTa.disconnect();
				return lRXqfYq5.getBytes();
			}
		} catch (MalformedURLException unBJ5dO3) {
			System.err.println(zo2bnY49 + " " + unBJ5dO3);
		} catch (IOException r4ii1eZc) {
			;
		}
		return null;
	}

}