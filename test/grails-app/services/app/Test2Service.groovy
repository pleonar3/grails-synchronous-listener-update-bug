package app

import grails.gorm.services.Service

@Service(Test2)
interface Test2Service {

    Test2 get(Serializable id)

    List<Test2> list(Map args)

    Long count()

    void delete(Serializable id)

    Test2 save(Test2 test2)

}