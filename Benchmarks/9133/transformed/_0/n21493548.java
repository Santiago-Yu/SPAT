class n21493548 {
	private void jButton1ActionPerformed(java.awt.event.ActionEvent jr9crZW8) {
		try {
			URL YIgddEd3 = new URL(upgradeURL);
			InputStream i0FwcNXQ = YIgddEd3.openStream();
			BufferedInputStream DpmUivM7 = new BufferedInputStream(i0FwcNXQ);
			FileOutputStream j399onSH = new FileOutputStream("");
			String LKIliIRk = "";
			int IKvUkHYt = DpmUivM7.read();
			int SBqklkby = 1;
			while (IKvUkHYt != -1) {
				j399onSH.write(IKvUkHYt);
				LKIliIRk.concat(Character.toString((char) IKvUkHYt));
				DpmUivM7.read();
				SBqklkby++;
				updateProgressBar(SBqklkby);
			}
			j399onSH.close();
			DpmUivM7.close();
			MessageDigest Gj7S5ywQ = MessageDigest.getInstance("MD5");
			Gj7S5ywQ.update(LKIliIRk.getBytes());
			String oYIOZOL3 = Gj7S5ywQ.digest().toString();
			if (oYIOZOL3.length() == 31) {
				oYIOZOL3 = "0" + oYIOZOL3;
			}
			if (!oYIOZOL3.equalsIgnoreCase(md5Hash)) {
			}
		} catch (MalformedURLException rkNivOBR) {
		} catch (IOException uJdptBud) {
		} catch (NoSuchAlgorithmException dYdVJFX4) {
		}
	}

}