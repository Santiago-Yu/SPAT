class n17824349 {
	private String httpGet(String urlString, boolean postStatus) throws Exception {
		URLConnection conn;
		URL url;
		String answer = "";
		try {
			url = new URL(urlString);
			if (username.equals("") || password.equals(""))
				throw new AuthNotProvidedException();
			conn = url.openConnection();
			conn.setRequestProperty("Authorization", "Basic " + getAuthentificationString());
			if (postStatus) {
				conn.setDoOutput(true);
				conn.setUseCaches(false);
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				DataOutputStream das = new DataOutputStream(conn.getOutputStream());
				String content = "status=" + URLEncoder.encode(statusMessage, "UTF-8") + "&source="
						+ URLEncoder.encode("sametimetwitterclient", "UTF-8");
				das.writeBytes(content);
				das.flush();
				das.close();
			}
			InputStream is = (InputStream) conn.getInputStream();
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				answer += line + "\n";
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.toString());
			throw new RuntimeException("Page not Found. Maybe Twitter-API has changed.");
		} catch (UnknownHostException ex) {
			System.out.println(ex.toString());
			throw new RuntimeException("Network connection problems. Could not find twitter.com");
		} catch (IOException ex) {
			System.out.println("IO-Exception");
			if (ex.getMessage().indexOf("401") > -1) {
				throw new AuthNotAcceptedException();
				authenthicated = AUTH_BAD;
			}
			System.out.println(ex.toString());
		}
		if (checkForError(answer) != null) {
			throw new RuntimeException(checkForError(answer));
		}
		authenthicated = AUTH_OK;
		return answer;
	}

}