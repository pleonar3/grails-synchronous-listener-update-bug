package app

class Test {
    Integer x = 0
    Integer y = 0
    Test2 test2
    static constraints = {
        x()
        y()
        test2 nullable: true
    }
}
