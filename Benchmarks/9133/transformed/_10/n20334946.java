class n20334946 {
	public static String doPost(String http_url, String post_data) {
		if (post_data == null) {
			post_data = "";
		}
		try {
			URLConnection conn = new URL(http_url).openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(post_data);
			out.flush();
			out.close();
			String line;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer buffer = new StringBuffer();
			while ((line = in.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
			return buffer.toString();
		} catch (IOException e) {
			;
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return null;
	}

}