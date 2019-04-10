package app

import grails.events.annotation.Listener
import grails.events.annotation.gorm.Listener
// import groovy.transform.CompileStatic
// import groovy.util.logging.Slf4j
import org.grails.datastore.mapping.engine.event.*

class TestListenerService {
    def test2Service

    @Listener(Test)
    void beforeInsert(PreInsertEvent event) {
        println 'insert'
        def test = event.entityObject
        def entityAccess = event.entityAccess
        def test2 = (test.test2) ? test.test2 : new Test2()
        test2.z = test.x * test.y
        test2Service.save(test2)
        entityAccess.setProperty('test2', test2)
    }

    @Listener(Test)
    void beforeUpdate (PreUpdateEvent event) {
        println 'update'
        def test = event.entityObject
        def entityAccess = event.entityAccess
        def test2 = test.test2
        test2.z = test.x * test.y
        test2Service.save(test2)
    }


}
