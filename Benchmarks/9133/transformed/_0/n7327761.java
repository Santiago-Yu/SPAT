class n7327761 {
	private void fillProductResult() {
		this.ProductResult = new int[this.linearDim + 1][this.linearDim + 1];
		for (int Lxf3oUBP = 1; Lxf3oUBP < this.linearDim + 1; Lxf3oUBP++) {
			this.ProductResult[1][Lxf3oUBP] = Lxf3oUBP;
			this.ProductResult[Lxf3oUBP][1] = Lxf3oUBP;
		}
		int[] ktGp5oMU = new int[2 * this.GradeCount - 1];
		int ZZmdivCS = 0;
		int DBpcRiGG = 0;
		int DHAgaq90 = 2;
		int MHCeJJND = 2;
		int ewkvayty = 1;
		int cmybeDM2 = 1;
		int k7hfoPk2 = 0;
		for (DHAgaq90 = 2; DHAgaq90 < this.linearDim + 1; DHAgaq90++) {
			for (MHCeJJND = 2; MHCeJJND < this.linearDim + 1; MHCeJJND++) {
				ZZmdivCS = 0;
				DBpcRiGG = 0;
				for (ewkvayty = 1; ewkvayty < this.GradeCount; ewkvayty++) {
					ktGp5oMU[ewkvayty] = this.ABasis.getBasis(DHAgaq90, ewkvayty);
					ktGp5oMU[ewkvayty + this.GradeCount - 1] = this.ABasis.getBasis(MHCeJJND, ewkvayty);
				}
				ewkvayty = 1;
				for (ewkvayty = 1; ewkvayty < 2 * this.GradeCount - 1; ewkvayty++) {
					for (cmybeDM2 = 1; cmybeDM2 < 2 * this.GradeCount - 2; cmybeDM2++) {
						if (ktGp5oMU[cmybeDM2] > ktGp5oMU[cmybeDM2 + 1]) {
							k7hfoPk2 = ktGp5oMU[cmybeDM2];
							ktGp5oMU[cmybeDM2] = ktGp5oMU[cmybeDM2 + 1];
							ktGp5oMU[cmybeDM2 + 1] = k7hfoPk2;
							if (!(ktGp5oMU[cmybeDM2] == 0 || ktGp5oMU[cmybeDM2 + 1] == 0)) {
								ZZmdivCS += 1;
							}
						}
					}
					cmybeDM2 = 1;
				}
				ewkvayty = 1;
				ZZmdivCS = ZZmdivCS % 2;
				for (ewkvayty = 1; ewkvayty < 2 * this.GradeCount - 2; ewkvayty++) {
					if (ktGp5oMU[ewkvayty] == 0)
						continue;
					if (ktGp5oMU[ewkvayty] == ktGp5oMU[ewkvayty + 1]) {
						k7hfoPk2 = ktGp5oMU[ewkvayty];
						ktGp5oMU[ewkvayty] = 0;
						ktGp5oMU[ewkvayty + 1] = 0;
						ewkvayty += 1;
						ZZmdivCS += intSignature[k7hfoPk2 - 1];
					}
				}
				ewkvayty = 1;
				ZZmdivCS = ZZmdivCS % 2;
				for (ewkvayty = 1; ewkvayty < 2 * this.GradeCount - 1; ewkvayty++) {
					for (cmybeDM2 = 1; cmybeDM2 < 2 * this.GradeCount - 2; cmybeDM2++) {
						if (ktGp5oMU[cmybeDM2] > ktGp5oMU[cmybeDM2 + 1]) {
							k7hfoPk2 = ktGp5oMU[cmybeDM2];
							ktGp5oMU[cmybeDM2] = ktGp5oMU[cmybeDM2 + 1];
							ktGp5oMU[cmybeDM2 + 1] = k7hfoPk2;
							if (!(ktGp5oMU[cmybeDM2] == 0 || ktGp5oMU[cmybeDM2 + 1] == 0)) {
								ZZmdivCS += 1;
							}
						}
					}
					cmybeDM2 = 1;
				}
				ewkvayty = 1;
				ZZmdivCS = ZZmdivCS % 2;
				for (ewkvayty = 1; ewkvayty < 2 * this.GradeCount - 1; ewkvayty++) {
					DBpcRiGG += (int) ktGp5oMU[ewkvayty]
							* Math.pow(this.GradeCount, 2 * this.GradeCount - 2 - ewkvayty);
				}
				ewkvayty = 1;
				this.ProductResult[DHAgaq90][MHCeJJND] = 0;
				for (ewkvayty = 1; ewkvayty < this.linearDim + 1; ewkvayty++) {
					if (DBpcRiGG == this.ABasis.getBasisKey(ewkvayty)) {
						this.ProductResult[DHAgaq90][MHCeJJND] = ewkvayty * (int) Math.pow(-1.0, ZZmdivCS);
						break;
					}
				}
				ewkvayty = 1;
			}
			MHCeJJND = 2;
		}
	}

}