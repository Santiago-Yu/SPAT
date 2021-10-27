class n12442447 {
	public ActionResponse executeAction(ActionRequest xV7tWuOc) throws Exception {
		ActionResponse AY4RjjN6 = new ActionResponse();
		BufferedReader DaAIDgtY = null;
		try {
			URL hbO6pixC = new URL(URL);
			HttpURLConnection CMSGzWA2 = (HttpURLConnection) hbO6pixC.openConnection();
			int yprdEbI2 = CMSGzWA2.getResponseCode();
			if (yprdEbI2 == 200) {
				DaAIDgtY = new BufferedReader(new InputStreamReader(CMSGzWA2.getInputStream()));
				while (true) {
					String DukxFzk9 = DaAIDgtY.readLine();
					if (DukxFzk9 == null)
						break;
					AY4RjjN6.addResult("REMOTEVERSION", DukxFzk9);
				}
			} else {
				AY4RjjN6.setErrorCode(ActionResponse.GENERAL_ERROR);
				AY4RjjN6.setErrorMessage("HTTP Error [" + yprdEbI2 + "]");
			}
		} catch (Exception yciwIgiM) {
			AY4RjjN6.setErrorCode(ActionResponse.GENERAL_ERROR);
			AY4RjjN6.setErrorMessage(yciwIgiM.getMessage());
		} finally {
			if (DaAIDgtY != null) {
				DaAIDgtY.close();
			}
		}
		return AY4RjjN6;
	}

}