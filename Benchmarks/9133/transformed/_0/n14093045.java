class n14093045 {
	@Override
	public boolean delete(String MuikpRtE, boolean ccnlgDtG, int UQC1l7sa, Connection i41RhGJJ) throws SQLException {
		filasDelete = 0;
		if (!MuikpRtE.contains(";")) {
			this.tipoConsulta = new Scanner(MuikpRtE);
			if (this.tipoConsulta.hasNext()) {
				execConsulta = this.tipoConsulta.next();
				if (execConsulta.equalsIgnoreCase("delete")) {
					Connection ujlP3iGU = i41RhGJJ;
					Statement K05l9Hl3 = null;
					try {
						ujlP3iGU.setAutoCommit(ccnlgDtG);
						if (UQC1l7sa == 1 || UQC1l7sa == 2 || UQC1l7sa == 4 || UQC1l7sa == 8) {
							ujlP3iGU.setTransactionIsolation(UQC1l7sa);
						} else {
							throw new IllegalArgumentException(
									"Valor invalido sobre TransactionIsolation,\n TRANSACTION_NONE no es soportado por MySQL");
						}
						K05l9Hl3 = (Statement) ujlP3iGU.createStatement(ResultSetImpl.TYPE_SCROLL_SENSITIVE,
								ResultSetImpl.CONCUR_UPDATABLE);
						ujlP3iGU.setReadOnly(false);
						filasDelete = K05l9Hl3.executeUpdate(MuikpRtE.trim(), Statement.RETURN_GENERATED_KEYS);
						if (filasDelete > -1) {
							if (ccnlgDtG == false) {
								ujlP3iGU.commit();
							}
							return true;
						} else {
							return false;
						}
					} catch (MySQLIntegrityConstraintViolationException y2LMRyDe) {
						if (ccnlgDtG == false) {
							try {
								ujlP3iGU.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException ebLGD8Vr) {
								System.out.println("No se ejecuto un Rollback");
								ebLGD8Vr.printStackTrace();
							} catch (SQLException dx79Mfqv) {
								dx79Mfqv.printStackTrace();
							}
						}
						y2LMRyDe.printStackTrace();
						return false;
					} catch (MySQLNonTransientConnectionException zPhBmNdn) {
						if (ccnlgDtG == false) {
							try {
								ujlP3iGU.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException ECDpi0eE) {
								System.out.println("No se ejecuto un Rollback");
								ECDpi0eE.printStackTrace();
							} catch (SQLException ryYnRTfH) {
								ryYnRTfH.printStackTrace();
							}
						}
						zPhBmNdn.printStackTrace();
						return false;
					} catch (MySQLDataException r019aDuM) {
						System.out.println("Datos incorrectos");
						if (ccnlgDtG == false) {
							try {
								ujlP3iGU.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException gByTw2XB) {
								System.out.println("No se ejecuto un Rollback");
								gByTw2XB.printStackTrace();
							} catch (SQLException jpj376oU) {
								jpj376oU.printStackTrace();
							}
						}
						return false;
					} catch (MySQLSyntaxErrorException XH5bpOR5) {
						System.out.println("Error en la sintaxis de la Consulta en MySQL");
						if (ccnlgDtG == false) {
							try {
								ujlP3iGU.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException T3DzuSxD) {
								System.out.println("No se ejecuto un Rollback");
								T3DzuSxD.printStackTrace();
							} catch (SQLException qmAe6jHe) {
								qmAe6jHe.printStackTrace();
							}
						}
						return false;
					} catch (SQLException nymiXkpt) {
						if (ccnlgDtG == false) {
							try {
								ujlP3iGU.rollback();
								System.out.println("Se ejecuto un Rollback");
							} catch (MySQLTransactionRollbackException Tgs0aUB8) {
								System.out.println("No se ejecuto un Rollback");
								Tgs0aUB8.printStackTrace();
							} catch (SQLException BvDna10W) {
								BvDna10W.printStackTrace();
							}
						}
						nymiXkpt.printStackTrace();
						return false;
					} finally {
						try {
							if (K05l9Hl3 != null) {
								if (!K05l9Hl3.isClosed()) {
									K05l9Hl3.close();
								}
							}
							if (!ujlP3iGU.isClosed()) {
								ujlP3iGU.close();
							}
						} catch (NullPointerException qcajV9W4) {
							qcajV9W4.printStackTrace();
						} catch (SQLException FAAdZM5W) {
							FAAdZM5W.printStackTrace();
						}
					}
				} else {
					throw new IllegalArgumentException("No es una instruccion Delete");
				}
			} else {
				try {
					throw new JMySQLException("Error Grave , notifique al departamento de Soporte Tecnico \n" + email);
				} catch (JMySQLException HvvRGnvD) {
					Logger.getLogger(JMySQL.class.getName()).log(Level.SEVERE, null, HvvRGnvD);
					return false;
				}
			}
		} else {
			throw new IllegalArgumentException("No estan permitidas las MultiConsultas en este metodo");
		}
	}

}