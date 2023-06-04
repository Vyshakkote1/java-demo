package com.xing.democlone.singleton;

public enum EnumDirector {
    INSTANCE;
    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }

}
