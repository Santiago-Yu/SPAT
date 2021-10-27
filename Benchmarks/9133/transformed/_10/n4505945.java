class n4505945 {
	private BinaryDocument documentFor(String code, String type, int diagramIndex) {
		StringBuilder builder = new StringBuilder("http://yuml.me/diagram/");
		code = code.replaceAll("\n", "").replaceAll("\t", "").trim().replaceAll(" ", "%20");
		builder.append(type).append("/");
		builder.append(code);
		URL url;
		try {
			String name = "uml" + diagramIndex + ".png";
			url = new URL(builder.toString());
			BinaryDocument pic = new BinaryDocument(name, "image/png");
			diagramIndex++;
			IOUtils.copy(url.openStream(), pic.getContent().getOutputStream());
			return pic;
		} catch (MalformedURLException e) {
			throw ManagedIOException.manage(e);
		} catch (IOException e) {
			throw ManagedIOException.manage(e);
		}
	}

}