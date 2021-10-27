package spat.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ConditionalExpression;
import org.eclipse.jdt.core.dom.ContinueStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.Utils;

public class LoopIfContinue2Else extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<ContinueStatement> continues = new ArrayList<ContinueStatement>();
	Set<Statement> involvedStatements = new HashSet<Statement>();
	AST ast = null;
	ASTRewrite rewriter = null;
	
	public LoopIfContinue2Else(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
	}
	
	private Statement ignoreBlock(ASTNode node) {
		if(node.getNodeType() == ASTNode.BLOCK) {
			return ignoreBlock(node.getParent());
		}
		return (Statement) node;
	}
	
	private boolean IsIntheElse(ContinueStatement csta) {
		Statement cur = csta;
		while(cur.getParent().getNodeType() != ASTNode.IF_STATEMENT) {
			cur = (Statement) cur.getParent();
		}

		if(cur.getLocationInParent() != IfStatement.THEN_STATEMENT_PROPERTY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean visit(ContinueStatement csta) {
		try {
			if(csta.getLabel()!=null) {
				return true;
			}
			IfStatement thisIf = (IfStatement) ignoreBlock(csta.getParent());
			if(IsIntheElse(csta)) {
				return true;
			}
			Block blocker = (Block) thisIf.getParent();
			Statement grandPa = (Statement) ignoreBlock(thisIf.getParent());
			int loopType = grandPa.getNodeType();
			if (loopType == ASTNode.FOR_STATEMENT || loopType == ASTNode.WHILE_STATEMENT || loopType == ASTNode.ENHANCED_FOR_STATEMENT ) {
				if(!involvedStatements.contains(grandPa)) {
					involvedStatements.add(grandPa);
					continues.add(csta);
				}
				
			}
		
		}catch (Exception e) {
			return true;
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		if (continues.size() == 0) {
			return;
		}
		for(ContinueStatement continuer : continues) {
			IfStatement thisIf = (IfStatement) ignoreBlock(continuer.getParent());
			IfStatement newIf = (IfStatement) ASTNode.copySubtree(ast, thisIf);
//			Statement grandPa = (Statement) ignoreBlock(thisIf.getParent());
//			System.out.println("Find One!");
//			System.out.println(continuer.toString());
//			System.out.println(newIf.toString());
//			System.out.println(grandPa.toString());
			Block blockerOftheLoop = (Block) thisIf.getParent();
			List<Statement> stats = blockerOftheLoop.statements();
			//check if there is only one thenstatement.
			Statement thenstate = newIf.getThenStatement();
			boolean OnlyOneContinue = false;
			if(thenstate.getNodeType() != ASTNode.BLOCK) {
				// that must means there is only one continue statement
				OnlyOneContinue = true;
			}
			
			
			
			
			//put all behindIf statements into else.
			Statement oriElse = newIf.getElseStatement();
			if(oriElse == null) {
				oriElse = ast.newBlock();
				newIf.setElseStatement(oriElse);
			}
			ListRewrite lrt = null;
			if(oriElse.getNodeType() != ASTNode.BLOCK) {
				Statement copyOri = (Statement) ASTNode.copySubtree(ast, oriElse);
				oriElse = ast.newBlock();
				newIf.setElseStatement(oriElse);
				lrt = rewriter.getListRewrite(oriElse, Block.STATEMENTS_PROPERTY);
				lrt.insertFirst(copyOri, null);
			}
			else {
				lrt = rewriter.getListRewrite(oriElse, Block.STATEMENTS_PROPERTY);
			}
			
			boolean meet = false;
			for(Statement stat : stats) {
				if(meet) {
					lrt.insertLast((Statement) ASTNode.copySubtree(ast, stat), null);
					rewriter.remove(stat, null);
				}
				else {
					if(stat == thisIf) {
						meet = true;
					}
				}
			}
			//remove the continue statement.
			if(!OnlyOneContinue) {
				rewriter.remove(findtheEqualContinue(newIf, continuer), null);
			}
			else {
				rewriter.replace(findtheEqualContinue(newIf, continuer), ast.newBlock(), null);
			}
			rewriter.replace(thisIf, newIf, null);
			
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}

	private ASTNode findtheEqualContinue(IfStatement newIf, ContinueStatement continuer) {
		class SpecASTVisitor extends ASTVisitor{
			public ContinueStatement continuerr = null;
			public boolean visit(ContinueStatement node) {
				if(node.subtreeMatch(new ASTMatcher(), continuer)) {
					continuerr = node;
				}
				return true;
			}
		}
		SpecASTVisitor sss = new SpecASTVisitor();
		newIf.accept(sss);
		return sss.continuerr;
	}
}
