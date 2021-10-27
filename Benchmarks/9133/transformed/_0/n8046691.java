class n8046691 {
	private void retrieveFile(URL i7b42BC3, RSLink OC1bxvFG) {
		OC1bxvFG.setStatus(RSLink.STATUS_DOWNLOADING);
		HttpURLConnection VMY7tYo3 = null;
		DataOutputStream TjPSHVgj = null;
		BufferedInputStream oRqfgWLS = null;
		BufferedOutputStream VxfizQHy = null;
		try {
			String XT1K6t3p = URLEncoder.encode("mirror", "UTF-8") + "="
					+ URLEncoder.encode(i7b42BC3.toString(), "UTF-8");
			VMY7tYo3 = (HttpURLConnection) i7b42BC3.openConnection();
			VMY7tYo3.setRequestMethod("POST");
			VMY7tYo3.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			VMY7tYo3.setRequestProperty("Content-Length", "" + Integer.toString(XT1K6t3p.getBytes().length));
			VMY7tYo3.setRequestProperty("Content-Language", "en-US");
			VMY7tYo3.setDoOutput(true);
			VMY7tYo3.setDoInput(true);
			TjPSHVgj = new DataOutputStream(VMY7tYo3.getOutputStream());
			TjPSHVgj.writeBytes(XT1K6t3p);
			TjPSHVgj.flush();
			Pattern pOTqhgRQ = Pattern.compile(".+/html.+");
			Matcher ZyGglk6p = pOTqhgRQ.matcher(VMY7tYo3.getContentType());
			if (ZyGglk6p.find()) {
				log("Can not download, maybe all RS slots are busy!");
				return;
			}
			OC1bxvFG.setSize(VMY7tYo3.getContentLength());
			oRqfgWLS = new BufferedInputStream(VMY7tYo3.getInputStream(), 4096);
			VxfizQHy = new BufferedOutputStream(new FileOutputStream(OC1bxvFG.getFile()), 4096);
			OC1bxvFG.setStatus(RSLink.STATUS_DOWNLOADING);
			OC1bxvFG.setDown(0);
			byte[] sXmKEWsL = new byte[4096];
			int GRizqkLT;
			while ((GRizqkLT = oRqfgWLS.read(sXmKEWsL)) != -1) {
				VxfizQHy.write(sXmKEWsL, 0, GRizqkLT);
				OC1bxvFG.setDown(OC1bxvFG.getDown() + GRizqkLT);
				if (!Main.start.get()) {
					OC1bxvFG.setStatus(RSLink.STATUS_NOTHING);
					return;
				}
			}
			OC1bxvFG.setStatus(RSLink.STATUS_DONE);
		} catch (IOException HUVLUfd0) {
			log("I/O Exception!");
			OC1bxvFG.setStatus(RSLink.STATUS_NOTHING);
		} finally {
			try {
				if (TjPSHVgj != null)
					TjPSHVgj.close();
				if (VxfizQHy != null)
					VxfizQHy.close();
				if (oRqfgWLS != null)
					oRqfgWLS.close();
			} catch (IOException c8zyBdnp) {
				JOptionPane.showMessageDialog(null, "Can not close some connections:\n" + c8zyBdnp.getMessage(),
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
			if (VMY7tYo3 != null)
				VMY7tYo3.disconnect();
		}
	}

}