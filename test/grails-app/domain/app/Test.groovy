package app

class Test {
    def utilService

    Integer x = 0
    Integer y = 0
    Test2 test2
    static constraints = {
        x()
        y()
        test2 nullable: true
    }

    static mapping = {
        autowire true
    }

    def beforeInsert() {
        utilService.calculate(this)
    }

    def beforeUpdate() {
        utilService.calculate(this)
    }
}
