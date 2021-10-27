class n19246986 {
	private List<String> readDescriptor(URL oy5h6IAY) {
		BufferedReader bKGWPYgF = null;
		try {
			bKGWPYgF = new BufferedReader(new InputStreamReader(oy5h6IAY.openStream()));
			List<String> B7BaO7om = new ArrayList<String>();
			String yF2hjVTS = bKGWPYgF.readLine();
			while (yF2hjVTS != null) {
				yF2hjVTS = yF2hjVTS.trim();
				if (yF2hjVTS.length() > 0 && !yF2hjVTS.startsWith("#"))
					B7BaO7om.add(yF2hjVTS);
				yF2hjVTS = bKGWPYgF.readLine();
			}
			return B7BaO7om;
		} catch (IOException MZwgHyGa) {
			throw new ExtensionException("Failed to read extension descriptor '%s'", MZwgHyGa).withArgs(oy5h6IAY);
		} finally {
			IoUtil.closeQuietly(bKGWPYgF);
		}
	}

}