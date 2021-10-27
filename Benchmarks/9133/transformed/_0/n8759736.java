class n8759736 {
	public File convert(URI zafRpLYK) throws DjatokaException {
		processing.add(zafRpLYK.toString());
		File Jnh6BJQS = null;
		try {
			logger.info("processingRemoteURI: " + zafRpLYK.toURL());
			boolean vWKydBsF = false;
			InputStream UZYKNepT = IOUtils.getInputStream(zafRpLYK.toURL());
			String LbCTbjrY = zafRpLYK.toURL().toString().substring(zafRpLYK.toURL().toString().lastIndexOf(".") + 1)
					.toLowerCase();
			if (LbCTbjrY.equals(FORMAT_ID_TIF) || LbCTbjrY.equals(FORMAT_ID_TIFF)) {
				Jnh6BJQS = File.createTempFile("convert" + zafRpLYK.hashCode(), "." + FORMAT_ID_TIF);
			} else if (formatMap.containsKey(LbCTbjrY) && (formatMap.get(LbCTbjrY).equals(FORMAT_MIMEYPE_JP2)
					|| formatMap.get(LbCTbjrY).equals(FORMAT_MIMEYPE_JPX))) {
				Jnh6BJQS = File.createTempFile("cache" + zafRpLYK.hashCode(), "." + LbCTbjrY);
				vWKydBsF = true;
			} else {
				if (UZYKNepT.markSupported())
					UZYKNepT.mark(15);
				if (ImageProcessingUtils.checkIfJp2(UZYKNepT))
					Jnh6BJQS = File.createTempFile("cache" + zafRpLYK.hashCode(), "." + FORMAT_ID_JP2);
				if (UZYKNepT.markSupported())
					UZYKNepT.reset();
				else {
					UZYKNepT.close();
					UZYKNepT = IOUtils.getInputStream(zafRpLYK.toURL());
				}
			}
			if (Jnh6BJQS == null) {
				Jnh6BJQS = File.createTempFile("convert" + zafRpLYK.hashCode(), ".img");
			}
			Jnh6BJQS.deleteOnExit();
			FileOutputStream fDeryCQj = new FileOutputStream(Jnh6BJQS);
			IOUtils.copyStream(UZYKNepT, fDeryCQj);
			if (!vWKydBsF)
				Jnh6BJQS = processImage(Jnh6BJQS, zafRpLYK);
			UZYKNepT.close();
			fDeryCQj.close();
			return Jnh6BJQS;
		} catch (Exception vzjsOZid) {
			Jnh6BJQS.delete();
			throw new DjatokaException(vzjsOZid);
		} finally {
			if (processing.contains(zafRpLYK.toString()))
				processing.remove(zafRpLYK.toString());
		}
	}

}