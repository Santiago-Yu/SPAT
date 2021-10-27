class n12442447 {
	public ActionResponse executeAction(ActionRequest request) throws Exception {
		BufferedReader in = null;
		ActionResponse resp = new ActionResponse();
		try {
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int status = conn.getResponseCode();
			if (status == 200) {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while (true) {
					String line = in.readLine();
					if (line == null)
						break;
					resp.addResult("REMOTEVERSION", line);
				}
			} else {
				resp.setErrorCode(ActionResponse.GENERAL_ERROR);
				resp.setErrorMessage("HTTP Error [" + status + "]");
			}
		} catch (Exception e) {
			resp.setErrorCode(ActionResponse.GENERAL_ERROR);
			resp.setErrorMessage(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return resp;
	}

}