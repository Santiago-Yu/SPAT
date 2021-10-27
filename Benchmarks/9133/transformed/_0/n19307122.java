class n19307122 {
	public static byte[] sendParamPost(String iGEdaUWd, String xYev1CjW) {
		try {
			URL HHlw8Lto = new URL(iGEdaUWd + "?" + xYev1CjW);
			HttpURLConnection YsBxhoRA = (HttpURLConnection) HHlw8Lto.openConnection();
			YsBxhoRA.setDoOutput(true);
			YsBxhoRA.setDefaultUseCaches(false);
			YsBxhoRA.setDoInput(true);
			YsBxhoRA.setRequestMethod("POST");
			YsBxhoRA.connect();
			OutputStream POI6uRq9 = YsBxhoRA.getOutputStream();
			POI6uRq9.close();
			InputStream wdhm6zQ4 = YsBxhoRA.getInputStream();
			byte[] nwmBPBOR = new byte[YsBxhoRA.getContentLength()];
			byte[] fHpvRUhY = new byte[1024];
			int EhMamXk8 = 0;
			int yGDArRmx = 0;
			while ((EhMamXk8 = wdhm6zQ4.read(fHpvRUhY)) != -1) {
				System.arraycopy(fHpvRUhY, 0, nwmBPBOR, yGDArRmx, EhMamXk8);
				yGDArRmx += EhMamXk8;
			}
			wdhm6zQ4.close();
			return nwmBPBOR;
		} catch (Exception CmDfbo2w) {
			CmDfbo2w.printStackTrace();
			return null;
		}
	}

}