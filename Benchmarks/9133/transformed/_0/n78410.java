class n78410 {
	public void run() {
		try {
			int U7KObskJ = getID() - 1;
			String wu0yswdd = U7KObskJ + ".dem";
			String lbXFQIVV = URLEncoder.encode("file", "UTF-8") + "=" + URLEncoder.encode(wu0yswdd, "UTF-8");
			lbXFQIVV += "&" + URLEncoder.encode("hash", "UTF-8") + "="
					+ URLEncoder.encode(getMD5Digest("tf2invite" + wu0yswdd), "UTF-8");
			URL VTBKxIiR = new URL("http://94.23.189.99/ftp.php");
			final URLConnection pjWTaCwF = VTBKxIiR.openConnection();
			pjWTaCwF.setDoOutput(true);
			OutputStreamWriter PWA8NmwF = new OutputStreamWriter(pjWTaCwF.getOutputStream());
			PWA8NmwF.write(lbXFQIVV);
			PWA8NmwF.flush();
			String dZ4yCjaw;
			BufferedReader fbPBONtY = new BufferedReader(new InputStreamReader(pjWTaCwF.getInputStream()));
			while ((dZ4yCjaw = fbPBONtY.readLine()) != null) {
				System.out.println(dZ4yCjaw);
				if (dZ4yCjaw.startsWith("demo="))
					msg("2The last gather demo has been uploaded successfully: " + dZ4yCjaw.split("=")[1]);
			}
			fbPBONtY.close();
			PWA8NmwF.close();
		} catch (IOException UTVqIS0q) {
			UTVqIS0q.printStackTrace();
		}
	}

}