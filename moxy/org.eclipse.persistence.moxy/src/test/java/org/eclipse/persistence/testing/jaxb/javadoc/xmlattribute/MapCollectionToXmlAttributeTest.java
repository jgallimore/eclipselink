/*
 * Copyright (c) 2011, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Praba Vijayaratnam - 2.3 - initial implementation
package org.eclipse.persistence.testing.jaxb.javadoc.xmlattribute;

import java.util.List;
import java.util.ArrayList;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class MapCollectionToXmlAttributeTest extends JAXBWithJSONTestCases {

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/javadoc/xmlattribute/collectionxmlattribute.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/javadoc/xmlattribute/collectionxmlattribute.json";

    public MapCollectionToXmlAttributeTest(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class<?>[] classes = new Class<?>[1];
        classes[0] = MapCollectionToXmlAttribute.class;
        setClasses(classes);
    }

    @Override
    protected Object getControlObject() {

        MapCollectionToXmlAttribute ls = new MapCollectionToXmlAttribute();
        List<String> words = new ArrayList();
        words.add("one");
        words.add("two");
        words.add("three");
        ls.items = words;
        return ls;
    }



}
