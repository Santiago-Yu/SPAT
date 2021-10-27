class n9580883 {
	public String translate(String VOmvaCy4, int IJAMnxnG) throws CoreException {
		if (VOmvaCy4 == null)
			throw new IllegalArgumentException("before is null.");
		if ((IJAMnxnG != ENGLISH_TO_JAPANESE) && (IJAMnxnG != JAPANESE_TO_ENGLISH)) {
			throw new IllegalArgumentException("Invalid translateType. value=" + IJAMnxnG);
		}
		try {
			URL kxK1EQ23 = new URL(config.getTranslatorSiteUrl());
			URLConnection eBVCVYyU = kxK1EQ23.openConnection();
			sendTranslateRequest(VOmvaCy4, IJAMnxnG, eBVCVYyU);
			String BeoDyLqS = receiveTranslatedResponse(eBVCVYyU);
			String pUXXURu8 = config.getTranslationResultStart();
			String Ivbmwtav = config.getTranslationResultEnd();
			int cVHXXbec = pUXXURu8.length();
			int H4vMqw3O = BeoDyLqS.indexOf(pUXXURu8);
			if (H4vMqw3O != -1) {
				int QokzCTUW = BeoDyLqS.indexOf(Ivbmwtav, H4vMqw3O);
				if (QokzCTUW != -1) {
					String INKwGBlP = BeoDyLqS.substring(H4vMqw3O + cVHXXbec, QokzCTUW);
					INKwGBlP = replaceEntities(INKwGBlP);
					return INKwGBlP;
				} else {
					throwCoreException(ERROR_END_KEYWORD_NOT_FOUND, "End keyword not found.", null);
				}
			} else {
				throwCoreException(ERROR_START_KEYWORD_NOT_FOUND, "Start keyword not found.", null);
			}
		} catch (IOException PVKQzMNU) {
			throwCoreException(ERROR_IO, PVKQzMNU.getMessage(), PVKQzMNU);
		}
		throw new IllegalStateException("CoreException not occurd.");
	}

}