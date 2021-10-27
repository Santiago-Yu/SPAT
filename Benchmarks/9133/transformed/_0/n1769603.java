class n1769603 {
	public static int getFilesize(String PdHRRPUj) {
		URL fAfKujrY;
		URLConnection bi3ILAct;
		int mvBBTdCb = -1;
		try {
			fAfKujrY = new URL(PdHRRPUj);
			bi3ILAct = fAfKujrY.openConnection();
			bi3ILAct.setRequestProperty("User-Agent", Main.USER_AGENT);
			bi3ILAct.setConnectTimeout(Main.CONNECT_TIMEOUT * 2);
			bi3ILAct.setReadTimeout(Main.READ_TIMEOUT * 2);
			mvBBTdCb = bi3ILAct.getContentLength();
			bi3ILAct.getInputStream().close();
		} catch (FileNotFoundException vG8NdOD7) {
			return -2;
		} catch (ConnectException RJtWI8rg) {
			return -3;
		} catch (ProtocolException VnLsLzgo) {
			return -2;
		} catch (IOException aWaYhj1W) {
			return -2;
		} catch (Exception iT41hR6Y) {
			iT41hR6Y.printStackTrace();
		}
		return mvBBTdCb;
	}

}