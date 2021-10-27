class n23291433 {
	public static String sendRequest(String NvKnmkPb) {
		URL qV5aYbJv;
		String EwWvqPWX;
		Log.i("DVBMonitor", "Please wait while receiving data from dvb...");
		try {
			qV5aYbJv = new URL(NvKnmkPb);
			BufferedReader AaELeX36 = new BufferedReader(new InputStreamReader(qV5aYbJv.openStream()));
			if ((EwWvqPWX = AaELeX36.readLine()) != null) {
				return EwWvqPWX;
			} else {
				return null;
			}
		} catch (Exception UKnSlnb8) {
			Log.e("DVBMonitor", UKnSlnb8.toString() + " while sending request to dvb");
			return null;
		}
	}

}