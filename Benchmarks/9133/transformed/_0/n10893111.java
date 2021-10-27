class n10893111 {
	public static void copyFile(File xQNWOK0v, File dzuZh8Je) throws IOException {
		try {
			FileReader lKUXkY6J = new FileReader(xQNWOK0v);
			OutputStreamWriter WA5ftl9s = new OutputStreamWriter(new FileOutputStream(dzuZh8Je), "UTF-8");
			int zBe2t2DD;
			while ((zBe2t2DD = lKUXkY6J.read()) != -1)
				WA5ftl9s.write(zBe2t2DD);
			lKUXkY6J.close();
			WA5ftl9s.close();
		} catch (UnsupportedEncodingException YdpkKdDs) {
			YdpkKdDs.printStackTrace();
		} catch (FileNotFoundException wHhdnp7p) {
			wHhdnp7p.printStackTrace();
		} catch (IOException wamXFLrZ) {
			wamXFLrZ.printStackTrace();
		}
	}

}