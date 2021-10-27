class n14093043 {
	@Override
	public boolean update(String imrkfexx, boolean HBrnY6QD, int WXQewaHm, Connection lV8TrJLA) throws SQLException {
		filasUpdate = 0;
		if (!imrkfexx.contains(";")) {
			this.tipoConsulta = new Scanner(imrkfexx);
			if (this.tipoConsulta.hasNext()) {
				execConsulta = this.tipoConsulta.next();
				if (execConsulta.equalsIgnoreCase("update")) {
					Connection fzXcMYRe = lV8TrJLA;
					Statement SlSu3pw4 = null;
					try {
						fzXcMYRe.setAutoCommit(HBrnY6QD);
						if (WXQewaHm == 1 || WXQewaHm == 2 || WXQewaHm == 4 || WXQewaHm == 8) {
							fzXcMYRe.setTransactionIsolation(WXQewaHm);
						} else {
							throw new IllegalArgumentException(
									"Valor invalido sobre TransactionIsolation,\n TRANSACTION_NONE no es soportado por MySQL");
						}
						SlSu3pw4 = (Statement) fzXcMYRe.createStatement(ResultSetImpl.TYPE_SCROLL_SENSITIVE,
								ResultSetImpl.CONCUR_UPDATABLE);
						fzXcMYRe.setReadOnly(false);
						filasUpdate = SlSu3pw4.executeUpdate(imrkfexx.trim(), Statement.RETURN_GENERATED_KEYS);
						if (filasUpdate > -1) {
							if (HBrnY6QD == false) {
								fzXcMYRe.commit();
							}
							return true;
						} else {
							return false;
						}
					} catch (MySQLIntegrityConstraintViolationException riiKhg2G) {
						System.out.println("Posible duplicacion de DATOS");
						if (HBrnY6QD == false) {
							try {
								fzXcMYRe.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException Xy5VQVqR) {
								System.out.println("No se ejecuto un Rollback");
								Xy5VQVqR.printStackTrace();
							} catch (SQLException VKFh0W8B) {
								VKFh0W8B.printStackTrace();
							}
						}
						riiKhg2G.printStackTrace();
						return false;
					} catch (MySQLNonTransientConnectionException O0JrTWp1) {
						if (HBrnY6QD == false) {
							try {
								fzXcMYRe.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException b25LLJeC) {
								System.out.println("No se ejecuto un Rollback");
								b25LLJeC.printStackTrace();
							} catch (SQLException on8BO0gW) {
								on8BO0gW.printStackTrace();
							}
						}
						O0JrTWp1.printStackTrace();
						return false;
					} catch (MySQLDataException NZFz0CyD) {
						System.out.println("Datos incorrectos");
						if (HBrnY6QD == false) {
							try {
								fzXcMYRe.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException nO6ruDuR) {
								System.out.println("No se ejecuto un Rollback");
								nO6ruDuR.printStackTrace();
							} catch (SQLException tcAE6bnr) {
								tcAE6bnr.printStackTrace();
							}
						}
						return false;
					} catch (MySQLSyntaxErrorException Nmkve7jJ) {
						System.out.println("Error en la sintaxis de la Consulta en MySQL");
						if (HBrnY6QD == false) {
							try {
								fzXcMYRe.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException Ru2pRDkg) {
								System.out.println("No se ejecuto un Rollback");
								Ru2pRDkg.printStackTrace();
							} catch (SQLException OtvGT2mh) {
								OtvGT2mh.printStackTrace();
							}
						}
						return false;
					} catch (SQLException rAdt6PbE) {
						if (HBrnY6QD == false) {
							try {
								fzXcMYRe.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException t2J3Zu0c) {
								System.out.println("No se ejecuto un Rollback");
								t2J3Zu0c.printStackTrace();
							} catch (SQLException uP4ovFrZ) {
								uP4ovFrZ.printStackTrace();
							}
						}
						rAdt6PbE.printStackTrace();
						return false;
					} finally {
						try {
							if (SlSu3pw4 != null) {
								if (!SlSu3pw4.isClosed()) {
									SlSu3pw4.close();
								}
							}
							if (!fzXcMYRe.isClosed()) {
								fzXcMYRe.close();
							}
						} catch (NullPointerException rSrbBRZM) {
							rSrbBRZM.printStackTrace();
						} catch (SQLException ic1k91Jy) {
							ic1k91Jy.printStackTrace();
						}
					}
				} else {
					throw new IllegalArgumentException("No es una instruccion Update");
				}
			} else {
				try {
					throw new JMySQLException("Error Grave , notifique al departamento de Soporte Tecnico \n" + email);
				} catch (JMySQLException bhdFw2LC) {
					Logger.getLogger(JMySQL.class.getName()).log(Level.SEVERE, null, bhdFw2LC);
					return false;
				}
			}
		} else {
			throw new IllegalArgumentException("No estan permitidas las MultiConsultas en este metodo");
		}
	}

}