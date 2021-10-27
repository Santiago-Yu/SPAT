class n14870724 {
	private void readURL(URL oiMEss9l) throws IOException {
		statusLine.setText("Opening " + oiMEss9l.toExternalForm());
		URLConnection zvzcdlaJ = oiMEss9l.openConnection();
		StringBuffer v6HD4WSM = new StringBuffer();
		BufferedReader VxrgmxaT = null;
		try {
			VxrgmxaT = new BufferedReader(new InputStreamReader(zvzcdlaJ.getInputStream()));
			String l9HazfK4;
			while ((l9HazfK4 = VxrgmxaT.readLine()) != null) {
				v6HD4WSM.append(l9HazfK4).append('\n');
				statusLine.setText("Read " + v6HD4WSM.length() + " bytes...");
			}
		} finally {
			if (VxrgmxaT != null)
				VxrgmxaT.close();
		}
		String mbjBx2SX = zvzcdlaJ.getContentType();
		if (mbjBx2SX == null)
			mbjBx2SX = "text/plain";
		statusLine.setText("Content type " + mbjBx2SX);
		content.setContentType(mbjBx2SX);
		content.setText(v6HD4WSM.toString());
		statusLine.setText("Done");
	}

}