class n18723564 {
	public String uploadVideo(String ticketId, String filePath) {
		TreeMap<String, String> uploadParams = new TreeMap<String, String>();
		String url = "http://www.vimeo.com/services/upload/";
		uploadParams.put("api_key", apiKey);
		uploadParams.put("auth_token", this.TEMP_AUTH_TOKEN);
		uploadParams.put("ticket_id", ticketId);
		uploadParams.put("format", "json");
		String signature = this.generateAppSignature(uploadParams);
		uploadParams.put("api_sig", signature);
		ClientHttpRequest request = null;
		try {
			request = new ClientHttpRequest(new URL(url).openConnection());
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream videoInput = null;
		for (Entry<String, String> param : uploadParams.entrySet()) {
			try {
				request.setParameter(param.getKey(), param.getValue());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			videoInput = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		InputStream response = null;
		try {
			request.setParameter("video", filePath, videoInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			response = request.post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			InputStreamReader inR = new InputStreamReader(response);
			String line;
			BufferedReader buf = new BufferedReader(inR);
			try {
				while ((line = buf.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "hey";
	}

}