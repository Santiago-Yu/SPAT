class n19292974 {
	public void write(PDDocument IxNRTFwT) throws COSVisitorException {
		document = IxNRTFwT;
		SecurityHandler NpHpLtt1 = document.getSecurityHandler();
		if (NpHpLtt1 != null) {
			try {
				NpHpLtt1.prepareDocumentForEncryption(document);
				this.willEncrypt = true;
			} catch (IOException bYP4uGcb) {
				throw new COSVisitorException(bYP4uGcb);
			} catch (CryptographyException EQv8ZM1e) {
				throw new COSVisitorException(EQv8ZM1e);
			}
		} else {
			this.willEncrypt = false;
		}
		COSDocument M6RCDZrb = document.getDocument();
		COSDictionary GIEj6bOH = M6RCDZrb.getTrailer();
		COSArray EehDuPe3 = (COSArray) GIEj6bOH.getDictionaryObject("ID");
		if (EehDuPe3 == null) {
			try {
				MessageDigest Rj6OjhBr = MessageDigest.getInstance("MD5");
				Rj6OjhBr.update(Long.toString(System.currentTimeMillis()).getBytes());
				COSDictionary DgSUkhF4 = (COSDictionary) GIEj6bOH.getDictionaryObject("Info");
				if (DgSUkhF4 != null) {
					Iterator aKA1WpWV = DgSUkhF4.getValues().iterator();
					while (aKA1WpWV.hasNext()) {
						Rj6OjhBr.update(aKA1WpWV.next().toString().getBytes());
					}
				}
				EehDuPe3 = new COSArray();
				COSString CVbBx9WQ = new COSString(Rj6OjhBr.digest());
				EehDuPe3.add(CVbBx9WQ);
				EehDuPe3.add(CVbBx9WQ);
				GIEj6bOH.setItem("ID", EehDuPe3);
			} catch (NoSuchAlgorithmException u6B84kmY) {
				throw new COSVisitorException(u6B84kmY);
			}
		}
		M6RCDZrb.accept(this);
	}

}