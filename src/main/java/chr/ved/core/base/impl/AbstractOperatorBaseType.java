package chr.ved.core.base.impl;

import chr.ved.core.base.BaseType;

public abstract class AbstractOperatorBaseType implements BaseType {
    protected Type type;
    protected OperatorType opType;

    protected AbstractOperatorBaseType(OperatorType opType) {
        this.opType = opType;
        this.type = Type.OPERATOR;
    }

    @Override
    public Type getType() {
        return type;
    }

    public OperatorType getOperatorType() {
        return opType;
    }
}
