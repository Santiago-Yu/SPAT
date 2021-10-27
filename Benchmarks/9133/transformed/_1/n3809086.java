class n3809086 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		jButton1.setEnabled(false);
		int d6XzU = 0;
		while (d6XzU < max) {
			Card crd = WLP.getSelectedCard(WLP.jTable1.getSelectedRows()[d6XzU]);
			String s, s2;
			s = "";
			s2 = "";
			try {
				URL url = new URL("http://www.m-w.com/dictionary/" + crd.getWord());
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String str;
				while ((str = in.readLine()) != null) {
					s = s + str;
				}
				in.close();
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
			Pattern pattern = Pattern.compile("popWin\\('/cgi-bin/(.+?)'", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				String newurl = "http://m-w.com/cgi-bin/" + matcher.group(1);
				try {
					URL url2 = new URL(newurl);
					BufferedReader in2 = new BufferedReader(new InputStreamReader(url2.openStream()));
					String str;
					while ((str = in2.readLine()) != null) {
						s2 = s2 + str;
					}
					in2.close();
				} catch (MalformedURLException e) {
				} catch (IOException e) {
				}
				Pattern pattern2 = Pattern.compile(
						"<A HREF=\"http://(.+?)\">Click here to listen with your default audio player",
						Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
				Matcher matcher2 = pattern2.matcher(s2);
				if (matcher2.find()) {
					getWave("http://" + matcher2.group(1), crd.getWord());
				}
				int val = jProgressBar1.getValue();
				val++;
				jProgressBar1.setValue(val);
				this.paintAll(this.getGraphics());
			}
			d6XzU++;
		}
		jButton1.setEnabled(true);
	}

}