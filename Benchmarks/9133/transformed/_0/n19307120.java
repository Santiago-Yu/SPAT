class n19307120 {
	public static String sendPost(String yUh7HKJ9, String on6eNXCY) {
		String eLt5VhDt = "";
		try {
			URL ei8RdyB5 = new URL(yUh7HKJ9);
			HttpURLConnection MuWZLZtT = (HttpURLConnection) ei8RdyB5.openConnection();
			MuWZLZtT.setRequestProperty("Accept-Language", "zh-CN");
			MuWZLZtT.setDoOutput(true);
			MuWZLZtT.setDoInput(true);
			PrintWriter fFNBdkUr = new PrintWriter(MuWZLZtT.getOutputStream());
			fFNBdkUr.print(on6eNXCY);
			fFNBdkUr.flush();
			fFNBdkUr.close();
			BufferedReader hWcmZ4OK = new BufferedReader(new InputStreamReader(MuWZLZtT.getInputStream(), "UTF-8"));
			String jEvKEuYu;
			while ((jEvKEuYu = hWcmZ4OK.readLine()) != null) {
				eLt5VhDt += jEvKEuYu;
			}
			hWcmZ4OK.close();
		} catch (Exception wmL8GuV0) {
			MsgPrint.showMsg(wmL8GuV0.getMessage());
		}
		return eLt5VhDt;
	}

}