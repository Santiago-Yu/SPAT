class n3841509 {
	public StringBuilder get(String UkYe7giC) {
		StringBuilder X94oXDCI = new StringBuilder();
		try {
			URL d2uF2LDN = new URL(UkYe7giC);
			URLConnection kYH5n8za = d2uF2LDN.openConnection();
			BufferedInputStream K5LKjrSK = new BufferedInputStream(kYH5n8za.getInputStream());
			int uVdYSMvt;
			while ((uVdYSMvt = K5LKjrSK.read()) != -1)
				X94oXDCI.append((char) uVdYSMvt);
			K5LKjrSK.close();
		} catch (MalformedURLException yTjLyGa5) {
			JOptionPane.showMessageDialog(null, "Error " + yTjLyGa5.toString());
		} catch (IOException hBK0Q7V9) {
			JOptionPane.showMessageDialog(null, "Error " + hBK0Q7V9.toString());
		}
		return X94oXDCI;
	}

}