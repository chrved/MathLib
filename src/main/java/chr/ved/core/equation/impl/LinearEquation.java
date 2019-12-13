package chr.ved.core.equation.impl;

import chr.ved.core.base.impl.numeric.Constant;
import chr.ved.core.base.impl.numeric.Variable;
import chr.ved.core.equation.Term;
/*
    One variable:
    ax+b=0 and it has a unique solution x=-b/a with a ≠ 0
    Two variables:
    ax+by+c=0 is a linear equation in the single variable y for every value of x.
    It has therefore a unique solution for y, which is given by
    y=-(a/b)*x -c/b. With slope -a/b and  y-intercept -c/b

y=2x+1
-1=2x
x = -1/2
 */

public class LinearEquation {//extends AbstracEquation {
//
//    private Variable y;
//    private Constant k;
//    private Constant m;
//    private Variable x;
//    private Operator op;
//
//    public LinearEquation(){
//        super();
//    }
//    @Override
//    public boolean solve() {
//
//        // Set to correct form; y = kx + m
//            setToCorrectForm();
//        // Solve
//            return checkIfSolvable();
//    }
//
//    private boolean checkIfSolvable() {
//        Term t = new Term(x);
//        t.g
//        k =
//        x = (Variable) rightSide.getExpressions().get(0).getObject();
//        op = (Operator) rightSide.getExpressions().get(1).getObject();
//        m = (Constant) rightSide.getExpressions().get(2).getObject();
//        if(x.getValue() == null){
//            return false;
//        }
//
//        solution.put("x",x.solve());
//
//        solution.put("m",m.solve());
//
//        solution.put("y",m.solve()+x.solve());
//        return true;
//    }
//
//    private void setToCorrectForm() {
//
//    }
}
