class n19948815 {
	public static int validate(String pJR1z90a) {
		HttpURLConnection oEp5xuYo = null;
		try {
			oEp5xuYo = (HttpURLConnection) (new URL(pJR1z90a)).openConnection();
		} catch (MalformedURLException rFIYpw4F) {
			return -1;
		} catch (IOException W1qBSCaU) {
			return -2;
		}
		try {
			if (oEp5xuYo != null && oEp5xuYo.getResponseCode() != 200) {
				return oEp5xuYo.getResponseCode();
			} else if (oEp5xuYo == null) {
				return -3;
			}
		} catch (IOException wcrdOMoB) {
			return -4;
		}
		return 1;
	}

}