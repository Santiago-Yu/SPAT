class n7767320 {
	private String executeUpload(String f9pydQUW, String vA1NwF0q, String TWoa0bjm, String kBedYpph) {
		StringBuffer ESKeoc2k = new StringBuffer();
		try {
			URL cw7ohScx = new URL(f9pydQUW);
			HttpURLConnection vpiTWmIn = (HttpURLConnection) cw7ohScx.openConnection();
			vpiTWmIn.setDoOutput(true);
			vpiTWmIn.setDoInput(true);
			vpiTWmIn.setRequestMethod("POST");
			vpiTWmIn.setRequestProperty("YAWLSessionHandle", kBedYpph);
			vpiTWmIn.setRequestProperty("filename", TWoa0bjm);
			vpiTWmIn.setRequestProperty("Content-Type", "text/xml");
			PrintWriter su2PqROX = new PrintWriter(vpiTWmIn.getOutputStream());
			su2PqROX.print(vA1NwF0q);
			su2PqROX.flush();
			BufferedReader KY250x7Z = new BufferedReader(new InputStreamReader(vpiTWmIn.getInputStream()));
			String oASoPYNA;
			while ((oASoPYNA = KY250x7Z.readLine()) != null) {
				ESKeoc2k.append(oASoPYNA);
			}
			KY250x7Z.close();
			su2PqROX.close();
			vpiTWmIn.disconnect();
		} catch (MalformedURLException VGtVMUfq) {
			VGtVMUfq.printStackTrace();
		} catch (IOException gZ5teh65) {
			InterfaceBWebsideController.logContactError(gZ5teh65, _backEndURIStr);
		}
		String GPVB9j6J = ESKeoc2k.toString();
		return stripOuterElement(GPVB9j6J);
	}

}