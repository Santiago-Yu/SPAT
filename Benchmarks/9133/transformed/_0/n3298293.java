class n3298293 {
	public static InputStream download_file(String i1QpZuaD, String UQMsNRZg) {
		String iFC40zEB = "https://s2.cloud.cm/rpc/raw?c=Storage&m=download_file&key=" + UQMsNRZg;
		try {
			URL M9lpZYrb = new URL(iFC40zEB);
			Log.d("current running function name:", "download_file");
			HttpURLConnection bJeVT2E6 = (HttpURLConnection) M9lpZYrb.openConnection();
			bJeVT2E6.setRequestProperty("Cookie", "PHPSESSID=" + i1QpZuaD);
			bJeVT2E6.setRequestMethod("POST");
			bJeVT2E6.setDoInput(true);
			InputStream LlD4Qzer = bJeVT2E6.getInputStream();
			Log.d("size of the picture file", "" + LlD4Qzer.available());
			return LlD4Qzer;
		} catch (Exception AZmWjeEg) {
			AZmWjeEg.printStackTrace();
		}
		return null;
	}

}