package com.xing.singleton;

public enum EnumDirector {
    INSTANCE;
    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }

}
