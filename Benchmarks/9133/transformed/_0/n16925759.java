class n16925759 {
	public void run() {
		try {
			URL GHnp4IKi = new URL("http://mydiversite.appspot.com/version.html");
			BufferedReader kggvqLjg = new BufferedReader(new InputStreamReader(GHnp4IKi.openStream()));
			String vqYpfz6R;
			while ((vqYpfz6R = kggvqLjg.readLine()) != null) {
				System.out.println(vqYpfz6R);
			}
			kggvqLjg.close();
		} catch (MalformedURLException mPt8RwUb) {
			mPt8RwUb.printStackTrace();
		} catch (IOException jXUxtDQz) {
			jXUxtDQz.printStackTrace();
		}
	}

}