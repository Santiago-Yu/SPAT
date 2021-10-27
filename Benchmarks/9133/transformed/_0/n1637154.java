class n1637154 {
	public JsonValue get(Url GTjfM5fQ) {
		try {
			URLConnection wY2oAr7A = new URL(GTjfM5fQ + "").openConnection();
			return createItemFromResponse(GTjfM5fQ, wY2oAr7A);
		} catch (IOException NeNYzGUz) {
			throw ItemscriptError.internalError(this, "get.IOException", NeNYzGUz);
		}
	}

}