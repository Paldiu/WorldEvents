package io.github.paldiu.api;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Tuple<A, B, C> {
    protected A primary;
    protected B secondary;
    protected C tertiary;

    public Tuple(A primary, B secondary, C tertiary) {
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
    }

    public A getPrimary() {
        return primary;
    }

    public B getSecondary() {
        return secondary;
    }

    public C getTertiary() {
        return tertiary;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getPrimary())
                .append(getSecondary())
                .append(getTertiary())
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tuple)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        Tuple atup = (Tuple) obj;
        return new EqualsBuilder()
                .append(getPrimary(), atup.getPrimary())
                .append(getSecondary(), atup.getSecondary())
                .append(getTertiary(), atup.getTertiary())
                .isEquals();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
