class n3011498 {
	@Override
	public List<String> transform(String pa1YVS0v) {
		String m96rhjsW = "";
		InputStream pZgVmtOv = null;
		try {
			URL wQNj77x4 = new URL(pa1YVS0v);
			HttpURLConnection Ya7rCpNl = (HttpURLConnection) wQNj77x4.openConnection();
			Ya7rCpNl.setRequestProperty("User-agent", "finance news monitor");
			Ya7rCpNl.setRequestProperty("From", "romilly.cocking@gmail.com");
			Ya7rCpNl.setInstanceFollowRedirects(true);
			pZgVmtOv = Ya7rCpNl.getInputStream();
			m96rhjsW = StringUtils.join(IOUtils.readLines(pZgVmtOv).toArray(), lineSeparator);
		} catch (MalformedURLException HNTKvQUf) {
			log.warn("Malformed url " + pa1YVS0v);
		} catch (IOException Qh5pIjum) {
			log.warn("error reading from url " + pa1YVS0v, Qh5pIjum);
		}
		if (pZgVmtOv != null) {
			try {
				pZgVmtOv.close();
			} catch (IOException WQU0TNVi) {
				log.warn("could not close url " + pa1YVS0v, WQU0TNVi);
			}
		}
		return enlist(m96rhjsW);
	}

}