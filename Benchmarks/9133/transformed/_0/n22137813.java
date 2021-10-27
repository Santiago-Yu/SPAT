class n22137813 {
	public static ObjectID[] sortDecending(ObjectID[] x2PXld2d) {
		for (int I9ovef77 = 1; I9ovef77 < x2PXld2d.length; I9ovef77++) {
			ObjectID VQy1sMgW = x2PXld2d[I9ovef77];
			for (int mkQogciI = 0; mkQogciI < x2PXld2d.length - I9ovef77; mkQogciI++) {
				if (x2PXld2d[mkQogciI].getTypePrefix() > x2PXld2d[mkQogciI + 1].getTypePrefix()) {
					ObjectID otpoBqVx = x2PXld2d[mkQogciI];
					x2PXld2d[mkQogciI] = x2PXld2d[mkQogciI + 1];
					x2PXld2d[mkQogciI + 1] = otpoBqVx;
				}
			}
		}
		return x2PXld2d;
	}

}