class n14310068 {
	protected Boolean lancerincident(long h0ldDV05, String rXjDugpd, java.util.GregorianCalendar WWANnJjD,
			long nIjltvFh, String MdHZ8sy7, String sbz2KjwF) {
		String vw1832aa;
		Boolean uDZ4BdP8 = false;
		Boolean aK1xgrQY;
		int lqyW1aNH;
		acgtools_core.AcgIO.SortieLog(new Date() + " - Appel de la fonction Lancer incident");
		Statement Zu4GV0HK = null;
		ResultSet glQP0cwo = null;
		String ayOyUdCx = "";
		acgtools_core.AcgIO.SortieLog(
				new Date() + " - nouvel incident pour le bloc : " + acgtools_core.AcgIO.RetourneDate(WWANnJjD));
		try {
			this.con = db.OpenConnection();
			aK1xgrQY = this.con.getAutoCommit();
			this.con.setAutoCommit(false);
			if (h0ldDV05 == 0) {
				h0ldDV05 = this.CreationBloc(nIjltvFh);
				if (h0ldDV05 == 0) {
					uDZ4BdP8 = false;
					acgtools_core.AcgIO.SortieLog(new Date() + " - Probl¨¨me lors de la cr¨¦ation du bloc");
					this.con.rollback();
					this.con.close();
					return false;
				}
			}
			acgtools_core.AcgIO.SortieLog(new Date() + " - bloc : " + h0ldDV05);
			lqyW1aNH = this.ChargerEtatServeur(h0ldDV05, WWANnJjD);
			if (lqyW1aNH != 2) {
				Zu4GV0HK = con.createStatement();
				acgtools_core.AcgIO.SortieLog(new Date() + " - Etat charg¨¦");
				ayOyUdCx = "SELECT incref_err_numer FROM tbl_incident_ref " + "WHERE incref_cde_job ='" + h0ldDV05
						+ "' " + "AND incref_err_numer NOT IN " + "(SELECT incref_err_numer FROM tbl_incident_ref "
						+ "WHERE incref_err_etat='c') " + "AND incref_err_numer NOT IN "
						+ "(SELECT incenc_err_numer FROM tbl_incident_encours " + "WHERE incenc_err_etat='c') ;";
				acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
				glQP0cwo = Zu4GV0HK.executeQuery(ayOyUdCx);
				if (!glQP0cwo.next()) {
					glQP0cwo.close();
					ayOyUdCx = "INSERT INTO tbl_incident_ref "
							+ "(incref_cde_job,incref_err_date,incref_err_etat,incref_niv_crimd,incref_err_msg,incref_err_srvnm)"
							+ "VALUES ('" + h0ldDV05 + "','" + acgtools_core.AcgIO.RetourneDate(WWANnJjD) + "','"
							+ rXjDugpd + "','" + MdHZ8sy7 + "','" + sbz2KjwF + "','" + nIjltvFh + "');";
					acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
					Zu4GV0HK.executeUpdate(ayOyUdCx);
					ayOyUdCx = "SELECT incref_err_numer FROM tbl_incident_ref " + "WHERE incref_cde_job = '" + h0ldDV05
							+ "' " + "AND incref_err_srvnm = '" + nIjltvFh + "' " + "AND incref_err_date = '"
							+ acgtools_core.AcgIO.RetourneDate(WWANnJjD) + "';";
					acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
					glQP0cwo = Zu4GV0HK.executeQuery(ayOyUdCx);
					if (glQP0cwo.next()) {
						vw1832aa = glQP0cwo.getString("incref_err_numer");
						glQP0cwo.close();
						ayOyUdCx = "INSERT INTO tbl_incident_encours"
								+ "(incenc_err_numer, incenc_err_etat, incenc_esc_etap, "
								+ "incenc_err_date, incenc_typ_user,incenc_cde_user,incenc_err_msg,incenc_niv_crimd) "
								+ "VALUES ('" + vw1832aa + "','" + rXjDugpd + "',0, " + "'"
								+ acgtools_core.AcgIO.RetourneDate(WWANnJjD) + "','n',0,'" + sbz2KjwF + "','" + MdHZ8sy7
								+ "');";
						acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
						Zu4GV0HK.executeUpdate(ayOyUdCx);
						acgtools_core.AcgIO.SortieLog(new Date() + " - Incident ins¨¦r¨¦ dans la base de donn¨¦es");
						acgtools_core.AcgIO
								.SortieLog(new Date() + " - Traitement de l'envois des emails si n¨¦cessaire");
						this.usermail(vw1832aa, lqyW1aNH, acgtools_core.AcgIO.RetourneDate(WWANnJjD), sbz2KjwF);
						acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦ation de l'historique");
						this.CreerHistorique(vw1832aa);
						acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦er maj");
						this.CreerMaj(true);
						uDZ4BdP8 = true;
					} else {
						acgtools_core.AcgIO
								.SortieLog(new Date() + " - Probl¨¨me d'insertion du nouvel incident dans la base");
						uDZ4BdP8 = false;
					}
				} else {
					vw1832aa = glQP0cwo.getString("incref_err_numer");
					acgtools_core.AcgIO.SortieLog(new Date() + " - Num¨¦ro de l'erreur trouv¨¦. Num¨¦ro =" + vw1832aa);
					ayOyUdCx = "SELECT incenc_err_etat FROM tbl_incident_encours " + "WHERE incenc_err_numer='"
							+ vw1832aa + "';";
					acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
					glQP0cwo = Zu4GV0HK.executeQuery(ayOyUdCx);
					if (!glQP0cwo.next()) {
						glQP0cwo.close();
						acgtools_core.AcgIO
								.SortieLog(new Date() + " - Probl¨¨me lors de la lecture de l'¨¦tat de l'incident.");
						String jw3Pqo0Y = "INSERT INTO tbl_incident_encours"
								+ "(incenc_err_numer, incenc_err_etat, incenc_esc_etap, "
								+ "incenc_err_date, incenc_typ_user,incenc_cde_user,incenc_err_msg,incenc_niv_crimd) "
								+ "VALUES ('" + vw1832aa + "','" + rXjDugpd + "',0, " + "'"
								+ acgtools_core.AcgIO.RetourneDate(WWANnJjD) + "','n',0,'"
								+ "Incident non clotur&eacute; - " + sbz2KjwF + "','" + MdHZ8sy7 + "');";
						acgtools_core.AcgIO.SortieLog(new Date() + " - " + jw3Pqo0Y);
						Zu4GV0HK.execute(jw3Pqo0Y);
						glQP0cwo = Zu4GV0HK.executeQuery(ayOyUdCx);
					} else {
						glQP0cwo = Zu4GV0HK.executeQuery(ayOyUdCx);
						acgtools_core.AcgIO.SortieLog(new Date() + " - Incident correctement positionn¨¦ dans encours");
					}
					if (glQP0cwo.next()) {
						switch (rXjDugpd.charAt(0)) {
						case 'c': {
							acgtools_core.AcgIO.SortieLog(new Date() + " - Cloture de l'incident.");
							ayOyUdCx = "UPDATE tbl_incident_ref SET incref_err_etat='c'" + "WHERE incref_err_numer='"
									+ vw1832aa + "';";
							acgtools_core.AcgIO.SortieLog(new Date() + " - " + ayOyUdCx);
							Zu4GV0HK.executeUpdate(ayOyUdCx);
							this.UpdateEnCours(vw1832aa, "c", MdHZ8sy7, acgtools_core.AcgIO.RetourneDate(WWANnJjD),
									sbz2KjwF, "auto");
							acgtools_core.AcgIO
									.SortieLog(new Date() + " - Traitement de l'envois des emails si n¨¦cessaire");
							this.usermail(vw1832aa, lqyW1aNH, sbz2KjwF, acgtools_core.AcgIO.RetourneDate(WWANnJjD));
							acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦er maj");
							this.CreerMaj(false);
							uDZ4BdP8 = true;
							break;
						}
						case 'm': {
							this.UpdateEnCours(vw1832aa, "m", MdHZ8sy7, acgtools_core.AcgIO.RetourneDate(WWANnJjD),
									sbz2KjwF, "auto");
							acgtools_core.AcgIO
									.SortieLog(new Date() + " - Traitement de l'envois des emails si n¨¦cessaire");
							this.usermail(vw1832aa, lqyW1aNH, sbz2KjwF, acgtools_core.AcgIO.RetourneDate(WWANnJjD));
							acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦er maj");
							this.CreerMaj(false);
							uDZ4BdP8 = true;
							break;
						}
						default: {
							this.UpdateEnCours(vw1832aa, "m", MdHZ8sy7, acgtools_core.AcgIO.RetourneDate(WWANnJjD),
									sbz2KjwF, "");
							acgtools_core.AcgIO
									.SortieLog(new Date() + " - Traitement de l'envois des emails si n¨¦cessaire");
							this.usermail(vw1832aa, lqyW1aNH, sbz2KjwF, acgtools_core.AcgIO.RetourneDate(WWANnJjD));
							acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦er maj");
							this.CreerMaj(false);
							uDZ4BdP8 = true;
							break;
						}
						}
					} else {
						acgtools_core.AcgIO
								.SortieLog(new Date() + " - Probl¨¨me lors de la lecture de l'¨¦tat de l'incident.");
						uDZ4BdP8 = false;
					}
				}
			} else {
				acgtools_core.AcgIO.SortieLog(new Date() + " - Systeme en maintenance, pas de remont¨¦e d'incidents.");
				uDZ4BdP8 = false;
			}
		} catch (ClassNotFoundException ujxNa10p) {
			acgtools_core.AcgIO.SortieLog(new Date() + "Annulation des modifications.");
			con.rollback();
			acgtools_core.AcgIO.SortieLog(new Date() + "Probl¨¦me lors de l'¨¦x¨¦cution de la connexion.");
			acgtools_core.AcgIO.SortieLog(ujxNa10p.getMessage());
			uDZ4BdP8 = false;
		} catch (SQLException HjqkdvtU) {
			acgtools_core.AcgIO.SortieLog(new Date() + "Annulation des modifications.");
			con.rollback();
			acgtools_core.AcgIO.SortieLog(HjqkdvtU.getMessage());
			acgtools_core.AcgIO.SortieLog(new Date() + "Probl¨¦me lors de l'¨¦x¨¦cution de la requ¨¨te SQL :");
			acgtools_core.AcgIO.SortieLog(ayOyUdCx);
			uDZ4BdP8 = false;
		} finally {
			try {
				if (Zu4GV0HK != null) {
					Zu4GV0HK.close();
				}
				if (uDZ4BdP8) {
					con.commit();
					acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦ation de l'incident : succ¨¨s");
				} else {
					con.rollback();
					acgtools_core.AcgIO.SortieLog(new Date() + " - Cr¨¦ation de l'incident : echec");
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception fzUf3uz2) {
				acgtools_core.AcgIO
						.SortieLog(new Date() + "Probl¨¨me lors de la fermeture de la connection ¨¤ la base de donn¨¦es");
			}
			return uDZ4BdP8;
		}
	}

}