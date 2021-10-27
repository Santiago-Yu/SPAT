class n9221721 {
	public SOCTradeOffer makeOffer(SOCPossiblePiece NOuJFenA) {
		D.ebugPrintln("***** MAKE OFFER *****");
		if (NOuJFenA == null) {
			return null;
		}
		SOCTradeOffer UEL1BCJZ = null;
		SOCResourceSet VJV9kKVG = null;
		switch (NOuJFenA.getType()) {
		case SOCPossiblePiece.CARD:
			VJV9kKVG = SOCGame.CARD_SET;
			break;
		case SOCPossiblePiece.ROAD:
			VJV9kKVG = SOCGame.ROAD_SET;
			break;
		case SOCPossiblePiece.SETTLEMENT:
			VJV9kKVG = SOCGame.SETTLEMENT_SET;
			break;
		case SOCPossiblePiece.CITY:
			VJV9kKVG = SOCGame.CITY_SET;
			break;
		}
		SOCResourceSet sGdlkcWs = ourPlayerData.getResources();
		D.ebugPrintln("*** targetResources = " + VJV9kKVG);
		D.ebugPrintln("*** ourResources = " + sGdlkcWs);
		if (sGdlkcWs.contains(VJV9kKVG)) {
			return UEL1BCJZ;
		}
		if (sGdlkcWs.getAmount(SOCResourceConstants.UNKNOWN) > 0) {
			D.ebugPrintln("AGG WE HAVE UNKNOWN RESOURCES !!!! %%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			return UEL1BCJZ;
		}
		SOCTradeOffer N6LGj8UC = getOfferToBank(VJV9kKVG);
		D.ebugPrintln("*** BATNA = " + N6LGj8UC);
		SOCBuildingSpeedEstimate St1GF9L8 = new SOCBuildingSpeedEstimate(ourPlayerData.getNumbers());
		SOCResourceSet Vp6m6p63 = new SOCResourceSet();
		SOCResourceSet fZubG4AD = new SOCResourceSet();
		int puUG2ZUb = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD, St1GF9L8);
		D.ebugPrintln("*** batnaBuildingTime = " + puUG2ZUb);
		if (N6LGj8UC != null) {
			puUG2ZUb = getETAToTargetResources(ourPlayerData, VJV9kKVG, N6LGj8UC.getGiveSet(), N6LGj8UC.getGetSet(),
					St1GF9L8);
		}
		D.ebugPrintln("*** batnaBuildingTime = " + puUG2ZUb);
		int[] MGc7iVuN = St1GF9L8.getRollsPerResource();
		int[] HqsZJrjb = new int[5];
		int[] ikHXQ28u = new int[5];
		int Efvyfmu4 = 0;
		int WKZpIEST = 0;
		for (int XhV4FMRx = SOCResourceConstants.CLAY; XhV4FMRx <= SOCResourceConstants.WOOD; XhV4FMRx++) {
			if (VJV9kKVG.getAmount(XhV4FMRx) > 0) {
				HqsZJrjb[Efvyfmu4] = XhV4FMRx;
				Efvyfmu4++;
			} else {
				ikHXQ28u[WKZpIEST] = XhV4FMRx;
				WKZpIEST++;
			}
		}
		for (int ZTDAxp9J = Efvyfmu4 - 1; ZTDAxp9J >= 0; ZTDAxp9J--) {
			for (int M3q91pH8 = 0; M3q91pH8 < ZTDAxp9J; M3q91pH8++) {
				if (MGc7iVuN[HqsZJrjb[M3q91pH8]] > MGc7iVuN[HqsZJrjb[M3q91pH8 + 1]]) {
					int TTKetWOG = HqsZJrjb[M3q91pH8];
					HqsZJrjb[M3q91pH8] = HqsZJrjb[M3q91pH8 + 1];
					HqsZJrjb[M3q91pH8 + 1] = TTKetWOG;
				}
			}
		}
		if (D.ebugOn) {
			for (int RNLq97jO = 0; RNLq97jO < Efvyfmu4; RNLq97jO++) {
				D.ebugPrintln("NEEDED RSRC: " + HqsZJrjb[RNLq97jO] + " : " + MGc7iVuN[HqsZJrjb[RNLq97jO]]);
			}
		}
		for (int S6P5YbBC = WKZpIEST - 1; S6P5YbBC >= 0; S6P5YbBC--) {
			for (int oZWexmDv = 0; oZWexmDv < S6P5YbBC; oZWexmDv++) {
				if (MGc7iVuN[ikHXQ28u[oZWexmDv]] > MGc7iVuN[ikHXQ28u[oZWexmDv + 1]]) {
					int wwhdvaWJ = ikHXQ28u[oZWexmDv];
					ikHXQ28u[oZWexmDv] = ikHXQ28u[oZWexmDv + 1];
					ikHXQ28u[oZWexmDv + 1] = wwhdvaWJ;
				}
			}
		}
		if (D.ebugOn) {
			for (int y9a9y3CY = 0; y9a9y3CY < WKZpIEST; y9a9y3CY++) {
				D.ebugPrintln("NOT-NEEDED RSRC: " + ikHXQ28u[y9a9y3CY] + " : " + MGc7iVuN[ikHXQ28u[y9a9y3CY]]);
			}
		}
		boolean[] kzhV5z0s = new boolean[SOCResourceConstants.MAXPLUSONE];
		for (int nNm1yXpj = SOCResourceConstants.CLAY; nNm1yXpj <= SOCResourceConstants.WOOD; nNm1yXpj++) {
			kzhV5z0s[nNm1yXpj] = false;
			for (int tXVWLq3e = 0; tXVWLq3e < SOCGame.MAXPLAYERS; tXVWLq3e++) {
				if ((tXVWLq3e != ourPlayerData.getPlayerNumber()) && (isSellingResource[tXVWLq3e][nNm1yXpj])) {
					kzhV5z0s[nNm1yXpj] = true;
					D.ebugPrintln("*** player " + tXVWLq3e + " is selling " + nNm1yXpj);
					break;
				}
			}
		}
		int uhNsAOes = Efvyfmu4 - 1;
		while ((uhNsAOes >= 0) && ((sGdlkcWs.getAmount(HqsZJrjb[uhNsAOes]) >= VJV9kKVG.getAmount(HqsZJrjb[uhNsAOes]))
				|| (!kzhV5z0s[HqsZJrjb[uhNsAOes]]))) {
			uhNsAOes--;
		}
		if (uhNsAOes >= 0) {
			D.ebugPrintln("*** getRsrc = " + HqsZJrjb[uhNsAOes]);
			fZubG4AD.add(1, HqsZJrjb[uhNsAOes]);
			D.ebugPrintln("*** offer should be null : offer = " + UEL1BCJZ);
			int q7UBaWZq = 0;
			while ((q7UBaWZq < WKZpIEST) && (UEL1BCJZ == null)) {
				D.ebugPrintln("*** ourResources.getAmount(" + ikHXQ28u[q7UBaWZq] + ") = "
						+ sGdlkcWs.getAmount(ikHXQ28u[q7UBaWZq]));
				if (sGdlkcWs.getAmount(ikHXQ28u[q7UBaWZq]) > 0) {
					Vp6m6p63.clear();
					Vp6m6p63.add(1, ikHXQ28u[q7UBaWZq]);
					UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
					D.ebugPrintln("*** offer = " + UEL1BCJZ);
					int Js6CaLOG = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD, St1GF9L8);
					D.ebugPrintln("*** offerBuildingTime = " + Js6CaLOG);
				}
				q7UBaWZq++;
			}
			D.ebugPrintln("*** ourResources = " + sGdlkcWs);
			if (UEL1BCJZ == null) {
				int byl4IOc6 = 0;
				while ((byl4IOc6 < Efvyfmu4) && (UEL1BCJZ == null)) {
					D.ebugPrintln("*** ourResources.getAmount(" + HqsZJrjb[byl4IOc6] + ") = "
							+ sGdlkcWs.getAmount(HqsZJrjb[byl4IOc6]));
					D.ebugPrintln("*** targetResources.getAmount(" + HqsZJrjb[byl4IOc6] + ") = "
							+ VJV9kKVG.getAmount(HqsZJrjb[byl4IOc6]));
					if ((sGdlkcWs.getAmount(HqsZJrjb[byl4IOc6]) > VJV9kKVG.getAmount(HqsZJrjb[byl4IOc6]))
							&& (HqsZJrjb[byl4IOc6] != HqsZJrjb[uhNsAOes])) {
						Vp6m6p63.clear();
						Vp6m6p63.add(1, HqsZJrjb[byl4IOc6]);
						int jar2UfKD = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD, St1GF9L8);
						if ((jar2UfKD < puUG2ZUb) || ((N6LGj8UC != null) && (jar2UfKD == puUG2ZUb)
								&& (Vp6m6p63.getTotal() < N6LGj8UC.getGiveSet().getTotal()))) {
							UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
							D.ebugPrintln("*** offer = " + UEL1BCJZ);
							D.ebugPrintln("*** offerBuildingTime = " + jar2UfKD);
						}
					}
					byl4IOc6++;
				}
			}
			D.ebugPrintln("*** ourResources = " + sGdlkcWs);
			SOCResourceSet abZlZ8ja = sGdlkcWs.copy();
			abZlZ8ja.subtract(VJV9kKVG);
			D.ebugPrintln("*** leftovers = " + abZlZ8ja);
			if (UEL1BCJZ == null) {
				int AA9nYXLp = 0;
				int ifBKLkuo = 0;
				while ((AA9nYXLp < WKZpIEST) && (UEL1BCJZ == null)) {
					if (sGdlkcWs.getAmount(ikHXQ28u[AA9nYXLp]) > 0) {
						while ((ifBKLkuo < WKZpIEST) && (UEL1BCJZ == null)) {
							Vp6m6p63.clear();
							Vp6m6p63.add(1, ikHXQ28u[AA9nYXLp]);
							Vp6m6p63.add(1, ikHXQ28u[ifBKLkuo]);
							if (sGdlkcWs.contains(Vp6m6p63)) {
								int yde8I1ad = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
										St1GF9L8);
								if ((yde8I1ad < puUG2ZUb) || ((N6LGj8UC != null) && (yde8I1ad == puUG2ZUb)
										&& (Vp6m6p63.getTotal() < N6LGj8UC.getGiveSet().getTotal()))) {
									UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
									D.ebugPrintln("*** offer = " + UEL1BCJZ);
									D.ebugPrintln("*** offerBuildingTime = " + yde8I1ad);
								}
							}
							ifBKLkuo++;
						}
						ifBKLkuo = 0;
						while ((ifBKLkuo < Efvyfmu4) && (UEL1BCJZ == null)) {
							if (HqsZJrjb[ifBKLkuo] != HqsZJrjb[uhNsAOes]) {
								Vp6m6p63.clear();
								Vp6m6p63.add(1, ikHXQ28u[AA9nYXLp]);
								Vp6m6p63.add(1, HqsZJrjb[ifBKLkuo]);
								if (abZlZ8ja.contains(Vp6m6p63)) {
									int CmLJdy0E = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
											St1GF9L8);
									if ((CmLJdy0E < puUG2ZUb) || ((N6LGj8UC != null) && (CmLJdy0E == puUG2ZUb)
											&& (Vp6m6p63.getTotal() < N6LGj8UC.getGiveSet().getTotal()))) {
										UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
										D.ebugPrintln("*** offer = " + UEL1BCJZ);
										D.ebugPrintln("*** offerBuildingTime = " + CmLJdy0E);
									}
								}
							}
							ifBKLkuo++;
						}
					}
					AA9nYXLp++;
				}
				AA9nYXLp = 0;
				ifBKLkuo = 0;
				while ((AA9nYXLp < Efvyfmu4) && (UEL1BCJZ == null)) {
					if ((abZlZ8ja.getAmount(HqsZJrjb[AA9nYXLp]) > 0) && (HqsZJrjb[AA9nYXLp] != HqsZJrjb[uhNsAOes])) {
						while ((ifBKLkuo < WKZpIEST) && (UEL1BCJZ == null)) {
							Vp6m6p63.clear();
							Vp6m6p63.add(1, HqsZJrjb[AA9nYXLp]);
							Vp6m6p63.add(1, ikHXQ28u[ifBKLkuo]);
							if (abZlZ8ja.contains(Vp6m6p63)) {
								int EUMfTBAx = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
										St1GF9L8);
								if ((EUMfTBAx < puUG2ZUb) || ((N6LGj8UC != null) && (EUMfTBAx == puUG2ZUb)
										&& (Vp6m6p63.getTotal() < N6LGj8UC.getGiveSet().getTotal()))) {
									UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
									D.ebugPrintln("*** offer = " + UEL1BCJZ);
									D.ebugPrintln("*** offerBuildingTime = " + EUMfTBAx);
								}
							}
							ifBKLkuo++;
						}
						ifBKLkuo = 0;
						while ((ifBKLkuo < Efvyfmu4) && (UEL1BCJZ == null)) {
							if (HqsZJrjb[ifBKLkuo] != HqsZJrjb[uhNsAOes]) {
								Vp6m6p63.clear();
								Vp6m6p63.add(1, HqsZJrjb[AA9nYXLp]);
								Vp6m6p63.add(1, HqsZJrjb[ifBKLkuo]);
								if (abZlZ8ja.contains(Vp6m6p63)) {
									int YVppSExV = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
											St1GF9L8);
									if ((YVppSExV < puUG2ZUb) || ((N6LGj8UC != null) && (YVppSExV == puUG2ZUb)
											&& (Vp6m6p63.getTotal() < N6LGj8UC.getGiveSet().getTotal()))) {
										UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, HqsZJrjb[uhNsAOes]);
										D.ebugPrintln("*** offer = " + UEL1BCJZ);
										D.ebugPrintln("*** offerBuildingTime = " + YVppSExV);
									}
								}
							}
							ifBKLkuo++;
						}
					}
					AA9nYXLp++;
				}
			}
		}
		if (UEL1BCJZ == null) {
			SOCResourceSet szI8X12m = sGdlkcWs.copy();
			szI8X12m.subtract(VJV9kKVG);
			D.ebugPrintln("*** leftovers = " + szI8X12m);
			int MHKG02it = WKZpIEST - 1;
			while ((MHKG02it >= 0) && (!kzhV5z0s[HqsZJrjb[MHKG02it]])) {
				MHKG02it--;
			}
			while ((MHKG02it >= 0) && (UEL1BCJZ == null)) {
				fZubG4AD.clear();
				fZubG4AD.add(1, ikHXQ28u[MHKG02it]);
				szI8X12m.add(1, ikHXQ28u[MHKG02it]);
				if (UEL1BCJZ == null) {
					int btd0ceLq = 0;
					while ((btd0ceLq < WKZpIEST) && (UEL1BCJZ == null)) {
						if ((szI8X12m.getAmount(ikHXQ28u[btd0ceLq]) > 0)
								&& (ikHXQ28u[btd0ceLq] != ikHXQ28u[MHKG02it])) {
							szI8X12m.subtract(1, ikHXQ28u[btd0ceLq]);
							if (getOfferToBank(VJV9kKVG, szI8X12m) != null) {
								Vp6m6p63.clear();
								Vp6m6p63.add(1, ikHXQ28u[btd0ceLq]);
								int Ek4r6qME = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
										St1GF9L8);
								if (Ek4r6qME < puUG2ZUb) {
									UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, ikHXQ28u[MHKG02it]);
									D.ebugPrintln("*** offer = " + UEL1BCJZ);
									D.ebugPrintln("*** offerBuildingTime = " + Ek4r6qME);
								}
							}
							szI8X12m.add(1, ikHXQ28u[btd0ceLq]);
						}
						btd0ceLq++;
					}
				}
				if (UEL1BCJZ == null) {
					int tdgsCTaN = 0;
					while ((tdgsCTaN < Efvyfmu4) && (UEL1BCJZ == null)) {
						if (szI8X12m.getAmount(HqsZJrjb[tdgsCTaN]) > 0) {
							szI8X12m.subtract(1, HqsZJrjb[tdgsCTaN]);
							if (getOfferToBank(VJV9kKVG, szI8X12m) != null) {
								Vp6m6p63.clear();
								Vp6m6p63.add(1, HqsZJrjb[tdgsCTaN]);
								int QuiIC77n = getETAToTargetResources(ourPlayerData, VJV9kKVG, Vp6m6p63, fZubG4AD,
										St1GF9L8);
								if (QuiIC77n < puUG2ZUb) {
									UEL1BCJZ = makeOfferAux(Vp6m6p63, fZubG4AD, ikHXQ28u[MHKG02it]);
									D.ebugPrintln("*** offer = " + UEL1BCJZ);
									D.ebugPrintln("*** offerBuildingTime = " + QuiIC77n);
								}
							}
							szI8X12m.add(1, HqsZJrjb[tdgsCTaN]);
						}
						tdgsCTaN++;
					}
				}
				szI8X12m.subtract(1, ikHXQ28u[MHKG02it]);
				MHKG02it--;
			}
		}
		return UEL1BCJZ;
	}

}