class n23087434 {
	private int[] get51JobId(String address, String category, int pageNum) {
		StringBuffer htmlContent = null;
		try {
			URL url = new URL(ConfigJob51.STR_51JOB_ADVANCE);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			OutputStream raw = connection.getOutputStream();
			OutputStream buf = new BufferedOutputStream(raw);
			OutputStreamWriter out = new OutputStreamWriter(buf, "gb2312");
			out.write("jobarea=" + address + "&funtype=" + category + "&curr_page=" + pageNum + "");
			out.flush();
			out.close();
			InputStream in = connection.getInputStream();
			in = new BufferedInputStream(in);
			Reader r = new InputStreamReader(in);
			int c;
			htmlContent = new StringBuffer();
			while ((c = r.read()) != -1) {
				htmlContent.append((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pattern p = Pattern.compile(JOB51_SEARCHLIST_URL_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = p.matcher(htmlContent);
		int idSum = 0, writeToDBSuccessful = 0;
		while (matcher.find()) {
			String s = matcher.group();
			String sql = "insert into `job51`(`id`,`retryCnt`,`Category`) values('" + s.replaceAll("[^0-9]", "")
					+ "','0','" + category + "')";
			if (mysql.executeInsert(sql)) {
				writeToDBSuccessful++;
			}
			idSum++;
		}
		return new int[] { idSum, writeToDBSuccessful };
	}

}