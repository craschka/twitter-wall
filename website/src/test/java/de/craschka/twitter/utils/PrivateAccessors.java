package de.craschka.twitter.utils;

import org.junit.Assert;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class PrivateAccessors {
    public static void setPrivateField(Object object, String fieldName, Object value) {
        assertThat(object, is(not(nullValue())));
        assertThat(fieldName, is(not(nullValue())));
        assertThat(value, is(not(nullValue())));

        // Go and find the private field...
        final Field fields[] = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; ++i) {
            if (fields[i].getName().endsWith(fieldName)) {
                try {
                    fields[i].setAccessible(true);
                    fields[i].set(object, value);
                    return;
                }
                catch (IllegalAccessException ex) {
                    Assert.fail("IllegalAccessException accessing " + fieldName);
                }
            }
        }
        fail("Field '" + fieldName + "' not found");
    }
}
