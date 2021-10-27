class n16006791 {
	public void print(PrintWriter YJBzMmR2) {
		YJBzMmR2.println("<?xml version=\"1.0\"?>\n"
				+ "<?xml-stylesheet type=\"text/xsl\" href=\"http://www.urbigene.com/foaf/foaf2html.xsl\" ?>\n"
				+ "<rdf:RDF \n" + "xml:lang=\"en\" \n" + "xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"  \n"
				+ "xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" \n" + "xmlns=\"http://xmlns.com/foaf/0.1/\" \n"
				+ "xmlns:foaf=\"http://xmlns.com/foaf/0.1/\" \n" + "xmlns:dc=\"http://purl.org/dc/elements/1.1/\">\n");
		YJBzMmR2.println("<!-- generated with SciFoaf http://www.urbigene.com/foaf -->");
		if (this.mainAuthor == null && this.authors.getAuthorCount() > 0) {
			this.mainAuthor = this.authors.getAuthorAt(0);
		}
		if (this.mainAuthor != null) {
			YJBzMmR2.println("<foaf:PersonalProfileDocument rdf:about=\"\">\n" + "\t<foaf:primaryTopic rdf:nodeID=\""
					+ this.mainAuthor.getID() + "\"/>\n"
					+ "\t<foaf:maker rdf:resource=\"mailto:plindenbaum@yahoo.fr\"/>\n" + "\t<dc:title>FOAF for "
					+ XMLUtilities.escape(this.mainAuthor.getName()) + "</dc:title>\n" + "\t<dc:description>\n"
					+ "\tFriend-of-a-Friend description for " + XMLUtilities.escape(this.mainAuthor.getName()) + "\n"
					+ "\t</dc:description>\n" + "</foaf:PersonalProfileDocument>\n\n");
		}
		for (int j5zFwSXv = 0; j5zFwSXv < this.laboratories.size(); ++j5zFwSXv) {
			Laboratory oDPEeS3h = this.laboratories.getLabAt(j5zFwSXv);
			YJBzMmR2.println("<foaf:Group rdf:ID=\"laboratory_ID" + j5zFwSXv + "\" >");
			YJBzMmR2.println("\t<foaf:name>" + XMLUtilities.escape(oDPEeS3h.toString()) + "</foaf:name>");
			for (int D3HEHFvb = 0; D3HEHFvb < oDPEeS3h.getAuthorCount(); ++D3HEHFvb) {
				YJBzMmR2.println("\t<foaf:member rdf:resource=\"#" + oDPEeS3h.getAuthorAt(D3HEHFvb).getID() + "\" />");
			}
			YJBzMmR2.println("</foaf:Group>\n\n");
		}
		for (int BxEVe4us = 0; BxEVe4us < this.authors.size(); ++BxEVe4us) {
			Author GJBxSx3v = authors.getAuthorAt(BxEVe4us);
			YJBzMmR2.println("<foaf:Person rdf:ID=\"" + xmlName(GJBxSx3v.getID()) + "\" >");
			YJBzMmR2.println("\t<foaf:name>" + xmlName(GJBxSx3v.getName()) + "</foaf:name>");
			YJBzMmR2.println("\t<foaf:title>Dr</foaf:title>");
			YJBzMmR2.println("\t<foaf:family_name>" + xmlName(GJBxSx3v.getLastName()) + "</foaf:family_name>");
			if (GJBxSx3v.getForeName() != null && GJBxSx3v.getForeName().length() > 2) {
				YJBzMmR2.println("\t<foaf:firstName>" + xmlName(GJBxSx3v.getForeName()) + "</foaf:firstName>");
			}
			String IwauuGKu = GJBxSx3v.getProperty("foaf:mbox");
			if (IwauuGKu != null) {
				String ikczgo01[] = IwauuGKu.split("[\t ]+");
				for (int RnqeN5qw = 0; RnqeN5qw < ikczgo01.length; ++RnqeN5qw) {
					if (ikczgo01[RnqeN5qw].trim().length() == 0)
						continue;
					if (ikczgo01[RnqeN5qw].equals("mailto:"))
						continue;
					if (!ikczgo01[RnqeN5qw].startsWith("mailto:"))
						ikczgo01[RnqeN5qw] = "mailto:" + ikczgo01[RnqeN5qw];
					try {
						MessageDigest py5cgIQq = MessageDigest.getInstance("SHA");
						py5cgIQq.update(ikczgo01[RnqeN5qw].getBytes());
						byte[] fRPqjJuE = py5cgIQq.digest();
						YJBzMmR2.print("\t<foaf:mbox_sha1sum>");
						for (int x4RZApQt = 0; x4RZApQt < fRPqjJuE.length; x4RZApQt++) {
							String uQSE2XG0 = Integer.toHexString(fRPqjJuE[x4RZApQt]);
							if (uQSE2XG0.length() == 1)
								uQSE2XG0 = "0" + uQSE2XG0;
							uQSE2XG0 = uQSE2XG0.substring(uQSE2XG0.length() - 2);
							YJBzMmR2.print(uQSE2XG0);
						}
						YJBzMmR2.println("</foaf:mbox_sha1sum>");
					} catch (Exception dSvsQiER) {
						YJBzMmR2.println("\t<foaf:mbox rdf:resource=\"" + ikczgo01[RnqeN5qw] + "\" />");
					}
				}
			}
			IwauuGKu = GJBxSx3v.getProperty("foaf:nick");
			if (IwauuGKu != null) {
				String o9kwXbJR[] = IwauuGKu.split("[\t ]+");
				for (int vfVEyNYR = 0; vfVEyNYR < o9kwXbJR.length; ++vfVEyNYR) {
					if (o9kwXbJR[vfVEyNYR].trim().length() == 0)
						continue;
					YJBzMmR2.println("\t<foaf:surname>" + XMLUtilities.escape(o9kwXbJR[vfVEyNYR]) + "</foaf:surname>");
				}
			}
			IwauuGKu = GJBxSx3v.getProperty("foaf:homepage");
			if (IwauuGKu != null) {
				String fXNLgv0G[] = IwauuGKu.split("[\t ]+");
				for (int NvAmtL95 = 0; NvAmtL95 < fXNLgv0G.length; ++NvAmtL95) {
					if (!fXNLgv0G[NvAmtL95].trim().startsWith("http://"))
						continue;
					if (fXNLgv0G[NvAmtL95].trim().equals("http://"))
						continue;
					YJBzMmR2.println("\t<foaf:homepage  rdf:resource=\""
							+ XMLUtilities.escape(fXNLgv0G[NvAmtL95].trim()) + "\"/>");
				}
			}
			YJBzMmR2.println(
					"\t<foaf:publications rdf:resource=\"http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?db=pubmed&amp;cmd=Search&amp;itool=pubmed_Abstract&amp;term="
							+ GJBxSx3v.getTerm() + "\"/>");
			IwauuGKu = GJBxSx3v.getProperty("foaf:img");
			if (IwauuGKu != null) {
				String Ia2zbf6o[] = IwauuGKu.split("[\t ]+");
				for (int UOhPENfq = 0; UOhPENfq < Ia2zbf6o.length; ++UOhPENfq) {
					if (!Ia2zbf6o[UOhPENfq].trim().startsWith("http://"))
						continue;
					if (Ia2zbf6o[UOhPENfq].trim().equals("http://"))
						continue;
					YJBzMmR2.println("\t<foaf:depiction rdf:resource=\""
							+ XMLUtilities.escape(Ia2zbf6o[UOhPENfq].trim()) + "\"/>");
				}
			}
			AuthorList MqJTPoPR = this.whoknowwho.getKnown(GJBxSx3v);
			for (int QmJiku12 = 0; QmJiku12 < MqJTPoPR.size(); ++QmJiku12) {
				YJBzMmR2.println(
						"\t<foaf:knows rdf:resource=\"#" + xmlName(MqJTPoPR.getAuthorAt(QmJiku12).getID()) + "\" />");
			}
			Paper VlRAqzVA[] = this.papers.getAuthorPublications(GJBxSx3v).toArray();
			if (!(VlRAqzVA.length == 0)) {
				HashSet PgzPDiKJ = new HashSet();
				for (int nELscKQO = 0; nELscKQO < VlRAqzVA.length; ++nELscKQO) {
					PgzPDiKJ.addAll(VlRAqzVA[nELscKQO].meshTerms);
				}
				for (Iterator DmYBgqPE = PgzPDiKJ.iterator(); DmYBgqPE.hasNext();) {
					MeshTerm xgJBK7iH = (MeshTerm) DmYBgqPE.next();
					YJBzMmR2.println("\t<foaf:interest>\n" + "\t\t<rdf:Description rdf:about=\"" + xgJBK7iH.getURL()
							+ "\">\n" + "\t\t\t<dc:title>" + XMLUtilities.escape(xgJBK7iH.toString()) + "</dc:title>\n"
							+ "\t\t</rdf:Description>\n" + "\t</foaf:interest>");
				}
			}
			YJBzMmR2.println("</foaf:Person>\n\n");
		}
		Paper CVZWFxFy[] = this.papers.toArray();
		for (int xlQ6V8Ds = 0; xlQ6V8Ds < CVZWFxFy.length; ++xlQ6V8Ds) {
			YJBzMmR2.println(
					"<foaf:Document rdf:about=\"http://www.ncbi.nlm.nih.gov/entrez/query.fcgi?cmd=Retrieve&amp;db=pubmed&amp;dopt=Abstract&amp;list_uids="
							+ CVZWFxFy[xlQ6V8Ds].getPMID() + "\">");
			YJBzMmR2.println("<dc:title>" + XMLUtilities.escape(CVZWFxFy[xlQ6V8Ds].getTitle()) + "</dc:title>");
			for (Iterator IcaNSZvn = CVZWFxFy[xlQ6V8Ds].authors.iterator(); IcaNSZvn.hasNext();) {
				Author r1njc1FQ = (Author) IcaNSZvn.next();
				YJBzMmR2.println("<dc:author rdf:resource=\"#" + XMLUtilities.escape(r1njc1FQ.getID()) + "\"/>");
			}
			YJBzMmR2.println("</foaf:Document>");
		}
		YJBzMmR2.println("</rdf:RDF>");
	}

}