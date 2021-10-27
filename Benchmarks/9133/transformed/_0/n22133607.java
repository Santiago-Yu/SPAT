class n22133607 {
	Object onSuccess() {
		this.mErrorExist = true;
		this.mErrorMdp = true;
		if (this.mNewMail.equals(mClient.getEmail())
				|| !this.mNewMail.equals(mClient.getEmail()) && !mClientManager.exists(this.mNewMail)) {
			this.mErrorExist = false;
			if (mNewMdp != null && mNewMdpConfirm != null) {
				if (this.mNewMdp.equals(this.mNewMdpConfirm)) {
					this.mErrorMdp = false;
					MessageDigest wUmn80Ar;
					try {
						wUmn80Ar = MessageDigest.getInstance("SHA1");
						wUmn80Ar.reset();
						wUmn80Ar.update(this.mNewMdp.getBytes());
						byte[] xTkW8VR4 = wUmn80Ar.digest();
						BigInteger T0OINzmQ = new BigInteger(1, xTkW8VR4);
						String fFnHF6T2 = T0OINzmQ.toString(16);
						mClient.setMdp(fFnHF6T2);
					} catch (NoSuchAlgorithmException D8RNzcEi) {
						mLogger.error(D8RNzcEi.getMessage(), D8RNzcEi);
					}
				}
			} else {
				this.mErrorMdp = false;
			}
			if (!this.mErrorMdp) {
				mClient.setAdresse(this.mNewAdresse);
				mClient.setEmail(this.mNewMail);
				mClient.setNom(this.mNewNom);
				mClient.setPrenom((this.mNewPrenom != null ? this.mNewPrenom : ""));
				Client unffmQhL = new Client(mClient);
				mClientManager.save(unffmQhL);
				mComponentResources.discardPersistentFieldChanges();
				return "Client/List";
			}
		}
		return errorZone.getBody();
	}

}