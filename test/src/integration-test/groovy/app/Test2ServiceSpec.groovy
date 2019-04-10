package app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Test2ServiceSpec extends Specification {

    Test2Service test2Service
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Test2(...).save(flush: true, failOnError: true)
        //new Test2(...).save(flush: true, failOnError: true)
        //Test2 test2 = new Test2(...).save(flush: true, failOnError: true)
        //new Test2(...).save(flush: true, failOnError: true)
        //new Test2(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //test2.id
    }

    void "test get"() {
        setupData()

        expect:
        test2Service.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Test2> test2List = test2Service.list(max: 2, offset: 2)

        then:
        test2List.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        test2Service.count() == 5
    }

    void "test delete"() {
        Long test2Id = setupData()

        expect:
        test2Service.count() == 5

        when:
        test2Service.delete(test2Id)
        sessionFactory.currentSession.flush()

        then:
        test2Service.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Test2 test2 = new Test2()
        test2Service.save(test2)

        then:
        test2.id != null
    }
}
