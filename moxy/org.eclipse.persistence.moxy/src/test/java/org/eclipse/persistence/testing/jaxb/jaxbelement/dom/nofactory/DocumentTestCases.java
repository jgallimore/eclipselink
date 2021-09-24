/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Denise Smith - October 2012
package org.eclipse.persistence.testing.jaxb.jaxbelement.dom.nofactory;

import jakarta.xml.bind.JAXBElement;

import javax.xml.namespace.QName;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;
import org.w3c.dom.Document;

public class DocumentTestCases extends JAXBWithJSONTestCases{

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element.xml";
    private final static String XML_RESOURCE_ORIGINAL = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element_original.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/jaxbelement/dom/nofactory/element.json";


    public DocumentTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class<?>[]{});
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    protected Object getControlObject() {
        Document doc;
        try {

            doc = parser.parse(this.getClass().getClassLoader().getResourceAsStream(XML_RESOURCE_ORIGINAL));
            JAXBElement<Object> obj = new JAXBElement<Object>(new QName("mynamespace", "mynewname"), Object.class, doc);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception was thrown.");
            return null;
        }
    }

    @Override
    public boolean isUnmarshalTest(){
        return false;
    }
}
