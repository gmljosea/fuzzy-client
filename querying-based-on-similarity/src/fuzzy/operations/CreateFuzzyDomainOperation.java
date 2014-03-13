/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.operations;

import fuzzy.database.Connector;
import fuzzy.ddl.Relation;

/**
 *
 * @author bishma-stornelli
 */
public class CreateFuzzyDomainOperation extends FuzzyDomainOperation {

    public CreateFuzzyDomainOperation(Connector connector, String name) throws Exception {
        super(connector);
        relation = new Relation<String>(connector, name, true);
    }
}
