package org.atomicoke.inf.common;

import org.atomicoke.inf.common.err.Err;

/**
 * assert.
 *
 * @author <a href="mailto:likelovec@gmail.com">fzdwx</a>
 * @date 2022/4/17 13:06
 */
public class Assert {

    public static void notNull(final Object obj, final String message) {
        if (obj == null) {
            throw Err.normal(message);
        }
    }

    public static void ensureTrue(final boolean flag, final String message) {
        ensureFalse(!flag, message);
    }

    public static void ensureFalse(final boolean flag, final String message) {
        if (flag) {
            throw Err.normal(message);
        }
    }
}