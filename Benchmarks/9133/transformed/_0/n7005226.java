class n7005226 {
	private void copyValidFile(File UZiWQCSU, int uvtDlRYC) {
		try {
			String r6QIWMvt = String.format("%s%s%02d%s%s", validovane, File.separator, uvtDlRYC, File.separator,
					UZiWQCSU.getName());
			boolean hS6hS52p = false;
			File UxCjKtl5 = new File(r6QIWMvt);
			if (UxCjKtl5.exists()) {
				if (UZiWQCSU.lastModified() > UxCjKtl5.lastModified())
					hS6hS52p = true;
				else
					hS6hS52p = false;
			} else {
				UxCjKtl5.createNewFile();
				hS6hS52p = true;
			}
			if (hS6hS52p) {
				String Un1RfslO = "" + (char) 0x0D + (char) 0x0A;
				FileReader M6bwqtlD = new FileReader(UZiWQCSU);
				BufferedReader RR0Vocrl = new BufferedReader(M6bwqtlD);
				FileWriter b81Yxq5d = new FileWriter(UxCjKtl5);
				String Y5i7hrRO;
				while ((Y5i7hrRO = RR0Vocrl.readLine()) != null)
					b81Yxq5d.write(Y5i7hrRO + Un1RfslO);
				RR0Vocrl.close();
				b81Yxq5d.close();
				UxCjKtl5.setLastModified(UZiWQCSU.lastModified());
			}
		} catch (FileNotFoundException HnoPxe3e) {
			HnoPxe3e.printStackTrace();
		} catch (IOException cvVFQ5pe) {
			cvVFQ5pe.printStackTrace();
		}
	}

}