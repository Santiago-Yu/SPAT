package spat.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;

import spat.RuleSelector;
import spat.Utils;

public class ChangeFor2While_Wrongly extends ASTVisitor{
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<ForStatement> fors = new ArrayList<ForStatement>();
	
	public ChangeFor2While_Wrongly(CompilationUnit cu_, Document document_, String outputDirPath_) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
	}
	
	
	public boolean visit(ForStatement node) {
		fors.add(node);

		return true;
	}
	
	@SuppressWarnings("unchecked")
	public void endVisit(CompilationUnit node) {
		
		if (fors.size() == 0) {
			return;
		}
		
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
		for(ForStatement forer: fors){
			ChangeInitNames(forer);
			
			WhileStatement whiler = ast.newWhileStatement();
			Expression theexp = null;
			if (forer.getExpression() == null) {
				theexp = ast.newBooleanLiteral(true);
			}
			else {
				theexp = (Expression) ASTNode.copySubtree(ast, forer.getExpression());
			}
			whiler.setExpression(theexp);
			Statement bodystatement = forer.getBody();
			Statement whilebody = (Statement) ASTNode.copySubtree(ast, bodystatement);
			if(whilebody.getNodeType() != ASTNode.BLOCK) {
//				System.out.println("single statement for, let's change it!");
				Block blocker = ast.newBlock();
				//ListRewrite lrt = rewriter.getListRewrite(blocker, Block.STATEMENTS_PROPERTY);
				blocker.statements().add(whilebody);
				whilebody = blocker;
			}
			whiler.setBody(whilebody);
			
//			List<Expression> updexpressions = forer.updaters();
//			//ListRewrite lrt = rewriter.getListRewrite(whilebody, Block.STATEMENTS_PROPERTY);
//			for(Expression upd: updexpressions) {
//				ExpressionStatement updsta = ast.newExpressionStatement((Expression) ASTNode.copySubtree(ast, upd));
//				//lrt.insertLast(updsta, null);
//				((Block) whilebody).statements().add(updsta);
//			}
//			
			
			List<Expression> initexpressions = forer.initializers();
			
			Block blockoutsideWhile;
			if(forer.getParent().getNodeType() != ASTNode.BLOCK) {//we have to create a new block 
				blockoutsideWhile = ast.newBlock();
				//ListRewrite lrt2 = rewriter.getListRewrite(blockoutsideWhile, Block.STATEMENTS_PROPERTY);// This place is dangerous
				for(Expression ini: initexpressions) {
					ExpressionStatement inista = ast.newExpressionStatement((Expression) ASTNode.copySubtree(ast, ini));
					blockoutsideWhile.statements().add(inista);
				}
				blockoutsideWhile.statements().add(whiler);
				rewriter.replace(forer, blockoutsideWhile, null);
			}
			else {
				blockoutsideWhile = (Block) forer.getParent();
				ListRewrite lrt2 = rewriter.getListRewrite(blockoutsideWhile, Block.STATEMENTS_PROPERTY);
				for(Expression ini: initexpressions) {//Be careful!!!, we have to rename the local variable
					ExpressionStatement inista = ast.newExpressionStatement((Expression) ASTNode.copySubtree(ast, ini));
					lrt2.insertBefore(inista, forer, null);
				}
				rewriter.replace(forer, whiler, null);
			}
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(node, edits, document,outputDirPath);
	}


	private void ChangeInitNames(ForStatement forer) {

		List<Expression> initexpressions = forer.initializers();
		for(Expression ini: initexpressions) {//Be careful!!!, we have to rename the local variable
			if(IsNameDeclaration(ini)) {
				
				List<VariableDeclarationFragment> ini_frags = ((VariableDeclarationExpression) ini).fragments();
				for(VariableDeclarationFragment frag: ini_frags) {
					ArrayList<SimpleName>tochangeNames = new ArrayList<>();
					SimpleName decName = frag.getName();
					tochangeNames.add(decName);
					SearchChange(forer.getExpression(),frag.getName(), tochangeNames);
					SearchChange(forer.getBody(),frag.getName(), tochangeNames);
					List<Expression> updas = forer.updaters();
					for(Expression a: updas) {
						SearchChange(a,frag.getName(), tochangeNames);
					}
					
					//Begin Change
					String newName = Utils.getRandomString(5);
					for(SimpleName var: tochangeNames) {
						var.setIdentifier(newName);
					}
					
				}
			}
		}
	}


	private void SearchChange(ASTNode astnode, SimpleName name, ArrayList<SimpleName> tochangeNames) {
		class searchFortheSameVar extends ASTVisitor{
			public ArrayList<SimpleName> records = new ArrayList<SimpleName>();
			SimpleName equaler;
			public searchFortheSameVar(SimpleName equaler) {
				this.equaler = equaler;
			}
			
			public boolean visit(SimpleName node) {
				if(node.resolveBinding() == equaler.resolveBinding()) {
					records.add(node);
				}
				return true;
			}

		}
		searchFortheSameVar searcher = new searchFortheSameVar(name);
		astnode.accept(searcher);
		tochangeNames.addAll(searcher.records);
	}


	private boolean IsNameDeclaration(Expression inista) {
		if (inista.getNodeType() == ASTNode.VARIABLE_DECLARATION_EXPRESSION) {
			return true;
		}
		else{
			return false;
		}
	}
}
