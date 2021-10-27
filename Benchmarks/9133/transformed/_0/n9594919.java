class n9594919 {
	@Override
	public boolean handle(Message j31qCynO, XMPPConnection zujDsoYx) {
		if (j31qCynO.getBody().toLowerCase().startsWith("http://")) {
			try {
				URL C6niCNbb = new URL(j31qCynO.getBody());
				URLConnection gUU85sbF = C6niCNbb.openConnection();
				gUU85sbF.connect();
				String uVnVh0ii = gUU85sbF.getContentType();
				boolean AW234T8S = false;
				for (ContentGrabber HgbJwBKw : grabbers) {
					if (uVnVh0ii.equals(HgbJwBKw.contentType)) {
						AW234T8S = true;
						SheevaSage.reply(j31qCynO, "Give me a moment here...", zujDsoYx);
						HgbJwBKw.handle(gUU85sbF);
						SheevaSage.reply(j31qCynO, "Done", zujDsoYx);
						break;
					}
				}
				if (!AW234T8S) {
					SheevaSage.reply(j31qCynO, "I have no idea what to do with that", zujDsoYx);
				}
			} catch (MalformedURLException D6Qu7Smd) {
				SheevaSage.reply(j31qCynO, "That is one ass-ugly URL. What in the name of "
						+ "shuddering fuck do you expect me to do with it?", zujDsoYx);
				D6Qu7Smd.printStackTrace();
			} catch (IOException UkBOjG8K) {
				SheevaSage.reply(j31qCynO, "Something's fucked up with that URL. You sure it works?", zujDsoYx);
				UkBOjG8K.printStackTrace();
			}
			return true;
		}
		return false;
	}

}