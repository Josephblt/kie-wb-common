/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.stunner.core.backend.definition.adapter.bind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackendBindableAdapterFunctionsTest {

    private BackendBindableAdapterFunctions tested;

    @Before
    public void init() {
        tested = new BackendBindableAdapterFunctions();
    }

    @Test
    public void testGetValue() {
        SomeBean bean = new SomeBean("someString", 5);
        assertEquals("someString", tested.getValue(bean, "someStringField"));
        assertEquals(5, tested.getValue(bean, "someIntField"));
    }

    @Test
    public void testSetValue() {
        SomeBean bean = new SomeBean("someString", 5);
        tested.setValue(bean, "someStringField", "anotherString");
        tested.setValue(bean, "someIntField", 3);
        assertEquals("anotherString", bean.someStringField);
        assertEquals(3, bean.someIntField);
    }

    private static class SomeBean {

        private String someStringField;
        private int someIntField;

        public SomeBean(String someStringField, int someIntField) {
            this.someStringField = someStringField;
            this.someIntField = someIntField;
        }
    }
}
