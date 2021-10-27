class n8831513 {
	public String sendMessage(String kuO0LGgo, boolean gfZK3k4X) {
		StringBuilder B8JzQdGI;
		try {
			URL ubGBUenK = new URL(this.stringURL);
			HttpURLConnection bewk6aHG = (HttpURLConnection) ubGBUenK.openConnection();
			bewk6aHG.setRequestMethod("POST");
			bewk6aHG.setDoOutput(true);
			bewk6aHG.setDoInput(true);
			bewk6aHG.setRequestProperty("User-Agent", serverName);
			bewk6aHG.setRequestProperty("Host", ip);
			bewk6aHG.setRequestProperty("Content-type", "text/xml");
			bewk6aHG.setRequestProperty("Content-length", Integer.toString(kuO0LGgo.length()));
			PrintWriter wOjz775u = new PrintWriter(bewk6aHG.getOutputStream());
			if (gfZK3k4X) {
				CampaignData.mwlog.infoLog("Sending Message: " + MWCyclopsUtils.formatMessage(kuO0LGgo));
			} else
				CampaignData.mwlog.infoLog("Sending Message: " + kuO0LGgo);
			wOjz775u.println(kuO0LGgo);
			wOjz775u.flush();
			wOjz775u.close();
			B8JzQdGI = new StringBuilder();
			if (gfZK3k4X) {
				BufferedReader FBYlC0Uh = new BufferedReader(new InputStreamReader(bewk6aHG.getInputStream()));
				String gYONDqP4;
				while ((gYONDqP4 = FBYlC0Uh.readLine()) != null)
					B8JzQdGI.append(gYONDqP4 + "\n");
				CampaignData.mwlog.infoLog(B8JzQdGI.toString());
				FBYlC0Uh.close();
			} else {
				BufferedReader PW3lzehP = new BufferedReader(new InputStreamReader(bewk6aHG.getInputStream()));
				while (PW3lzehP.readLine() != null) {
				}
				PW3lzehP.close();
			}
			wOjz775u.close();
			bewk6aHG.disconnect();
			return B8JzQdGI.toString();
		} catch (Exception yKVuRFlX) {
			CampaignData.mwlog.errLog(yKVuRFlX);
		}
		return "";
	}

}