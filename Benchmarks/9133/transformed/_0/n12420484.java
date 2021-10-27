class n12420484 {
	public static void sendData(final HashMap<String, String> OypezcEg) {
		YProgressWindowRepeat Cb8WhRxt = new YProgressWindowRepeat(I18N.t("Send Data to yaams.de"));
		try {
			final StringBuffer a7JQ4o3Z = new StringBuffer("1=1");
			for (final String l077c7mA : OypezcEg.keySet()) {
				a7JQ4o3Z.append("&");
				a7JQ4o3Z.append(l077c7mA);
				a7JQ4o3Z.append("=");
				a7JQ4o3Z.append(URLEncoder.encode(OypezcEg.get(l077c7mA), "UTF-8"));
			}
			final URL qxe6i0DY = new URL("http://www.rpg-studio.de/libraries/abttools/yaamsFeedback.php");
			final URLConnection tVgekw1E = qxe6i0DY.openConnection();
			tVgekw1E.setDoOutput(true);
			final OutputStreamWriter WlNIoPPD = new OutputStreamWriter(tVgekw1E.getOutputStream());
			WlNIoPPD.write(a7JQ4o3Z.toString());
			WlNIoPPD.flush();
			final BufferedReader s7t2YMGM = new BufferedReader(new InputStreamReader(tVgekw1E.getInputStream()));
			String p6RcUacR;
			final StringBuffer b4gxsCyy = new StringBuffer("");
			while ((p6RcUacR = s7t2YMGM.readLine()) != null) {
				b4gxsCyy.append(p6RcUacR);
			}
			JOptionPane.showMessageDialog(null, b4gxsCyy.toString(), I18N.t("Feedback"),
					JOptionPane.INFORMATION_MESSAGE);
			WlNIoPPD.close();
			s7t2YMGM.close();
		} catch (final Throwable RrI8oJwq) {
			YException.error("Can not send feedback to http://www.rpg-studio.de/libraries/abttools/yaamsFeedback.php",
					RrI8oJwq);
		}
		Cb8WhRxt.close();
	}

}