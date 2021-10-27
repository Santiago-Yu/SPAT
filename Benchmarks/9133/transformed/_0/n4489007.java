class n4489007 {
	Object onSuccess() {
		this.mErrorExist = true;
		this.mErrorMdp = true;
		if (!mClientManager.exists(this.mNewMail)) {
			this.mErrorExist = false;
			if (mNewMdp.equals(mNewMdpConfirm)) {
				this.mErrorMdp = false;
				MessageDigest euq513Sc;
				try {
					euq513Sc = MessageDigest.getInstance("SHA1");
					euq513Sc.reset();
					euq513Sc.update(this.mNewMdp.getBytes());
					byte[] W1aBjhKE = euq513Sc.digest();
					BigInteger xtmBaRgo = new BigInteger(1, W1aBjhKE);
					String wHuKRRgv = xtmBaRgo.toString(16);
					Client vGZQGB3f = new Client(this.mNewNom, (this.mNewPrenom != null ? this.mNewPrenom : ""),
							this.mNewMail, wHuKRRgv, this.mNewAdresse, 1);
					mClientManager.save(vGZQGB3f);
					mComponentResources.discardPersistentFieldChanges();
					return "Client/List";
				} catch (NoSuchAlgorithmException c0Cslys1) {
					mLogger.error(c0Cslys1.getMessage(), c0Cslys1);
				}
			}
		}
		return errorZone.getBody();
	}

}