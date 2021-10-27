class n2936895 {
	protected byte[] createFileID() {
		try {
			COSDocument o1FT2cA9 = cosGetDoc();
			if (o1FT2cA9 == null) {
				return null;
			}
			ILocator vezw7C4S = o1FT2cA9.getLocator();
			if (vezw7C4S == null) {
				return null;
			}
			IRandomAccess lhLeIE2f = o1FT2cA9.stGetDoc().getRandomAccess();
			if (lhLeIE2f == null) {
				lhLeIE2f = new RandomAccessByteArray(StringTools.toByteArray("DummyValue"));
			}
			MessageDigest dShvcjD0 = MessageDigest.getInstance("MD5");
			long TOS3bt5N = System.currentTimeMillis();
			dShvcjD0.update(String.valueOf(TOS3bt5N).getBytes());
			dShvcjD0.update(vezw7C4S.getFullName().getBytes());
			dShvcjD0.update(String.valueOf(lhLeIE2f.getLength()).getBytes());
			COSInfoDict wRONqBdA = getInfoDict();
			if (wRONqBdA != null) {
				for (Iterator h7imFlJf = wRONqBdA.cosGetDict().iterator(); h7imFlJf.hasNext();) {
					COSObject xIGf2muP = (COSObject) h7imFlJf.next();
					dShvcjD0.update(xIGf2muP.stringValue().getBytes());
				}
			}
			return dShvcjD0.digest();
		} catch (Exception VGIekGJd) {
			throw new IllegalStateException(VGIekGJd);
		}
	}

}