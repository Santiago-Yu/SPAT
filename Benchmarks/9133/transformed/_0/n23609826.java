class n23609826 {
	@Override
	public void onSensorChanged(SensorEvent WaLEIxb7) {
		float U3wvhfwG[] = WaLEIxb7.values;
		if (httpRequestRunning) {
			return;
		}
		float FR8ftSPn = U3wvhfwG[0] / SensorManager.GRAVITY_EARTH;
		float xZMIJcG3 = U3wvhfwG[1] / SensorManager.GRAVITY_EARTH;
		float I3sjl4cS = U3wvhfwG[2] / SensorManager.GRAVITY_EARTH;
		String p0QYeROn = edtIpAddress.getText().toString();
		String r66Iq9eg = new String("http://" + p0QYeROn + ":8080/ACC/");
		r66Iq9eg += String.valueOf(FR8ftSPn);
		r66Iq9eg += "/";
		r66Iq9eg += String.valueOf(xZMIJcG3);
		r66Iq9eg += "/";
		r66Iq9eg += String.valueOf(I3sjl4cS);
		final URL dLBXzoJW;
		try {
			dLBXzoJW = new URL(r66Iq9eg);
		} catch (MalformedURLException vQblROer) {
			return;
		}
		httpRequestRunning = true;
		handler.post(new Runnable() {

			public void run() {
				try {
					URLConnection XrSg4gET = dLBXzoJW.openConnection();
					XrSg4gET.getInputStream().close();
				} catch (IOException x4WYwDpV) {
				}
				httpRequestRunning = false;
			}
		});
	}

}