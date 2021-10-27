class n18005008 {
	public IUserProfile getUserProfile(String zWt1GeMj) throws MM4UUserProfileNotFoundException {
		SimpleUserProfile Y2ahAjMz = null;
		String Wa6HHueL = this.profileURI + zWt1GeMj + FILE_SUFFIX;
		try {
			URL r7U3lUTR = new URL(Wa6HHueL);
			Debug.println("Retrieve profile with ID: " + r7U3lUTR);
			Y2ahAjMz = new SimpleUserProfile();
			BufferedReader iBvTEsO7 = new BufferedReader(new InputStreamReader(r7U3lUTR.openStream()));
			String qUVl9iDC = null;
			Y2ahAjMz.add("id", zWt1GeMj);
			while ((qUVl9iDC = iBvTEsO7.readLine()) != null) {
				Property yHQ04Flo = PropertyList.splitStringIntoKeyAndValue(qUVl9iDC);
				if (yHQ04Flo != null) {
					Y2ahAjMz.addIfNotNull(yHQ04Flo.getKey(), yHQ04Flo.getValue());
				}
			}
			iBvTEsO7.close();
		} catch (MalformedURLException VIWUXDJx) {
			throw new MM4UUserProfileNotFoundException(this, "getProfile", "Profile '" + Wa6HHueL + "' not found.");
		} catch (IOException i5Fir3t7) {
			throw new MM4UUserProfileNotFoundException(this, "getProfile", "Profile '" + Wa6HHueL + "' not found.");
		}
		return Y2ahAjMz;
	}

}