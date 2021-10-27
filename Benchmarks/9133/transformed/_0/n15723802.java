class n15723802 {
	void createAgentProgram(PrintStream tSv7NtxN, String qcEY0O4R, String SMmDlaDN)
			throws IOException, ConfigException {
		Agent fKZtiRBW = service.getAgent(qcEY0O4R);
		File u0T1UPgo = getInstanceDir();
		double Bny5uVTe = engine.getTimeout();
		String mT0fcv9b = "\"";
		String HwyHIaZO = "agent-" + qcEY0O4R + ".py";
		String aqW2n4os = "service.py";
		Set<String> B8akDA99 = fKZtiRBW.getTasks().keySet();
		File GzdjLhzC = getService().getScriptDir();
		final boolean z0wvi7YO = true;
		{
			tSv7NtxN.println("#!/bin/sh");
			tSv7NtxN.println("umask 0077");
		}
		for (String QwDrqlyO : B8akDA99) {
			Task DOqpQImj = getService().getTask(QwDrqlyO);
			String ghyzc9VP = DOqpQImj.getScriptContent();
			if (z0wvi7YO) {
				tSv7NtxN.println();
				tSv7NtxN.println(
						"cat > " + DOqpQImj.getFile() + " << " + mT0fcv9b + "EOF_" + DOqpQImj.getFile() + mT0fcv9b);
				tSv7NtxN.println(ghyzc9VP);
				tSv7NtxN.println("EOF_" + DOqpQImj.getFile());
			} else {
				File JiqeP7nC = new File(u0T1UPgo, DOqpQImj.getFile());
				PrintStream ZYaV51Ki = new PrintStream(JiqeP7nC);
				ZYaV51Ki.print(ghyzc9VP);
				ZYaV51Ki.close();
			}
		}
		{
			PrintStream KD7xfHcd = null;
			if (z0wvi7YO) {
				tSv7NtxN.println();
				tSv7NtxN.println("cat > " + aqW2n4os + " << " + mT0fcv9b + "EOF_" + aqW2n4os + mT0fcv9b);
				KD7xfHcd = tSv7NtxN;
			} else {
				File wmRZJDrb = new File(u0T1UPgo, aqW2n4os);
				KD7xfHcd = new PrintStream(wmRZJDrb);
			}
			service.createServiceScript(KD7xfHcd);
			if (z0wvi7YO)
				tSv7NtxN.println("EOF_" + aqW2n4os);
			else
				KD7xfHcd.close();
		}
		{
			URL aRIT9mGn = new URL(engine.getAgentContextURL() + "/" + engine.getAgentURLPath());
			log.debug("url for agent = " + aRIT9mGn.toExternalForm());
			PrintStream j02AKiN8 = null;
			if (z0wvi7YO) {
				tSv7NtxN.println();
				tSv7NtxN.println("cat > " + HwyHIaZO + " << " + mT0fcv9b + "EOF_" + HwyHIaZO + mT0fcv9b);
				j02AKiN8 = tSv7NtxN;
			} else {
				File MgulHEo3 = new File(u0T1UPgo, HwyHIaZO);
				j02AKiN8 = new PrintStream(MgulHEo3);
			}
			String E41XquG2[] = { "", "    ", "        ", "            ", "                ", "                    " };
			int vqm1nivb = 0;
			j02AKiN8.println(E41XquG2[vqm1nivb] + "from wrapper import ZSIWrapper");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "from service import Service");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "import threading");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "from sys import exit");
			j02AKiN8.println();
			j02AKiN8.println(E41XquG2[vqm1nivb] + "URL=" + mT0fcv9b + aRIT9mGn.toString() + mT0fcv9b);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "agentID=" + mT0fcv9b + SMmDlaDN + mT0fcv9b);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "instanceID=" + instanceID);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "instanceKey=" + mT0fcv9b + key + mT0fcv9b);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "timeout=" + mT0fcv9b + Bny5uVTe + mT0fcv9b);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "stop_flag=0");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "kill_flag=0");
			j02AKiN8.println();
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# Need extra port for each thread, "
					+ "ZSIWrapper (actually ZSI) not thread save");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "port0=ZSIWrapper(URL, agentID, instanceID, instanceKey, timeout)");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "port0.setAgentStatus(" + Status.RUNNING.ordinal() + ")");
			j02AKiN8.println();
			j02AKiN8.println(E41XquG2[vqm1nivb] + "def create_namespace(service) :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    " + mT0fcv9b + "create a namespace for injection "
					+ "into a task script and returns it." + mT0fcv9b);
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# first get most (not all) variables");
			j02AKiN8.print(E41XquG2[vqm1nivb] + "    arglist = [ ");
			int LAMiwbGT = 0;
			for (VarAttributes P8xkzlFh : attributesMap.values()) {
				LAMiwbGT++;
				String MWaXFd0D = P8xkzlFh.getName();
				if (Constants.VAR_STDOUT.equals(MWaXFd0D))
					continue;
				VarTypeEnum PqBlRrFa = P8xkzlFh.getType();
				switch (PqBlRrFa) {
				case DOUBLE:
				case STRING:
				case LONG:
				case BOOLEAN:
				case CHOICE:
					j02AKiN8.print(E41XquG2[vqm1nivb] + "    '" + MWaXFd0D + "'");
					if (LAMiwbGT != attributesMap.size())
						j02AKiN8.println(",\\");
					break;
				case FILES:
					break;
				default:
					throw new RuntimeException("unkown data type in switch");
				}
			}
			j02AKiN8.println("]");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    vars=port0.getManyVars(arglist)");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    namesp = vars ");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    namesp[ 'service' ] = service ");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    return namesp");
			j02AKiN8.println();
			for (String jklDG6CL : B8akDA99) {
				Task bHWRGpyl = getService().getTask(jklDG6CL);
				boolean kRfZ1UOV = bHWRGpyl.isBackground();
				j02AKiN8.println(E41XquG2[vqm1nivb] + "def task_" + jklDG6CL + "():");
				{
					vqm1nivb++;
					j02AKiN8.println(E41XquG2[vqm1nivb] + "try :");
					if (kRfZ1UOV) {
						j02AKiN8.println(
								E41XquG2[vqm1nivb] + "    # as ZSIWrapper is not task save," + " create a new one");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    port_task=ZSIWrapper(URL, agentID, "
								+ "instanceID, instanceKey, timeout)");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    service = Service(port_task)");
					} else {
						j02AKiN8.println(
								E41XquG2[vqm1nivb] + "    # this is foreground, " + "use port0 from current task");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    service = Service(port0)");
					}
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    globals = create_namespace(service)");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    locals = { }");
					j02AKiN8.println(
							E41XquG2[vqm1nivb] + "    execfile('" + bHWRGpyl.getFile() + "', globals, locals )");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "except :");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    port0.setTaskStatus('" + jklDG6CL + "', "
							+ Status.FAILED.ordinal() + " )");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "else :");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    if kill_flag :");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "        task_exit_status = " + Status.FAILED.ordinal());
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    elif stop_flag :");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "        task_exit_status = " + Status.TERMINATED.ordinal());
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    else :");
					j02AKiN8.println(E41XquG2[vqm1nivb] + "        task_exit_status = " + Status.FINISHED.ordinal());
					j02AKiN8.println(
							E41XquG2[vqm1nivb] + "    port0.setTaskStatus('" + jklDG6CL + "', task_exit_status )");
					j02AKiN8.println();
					vqm1nivb--;
				}
			}
			j02AKiN8.println(E41XquG2[vqm1nivb] + "try:");
			vqm1nivb++;
			j02AKiN8.println(E41XquG2[vqm1nivb] + "tasklist = []");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "action=None");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "while action != '" + Agent.STOP + "' and action != '" + Agent.KILL
					+ "' and action != '" + Agent.FINISH + "' :");
			{
				vqm1nivb++;
				j02AKiN8.println(E41XquG2[vqm1nivb] + "# print 'ACTION=', action");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "action = port0.getAction()");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "# cleanup tasklist (only to save memory)");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "# In two cycles, don't change list during iter.");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "to_be_removed = []");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "for tr2 in tasklist:");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    if (not tr2.isAlive()):");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "        to_be_removed.append(tr2)");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "for tr3 in to_be_removed:");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'old task removed: ',tr3.getName()");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    tasklist.remove(tr3)");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "if action == None :");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'processing None'");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    None");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "if action == '" + Agent.FINISH + "' :");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'processing FINISH'");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    None");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "elif action == '" + Agent.STOP + "' :");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    stop_flag=1");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'processing STOP'");
				String obFU5Tnk = fKZtiRBW.onStop;
				if (obFU5Tnk != null) {
					String CFfNvoMn = "task_" + obFU5Tnk;
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    " + CFfNvoMn + "()");
				}
				j02AKiN8.println(E41XquG2[vqm1nivb] + "");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "elif action == '" + Agent.KILL + "' :");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    kill_flag=1");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'processing KILL'");
				String j1OCzHU6 = fKZtiRBW.onKill;
				if (j1OCzHU6 != null) {
					String qWqqufis = "task_" + j1OCzHU6;
					j02AKiN8.println(E41XquG2[vqm1nivb] + "    " + qWqqufis + "()");
				}
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # This would be the place " + "to kill external programs");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    port0.setAgentStatus(" + Status.FAILED.ordinal() + ")");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    # exit without waiting for bg threads");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    exit(13)");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "");
				for (String BLsaxx5H : B8akDA99) {
					Task JAMb6eva = getService().getTask(BLsaxx5H);
					boolean uHPdF2ax = JAMb6eva.isBackground();
					j02AKiN8.println(E41XquG2[vqm1nivb] + "elif action == '" + Agent.TASK + BLsaxx5H + "':");
					String qYbWWVfW = "task_" + BLsaxx5H;
					if (uHPdF2ax) {
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    # create, register and start task");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    t = threading.Thread(target=" + qYbWWVfW + ", name='"
								+ qYbWWVfW + "')");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    tasklist.append(t)");
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    t.start()");
					} else {
						j02AKiN8.println(E41XquG2[vqm1nivb] + "    " + qYbWWVfW + "()");
					}
				}
				j02AKiN8.println(E41XquG2[vqm1nivb] + "else :");
				j02AKiN8.println(E41XquG2[vqm1nivb] + "    print 'undefined case in agent script iov0j23fds, "
						+ "action=', action");
				vqm1nivb--;
			}
			j02AKiN8.println();
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# wait for running background tasks");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# print 'remaining threads (inclides demonic ones!):'"
					+ ", threading.activeCount()");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# for tr in threading.enumerate():");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "#    print 'remaining thread: '," + " tr.getName()");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "for tr2 in tasklist:");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    # print 'joining with ',tr2.getName()");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    tr2.join()");
			vqm1nivb--;
			j02AKiN8.println(E41XquG2[vqm1nivb] + "# Set agent status");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "except :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    port0.setAgentStatus(" + Status.FAILED.ordinal() + ")");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "else :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    if kill_flag :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "        agent_exit_status = " + Status.FAILED.ordinal());
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    elif stop_flag :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "        agent_exit_status = " + Status.TERMINATED.ordinal());
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    else :");
			j02AKiN8.println(E41XquG2[vqm1nivb] + "        agent_exit_status = " + Status.FINISHED.ordinal());
			j02AKiN8.println(E41XquG2[vqm1nivb] + "    port0.setAgentStatus( agent_exit_status )");
			if (z0wvi7YO)
				tSv7NtxN.println("EOF_" + HwyHIaZO);
			else
				j02AKiN8.close();
		}
		for (String mXQjTnCQ : fKZtiRBW.getFilesSet()) {
			tSv7NtxN.println();
			File kqdjP6FB = new File(mXQjTnCQ);
			File UsA85qMQ = kqdjP6FB.getParentFile();
			if (UsA85qMQ != null) {
				tSv7NtxN.println("mkdir -p " + UsA85qMQ.getPath());
			}
			tSv7NtxN.println("cat > " + mXQjTnCQ + " << " + mT0fcv9b + "EOF_" + mXQjTnCQ + mT0fcv9b);
			File Tr8cFKzO = new File(GzdjLhzC, mXQjTnCQ);
			byte KMYjnv7i[] = FileUtils.readFileToByteArray(Tr8cFKzO);
			tSv7NtxN.write(KMYjnv7i);
			tSv7NtxN.println();
			tSv7NtxN.println("EOF_" + mXQjTnCQ);
		}
		if (z0wvi7YO) {
			tSv7NtxN.println("SKIP=`awk '/^__ARCHIVE_FOLLOWS__/ { print NR + 1; exit 0; }' $0`");
			tSv7NtxN.println("tail -n +$SKIP $0 | gzip -dc | tar x ");
			tSv7NtxN.println("python -u " + HwyHIaZO);
			tSv7NtxN.println("exit 0");
			tSv7NtxN.println("__ARCHIVE_FOLLOWS__");
			java.io.InputStream vkOF8ZCh = this.getClass().getClassLoader()
					.getResourceAsStream("sc/fgrid/agent.tar.gz");
			IOUtils.copy(vkOF8ZCh, tSv7NtxN);
		} else {
			String y2eZKPEH = engine.getAgentPythonPath();
			tSv7NtxN.println("export PYTHONPATH=" + mT0fcv9b + y2eZKPEH + mT0fcv9b);
			tSv7NtxN.println("python -u " + HwyHIaZO);
			tSv7NtxN.println("exit 0");
		}
	}

}