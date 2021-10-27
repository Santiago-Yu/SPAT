class n7844497 {
	public static String simplePostRequest(String path, Map<String, Object> model) {
		try {
			URL url = new URL(path);
			URLConnection con = url.openConnection();
			con.setDoOutput(true);
			OutputStream out = con.getOutputStream();
			OutputStream bout = new BufferedOutputStream(out);
			boolean first = true;
			OutputStreamWriter writer = new OutputStreamWriter(bout);
			for (String name : model.keySet()) {
				String value = (String) model.get(name);
				if (!first) {
					writer.write("&");
					first = false;
				}
				writer.write(name + "=" + value);
			}
			writer.flush();
			writer.close();
			InputStream stream = new BufferedInputStream(con.getInputStream());
			StringBuilder buffer = new StringBuilder();
			Reader reader = new BufferedReader(new InputStreamReader(stream));
			for (int c = reader.read(); c != -1; c = reader.read()) {
				buffer.append((char) c);
			}
			return buffer.toString();
		} catch (MalformedURLException e) {
			throw new CVardbException(e);
		} catch (IOException e) {
			throw new CVardbException(e);
		}
	}

}